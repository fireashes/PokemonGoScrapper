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

//                {"Fr", 1, 806},
//                {"Es", 1, 806},

                {"Uk", 1, 151},
                {"Uk", 152, 251},
                {"Uk", 252, 386},
                {"Uk", 387, 493},
                {"Uk", 494, 649},
                {"Uk", 650, 721},
                {"Uk", 722, 806},

                {"Us", 1, 151},
                {"Us", 152, 251},
                {"Us", 252, 386},
                {"Us", 387, 493},
                {"Us", 494, 649},
                {"Us", 650, 721},
                {"Us", 722, 806},
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
        getPokemonComRange(startIndex, endIndex);
    }

    private void getPokemonComRange(int startIndex, int endIndex) {
        Path path = null;

        for (int index = startIndex; index <= endIndex; index++) {
            path = Paths.get("./src/main/data/PokemonCom/" + location.toLowerCase() + "/" + getGen(index) + "/" + String.format("%03d", index) + ".properties");
            path = Paths.get("./src/main/data/PokemonCom/" + location.toLowerCase() + "_" + getGen(index) + ".properties");
            driver.get("https://www.pokemon.com/" + location.toLowerCase() + "/pokedex/" + index);
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
        String pokedexTxt = String.format("%03d", pokedex);
        try {
            page.findPokemonNamePokedexFormes();

            assertEquals(pokedexTxt + ": pokedex " + pokedex + " should be equal to pokedex displayed in the page " + page.getPokedex(), pokedex, page.getPokedex());
            assertEquals(pokedexTxt + ": pokedexTxt " + pokedexTxt + " should be equal to pokedexTxt displayed in the page " + page.getPokedexTxt(), pokedexTxt, page.getPokedexTxt());
            assertEquals(pokedexTxt + ": pokedexTxt " + pokedexTxt + " and pokedex " + pokedex + " displayed in the page should be same integer", page.getPokedex(), Integer.parseInt(page.getPokedexTxt()));

            List<String> formesNamesList = page.getFormesNameList();
            String pokemonName = page.getPokemonName();
            lines.add(pokedexTxt + ".PokemonName=" + pokemonName);
            String pokemonNameSimple = page.getPokemonNameSimple();
            lines.add(pokedexTxt + ".PokemonNameSimple=" + pokemonNameSimple);
            if (!pokemonName.equalsIgnoreCase(pokemonNameSimple)) {
                System.out.println(pokedexTxt + ": Pokemon name and simple name don't match. '" + pokemonName + "' != '" + pokemonNameSimple + "'");
                log.info(pokedexTxt + ": Pokemon name and simple name don't match. '" + pokemonName + "' != '" + pokemonNameSimple + "'");
            }
            lines.add(pokedexTxt + ".Pokedex=" + page.getPokedex());
            lines.add(pokedexTxt + ".PokedexTxt=" + page.getPokedexTxt());
            lines.add(pokedexTxt + ".PokemonFormes=" + page.getFormesNameList());
            for (String formeName : formesNamesList) {
                if (!formeName.equalsIgnoreCase(pokemonName)) {
                    System.out.println(pokedexTxt + ": Pokemon name and forme  name don't match. '" + pokemonName + "' != '" + formeName + "'");
                    log.info(pokedexTxt + ": Pokemon name and forme  name don't match. '" + pokemonName + "' != '" + formeName + "'");
                }
                page.selectForme(formeName);
                String formeNameSimple = formeName.replaceAll(" ", "_");
                sleep(500);
                List<String> versions = page.findVersions();
                lines.add(pokedexTxt + "." + formeNameSimple + ".Versions=" + versions);
                for (String version : versions) {
                    page.selectVersion(version);
                    lines.add(pokedexTxt + "." + formeNameSimple + "." + version + ".Description=" + page.findDescription());
                    if (location.equalsIgnoreCase("uk")) {
                        lines.add(pokedexTxt + "." + formeNameSimple + "." + version + ".Height_m=" + page.findHeight().replaceAll("m$","").trim());
                        lines.add(pokedexTxt + "." + formeNameSimple + "." + version + ".Weight_kg=" + page.findWeight().replaceAll("kg$","").trim());
                    } else if (location.equalsIgnoreCase("us")) {
                        lines.add(pokedexTxt + "." + formeNameSimple + "." + version + ".Height_ft_in=" + page.findHeight());
                        lines.add(pokedexTxt + "." + formeNameSimple + "." + version + ".Weight_lbs=" + page.findWeight().replaceAll("lbs$","").trim());
                    } else {
                        lines.add(pokedexTxt + "." + formeNameSimple + "." + version + ".Height=" + page.findHeight());
                        lines.add(pokedexTxt + "." + formeNameSimple + "." + version + ".Weight=" + page.findWeight());
                    }
                    lines.add(pokedexTxt + "." + formeNameSimple + "." + version + ".Genders=" + page.findGenders());
                    lines.add(pokedexTxt + "." + formeNameSimple + "." + version + ".Category=" + page.findCategory());
                    HashMap pokemonAbilitiesAndDescriptions = page.findAbilitiesAndItsDescriptions();
                    lines.add(pokedexTxt + "." + formeNameSimple + "." + version + ".Abilities=" + page.getAbilities());
                    for (Object abilityAbilityDescription : pokemonAbilitiesAndDescriptions.entrySet()) {
                        Map.Entry pair = (Map.Entry) abilityAbilityDescription;
                        lines.add(pokedexTxt + "." + formeNameSimple + "." + version + ".Ability." + pair.getKey().toString().replaceAll(" ", "_") + "=" + pair.getValue().toString());
                    }
                    lines.add(pokedexTxt + "." + formeNameSimple + "." + version + ".Types=" + page.getTypes());
                }
            }
            lines.add(pokedexTxt + ".EvolutionClass=" + page.findEvolutionClass());
            lines.add(pokedexTxt + ".EvolutionBranches=" + page.findEvolutionBranches());
            appendLinesToFile(lines, path);
        } catch (Exception e) {
//            for (String line : lines) {
//                System.out.println(line);
//                log.info(line);
//            }
            System.out.println("Failed after performing : " + lines.get(lines.size() - 1));
            log.info("Failed after performing : " + lines.get(lines.size() - 1));
            System.out.println("Could not finish pokedexTxt='" + pokedexTxt + "'; location='" + location + "'\n");
            log.info("Could not finish pokedexTxt='" + pokedexTxt + "'; location='" + location + "'\n");
            System.out.println(e.getMessage());
            log.error(e.getMessage());

            e.printStackTrace();
//            fail(pokedexTxt + ":" + e.getMessage());
        }
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
