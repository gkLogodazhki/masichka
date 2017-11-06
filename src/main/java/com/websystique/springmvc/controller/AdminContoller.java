package com.websystique.springmvc.controller;

import com.websystique.springmvc.model.Place;
import com.websystique.springmvc.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;
import java.util.Locale;


@Controller
@RequestMapping("/admin")
public final class AdminContoller extends AppController {

    @RequestMapping(method = RequestMethod.GET)
    public String admin(ModelMap model) {
        String principal = getPrincipal();
        if (principal == null) {
            return "redirect:/login?logout";
        }
        List<User> users = userService.findAll();
        List<Place> places = placeService.findAll();
        model.addAttribute("users", users);
        model.addAttribute("places", places);
        model.addAttribute("loggedinuser", principal);
        return "indexAdmin";
    }

    @RequestMapping(value = "/addPlace",method = RequestMethod.GET)
    public String addPlaceGet(ModelMap model) {
        String principal = getPrincipal();
        if (principal == null) {
            return "redirect:/login?logout";
        }
        Place place = new Place();
        model.addAttribute("place", place);
        model.addAttribute("loggedinuser", principal);
        return "addPlace";
    }

    @RequestMapping(value = "/addPlace",method = RequestMethod.POST)
    public String addPlacePost(@Valid Place place, BindingResult result,
                            ModelMap model) {

        if (result.hasErrors()) {
            return "addPlace";
        }

        if(!placeService.isNameUnique(place.getId(), place.getName())){
            FieldError ssoError =new FieldError("name","name",messageSource.getMessage("non.unique.name", new String[]{place.getName()}, Locale.getDefault()));
            result.addError(ssoError);
            return "addPlace";
        }

        placeService.save(place);

        model.addAttribute("success", "Place " + place.getName() + " at " + place.getAddress() + " added successfully");
        model.addAttribute("loggedinuser", getPrincipal());
        return "redirect:/admin";

    }


    /**
     * This method will delete an user by it's SSOID value.
     */
    @RequestMapping(value = {"/delete-user-{ssoId}"}, method = RequestMethod.GET)
    public String deleteUser(@PathVariable String ssoId) {
        userService.deleteBySSO(ssoId);
        return "redirect:/admin";
    }

    @RequestMapping(value = {"/delete-place-{name}"}, method = RequestMethod.GET)
    public String deletePlace(@PathVariable String name) {
        placeService.delete(placeService.findByName(name));
        return "redirect:/admin";
    }

    @RequestMapping(value = {"/edit-place-{name}"}, method = RequestMethod.GET)
    public String editPlace(@PathVariable String name, ModelMap model) {
        Place place = placeService.findByName(name);
        model.addAttribute("place", place);
        model.addAttribute("edit", true);
        model.addAttribute("loggedinuser", getPrincipal());
        return "addPlace";
    }


    @RequestMapping(value = {"/edit-place-{name}"}, method = RequestMethod.POST)
    public String updatePlace(@Valid Place place, BindingResult result,
                             ModelMap model, @PathVariable String name) {
        if (result.hasErrors()) {
            return "addPlace";
        }

        placeService.update(place);

        model.addAttribute("success", "Place: " + place.getName() + " " + place.getAddress() + " updated successfully");
        model.addAttribute("loggedinuser", getPrincipal());
        return "redirect:/admin";
    }

}
