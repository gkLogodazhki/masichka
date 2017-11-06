package com.websystique.springmvc.controller;

import com.websystique.springmvc.dao.IIdNameDao;
import com.websystique.springmvc.dao.IPlaceDao;
import com.websystique.springmvc.dao.IReservationDao;
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
import java.util.List;
import java.util.Locale;
import java.util.Set;


@Controller
@RequestMapping("/")
@SessionAttributes({"userTypes", "cities", "placeTypes", "regions", "avgBills"
	, "options", "payMethods", "setups", "placesRestaurant", "hours"})
public class AppController {

	@Autowired
	IReservationDao reservationService;
	
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

    @RequestMapping(value = {"/"}, method = RequestMethod.GET)
    public String home(ModelMap model) {
        User user = userService.findBySSO(getPrincipal());

        try {
            user = userService.findBySSO(getPrincipal());
        } catch (Exception e) {
            return "redirect:/AccessDenied";
        }

        if (user == null) {
            return "index";
        }

        if (user.getUserType().getName().equals("ADMIN")){
            return "redirect:/admin";
        }

        try {
            PlaceType club = placeTypeService.findByName("клуб");
            PlaceType restaurants = placeTypeService.findByName("ресторант");

            model.addAttribute("clubs", placeService.findAll());
            model.addAttribute("restaurants", placeService.findAll());

            model.addAttribute("newClubs", placeService.find(club, Order.desc("date")));
            model.addAttribute("newRestaurants", placeService.find(restaurants, Order.desc("date")));

            model.addAttribute("discountsClubs", placeService.find(club, Order.desc("discount")));
            model.addAttribute("discountsRestaurants", placeService.find(restaurants, Order.desc("discount")));

            model.addAttribute("loggedinuser", getPrincipal());
        } catch (Exception e) {
            return "redirect:/AccessDenied";
        }

        if (user.getUserType().getName().equals("USER")) {
            return "redirect:/user";
        }
        return "index";
    }

    @RequestMapping(value = {"/reg"}, method = RequestMethod.GET)
    public String reg(ModelMap model) {
        User user = new User();
        model.addAttribute("user", user);
        model.addAttribute("edit", false);
        model.addAttribute("loggedinuser", getPrincipal());
        return "Register";
    }

    @RequestMapping(value = {"/reg"}, method = RequestMethod.POST)
    public String saveUser(@Valid User user, BindingResult result,
                           ModelMap model) {
        if (result.hasErrors()) {
            model.addAttribute("loggedinuser", getPrincipal());
            System.out.println("Tuk sam na hasErrors");
            return "Register";
        }

        model.addAttribute("success", "Place " + user.getFirstName() + " at " + user.getLastName() + " added successfully");
        if (!userService.isUserSSOUnique(user.getId(), user.getSsoId())) {
            FieldError ssoError = new FieldError("user", "ssoId", messageSource.getMessage("non.unique.ssoId", new String[]{user.getSsoId()}, Locale.getDefault()));
            result.addError(ssoError);
            System.out.println("Takav potrebitel sashtestwuwa");
            return "Register";
        }
        System.out.println("Ocelqh do tuk");
        userService.save(user);

        model.addAttribute("success", "User " + user.getFirstName() + " " + user.getLastName() + " registered successfully");
        model.addAttribute("loggedinuser", getPrincipal());
        //return "success";
        if (userService.findBySSO(getPrincipal()).equals("ADMIN")) {
            return "redirect:/admin";
        }
        return "index";
    }

    @RequestMapping(value = "/AccessDenied", method = RequestMethod.GET)
    public String accessDeniedPage(ModelMap model) {
        model.addAttribute("loggedinuser", getPrincipal());
        return "accessDenied";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage() {
        return (isCurrentAuthenticationAnonymous()) ? "index" : "redirect:/";
    }


    /* @RequestMapping(value = "/facebook", method = RequestMethod.GET)
     public String facebookPage(@Valid UserFacebook userFacebook, BindingResult result,
                            ModelMap model) {
         if (userService.findBySSO(userFacebook.getName())==null){
             User user = new User();
             user.setUserType(userTypeService.findByName("USER"));
             user.setSsoId(userFacebook.getName());
             user.setEmail(userFacebook.getEmail());
             int maxLenght = userFacebook.getName().length();
             System.out.println("");
             user.setPassword(userFacebook.getName().substring(0,maxLenght/2));
             userService.save(user);
         }
         return "profile";
     }
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

    protected String getPrincipal() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return (principal instanceof UserDetails) ? ((UserDetails) principal).getUsername() : principal.toString();
    }
    
    @RequestMapping(value = "/restaurantPage-{name}" , method = RequestMethod.GET)
    public String goToRestaurantPage(ModelMap model, @PathVariable String name) {
    	Place place = placeService.findByName(name);
    	Reservation reservation = new Reservation();
    	Set<Option> options = place.getOptions();
    	System.out.println(options.size());
    	
    	model.addAttribute("reservation", reservation);
    	model.addAttribute("place", place);
    	model.addAttribute("options", options);

        model.addAttribute("edit", false);
        model.addAttribute("loggedinuser", getPrincipal());
        return "restaurantPage";    
       }
    
    
    @RequestMapping(value = "/restaurantPage", method = RequestMethod.POST)
    public String makeReservation(@Valid Reservation reservation, BindingResult result,
                           ModelMap model) {
    	System.out.println("HERE");
    	if (result.hasErrors()) {
            model.addAttribute("loggedinuser", getPrincipal());
            return "restaurantPage";
        }

        model.addAttribute("success", reservation + " added successfully");
        
        reservationService.save(reservation);

        model.addAttribute("success", reservation + " added successfully");
        model.addAttribute("loggedinuser", getPrincipal());
        //return "success";
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

    protected boolean isCurrentAuthenticationAnonymous() {
        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authenticationTrustResolver.isAnonymous(authentication);
    }

}