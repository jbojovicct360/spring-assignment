package com.jovan_bojovic.spring_assignment.controller;

import com.jovan_bojovic.spring_assignment.service.HelloService;
import com.jovan_bojovic.spring_assignment.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;

@WebMvcTest(SecureHelloController.class)
class SecureHelloControllerTest {

    @MockBean
    private UserService userService;

    @MockBean
    private HelloService helloService;

    @Autowired
    private MockMvc mvc;

    @Test
    void testGetLoginPage() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/secure/hello/"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("login"));
    }

}