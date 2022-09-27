package com.jovan_bojovic.spring_assignment.controller;

import com.jovan_bojovic.spring_assignment.dto.LoginDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(path = "/secure/hello")
public class SecureHelloController {


    @GetMapping(path = "/")
    public ModelAndView getSecureHello() {
        ModelAndView modelAndView = new ModelAndView("login", "loginDTO", new LoginDTO());
        modelAndView.addObject("showMessage", false);
        return modelAndView;
    }

    @PostMapping(path = "/")
    public String login(@ModelAttribute LoginDTO loginDTO, Model model) {
        model.addAttribute("showMessage", true);
        return "login";
    }

}
