package com.jovan_bojovic.spring_assignment.api;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LanguageAPITest {

    @Test
    public void getTranslationFromApiTest() {
        assertEquals("Hallo Welt!", LanguageAPI.getTranslationFromApi("de_DE"));
        assertEquals("Ahoj svět!", LanguageAPI.getTranslationFromApi("cs_CZ"));
        assertEquals("Hej verden!", LanguageAPI.getTranslationFromApi("da_DK"));
        assertEquals("Hallo wereld!", LanguageAPI.getTranslationFromApi("nl_NL"));
        assertEquals("Hei maailma!", LanguageAPI.getTranslationFromApi("fi_FI"));
        assertEquals("Bonjour le monde!", LanguageAPI.getTranslationFromApi("fr_FR"));
    }

}