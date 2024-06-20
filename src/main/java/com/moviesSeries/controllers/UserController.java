package com.moviesSeries.controllers;

import com.moviesSeries.model.User;
import com.moviesSeries.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/register")
    public String getRegisterPage(){
        return "register_page";
    }

    @GetMapping("/login")
    public String getLoginPage(){
        return "login_page";
    }

    @PostMapping("/register")
    public ModelAndView registerUser(@ModelAttribute User user) {
        userService.registerUser(user.getUsername(), user.getPassword(), user.getEmail());
        ModelAndView mav = new ModelAndView("register_success");
        mav.addObject("user", user);
        return mav;
    }

    @PostMapping("/login")
    public ModelAndView loginUser(@ModelAttribute User user) {
        if(userService.authenticate(user.getUsername(), user.getPassword())!= null){
            ModelAndView mav = new ModelAndView("register_success");
            mav.addObject("user", user);
            return mav;
        }else{
            ModelAndView mav = new ModelAndView("error_page");
            mav.addObject("user", user);
            return mav;
        }

    }

}
