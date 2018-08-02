package com.caliyeti;

import org.junit.Test;
import static org.junit.Assert.*;

public class PokemonGoScrapperAppTest {
    @Test public void testAppHasAGreeting() {
        PokemonGoScrapperApp classUnderTest = new PokemonGoScrapperApp();
        assertNotNull("app should have a greeting", classUnderTest.getGreeting());
    }
}
