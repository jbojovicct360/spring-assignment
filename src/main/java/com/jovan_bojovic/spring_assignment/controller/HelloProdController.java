package com.jovan_bojovic.spring_assignment.controller;

import com.jovan_bojovic.spring_assignment.api.LanguageAPI;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Profile("prod")
@RequestMapping(path = "/hello")
public class HelloProdController {

    @GetMapping(path = "/{lang}")
    public String getLangHello(@PathVariable(value = "lang") String lang, Model model) {
        String byLang = LanguageAPI.getTranslationFromApi(lang);
        if(byLang == null) {
            model.addAttribute("lang", "Hello world");
        } else {
            model.addAttribute("lang", byLang);
        }
        return "hello-world";
    }

}
