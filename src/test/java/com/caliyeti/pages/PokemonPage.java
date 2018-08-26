package com.caliyeti.pages;

import com.caliyeti.model.Pokemon;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class PokemonPage {
    WebDriver driver;
    WebDriverWait wait;
    Actions actions;

    Pokemon pokemon = new Pokemon();
    List<Pokemon> pokemonList = new ArrayList<>();

    public PokemonPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 30);
        actions = new Actions(driver);
        PageFactory.initElements(driver, this);
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public void sleepMillis(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            fail(e.getMessage());
        }
    }

    public PokemonPage load(String baseurl) {
        return this;
    }

}
