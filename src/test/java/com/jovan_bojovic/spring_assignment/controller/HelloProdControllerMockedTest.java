package com.jovan_bojovic.spring_assignment.controller;

import com.jovan_bojovic.spring_assignment.api.LanguageAPI;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.mockito.Mockito.when;

@WebMvcTest(HelloProdController.class)
@ActiveProfiles("prod")
public class HelloProdControllerMockedTest {

    @Autowired
    private MockMvc mvc;

    @Mock
    private LanguageAPI api;

    @Test
    public void getLangHelloTestMockedApi() throws Exception {
        when(api.getTranslationFromApi("de_DE")).thenReturn("Hallo Welt!");
        mvc.perform(MockMvcRequestBuilders.get("/hello/de_DE"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("hello-world"))
                .andExpect(MockMvcResultMatchers.model().attribute("lang", "Hallo Welt!"));
    }

}
