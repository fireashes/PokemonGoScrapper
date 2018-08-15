package com.caliyeti;

import com.caliyeti.pages.PokemonComPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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

import static java.lang.Thread.sleep;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class PokemonComTest {
    private WebDriver driver;
    private final Logger log = LoggerFactory.getLogger(PokemonComTest.class);

    @BeforeClass
    public static void setupClass() {
        WebDriverManager.chromedriver().setup();

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

    @Test
    public void testPokemonComUkPokedexGenI_1_100() {
        getPokemonComRange("Uk", 1, 100);
    }

    @Test
    public void testPokemonComUkPokedexGenI_101_151() {
        getPokemonComRange("Uk", 101, 151);
    }

    @Test
    public void testPokemonComUkPokedexGenII_152_200() {
        getPokemonComRange("Uk", 152, 200);
    }

    @Test
    public void testPokemonComUkPokedexGenII_201_251() {
        getPokemonComRange("Uk", 201, 251);
    }

    @Test
    public void testPokemonComUkPokedexGenIII_252_300() {
        getPokemonComRange("Uk", 252, 300);
    }

    @Test
    public void testPokemonComUkPokedexGenIII_301_386() {
        getPokemonComRange("Uk", 301, 386);
    }

    @Test
    public void testPokemonComUkPokedexGenIV_387_400() {
        getPokemonComRange("Uk", 387, 400);
    }

    @Test
    public void testPokemonComUkPokedexGenIV_401_492() {
        getPokemonComRange("Uk", 401, 487);
    }

    @Test
    public void testPokemonComUkPokedexGenIV_493_493() {
        getPokemonComRange("Uk", 493, 493);
    }

    @Test
    public void testPokemonComUkPokedexGenV_494_500() {
        getPokemonComRange("Uk", 494, 500);
    }

    @Test
    public void testPokemonComUkPokedexGenV_501_600() {
        getPokemonComRange("Uk", 501, 600);
    }

    @Test
    public void testPokemonComUkPokedexGenV_601_649() {
        getPokemonComRange("Uk", 601, 649);
    }

    @Test
    public void testPokemonComUkPokedexGenVI_650_700() {
        getPokemonComRange("Uk", 650, 700);
    }

    @Test
    public void testPokemonComUkPokedexGenVI_701_721() {
        getPokemonComRange("Uk", 701, 721);
    }

    @Test
    public void testPokemonComUkPokedexGenVII_722_800() {
        getPokemonComRange("Uk", 722, 800);
    }

    @Test
    public void testPokemonComUkPokedexGenVII_801_806() {
        getPokemonComRange("Uk", 801, 806);
    }

    @Test
    public void testPokemonComUsPokedexGenI_1_100() {
        getPokemonComRange("Us", 1, 100);
    }

    @Test
    public void testPokemonComUsPokedexGenI_101_151() {
        getPokemonComRange("Us", 101, 151);
    }

    @Test
    public void testPokemonComUsPokedexGenII_152_200() {
        getPokemonComRange("Us", 152, 200);
    }

    @Test
    public void testPokemonComUsPokedexGenII_201_251() {
        getPokemonComRange("Us", 201, 251);
    }

    @Test
    public void testPokemonComUsPokedexGenIII_252_300() {
        getPokemonComRange("Us", 252, 300);
    }

    @Test
    public void testPokemonComUsPokedexGenIII_301_386() {
        getPokemonComRange("Us", 301, 386);
    }

    @Test
    public void testPokemonComUsPokedexGenIV_387_400() {
        getPokemonComRange("Us", 387, 400);
    }

    @Test
    public void testPokemonComUsPokedexGenIV_401_492() {
        getPokemonComRange("Us", 401, 487);
    }

    @Test
    public void testPokemonComUsPokedexGenIV_493_493() {
        getPokemonComRange("Us", 493, 493);
    }

    @Test
    public void testPokemonComUsPokedexGenV_494_500() {
        getPokemonComRange("Us", 494, 500);
    }

    @Test
    public void testPokemonComUsPokedexGenV_501_600() {
        getPokemonComRange("Us", 501, 600);
    }

    @Test
    public void testPokemonComUsPokedexGenV_601_649() {
        getPokemonComRange("Us", 601, 649);
    }

    @Test
    public void testPokemonComUsPokedexGenVI_650_700() {
        getPokemonComRange("Us", 650, 700);
    }

    @Test
    public void testPokemonComUsPokedexGenVI_701_721() {
        getPokemonComRange("Us", 701, 721);
    }

    @Test
    public void testPokemonComUsPokedexGenVII_722_800() {
        getPokemonComRange("Us", 722, 800);
    }

    @Test
    public void testPokemonComUsPokedexGenVII_801_806() {
        getPokemonComRange("Us", 801, 806);
    }

    @Test
    public void testPokemonEvolution() {
        int startIndex = 1;
        int endIndex = 806;
        String location = "Us";
        Path path = Paths.get("./src/main/resources/PokemonCom" + location + "_" + startIndex + "-" + endIndex + ".properties");
        List<String> lines = new ArrayList<>();

        log.debug("startIndex = %d; endIndex = %d; location = %s; path = %s", startIndex, endIndex, location, path.toString());
        for (int index = startIndex; index <= endIndex; index++) {
            driver.get("https://www.pokemon.com/" + location.toLowerCase() + "/pokedex/" + index);
            try {
                sleep(1000);
            } catch (Exception e) {
                fail(e.getMessage());
            }
            PokemonComPage page = new PokemonComPage(driver);
            if (index == startIndex) {
                page.dismissCookie();
            }
            lines.add(index + "=" + page.findEvolutionClass());
            appendLinesToFile(lines, path);
        }
    }

    public void getPokemonComRange(String location, int startIndex, int endIndex) {
        Path path = Paths.get("./src/main/resources/PokemonCom" + location + "_" + startIndex + "-" + endIndex + ".properties");

        log.info("startIndex = %d; endIndex = %d; location = %s; path = %s", startIndex, endIndex, location, path.toString());
        for (int index = startIndex; index <= endIndex; index++) {
            log.info("index = %d", index);
            driver.get("https://www.pokemon.com/" + location.toLowerCase() + "/pokedex/" + index);
            try {
                sleep(500);
            } catch (Exception e) {
                fail(e.getMessage());
            }
            PokemonComPage page = new PokemonComPage(driver);
            if (index == startIndex) {
                page.dismissCookie();
            }
            getPageDetails(path, index, page);
        }
    }

    public void getPageDetails(Path path, int pokedex, PokemonComPage page) {
        List<String> lines = new ArrayList<>();
        page.findPokemonNamePokedexFormes();


        String pokedexTxt = String.format("%03d", pokedex);

        assertEquals(pokedexTxt + ": pokedex " + pokedex + " should be equal to pokedex displayed in the page " + page.getPokedex(), pokedex, page.getPokedex());
        assertEquals(pokedexTxt + ": pokedexTxt " + pokedexTxt + " should be equal to pokedexTxt displayed in the page " + page.getPokedexTxt(), pokedexTxt, page.getPokedexTxt());

        List<String> formesNamesList = page.getFormesNameList();

        lines.add(pokedexTxt + ".PokemonName=" + page.getPokemonName());
        lines.add(pokedexTxt + ".pokedex=" + page.getPokedex());
        lines.add(pokedexTxt + ".PokedexTxt=" + page.getPokedexTxt());
        lines.add(pokedexTxt + ".PokemonFormes=" + page.getFormesNameList());

        for (String formeName : formesNamesList) {
            try {
                page.selectForme(formeName);
                sleep(500);
                List<String> versions = page.findVersions();
                lines.add(pokedexTxt + "." + formeName + ".Versions=" + versions);
                for (String version : versions) {
                    page.selectVersion(version);
                    lines.add(pokedexTxt + "." + formeName + "." + version + ".Description=" + page.getDesctiption());
                    lines.add(pokedexTxt + "." + formeName + "." + version + ".Height=" + page.getHeight());
                    lines.add(pokedexTxt + "." + formeName + "." + version + ".Weight=" + page.getWeight());
                    lines.add(pokedexTxt + "." + formeName + "." + version + ".Genders=" + page.getGenders());
                    lines.add(pokedexTxt + "." + formeName + "." + version + ".Category=" + page.getCategory());
                    HashMap pokemonAbilities = page.findAbilities();
                    lines.add(pokedexTxt + "." + formeName + "." + version + ".Abilities=" + page.getAbilities());
                    for (Object abilityAbilityDescription : pokemonAbilities.entrySet()) {
                        Map.Entry pair = (Map.Entry) abilityAbilityDescription;
                        lines.add(pokedexTxt + "." + formeName + "." + version + ".Ability." + pair.getKey() + "=" + pair.getValue());
                    }
                    lines.add(pokedexTxt + "." + formeName + "." + version + ".Types=" + page.getTypes());
                }
                lines.add(pokedexTxt + ".evolutionClass=" + page.findEvolutionClass());
            } catch (Exception e) {
                fail(pokedexTxt + ":" + e.getMessage());
            }
        }
        appendLinesToFile(lines, path);
    }

    public void appendLinesToFile(List<String> lines, Path path) {
        try {
            if (Files.notExists(path) || !Files.isRegularFile(path)) {
                Files.createFile(path);
            }
            Files.write(path, lines, StandardOpenOption.APPEND);
        } catch (IOException e) {
            System.out.println("Could not add lines to the file " + path.toString());
        }
        for (String line : lines) {
            System.out.println(line);
        }
    }

}