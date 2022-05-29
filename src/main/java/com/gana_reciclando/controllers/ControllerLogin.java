package com.gana_reciclando.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gana_reciclando.models.UserObject;
import com.gana_reciclando.repositories.UserRepository;
import com.gana_reciclando.services.UserService;

@RestController
public class ControllerLogin {

    @Autowired
    UserService userService;
    @Autowired
    UserRepository userRepository;

   

    @GetMapping("/register")
    public String register(Model model){
        model.addAttribute("user", new UserObject());
        return "register";
    }

    @PostMapping("/register")
    public void afegirSubmit(@ModelAttribute("user") UserObject user){
        userService.putUser(user);

    }

}