package com.caliyeti;

import com.caliyeti.pages.PokemonComPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
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

import static java.lang.Thread.sleep;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class PokemonComTest {
    private WebDriver driver;

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

    @Test
    public void testPokemonEvolution() {
        int startIndex = 1;
        int endIndex = 806;
        String location = "Us";
        Path path = Paths.get("./src/main/resources/PokemonCom" + location + "_" + startIndex + "-" + endIndex + ".properties");
        List<String> lines = new ArrayList<>();

        if (!Files.exists(path)) {
            try {
                Files.createFile(path);
            } catch (IOException e) {
                fail("Could not create " + path.toString() + "\n" + e.getMessage());
            }
        }
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
//        System.out.printf("Starting location = %s\tstartIndex = %d\tendIndex = %d\n", location, startIndex, endIndex);
        Path path = Paths.get("./src/main/resources/PokemonCom" + location + "_" + startIndex + "-" + endIndex + ".properties");
        List<String> lines = new ArrayList<>();

        if (!Files.exists(path)) {
            try {
                Files.createFile(path);
            } catch (IOException e) {
                fail("Could not create " + path.toString() + "\n" + e.getMessage());
            }
        }
        for (int index = startIndex; index <= endIndex; index++) {
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
            appendLinesToFile(lines, path);
        }
    }

    public void getPageDetails(Path path, int pokedex, PokemonComPage page) {
        List<String> lines = new ArrayList<>();
        page.findPokemonNamePokedexFormes();
        String pokemonName = page.getPokemonName();
        String pokedexTxt = page.getPokedexTxt();
        assertEquals(pokedexTxt + ": pokedex " + pokedex + " should match with pokedexTxt " + pokedexTxt, Integer.parseInt(pokedexTxt), pokedex);
        List<String> formesNamesList = page.getFormesNameList();

        lines.add(pokedexTxt + ".PokemonName=" + pokemonName);
        lines.add(pokedexTxt + ".PokedexTxt=" + pokedexTxt);
        lines.add(pokedexTxt + ".PokemonFormes=" + formesNamesList);

        for (String formeName : formesNamesList) {
            try {
                page.selectForme(formeName);
                sleep(500);
                List<String> versions = page.getVersions();
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
                e.printStackTrace();
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