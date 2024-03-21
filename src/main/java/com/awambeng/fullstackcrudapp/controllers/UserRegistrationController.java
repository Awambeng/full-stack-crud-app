package com.awambeng.fullstackcrudapp.controllers;

import com.awambeng.fullstackcrudapp.dto.UserRegistrationDto;
import com.awambeng.fullstackcrudapp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/registration")
public class UserRegistrationController {

    @Autowired
    private UserService userService;

    @ModelAttribute("users")
    public UserRegistrationDto userRegistrationDto(){
        return new UserRegistrationDto();
    }

    @GetMapping
    public String showRegistrationForm(){
        return "registration";
    }

    @PostMapping
    public String createUserAccount(@ModelAttribute("users") UserRegistrationDto registrationDto){
        userService.saveUser(registrationDto);
        return "redirect:/registration?success";
    }
}
