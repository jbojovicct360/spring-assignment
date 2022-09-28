package com.jovan_bojovic.spring_assignment.controller;

import com.jovan_bojovic.spring_assignment.entity.Hello;
import com.jovan_bojovic.spring_assignment.service.HelloService;
import okhttp3.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/hello")
public class HelloController {

    @Autowired
    HelloService service;

    @GetMapping(path = "/")
    public String helloWorldMVC(Model model) {
        model.addAttribute("lang", "Hello world!");
        return "hello-world";
    }

    @GetMapping(path = "/{lang}")
    public String getLangHello(@PathVariable(value = "lang") String lang, Model model) {
        Hello byLang = service.findByLang(lang);
        if(byLang == null) {
            model.addAttribute("lang", "Hello world");
        } else {
            model.addAttribute("lang", byLang.getCURRENT());
        }
        return "hello-world";
    }

    @GetMapping(path = "/api/{lang}")
    public String getLangApiHello(@PathVariable(value = "lang") String lang, Model model) {
        return null;
    }

}
