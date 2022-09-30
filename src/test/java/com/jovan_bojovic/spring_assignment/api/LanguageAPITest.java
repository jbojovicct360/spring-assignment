package com.jovan_bojovic.spring_assignment.api;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class LanguageAPITest {

    private LanguageAPI api;

    @BeforeAll
    public void init() {
        api = new LanguageAPI();
    }

    @Test
    public void getTranslationFromApiTest() {
        assertEquals("Hallo Welt!", api.getTranslationFromApi("de_DE"));
        assertEquals("Ahoj svět!", api.getTranslationFromApi("cs_CZ"));
        assertEquals("Hej verden!", api.getTranslationFromApi("da_DK"));
        assertEquals("Hallo wereld!", api.getTranslationFromApi("nl_NL"));
        assertEquals("Hei maailma!", api.getTranslationFromApi("fi_FI"));
        assertEquals("Bonjour le monde!", api.getTranslationFromApi("fr_FR"));
    }

}