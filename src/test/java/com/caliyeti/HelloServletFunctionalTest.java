package com.caliyeti;

import com.caliyeti.Pages.PokemonComUkPokedexName;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;
import static java.lang.Thread.sleep;

public class HelloServletFunctionalTest {
    private WebDriver driver;

    @BeforeClass
    public static void setupClass() {
        ChromeDriverManager.getInstance().setup();
    }

    @Before
    public void setUp() {
        try {
            driver = new ChromeDriver();
        } catch (Exception e) {
            fail(e.getMessage());
        }
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @After
    public void tearDown() {
        if (driver != null)
            driver.quit();
    }

    @Ignore
    @Test
    public void sayHello() throws Exception {
        driver.get("http://localhost:8080/PokemonGoScrapper");

        driver.findElement(By.id("say-hello-text-input")).sendKeys("Ashes");
        driver.findElement(By.id("say-hello-button")).click();

        assertEquals("Hello Page", driver.getTitle());
        assertEquals("Hello, Ashes!", driver.findElement(By.tagName("h2")).getText());
    }

    @Test
    public void testPokemonComUkPokedex() {
        int startIndex = 1; //1-806
        int endIndex = 806;
        for (int i = startIndex; i <= endIndex; i++) {

            driver.get("https://www.pokemon.com/uk/pokedex/" + i);
            try {
                sleep(500);
            } catch (Exception e) {
                fail(e.getMessage());
            }
            PokemonComUkPokedexName page = new PokemonComUkPokedexName(driver);
            if (i == startIndex) {
                page.dismissCookie();
            }

            page.findPokemonNamePokedexFormes();
            String pokemonName = page.getPokemonName();
            String pokemonPokedex = page.getPokemonPokedex();
            List<String> formesNamesList = page.getFormesNameList();

            System.out.println(i + ".PokemonName=" + pokemonName);
            System.out.println(i + ".PokemonPokedex=" + pokemonPokedex);
            System.out.println(i + ".PokemonFormes=" + formesNamesList);



            for (String formeName : formesNamesList) {
                try {
                    page.selectForme(formeName);
                    sleep(500);
                    System.out.println(i + "." + formeName + ".NumberOfVersions=" + page.getNumberOfVersions());

                    page.selectVersionY();
                    sleep(500);
                    System.out.println(i + "." + formeName + ".Y.Description=" + page.getDesctiption());
                    System.out.println(i + "." + formeName + ".Y.Height=" + page.getHeight());
                    System.out.println(i + "." + formeName + ".Y.Weight=" + page.getWeight());
                    System.out.println(i + "." + formeName + ".Y.Genders=" + page.getGenders());
                    System.out.println(i + "." + formeName + ".Y.Category=" + page.getCategory());
                    System.out.println(i + "." + formeName + ".Y.Abilities=" + page.getAbilities());
                    System.out.println(i + "." + formeName + ".Y.Types=" + page.getTypes());

                    page.selectVersionX();
                    sleep(500);
                    System.out.println(i + "." + formeName + ".X.Description=" + page.getDesctiption());
                    System.out.println(i + "." + formeName + ".X.Height=" + page.getHeight());
                    System.out.println(i + "." + formeName + ".X.Weight=" + page.getWeight());
                    System.out.println(i + "." + formeName + ".X.Gender=" + page.getGenders());
                    System.out.println(i + "." + formeName + ".X.Category=" + page.getCategory());
                    System.out.println(i + "." + formeName + ".X.Abilities=" + page.getAbilities());
                    System.out.println(i + "." + formeName + ".X.Types=" + page.getTypes());

                } catch (Exception e) {
                    fail(e.getMessage());
                }
            }
        }
    }
}