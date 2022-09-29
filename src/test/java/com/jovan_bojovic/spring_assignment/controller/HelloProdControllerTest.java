package com.jovan_bojovic.spring_assignment.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


@WebMvcTest(HelloProdController.class)
@ActiveProfiles("prod")
class HelloProdControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void getLangHelloTest() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/hello/de_DE"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("hello-world"))
                .andExpect(MockMvcResultMatchers.model().attribute("lang", "Hallo Welt!"));
    }

}