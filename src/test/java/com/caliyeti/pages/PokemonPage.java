package com.caliyeti.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PokemonPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public PokemonPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 30);
        PageFactory.initElements(driver, this);
    }
    public String getTitle() {
        return driver.getTitle();
    }
    public String getCurrentUrl(){
        return driver.getCurrentUrl();
    }

}
