package com.jovan_bojovic.spring_assignment.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = HelloRestController.class)
@WebAppConfiguration
class HelloRestControllerTest {

    private MockMvc mvc;

    @Autowired
    WebApplicationContext context;

    @BeforeEach
    protected void setUp() {
        mvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    public void restHelloWorldTest() throws Exception {
        MvcResult result = mvc.perform(MockMvcRequestBuilders.get("/hello-rest/")
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
        int status = result.getResponse().getStatus();
        assertEquals(200, status);
        assertEquals("Hello world!", result.getResponse().getContentAsString());
    }

}