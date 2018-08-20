package com.caliyeti;

import com.caliyeti.pages.PokemonComPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
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
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

@RunWith(Parameterized.class)
public class PokemonComTest {
    private WebDriver driver;
    private final Logger log = LoggerFactory.getLogger(PokemonComTest.class);

    @Parameterized.Parameters(name = "test : location {0}; startIndex {1}; endIndex {2}")
    public static Collection<Object[]> data() {
        List<Object[]> paramaterizedData = Arrays.asList(new Object[][]{
                // Gen I
                {"Uk", 1, 50},
                {"Us", 1, 50},
                {"Uk", 51, 100},
                {"Us", 51, 100},
                {"Uk", 101, 151},
                {"Us", 101, 151},

                // Gen II
                {"Uk", 152, 200},
                {"Us", 152, 200},
                {"Uk", 201, 251},
                {"Us", 201, 251},

                // Gen III
                {"Uk", 252, 300},
                {"Us", 252, 300},
                {"Uk", 301, 350},
                {"Us", 301, 350},
                {"Uk", 351, 386},
                {"Us", 351, 386},

                // Gen IV
                {"Uk", 387, 400},
                {"Us", 387, 400},
                {"Uk", 401, 450},
                {"Us", 401, 450},
                {"Uk", 451, 493},
                {"Us", 451, 493},

                // Gen V
                {"Uk", 494, 550},
                {"Us", 494, 550},
                {"Uk", 551, 600},
                {"Us", 551, 600},
                {"Uk", 601, 649},
                {"Us", 601, 649},

                // Gen VI
                {"Uk", 650, 700},
                {"Us", 650, 700},
                {"Uk", 701, 721},
                {"Us", 701, 721},

                // Gen VII
                {"Uk", 722, 750},
                {"Us", 722, 750},
                {"Uk", 751, 806},
                {"Us", 751, 806},

//                one=083 (1)
//                two=019 (1>1) (first-last)
//                three=001 (1>1>1) (first-middle)(middle-last)
//                four=133 (1>8) (1-2)(1-3)(1-4)(1-5)(1-6)(1-7)(1-8)(1-9)
//                five=265 (1>2>2) (1-2)(2-3)(1-4)(4-5)
//                six=043 (1>1>2) (1-2)(2-3)(2-4)
//                seven=079 (1>2) (1-2)(1-3)
//                eight=106 (1>3) (1-2)(1-3)(1-4)

//                {"Us", 1, 9},       // evolution3, 2Types,1 Type Mega, Gender male+female, Gender Unknown, 1 ability, space, versions
//                {"Us", 16, 18},     // 2 abilities
//                {"Us", 19, 20},
//                {"Us", 29, 34},
//                {"Us", 43, 45},
//                {"Us", 79, 80},
//                {"Us", 81, 82},
//                {"Us", 83, 83},
//                {"Us", 182, 182},
//                {"Us", 106, 107},
//                {"Us", 133, 136},
//                {"Us", 196, 197},
//                {"Us", 199, 199},
//                {"Us", 236, 237},
//                {"Us", 265, 269},
//                {"Us", 462, 462},
//                {"Us", 470, 471},
//                {"Us", 3, 3},
//                {"Us", 1, 1},
//                {"Us", 3, 3},
//                {"Us", 6, 6},
//                {"Us", 9, 9},
                {"Us", 493, 493},
//                {"Uk", 801, 806},
//                {"Us", 1, 806},

        });
        return paramaterizedData;
    }

    @Parameterized.Parameter
    public String location;

    @Parameterized.Parameter(1)
    public int startIndex;

    @Parameterized.Parameter(2)
    public int endIndex;

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
    public void testPokemonCom() {
        getPokemonComRange(location, startIndex, endIndex);
    }

    private void getPokemonComRange(String location, int startIndex, int endIndex) {
        Path path = Paths.get("./src/main/data/PokemonCom" + location + "_" + String.format("%03d", startIndex) + "-" + String.format("%03d", endIndex) + ".properties");

//        log.info("startIndex = " + startIndex + "; endIndex = " + endIndex + "; location = " + location + "; path = " + path.toString());
        for (int index = startIndex; index <= endIndex; index++) {
            path = Paths.get("./src/main/data/PokemonCom" + location + "_" + getGen(index) + ".properties");
//            log.info("index = " + index);
            driver.get("https://www.pokemon.com/" + location.toLowerCase() + "/pokedex/" + index);
//            try {
//                sleep(500);
//            } catch (Exception e) {
//                fail(e.getMessage());
//            }
            PokemonComPage page = new PokemonComPage(driver);
            page.sleepMillis(1000);
            if (index == startIndex) {
                page.dismissCookie();
            }
            getPageDetails(path, index, page);
        }
    }

    private void getPageDetails(Path path, int pokedex, PokemonComPage page) {
        List<String> lines = new ArrayList<>();
        page.findPokemonNamePokedexFormes();

        String pokedexTxt = String.format("%03d", pokedex);

        assertEquals(pokedexTxt + ": pokedex " + pokedex + " should be equal to pokedex displayed in the page " + page.getPokedex(), pokedex, page.getPokedex());
        assertEquals(pokedexTxt + ": pokedexTxt " + pokedexTxt + " should be equal to pokedexTxt displayed in the page " + page.getPokedexTxt(), pokedexTxt, page.getPokedexTxt());
        assertEquals(pokedexTxt + ": pokedexTxt " + pokedexTxt + " and pokedex " + pokedex + " displayed in the page should be same integer", page.getPokedex(), Integer.parseInt(page.getPokedexTxt()));

        List<String> formesNamesList = page.getFormesNameList();

        lines.add(pokedexTxt + ".PokemonName=" + page.getPokemonName());
        lines.add(pokedexTxt + ".PokemonNameSimple=" + page.getPokemonNameSimple());
        lines.add(pokedexTxt + ".Pokedex=" + page.getPokedex());
        lines.add(pokedexTxt + ".PokedexTxt=" + page.getPokedexTxt());
        lines.add(pokedexTxt + ".PokemonFormes=" + page.getFormesNameList());
        log.info("formesNamesList = " + formesNamesList);
        for (String formeName : formesNamesList) {
            try {
                log.info("formeName = " + formeName);
                page.selectForme(formeName);
                sleep(500);
                List<String> versions = page.findVersions();
                lines.add(pokedexTxt + "." + formeName + ".Versions=" + versions);
                for (String version : versions) {
                    page.selectVersion(version);
                    lines.add(pokedexTxt + "." + formeName + "." + version + ".Description=" + page.findDescription());
                    lines.add(pokedexTxt + "." + formeName + "." + version + ".Height=" + page.findHeight());
                    lines.add(pokedexTxt + "." + formeName + "." + version + ".Weight=" + page.findWeight());
                    lines.add(pokedexTxt + "." + formeName + "." + version + ".Genders=" + page.findGenders());
                    lines.add(pokedexTxt + "." + formeName + "." + version + ".Category=" + page.findCategory());
                    HashMap pokemonAbilitiesAndDescriptions = page.findAbilitiesAndItsDescriptions();
                    lines.add(pokedexTxt + "." + formeName + "." + version + ".Abilities=" + page.getAbilities());
                    for (Object abilityAbilityDescription : pokemonAbilitiesAndDescriptions.entrySet()) {
                        Map.Entry pair = (Map.Entry) abilityAbilityDescription;
                        lines.add(pokedexTxt + "." + formeName + "." + version + ".Ability." + pair.getKey() + "=" + pair.getValue());
                    }
                    lines.add(pokedexTxt + "." + formeName + "." + version + ".Types=" + page.getTypes());
                }
            } catch (Exception e) {
                fail(pokedexTxt + ":" + e.getMessage());
            }
        }
        lines.add(pokedexTxt + ".EvolutionClass=" + page.findEvolutionClass());
        lines.add(pokedexTxt + ".EvolutionBranches=" + page.findEvolutionBranches());
        appendLinesToFile(lines, path);
    }

    private void appendLinesToFile(List<String> lines, Path path) {
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

    private String getGen(int pokedex) {
        if (pokedex >= 1 && pokedex <= 151) {
            return "GenI";
        } else if (pokedex >= 152 && pokedex <= 251) {
            return "GenII";
        } else if (pokedex >= 252 && pokedex <= 386) {
            return "GenIII";
        } else if (pokedex >= 387 && pokedex <= 493) {
            return "GenIV";
        } else if (pokedex >= 494 && pokedex <= 649) {
            return "GenV";
        } else if (pokedex >= 650 && pokedex <= 721) {
            return "GenVI";
        } else if (pokedex >= 722 && pokedex <= 806) {
            return "GenVII";
        } else {
            return "Gen0";
        }
    }

    private String getGen(String pokedexTxt) {
        return getGen(Integer.parseInt(pokedexTxt));
    }
}
