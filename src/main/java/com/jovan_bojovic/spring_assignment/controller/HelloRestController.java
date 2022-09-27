package com.jovan_bojovic.spring_assignment.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/hello-rest")
public class HelloRestController {

    @GetMapping(path = "/")
    public String getHelloWorld() {
        return "Hello world!";
    }
    
}
