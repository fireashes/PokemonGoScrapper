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

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
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
        String location = "us";
        location = "us";
        Path path = null;
        if (location.toLowerCase().equals("us")) {
            path = Paths.get("./src/main/resources/testPokemonComUsPokedex.properties");
        } else if (location.toLowerCase().equals("uk")) {
            path = Paths.get("./src/main/resources/testPokemonComUkPokedex.properties");
        } else {
            path = Paths.get("./src/main/resources/testPokemonComUkPokedex.properties");
        }
        int startIndex = 493; //1-492,494-806
        int endIndex = 493;
        for (int i = startIndex; i <= endIndex; i++) {
            List<String> lines = new ArrayList<>();

            if (location.toLowerCase().equals("us")) {
                driver.get("https://www.pokemon.com/us/pokedex/" + i);
            } else if (location.toLowerCase().equals("uk")) {
                driver.get("https://www.pokemon.com/uk/pokedex/" + i);
            } else {
                driver.get("https://www.pokemon.com/uk/pokedex/" + i);
            }
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
            String pokemonPokedex = page.getPokemonPokedex().replace("#", "");
            List<String> formesNamesList = page.getFormesNameList();
            assert (Integer.parseInt(pokemonPokedex) == i);

            lines.add(pokemonPokedex + ".PokemonName=" + pokemonName);
            lines.add(pokemonPokedex + ".PokemonPokedex=" + pokemonPokedex);
            lines.add(pokemonPokedex + ".PokemonFormes=" + formesNamesList);


            for (String formeName : formesNamesList) {
                try {
                    page.selectForme(formeName);
                    sleep(500);
                    lines.add(pokemonPokedex + "." + formeName + ".NumberOfVersions=" + page.getNumberOfVersions());

                    page.selectVersionY();
                    sleep(500);
                    lines.add(pokemonPokedex + "." + formeName + ".Y.Description=" + page.getDesctiption());
                    lines.add(pokemonPokedex + "." + formeName + ".Y.Height=" + page.getHeight());
                    lines.add(pokemonPokedex + "." + formeName + ".Y.Weight=" + page.getWeight());
                    lines.add(pokemonPokedex + "." + formeName + ".Y.Genders=" + page.getGenders());
                    lines.add(pokemonPokedex + "." + formeName + ".Y.Category=" + page.getCategory());
                    lines.add(pokemonPokedex + "." + formeName + ".Y.Abilities=" + page.getAbilities());
                    lines.add(pokemonPokedex + "." + formeName + ".Y.Types=" + page.getTypes());

                    page.selectVersionX();
                    sleep(500);
                    lines.add(pokemonPokedex + "." + formeName + ".X.Description=" + page.getDesctiption());
                    lines.add(pokemonPokedex + "." + formeName + ".X.Height=" + page.getHeight());
                    lines.add(pokemonPokedex + "." + formeName + ".X.Weight=" + page.getWeight());
                    lines.add(pokemonPokedex + "." + formeName + ".X.Gender=" + page.getGenders());
                    lines.add(pokemonPokedex + "." + formeName + ".X.Category=" + page.getCategory());
                    lines.add(pokemonPokedex + "." + formeName + ".X.Abilities=" + page.getAbilities());
                    lines.add(pokemonPokedex + "." + formeName + ".X.Types=" + page.getTypes());

                } catch (Exception e) {
                    fail(e.getMessage());
                }
            }
            appendLinesToFile(lines, path);
        }
    }

    public void appendLineToPath(String line, Path path) {
        List<String> lines = new ArrayList<>();
        lines.add(line);
        appendLinesToFile(lines, path);
    }

    public void appendLinesToFile(List<String> lines, Path path) {
        try {
            if (Files.notExists(path) || !Files.isRegularFile(path)) {
                Files.createFile(path);
            }
            for (String line : lines) {
                System.out.println(line);
            }
            Files.write(path, lines, StandardOpenOption.APPEND);
        } catch (IOException e) {
            for (String line : lines) {
                System.out.println(line);
            }
        }
    }

}