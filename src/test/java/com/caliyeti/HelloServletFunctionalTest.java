package com.caliyeti;

import com.caliyeti.Pages.PokemonComPokedexName;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
    public void testPokemonComUkPokedexI_1_100() {
        getPokemonComRange("Uk", 1, 100);
    }

    @Test
    public void testPokemonComUkPokedexI_101_151() {
        getPokemonComRange("Uk", 101, 151);
    }

    @Test
    public void testPokemonComUkPokedexII_152_200() {
        getPokemonComRange("Uk", 152, 200);
    }

    @Test
    public void testPokemonComUkPokedexII_201_251() {
        getPokemonComRange("Uk", 201, 251);
    }

    @Test
    public void testPokemonComUkPokedexIII_252_300() {
        getPokemonComRange("Uk", 252, 300);
    }

    @Test
    public void testPokemonComUkPokedexIII_301_386() {
        getPokemonComRange("Uk", 301, 386);
    }

    @Test
    public void testPokemonComUkPokedexIV_387_400() {
        getPokemonComRange("Uk", 387, 400);
    }

    @Test
    public void testPokemonComUkPokedexIV_401_487() {
        getPokemonComRange("Uk", 401, 487);
    }

    @Test
    public void testPokemonComUkPokedexIV_488_492() {
        getPokemonComRange("Uk", 488, 492);
    }

    @Test
    public void testPokemonComUkPokedexIV_493_493() {
        getPokemonComRange("Uk", 493, 493);
    }

    @Test
    public void testPokemonComUkPokedexV_494_500() {
        getPokemonComRange("Uk", 494, 500);
    }

    @Test
    public void testPokemonComUkPokedexV_501_600() {
        getPokemonComRange("Uk", 501, 600);
    }

    @Test
    public void testPokemonComUkPokedexV_601_649() {
        getPokemonComRange("Uk", 601, 649);
    }

    @Test
    public void testPokemonComUkPokedexVI_650_700() {
        getPokemonComRange("Uk", 650, 700);
    }

    @Test
    public void testPokemonComUkPokedexVI_701_721() {
        getPokemonComRange("Uk", 701, 721);
    }

    @Test
    public void testPokemonComUkPokedexVII_722_800() {
        getPokemonComRange("Uk", 722, 800);
    }

    @Test
    public void testPokemonComUkPokedexVII_801_806() {
        getPokemonComRange("Uk", 801, 806);
    }

    @Test
    public void testPokemonComUsPokedexI_1_100() {
        getPokemonComRange("Us", 1, 100);
    }

    @Test
    public void testPokemonComUsPokedexI_101_151() {
        getPokemonComRange("Us", 101, 151);
    }

    @Test
    public void testPokemonComUsPokedexII_152_200() {
        getPokemonComRange("Us", 152, 200);
    }

    @Test
    public void testPokemonComUsPokedexII_201_251() {
        getPokemonComRange("Us", 201, 251);
    }

    @Test
    public void testPokemonComUsPokedexIII_252_300() {
        getPokemonComRange("Us", 252, 300);
    }

    @Test
    public void testPokemonComUsPokedexIII_301_386() {
        getPokemonComRange("Us", 301, 386);
    }

    @Test
    public void testPokemonComUsPokedexIV_387_400() {
        getPokemonComRange("Us", 387, 400);
    }

    @Test
    public void testPokemonComUsPokedexIV_401_487() {
        getPokemonComRange("Us", 401, 487);
    }

    @Test
    public void testPokemonComUsPokedexIV_488_492() {
        getPokemonComRange("Us", 488, 492);
    }

    @Test
    public void testPokemonComUsPokedexIV_493_493() {
        getPokemonComRange("Us", 493, 493);
    }

    @Test
    public void testPokemonComUsPokedexV_494_500() {
        getPokemonComRange("Us", 494, 500);
    }

    @Test
    public void testPokemonComUsPokedexV_501_600() {
        getPokemonComRange("Us", 501, 600);
    }

    @Test
    public void testPokemonComUsPokedexV_601_649() {
        getPokemonComRange("Us", 601, 649);
    }

    @Test
    public void testPokemonComUsPokedexVI_650_700() {
        getPokemonComRange("Us", 650, 700);
    }

    @Test
    public void testPokemonComUsPokedexVI_701_721() {
        getPokemonComRange("Us", 701, 721);
    }

    @Test
    public void testPokemonComUsPokedexVII_722_800() {
        getPokemonComRange("Us", 722, 800);
    }

    @Test
    public void testPokemonComUsPokedexVII_801_806() {
        getPokemonComRange("Us", 801, 806);
    }

    public void getPokemonComRange(String location, int startIndex, int endIndex) {
        Path path = Paths.get("./src/main/resources/testPokemonCom" + location + ".properties");
        for (int index = startIndex; index <= endIndex; index++) {
            driver.get("https://www.pokemon.com/" + location.toLowerCase() + "/pokedex/" + index);
            try {
                sleep(500);
            } catch (Exception e) {
                fail(e.getMessage());
            }
            PokemonComPokedexName page = new PokemonComPokedexName(driver);
            if (index == startIndex) {
                page.dismissCookie();
            }
            getPageDetails(path, index, page);
        }
    }

    public void getPageDetails(Path path, int pokemonPokedex, PokemonComPokedexName page) {
        List<String> lines = new ArrayList<>();
        page.findPokemonNamePokedexFormes();
        String pokemonName = page.getPokemonName();
        assertTrue(page.getCurrentUrl().toLowerCase().contains(pokemonName.toLowerCase()));
        List<String> formesNamesList = page.getFormesNameList();

        lines.add(pokemonPokedex + ".PokemonName=" + pokemonName);
        lines.add(pokemonPokedex + ".PokemonPokedex=" + pokemonPokedex);
        lines.add(pokemonPokedex + ".PokemonFormes=" + formesNamesList);

        for (String formeName : formesNamesList) {
            try {
                page.selectForme(formeName);
                sleep(500);
                List<String> versions = page.getVersions();
                lines.add(pokemonPokedex + "." + formeName + ".Versions=" + versions);
                for (String version : versions) {
                    page.selectVersion(version);
                    lines.add(pokemonPokedex + "." + formeName + "." + version + ".Description=" + page.getDesctiption());
                    lines.add(pokemonPokedex + "." + formeName + "." + version + ".Height=" + page.getHeight());
                    lines.add(pokemonPokedex + "." + formeName + "." + version + ".Weight=" + page.getWeight());
                    lines.add(pokemonPokedex + "." + formeName + "." + version + ".Genders=" + page.getGenders());
                    lines.add(pokemonPokedex + "." + formeName + "." + version + ".Category=" + page.getCategory());
                    HashMap pokemonAbilities = page.findAbilities();
                    lines.add(pokemonPokedex + "." + formeName + "." + version + ".Abilities=" + page.getAbilities());
                    for (Object abilityAbilityDescription : pokemonAbilities.entrySet()) {
                        Map.Entry pair = (Map.Entry) abilityAbilityDescription;
                        lines.add(pokemonPokedex + "." + formeName + "." + version + ".Ability." + pair.getKey() + "=" + pair.getValue());
                    }
                    lines.add(pokemonPokedex + "." + formeName + "." + version + ".Types=" + page.getTypes());
                }
            } catch (Exception e) {
                e.printStackTrace();
                fail(e.getMessage());
            }
        }
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