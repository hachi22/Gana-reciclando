package com.gana_reciclando.controllers;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.gana_reciclando.models.UserModel;
import com.gana_reciclando.repositories.UserRepository;
import com.gana_reciclando.services.UserService;

@Controller
public class ControllerLogin {

    @Autowired
    UserService userService;
    @Autowired
    UserRepository userRepository;



    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/register")
    public String register(Model model){
        model.addAttribute("user", new UserModel());
        return "register";
    }

    @PostMapping("/register")
    public String afegirSubmit(@ModelAttribute("user") UserModel user){
        userService.putUser(user);
        return "redirect:/";

    }

}