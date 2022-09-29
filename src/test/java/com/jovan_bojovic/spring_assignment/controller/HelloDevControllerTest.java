package com.jovan_bojovic.spring_assignment.controller;

import com.jovan_bojovic.spring_assignment.entity.Hello;
import com.jovan_bojovic.spring_assignment.service.HelloService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import static org.mockito.Mockito.when;


@WebMvcTest(HelloDevController.class)
@ActiveProfiles("dev")
class HelloDevControllerTest {

    @MockBean
    private HelloService service;

    @Autowired
    private MockMvc mvc;

    @Test
    public void getHelloWorldMvcTest() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/hello/"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("hello-world"))
                .andExpect(MockMvcResultMatchers.model().attribute("lang", "Hello world!"));
    }

    @Test
    public void getLangHelloTest() throws Exception {
        when(service.findByLang("ES")).thenReturn(new Hello("ES", "Hola mundo!"));
        mvc.perform(MockMvcRequestBuilders.get("/hello/{lang}", "ES"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("hello-world"))
                .andExpect(MockMvcResultMatchers.model().attribute("lang", "Hola mundo!"));
    }

}