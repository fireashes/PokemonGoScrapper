package com.caliyeti;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PokemonGoScrapperApp {
    private final Logger log = LoggerFactory.getLogger(getClass());

    public String getGreeting() {
        log.trace("Trace message");
        log.debug("Debug message");
        log.info("Info message");
        log.warn("Warning message");
        log.error("Error message");
//        log.fatal("Log fatal");


        for (int i = 0; i < 10; i++) {
            if (i % 2 == 0) {
                log.info("Hello {}", i);
            } else {
                log.debug("I am on index {}", i);
            }
        }
        return "Hello world.";
    }

    public static void main(String[] args) {

        System.out.println(new PokemonGoScrapperApp().getGreeting());
        int pokedex = 100;
        String pokedexTxt = String.format("%03d", pokedex);
        System.out.println("PokedexTxt = " + pokedexTxt);

    }
}
