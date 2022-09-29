package com.jovan_bojovic.spring_assignment.controller;

import com.jovan_bojovic.spring_assignment.dto.LoginDTO;
import com.jovan_bojovic.spring_assignment.dto.MessageDTO;
import com.jovan_bojovic.spring_assignment.entity.User;
import com.jovan_bojovic.spring_assignment.service.HelloService;
import com.jovan_bojovic.spring_assignment.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(path = "/secure/hello")
public class SecureHelloController {

    @Autowired
    private UserService userService;

    @Autowired
    private HelloService helloService;

    @GetMapping(path = "/")
    public ModelAndView getSecureHello() {
        ModelAndView modelAndView = new ModelAndView("login", "loginDTO", new LoginDTO());
        modelAndView.addObject("showMessage", false);
        return modelAndView;
    }

    @PostMapping(path = "/")
    public String login(@ModelAttribute LoginDTO loginDTO, Model model) {
        if(userService.doLogin(loginDTO.getUsername(), loginDTO.getPassword())) {
            return "admin-page";
        }
        model.addAttribute("showMessage", true);
        return "login";
    }

    @PostMapping(path = "/save-message")
    public String saveMessage(@ModelAttribute MessageDTO messageDTO, Model model) {
        System.out.printf(messageDTO.toString());
        if (helloService.saveHello(messageDTO.getLanguage(), messageDTO.getMessage())) {
            return "admin-page";
        }
        model.addAttribute("adminMessage", false);
        return "admin-page";
    }

}
