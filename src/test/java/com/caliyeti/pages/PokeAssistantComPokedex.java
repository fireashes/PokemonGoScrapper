package com.caliyeti.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PokeAssistantComPokedex extends PokemonPage {
    public PokeAssistantComPokedex(WebDriver driver) {
        super(driver);
    }
    public void ashes (){
        driver.getTitle();
        sleepMillis(500);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("")));
    }

}
