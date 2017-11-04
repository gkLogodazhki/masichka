package com.websystique.springmvc.controller;

import com.websystique.springmvc.dao.IIdNameDao;
import com.websystique.springmvc.dao.IPlaceDao;
import com.websystique.springmvc.dao.IUserDao;
import com.websystique.springmvc.model.*;
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


@Controller
@RequestMapping("/")
@SessionAttributes({"userTypes", "cities", "placeTypes", "regions", "avgBills", "options", "payMethods", "weekDays", "setups", "placesRestaurant"})
public class AppController {

    @Autowired
    IUserDao userService;

    @Autowired
    IPlaceDao placeDao;

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
    IIdNameDao<WeekDay> weekDayService;

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
    public String listUsers(ModelMap model) {
        List<User> users = userService.findAll();
        model.addAttribute("users", users);
        model.addAttribute("loggedinuser", getPrincipal());
        return "index";
    }


    @RequestMapping(value = {"/reg"}, method = RequestMethod.GET)
    public String reg(ModelMap model) {
    	System.err.println("Again back");
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
    
    @RequestMapping(value = {"/makeRegister"}, method = RequestMethod.POST)
    public String saveUser(@ModelAttribute("users") User user, BindingResult result,
                           ModelMap model) {
    	System.err.println("Finally got here");
        if (result.hasErrors()) {
            model.addAttribute("loggedinuser", getPrincipal());
            return "Register";
        }

        if (!userService.isSSOUnique(user.getId(), user.getSsoId())) {
            FieldError ssoError = new FieldError("user", "ssoId", messageSource.getMessage("non.unique.ssoId", new String[]{user.getSsoId()}, Locale.getDefault()));
            result.addError(ssoError);
            model.addAttribute("loggedinuser", getPrincipal());
            return "Register";
        }

        userService.save(user);

        model.addAttribute("success", "User " + user.getFirstName() + " " + user.getLastName() + " registered successfully");
        model.addAttribute("loggedinuser", getPrincipal());
        //return "success";
        return "redirect:/reg";
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

    /**
     * This method will be called on form submission, handling POST request for
     * updating user in database. It also validates the user input
     */
    @RequestMapping(value = {"/edit-user-{ssoId}"}, method = RequestMethod.POST)
    public String updateUser(@Valid User user, BindingResult result,
                             ModelMap model, @PathVariable String ssoId) {
        if (result.hasErrors()) {
            return "Register";
        }

        userService.update(user);

        model.addAttribute("success", "User " + user.getFirstName() + " " + user.getLastName() + " updated successfully");
        model.addAttribute("loggedinuser", getPrincipal());
        return "registrationsuccess";
    }


    /**
     * This method will delete an user by it's SSOID value.
     */
    @RequestMapping(value = {"/delete-user-{ssoId}"}, method = RequestMethod.GET)
    public String deleteUser(@PathVariable String ssoId) {
        userService.deleteBySSO(ssoId);
        return "redirect:/list";
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
            return "index";
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
    private String getPrincipal() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return (principal instanceof UserDetails) ? ((UserDetails) principal).getUsername() : principal.toString();
    }

    /**
     * ADD NEW PLACE BEGIN
     */
    @RequestMapping(value = {"/addplace"}, method = RequestMethod.GET)
    public String newPlace(ModelMap model) {
        if (userService.findBySSO(getPrincipal()) == null) {
            return "redirect:/logout";
        }
        Place place = new Place();
        model.addAttribute("place", place);
        model.addAttribute("loggedinuser", getPrincipal());
        return "addPlace";
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

    @ModelAttribute("weekDays")
    public List<WeekDay> initializeWeekDays() {
        return weekDayService.findAll();
    }

    @ModelAttribute("places")
    public List<Place> initializePlaces() {
        return placeService.findAll();
    }

    @RequestMapping(value = {"/addplace"}, method = RequestMethod.POST)
    public String saveUser(@Valid Place place, BindingResult result,
                           ModelMap model) {

        if (result.hasErrors()) {
            model.addAttribute("loggedinuser", getPrincipal());
            return "addPlace";
        }

        if (!placeService.isUnique(place.getId(), place.getName())) {
            FieldError ssoError = new FieldError("place", "name", messageSource.getMessage("non.unique.name", new String[]{place.getName()}, Locale.getDefault()));
            result.addError(ssoError);
            model.addAttribute("loggedinuser", getPrincipal());
            return "addPlace";
        }

        placeService.save(place);

        model.addAttribute("success", "Place " + place.getName() + " at " + place.getAddress() + " added successfully");
        model.addAttribute("loggedinuser", getPrincipal());
        //return "success";
        return "registrationsuccess";
    }

	/*
        ADD NEW PLACE END
	 */

    /**
     * This method returns true if users is already authenticated [logged-in], else false.
     */
    private boolean isCurrentAuthenticationAnonymous() {
        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authenticationTrustResolver.isAnonymous(authentication);
    }

}