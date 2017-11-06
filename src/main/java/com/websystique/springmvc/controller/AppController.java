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
import java.util.Date;
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


    /**
     * This method will list all existing users.
     */
    @RequestMapping(value = {"/"}, method = RequestMethod.GET)
    public String home(ModelMap model) {
<<<<<<< HEAD
//        try{
//            PlaceType typeClub = placeTypeService.findByName("Клуб");
//            PlaceType typeRestaurant = placeTypeService.findByName("Ресторант");
//            List<Place> clubs = placeService.findByPlaceType(typeClub,10);
//            List<Place> restaurants = placeService.findByPlaceType(typeRestaurant,10);
//            model.addAttribute("clubs", clubs);
//            model.addAttribute("restaurants", restaurants);
//        } catch (HibernateException he){
//            return "accessDenied";
//        }
        model.addAttribute("loggedinuser", getPrincipal());
        return "index";
    }

    @RequestMapping(value = {"/users"}, method = RequestMethod.GET)
    public String listUsers(ModelMap model) {
        List<User> users = userService.findAll();
        model.addAttribute("users", users);
        model.addAttribute("loggedinuser", getPrincipal());
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

    /**
     * This method will be called on form submission, handling POST request for
     * saving user in database. It also validates the user input
     */
    
    @RequestMapping(value = {"/reg"}, method = RequestMethod.POST)
    public String saveUser(@Valid User user, BindingResult result,
                           ModelMap model) {
    	if (result.hasErrors()) {
            model.addAttribute("loggedinuser", getPrincipal());
            return "Register";
        }

        model.addAttribute("success", "Place " + user.getFirstName() + " at " + user.getLastName() + " added successfully");
        if(!userService.isUserSSOUnique(user.getId(), user.getSsoId())){
            FieldError ssoError =new FieldError("user","ssoId",messageSource.getMessage("non.unique.ssoId", new String[]{user.getSsoId()}, Locale.getDefault()));
            result.addError(ssoError);
            return "Register";
        }
        userService.save(user);
        
        model.addAttribute("success", "User " + user.getFirstName() + " " + user.getLastName() + " registered successfully");
        model.addAttribute("loggedinuser", getPrincipal());
        //return "success";
        return "index";
    }


    /**
     * This method will provide the medium to update an existing user.
     */
    @RequestMapping(value = {"/edit-user-{ssoId}"}, method = RequestMethod.GET)
    public String editUser(@PathVariable String ssoId, ModelMap model) {
        User user = userService.findBySSO(ssoId);
        model.addAttribute("user", user);
        model.addAttribute("edit", true);
        model.addAttribute("loggedinuser", getPrincipal());
        return "Register";
    }
=======
        String principal = getPrincipal();
        if (principal == null){
            return "redirect:login?logout";
        }
        User user = userService.findBySSO(principal);
        model.addAttribute("loggedinuser", principal);
        if (user.getUserType().getName().equals("ADMIN")){
            return "redirect:/admin";
        }
>>>>>>> 79b18c2912e035a9233fdf0d6ca6e52b3d836e3b

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