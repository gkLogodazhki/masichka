package com.websystique.springmvc.controller;

import com.websystique.springmvc.dao.IIdNameDao;
import com.websystique.springmvc.dao.IPlaceDao;
import com.websystique.springmvc.dao.IUserDao;
import com.websystique.springmvc.model.*;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.authentication.AuthenticationTrustResolver;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.rememberme.PersistentTokenBasedRememberMeServices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.Date;
import java.util.List;
import java.util.Locale;


@Controller
@RequestMapping("/")
@SessionAttributes({"userTypes", "cities", "placeTypes", "regions", "avgBills"
	, "options", "payMethods", "setups", "placesRestaurant", "hours"})
public class AppController {

    @Autowired
    IUserDao userService;

    @Autowired
    IPlaceDao placeService;

    @Autowired
    IIdNameDao<UserType> userTypeService;

    @Autowired
    IIdNameDao<City> cityService;

    @Autowired
    IIdNameDao<PlaceType> placeTypeService;

    @Autowired
    IIdNameDao<Region> regionService;

    @Autowired
    IIdNameDao<AvgBill> avgBillService;

    @Autowired
    IIdNameDao<Option> optionService;

    @Autowired
    IIdNameDao<PayMethod> payMethodService;

    @Autowired
    IIdNameDao<Setup> setupService;

    @Autowired
    IIdNameDao<Hour> hourService;
    
    @Autowired
    MessageSource messageSource;

    @Autowired
    PersistentTokenBasedRememberMeServices persistentTokenBasedRememberMeServices;

    @Autowired
    AuthenticationTrustResolver authenticationTrustResolver;


    /**
     * This method will list all existing users.
     */
    @RequestMapping(value = {"/"}, method = RequestMethod.GET)
    public String home(ModelMap model) {
        String principal = getPrincipal();
        if (principal == null){
            return "redirect:login?logout";
        }
        User user = userService.findBySSO(principal);
        model.addAttribute("loggedinuser", principal);
        if (user.getUserType().getName().equals("ADMIN")){
            return "redirect:/admin";
        }

        PlaceType club = placeTypeService.findByName("клуб");
        PlaceType restaurants = placeTypeService.findByName("ресторант");

        model.addAttribute("clubs", placeService.findAll());
        model.addAttribute("restaurants", placeService.findAll());

        model.addAttribute("newClubs", placeService.find(club, Order.desc("date")));
        model.addAttribute("newRestaurants",placeService.find(restaurants, Order.desc("date")));

        model.addAttribute("discountsClubs", placeService.find(club, Order.desc("discount")));
        model.addAttribute("discountsRestaurants", placeService.find(restaurants, Order.desc("discount")));

        return "index";
    }


    /**
     * This method handles Access-Denied redirect.
     */
    @RequestMapping(value = "/Access_Denied", method = RequestMethod.GET)
    public String accessDeniedPage(ModelMap model) {
        model.addAttribute("loggedinuser", getPrincipal());
        return "accessDenied";
    }

    /**
     * This method handles login GET requests.
     * If users is already logged-in and tries to goto login page again, will be redirected to list page.
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage() {
        if (isCurrentAuthenticationAnonymous()) {
            return "index";
        } else {
            return "redirect:/";
        }
    }

    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public String profilePage() {
        return "profile";
    }

    /**
     * This method handles logout requests.
     * Toggle the handlers if you are RememberMe functionality is useless in your app.
     */
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            //new SecurityContextLogoutHandler().logout(request, response, auth);
            persistentTokenBasedRememberMeServices.logout(request, response, auth);
            SecurityContextHolder.getContext().setAuthentication(null);
        }
        return "redirect:/";
    }

    /**
     * This method returns the principal[user-name] of logged-in user.
     */
    protected String getPrincipal() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return (principal instanceof UserDetails) ? ((UserDetails) principal).getUsername() : principal.toString();
    }

    /**
     * ADD NEW PLACE BEGIN
     */
    
    @RequestMapping(value = "restaurantPage" , method = RequestMethod.GET)
    public String goToRestaurantPage() {
    	return "restaurantPage";
    }
    
    

    @ModelAttribute("placesRestaurants")
    public List<Place> initializePlacesRestaurants() {
        return placeService.findAll();
    }

    @ModelAttribute("userTypes")
    public List<UserType> initializeRoles() {
        return userTypeService.findAll();
    }

    @ModelAttribute("cities")
    public List<City> initializeCities() {
        return cityService.findAll();
    }

    @ModelAttribute("placeTypes")
    public List<PlaceType> initializePlaceTypes() {
        return placeTypeService.findAll();
    }

    @ModelAttribute("regions")
    public List<Region> initializeRegions() {
        return regionService.findAll();
    }

    @ModelAttribute("setups")
    public List<Setup> initializeSetups() {
        return setupService.findAll();
    }

    @ModelAttribute("avgBills")
    public List<AvgBill> initializeAvgBills() {
        return avgBillService.findAll();
    }

    @ModelAttribute("options")
    public List<Option> initializeOptions() {
        return optionService.findAll();
    }

    @ModelAttribute("payMethods")
    public List<PayMethod> initializePayMethods() {
        return payMethodService.findAll();
    }


    @ModelAttribute("places")
    public List<Place> initializePlaces() {
        return placeService.findAll();
    }
    @ModelAttribute("hours")
    public List<Hour> initializeHours() {
        return hourService.findAll();
    }

	/*
        ADD NEW PLACE END
	 */

    /**
     * This method returns true if users is already authenticated [logged-in], else false.
     */
    protected boolean isCurrentAuthenticationAnonymous() {
        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authenticationTrustResolver.isAnonymous(authentication);
    }

}