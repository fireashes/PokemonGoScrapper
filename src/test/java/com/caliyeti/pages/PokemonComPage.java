package com.caliyeti.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class PokemonComPage extends PokemonPage {
    private final Logger log = LoggerFactory.getLogger(PokemonComPage.class);

    private List<String> formesNamesList = new ArrayList<>();
    private String pokemonName = "";
    private String pokemonNameSimple = "";
    private String pokedexTxt = "";
    private int pokedex = 0;

    private List<String> evolutionBranches = new ArrayList<>();

    private HashMap<String, String> pokemonAbilitiesAndDescriptions = new HashMap<>();

    public PokemonComPage(WebDriver driver) {
        super(driver);
        actions.moveToElement(wePokedexPokemonPaginationTitle);
    }

    /*
	//section[contains(@class,'pokedex-pokemon-form')]
		/div
			/div[contains(@class,'styled-select')][contains(@class,'button-black')]
			/div[@class='custom-select-wrapper']
				/select[@id='formes'][@name='formes']
					/option
					/option
				/div[@class='custom-select-menu']
					/label[contains(@class,'styled-select')][contains(@class,'button-black')]
					//ul[@data-select-name='formes']
                        /li[@class='selected']
						/li
					//ul[@data-select-name='overview']
                        /li[@class='selected']
						/li
					/input[@type='hidden']
				/i[contains(@class,'icon')]

493	//section[@class='section pokedex-pokemon-form']
		/div
			/div[@class='custom-select-wrapper']
				/select[@id='formes'][@name='formes']
					/option
				/div[@class='custom-select-menu']
					/label[contains(@class,'styled-select')][contains(@class,'button-black')]
					/div
						/div[@class='viewport']
							/ul[@class='overview']
								/li[@class='selected']
								/li[@class='']
					/input[@type='hidden']
				/i[@class='icon icon_arrow_sm_down']


        //section[contains(@class,'pokedex-pokemon-header')]
            /div[@class='pokedex-pokemon-pagination-title']

        //section[contains(@class,'pokedex-pokemon-form')]
            /div
                /div[contains(@class,'styled-select')][contains(@class,'button-black')][contains(@class,'right')]
                /div[@class='custom-select-wrapper']
                    /select[@id='formes'][@name='formes']
                        /option[]
                    /div[@class='custom-select-menu']
                        /label[contains(@class,'styled-select button-black right opened')]
                        /ul[@data-select-name='formes']
                            /li[]
                            /li[@class='selected']
                    /i[contains(@class,'icon')]

        //section[contains(@class,'pokedex-pokemon-details')]
            //div[@class='pokedex-pokemon-profile']
            //div[@class='notch-collectibles-large']
            //div[contains(@class,'pokemon-stats-info')]
            //div[contains(@class,'pokemon-stats-info')][contains(@class,'active')]
            //div[@class='pokedex-pokemon-details-right']
                /div[contains(@class,'version-descriptions')]
                /div[contains(@class,'version-descriptions')][contains(@class,'active')]
                    /p[contains(@class,'version-x')][contains(@class,'active')]
                    /p[contains(@class,'version-y')][contains(@class,'active')]
                /div[@class='version-labels']
                    /span[contains(@class,'version-label')][contains(@class,'version-y')][contains(@class,'active')]/i
                    /span[contains(@class,'version-label')][contains(@class,'version-x')][contains(@class,'active')]/i
                /div[contains(@class,'info')][contains(@class,'match-height-tablet')]
                    /div[contains(@class,'pokemon-ability-info')]
                    /div[contains(@class,'pokemon-ability-info')][contains(@class,'match')][contains(@class,'active')]
                        //span[@class='attribute-title'][contains(text(),'Height')]/../span[@class='attribute-value']
                        //span[@class='attribute-title'][contains(text(),'Weight')]/../span[@class='attribute-value']
                        //span[@class='attribute-title'][contains(text(),'Gender')]/../span[@class='attribute-value']
                        //span[@class='attribute-title'][contains(text(),'Gender')]/../span[@class='attribute-value']/i[contains(@class,'icon_male_symbol')
                        //span[@class='attribute-title'][contains(text(),'Gender')]/../span[@class='attribute-value']/i[contains(@class,'icon_female_symbol')
                        //span[@class='attribute-title'][contains(text(),'Category')]/../span[@class='attribute-value']
                        //span[@class='attribute-title'][contains(text(),'Abilities')]/..//span[@class='attribute-value']
                        //div[contains(@class,'pokemon-ability-info-detail')][contains(@class,'match')]
                            /span[@class='button-close']
                            /span[@class='title']
                            /h3
                            /p
                    /div[contains(@class,'pokedex-pokemon-attributes')]
                    /div[contains(@class,'pokedex-pokemon-attributes')][contains(@class,'active')]
                        /div[@class='dtm-type']
                            /h3[contains(text(),'Type')]
                            /ul/li/a
                        /div[@class='dtm-weaknesses']
                            /h3[contains(text(),'Weaknesses')]
                            /ul/li/a
                /div[@class='collectibles-detail-friends']

        //section[contains(@class,'pokedex-pokemon-evolution')]
    //section[contains(@class,'pokedex-pokemon-evolution')][contains(@class,'evolution-one')]
        //h2
        //p
        //ul[contains(@class,'evolution-profile')]
            /li[@class='first'][@class='middle'][@class='last']
                /a
                    /img
                    /h3
                        /span
                    /ul
                        /li

                /ul/li
                    /a
                        /img
                        /h3
                            /span
                        /ul
                            /li



     */
    @FindBy(xpath = "//section[contains(@class,'pokedex-pokemon-header')]" +
            "//div[contains(@class,'pokedex-pokemon-pagination-title')]")
    private WebElement wePokedexPokemonPaginationTitle;

    @FindBy(xpath = "//section[contains(@class,'pokedex-pokemon-form')]" +
            "//*[contains(@class,'styled-select')]")
    private WebElement weStyledSelect;

    @FindBy(xpath = "//section[contains(@class,'pokedex-pokemon-form')]" +
            "//div[contains(@class,'styled-select')]")
    private WebElement weCurrentFormeDiv;

    @FindBy(xpath = "//section[contains(@class,'pokedex-pokemon-form')]" +
            "//label[contains(@class,'styled-select')]")
    private WebElement weCurrentFormeLabel;

    @FindBys({
            @FindBy(xpath = "//section[contains(@class,'pokedex-pokemon-form')]" +
                    "//select[@id='formes']" +
                    "/option")
    })
    private List<WebElement> welFormesOptions;

    @FindBy(xpath = "//section[contains(@class,'pokedex-pokemon-form')]" +
            "//div[@class='custom-select-menu']")
    private WebElement weCustomSelectMenu;

    @FindBys({
            @FindBy(xpath = "//section[contains(@class,'pokedex-pokemon-form')]" +
                    "//div[@class='custom-select-menu']" +
                    "//ul[@data-select-name='formes']" +
                    "/li")
    })
    private List<WebElement> welCustomSelectMenuFormesNames;

    @FindBy(xpath = "//section[contains(@class,'pokedex-pokemon-form')]" +
            "//div[@class='custom-select-menu']" +
            "//ul" +
            "/li[@class='selected'")
    private WebElement weSelectedForme;

    @FindBy(xpath = "//section[contains(@class,'pokedex-pokemon-details')]" +
            "//div[@class='pokedex-pokemon-details-right']" +
            "/div[contains(@class,'version-descriptions')][contains(@class,'active')]" +
            "/p[contains(@class,'version-x')][contains(@class,'active')]")
    private WebElement weVersionXActiveDescription;

    @FindBy(xpath = "//section[contains(@class,'pokedex-pokemon-details')]" +
            "//div[@class='pokedex-pokemon-details-right']" +
            "/div[contains(@class,'version-descriptions')][contains(@class,'active')]" +
            "/p[contains(@class,'version-y')][contains(@class,'active')]")
    private WebElement weVersionYActiveDescription;

    @FindBy(xpath = "//section[contains(@class,'pokedex-pokemon-details')]" +
            "//div[@class='pokedex-pokemon-details-right']" +
            "/div[contains(@class,'version-descriptions')][contains(@class,'active')]" +
            "/p[contains(@class,'active')]")
    private WebElement weDescription;

    @FindBys({
            @FindBy(xpath = "//section[contains(@class,'pokedex-pokemon-details')]" +
                    "//div[@class='pokedex-pokemon-details-right']" +
                    "/div[@class='version-labels']" +
                    "/span[contains(@class,'version-label')]" +
                    "/i")

    })
    private List<WebElement> welVersionsList;

    @FindBy(xpath = "//section[contains(@class,'pokedex-pokemon-details')]" +
            "//div[@class='pokedex-pokemon-details-right']" +
            "/div[@class='version-labels']" +
            "/span[contains(@class,'version-label')][contains(@class,'version-y')]" +
            "/i")
    private WebElement weVersionY;

    @FindBy(xpath = "//section[contains(@class,'pokedex-pokemon-details')]" +
            "//div[@class='pokedex-pokemon-details-right']" +
            "/div[@class='version-labels']" +
            "/span[contains(@class,'version-label')][contains(@class,'version-x')]" +
            "/i")
    private WebElement weVersionX;

    @FindBy(id = "cookie-dismisser")
    private WebElement weCookieDismisser;

    @FindBy(xpath = "//div[@class='pokedex-pokemon-details-right'" +
            "/div[contains(@class,'version-descriptions')][contains(@class,'active')]" +
            "/p[contains(@class,active)]")
    private WebElement weActiveVersionDescription;

    @FindBy(xpath = "//section[contains(@class,'pokedex-pokemon-details')]" +
            "//div[@class='pokedex-pokemon-details-right']" +
            "/div[contains(@class,'info')][contains(@class,'match-height-tablet')]" +
            "/div[contains(@class,'pokemon-ability-info')][contains(@class,'active')]" +
            "//span[@class='attribute-title'][contains(text(),'Height')]" +
            "/../span[@class='attribute-value']")
    private WebElement weHeight;

    @FindBy(xpath = "//section[contains(@class,'pokedex-pokemon-details')]" +
            "//div[@class='pokedex-pokemon-details-right']" +
            "/div[contains(@class,'info')][contains(@class,'match-height-tablet')]" +
            "/div[contains(@class,'pokemon-ability-info')][contains(@class,'active')]" +
            "//span[@class='attribute-title'][contains(text(),'Weight')]" +
            "/../span[@class='attribute-value']")
    private WebElement weWeight;

    @FindBy(xpath = "//section[contains(@class,'pokedex-pokemon-details')]" +
            "//div[@class='pokedex-pokemon-details-right']" +
            "/div[contains(@class,'info')][contains(@class,'match-height-tablet')]" +
            "/div[contains(@class,'pokemon-ability-info')][contains(@class,'active')]" +
            "//span[@class='attribute-title'][contains(text(),'Gender')]" +
            "/../span[@class='attribute-value']")
    private WebElement weGenders;

    @FindBys({
            @FindBy(xpath = "//section[contains(@class,'pokedex-pokemon-details')]" +
                    "//div[@class='pokedex-pokemon-details-right']" +
                    "/div[contains(@class,'info')][contains(@class,'match-height-tablet')]" +
                    "/div[contains(@class,'pokemon-ability-info')][contains(@class,'active')]" +
                    "//span[@class='attribute-title'][contains(text(),'Gender')]" +
                    "/../span[@class='attribute-value']" +
                    "/i")
    })
    List<WebElement> welGenderList;

    @FindBy(xpath = "//section[contains(@class,'pokedex-pokemon-details')]" +
            "//div[@class='pokedex-pokemon-details-right']" +
            "/div[contains(@class,'info')][contains(@class,'match-height-tablet')]" +
            "/div[contains(@class,'pokemon-ability-info')][contains(@class,'active')]" +
            "//span[@class='attribute-title'][contains(text(),'Gender')]" +
            "/../span[@class='attribute-value']" +
            "/i[contains(@class,'icon_male_symbol')]")
    private WebElement weGenderMale;

    @FindBy(xpath = "//section[contains(@class,'pokedex-pokemon-details')]" +
            "//div[@class='pokedex-pokemon-details-right']" +
            "/div[contains(@class,'info')][contains(@class,'match-height-tablet')]" +
            "/div[contains(@class,'pokemon-ability-info')][contains(@class,'active')]" +
            "//span[@class='attribute-title'][contains(text(),'Gender')]" +
            "/../span[@class='attribute-value']" +
            "/i[contains(@class,'icon_female_symbol')]")
    private WebElement weGenderFemale;

    @FindBy(xpath = "//section[contains(@class,'pokedex-pokemon-details')]" +
            "//div[@class='pokedex-pokemon-details-right']" +
            "/div[contains(@class,'info')][contains(@class,'match-height-tablet')]" +
            "/div[contains(@class,'pokemon-ability-info')][contains(@class,'active')]" +
            "//span[@class='attribute-title'][contains(text(),'Gender')]" +
            "/../span[@class='attribute-value'][contains(text(),'Unknown')]")
    private WebElement weGenderUnknown;

    @FindBy(xpath = "//section[contains(@class,'pokedex-pokemon-details')]" +
            "//div[@class='pokedex-pokemon-details-right']" +
            "/div[contains(@class,'info')][contains(@class,'match-height-tablet')]" +
            "/div[contains(@class,'pokemon-ability-info')][contains(@class,'active')]" +
            "//span[@class='attribute-title'][contains(text(),'Category')]" +
            "/../span[@class='attribute-value']")
    private WebElement weCategory;

    @FindBys({
            @FindBy(xpath = "//section[contains(@class,'pokedex-pokemon-details')]" +
                    "//div[@class='pokedex-pokemon-details-right']" +
                    "/div[contains(@class,'info')][contains(@class,'match-height-tablet')]" +
                    "/div[contains(@class,'pokemon-ability-info')][contains(@class,'active')]" +
                    "//span[@class='attribute-title'][contains(text(),'Abilities')]" +
                    "/..//span[@class='attribute-value']")
    })
    private List<WebElement> welAbilities;

    @FindBy(xpath = "//section[contains(@class,'pokedex-pokemon-details')]" +
            "//div[@class='pokedex-pokemon-details-right']" +
            "/div[contains(@class,'info')][contains(@class,'match-height-tablet')]" +
            "/div[contains(@class,'pokemon-ability-info')][contains(@class,'match')][contains(@class,'active')]" +
            "/div[contains(@class,'pokemon-ability-info-detail')][contains(@class,'match')][contains(@style,'block')]" +
            "/span[@class='button-close']")
    private WebElement buttonClose;

    @FindBy(xpath = "//section[contains(@class,'pokedex-pokemon-details')]" +
            "//div[@class='pokedex-pokemon-details-right']" +
            "/div[contains(@class,'info')][contains(@class,'match-height-tablet')]" +
            "/div[contains(@class,'pokemon-ability-info')][contains(@class,'match')][contains(@class,'active')]" +
            "/div[contains(@class,'pokemon-ability-info-detail')][contains(@class,'match')][contains(@style,'block')]" +
            "/h3")
    private WebElement weAbilityHeading;

    @FindBy(xpath = "//section[contains(@class,'pokedex-pokemon-details')]" +
            "//div[@class='pokedex-pokemon-details-right']" +
            "/div[contains(@class,'info')][contains(@class,'match-height-tablet')]" +
            "/div[contains(@class,'pokemon-ability-info')][contains(@class,'match')][contains(@class,'active')]" +
            "/div[contains(@class,'pokemon-ability-info-detail')][contains(@class,'match')][contains(@style,'block')]" +
            "/p")
    private WebElement weAbilityDescription;

    @FindBys({
            @FindBy(xpath = "//section[contains(@class,'pokedex-pokemon-details')]" +
                    "//div[@class='pokedex-pokemon-details-right']" +
                    "/div[contains(@class,'info')][contains(@class,'match-height-tablet')]" +
                    "/div[contains(@class,'pokedex-pokemon-attributes')][contains(@class,'active')]" +
                    "/div[@class='dtm-type']" +
                    "/h3[contains(text(),'Type')]" +
                    "/..//a")
    })
    private List<WebElement> welTypes;

    @CacheLookup
    @FindBy(xpath = "//section[contains(@class,'pokedex-pokemon-evolution')]")
    private WebElement wePokedexPokemonEvolution;

    @CacheLookup
    @FindBys({
            @FindBy(xpath = "//section[contains(@class,'pokedex-pokemon-evolution')]" +
                    "//span[@class='pokemon-number']")
    })
    private List<WebElement> welAllEvolutionsList;

    @CacheLookup
    @FindBys({
            @FindBy(xpath = "//section[contains(@class,'pokedex-pokemon-evolution')]" +
                    "//ul" +
                    "/li[@class='first']" +
                    "//h3" +
                    "/span[@class='pokemon-number']")
    })
    private List<WebElement> welEvolutionFirstList;

    @CacheLookup
    @FindBys({
            @FindBy(xpath = "//section[contains(@class,'pokedex-pokemon-evolution')]" +
                    "//ul" +
                    "/li[@class='middle']" +
                    "//h3" +
                    "/span[@class='pokemon-number']")
    })
    private List<WebElement> welEvolutionMiddleList;

    @CacheLookup
    @FindBys({
            @FindBy(xpath = "//section[contains(@class,'pokedex-pokemon-evolution')]" +
                    "//ul" +
                    "/li[@class='last']" +
                    "//h3" +
                    "/span[@class='pokemon-number']")
    })
    private List<WebElement> welEvolutionLastList;

    public void dismissCookie() {
        wait.until(ExpectedConditions.elementToBeClickable(weCookieDismisser))
                .click();
        sleepMillis(500);
    }

    public void findPokemonNamePokedex() {
        pokemonName = getTitle()
                .replace(" | Pokédex", "")
                .trim();
        String pokedexPokemonPaginationTitleTxt = wait.until(ExpectedConditions.visibilityOf(wePokedexPokemonPaginationTitle))
                .getText()
                .trim();
        String pokemonNameDisplayed = pokedexPokemonPaginationTitleTxt
                .replaceAll("#.*", "")
                .trim();
        assertTrue("Pokemon name from page tile " + pokemonName + " should be same with pokemon name displayed " + pokemonNameDisplayed, pokemonName.equals(pokemonNameDisplayed));
        pokedexTxt = pokedexPokemonPaginationTitleTxt
                .replaceAll(".*(\\d{3}).*", "$1")
                .trim();
        pokedex = Integer.parseInt(pokedexTxt);
        pokemonNameSimple = driver.getCurrentUrl()
                .replaceAll(".*/", "")
                .trim();
        if (!pokemonName.toLowerCase().equals(pokemonNameSimple.toLowerCase())) {
//            System.out.println(pokedexTxt + ": Pokemon name '" + pokemonName + "' and simple pokemon name '" + pokemonNameSimple + "' does not match");
//            log.info(pokedexTxt + ": Pokemon name '" + pokemonName + "' and simple pokemon name '" + pokemonNameSimple + "' does not match");
        }
    }

    public void findPokemonNamePokedexFormes() {
        if (pokemonName.isEmpty() || pokedexTxt.isEmpty() || pokedex == 0 || pokemonNameSimple.isEmpty()) {
            findPokemonNamePokedex();
        }
        formesNamesList.clear();
        // Create a better logic to make sure it does or does not have formes
        String styledSelectTagName = wait.until(ExpectedConditions.visibilityOf(weStyledSelect))
                .getTagName()
                .trim();
        int numberOfDivInForme = driver.findElements(By.xpath("//section[contains(@class,'pokedex-pokemon-form')]//div")).size();
        if (numberOfDivInForme == 2 && styledSelectTagName.equals("div")) {
            formesNamesList.add(pokemonName);
        } else if (styledSelectTagName.equals("label")) {
            try {
                wait.until(ExpectedConditions.visibilityOf(wePokedexPokemonPaginationTitle))
                        .click();
                sleepMillis(500);
                wait.until(ExpectedConditions.visibilityOf(weCurrentFormeLabel))
                        .click();
                sleepMillis(500);
            } catch (Exception e) {
                fail(e.getMessage());
            }
            assertTrue(pokedexTxt + ": Number of forms should be greater than 0", welCustomSelectMenuFormesNames.size() > 0);
            for (WebElement customSelectMenuFormesName : welCustomSelectMenuFormesNames) {
                String thisFormName = customSelectMenuFormesName.getText().trim();
                formesNamesList.add(thisFormName);
            }
        } else {
            log.info("Number of div in forme = " + numberOfDivInForme + "; styledSelectTagName = " + styledSelectTagName);
            fail("Could not determine if it has formes");
        }
    }

    public String getPokemonName() {
        return pokemonName;
    }

    public String getPokedexTxt() {
        return pokedexTxt;
    }

    public String getPokemonNameSimple() {
        return pokemonNameSimple;
    }

    public int getPokedex() {
        return pokedex;
    }

    public List<String> getFormesNameList() {
        return formesNamesList;
    }

    public void selectForme(String formeName) {
        if (formesNamesList == null || formesNamesList.size() == 0) {
            findPokemonNamePokedexFormes();
        }
        wePokedexPokemonPaginationTitle.click();
        if (formesNamesList.size() == 1) {
            if (formeName.equals(pokemonName)) {
//                log.debug("Form name and pokemon name matches");
            } else {
                log.info("Form name and pokemon name does not match");
                fail("Forme not found");
            }
        } else {
            if (formeName.equals(weCurrentFormeLabel.getText().trim())) {
//                log.debug("Current form name is already selected");
            } else {
                for (int i = 0; i < formesNamesList.size(); i++) {
                    if (formeName.equals(formesNamesList.get(i))) {
                        try {
                            wePokedexPokemonPaginationTitle.click();
                            sleepMillis(500);
                            wait.until(ExpectedConditions.visibilityOf(weCurrentFormeLabel));
                            weCurrentFormeLabel.click();
                            sleepMillis(500);
                            // wait.until(ExpectedConditions.visibilityOfAllElements(welCustomSelectMenuFormesNames));
                            // sleepMillis(500);
                            welCustomSelectMenuFormesNames.get(i).click();
                            sleepMillis(500);
                            wait.until(ExpectedConditions.textToBePresentInElement(weCurrentFormeLabel, formeName));
                        } catch (Exception e) {
                            fail(pokedex + ":" + pokemonName + ":" + e.getMessage());
                        }
                    } else {
                        // Do Nothing, check next one
                    }
                }
                if (formeName.equals(weCurrentFormeLabel.getText().trim())) {
                    // Do Nothing
                } else {
                    fail("Forme not loaded");
                }
            }
        }
    }

    public List<String> findVersions() {
        wait.until(ExpectedConditions.visibilityOfAllElements(welVersionsList));
        wait.until(ExpectedConditions.visibilityOf(weVersionX));
        wait.until(ExpectedConditions.visibilityOf(weVersionY));
        assertEquals(pokedexTxt + ": There should be two version X and Y", 2, welVersionsList.size());
        List<String> versions = new ArrayList<>();
        versions.add("Y");
        versions.add("X");
        return versions;
    }

    public void selectVersion(String version) {
        if (version.toLowerCase().equals("x")) {
            selectVersionX();
        } else if (version.toLowerCase().equals("y")) {
            selectVersionY();
        } else {
            fail("Version " + version + " not found.");
        }
        sleepMillis(500);
    }

    public void selectVersionX() {
        wait.until(ExpectedConditions.visibilityOf(weVersionX))
                .click();
        sleepMillis(500);
        wait.until(ExpectedConditions.visibilityOf(weVersionXActiveDescription));
        sleepMillis(500);
    }

    public void selectVersionY() {
        wait.until(ExpectedConditions.visibilityOf(weVersionY))
                .click();
        sleepMillis(500);
        wait.until(ExpectedConditions.visibilityOf(weVersionYActiveDescription));
        sleepMillis(500);
    }

    public String findDescription() {
        return wait.until(ExpectedConditions.visibilityOf(weDescription))
                .getText()
                .trim();
    }

    public String findHeight() {
        return wait.until(ExpectedConditions.visibilityOf(weHeight))
                .getText()
                .trim();
    }

    public String findWeight() {
        return wait.until(ExpectedConditions.visibilityOf(weWeight))
                .getText()
                .trim();
    }

    public List<String> findGenders() {
        List<String> gList = new ArrayList<>();
        wait.until(ExpectedConditions.visibilityOf(weGenders));
        if (weGenders.getText().trim().equals("Unknown")) {
            gList.add(weGenders.getText().trim());
        } else {
            for (WebElement gender : welGenderList) {
                if (gender.getAttribute("class").contains("icon_male_symbol")) {
                    gList.add("Male");
                } else if (gender.getAttribute("class").contains("icon_female_symbol")) {
                    gList.add("Female");
                }
            }
        }
        return gList;
    }

    public String findCategory() {
        return wait.until(ExpectedConditions.visibilityOf(weCategory))
                .getText()
                .trim();
    }

    public HashMap<String, String> findAbilitiesAndItsDescriptions() {
        pokemonAbilitiesAndDescriptions.clear();
        wait.until(ExpectedConditions.visibilityOfAllElements(welAbilities));
        for (WebElement ability : welAbilities) {
            actions.moveToElement(ability);
            String abilityName = wait.until(ExpectedConditions.visibilityOf(ability))
                    .getText()
                    .trim();
            wait.until(ExpectedConditions.elementToBeClickable(ability))
                    .click();
            sleepMillis(500);

            String abilityHeading = wait.until(ExpectedConditions.visibilityOf(weAbilityHeading))
                    .getText()
                    .trim();

            assertEquals(pokedexTxt + ": Ability name should be equal to ability heading", abilityName, abilityHeading);

            String abilityInfo = wait.until(ExpectedConditions.visibilityOf(weAbilityDescription))
                    .getText()
                    .trim();
            pokemonAbilitiesAndDescriptions.put(abilityName, abilityInfo);

            wait.until(ExpectedConditions.visibilityOf(buttonClose))
                    .click();

            sleepMillis(500);
        }
        return pokemonAbilitiesAndDescriptions;
    }

    public List<String> getAbilities() {
        List<String> abilityList = new ArrayList<>();
        for (Object o : pokemonAbilitiesAndDescriptions.entrySet()) {
            Map.Entry pair = (Map.Entry) o;
            abilityList.add(pair.getKey().toString());
        }
        return abilityList;
    }


    public String getAbilityInfo(String ability) {
        String abilityInfo = "";
        for (Object o : pokemonAbilitiesAndDescriptions.entrySet()) {
            Map.Entry pair = (Map.Entry) o;
            if (pair.getKey().toString().equals(ability)) {
                abilityInfo = pair.getValue().toString();
            }
        }
        return abilityInfo;
    }

    public List<String> getTypes() {
        List<String> typeList = new ArrayList<>();
        for (WebElement type : welTypes) {
            actions.moveToElement(type);
            typeList.add(type.getText());
        }
        return typeList;
    }

    public String findEvolutionClass() {
        return wait.until(ExpectedConditions.visibilityOf(wePokedexPokemonEvolution))
                .getAttribute("class")
                .replace("section pokedex-pokemon-evolution", "")
                .trim();
    }

    public List<String> findEvolutionBranches() {
        evolutionBranches.clear();
        String evolutionClass = findEvolutionClass();
        actions.moveToElement(wePokedexPokemonEvolution);

        /*
        log.info(pokedexTxt + " : evolution First : " + getTexts(welEvolutionFirstList) + " = " + welEvolutionFirstList.size());
        if (welEvolutionMiddleList != null) {
            log.info(pokedexTxt + " : evolution Middle : " + getTexts(welEvolutionMiddleList) + " = " + welEvolutionMiddleList.size());
        } else {
            log.info(pokedexTxt + " : evolution Middle : null");
        }
        log.info(pokedexTxt + " : evolution Last : " + getTexts(welEvolutionLastList) + " = " + welEvolutionLastList.size());
        log.info(pokedexTxt + " : evolution All : " + getTexts(welAllEvolutionsList) + " = " + welAllEvolutionsList.size());
        */

        switch (evolutionClass) {
            case "evolution-one":
                assertEquals("There should be 1 from evolution first list ", 1, welEvolutionFirstList.size());
//                assertEquals("There should be 0 from evolution middle list ", 0, welEvolutionMiddleList.size());
//                assertEquals("There should be 0 from evolution last list ", 0, welEvolutionLastList.size());
                assertEquals("There should be 1 from evolution all list ", 1, welAllEvolutionsList.size());
                evolutionBranches.add(getEvolutionBranch(welEvolutionFirstList.get(0), welEvolutionFirstList.get(0)));
                break;
            case "evolution-two":
                assertEquals("There should be 1 from evolution first list ", 1, welEvolutionFirstList.size());
//                assertEquals("There should be 0 from evolution middle list ", 0, welEvolutionMiddleList.size());
                assertEquals("There should be 1 from evolution last list ", 1, welEvolutionLastList.size());
                assertEquals("There should be 2 from evolution all list ", 2, welAllEvolutionsList.size());
                evolutionBranches.add(getEvolutionBranch(welEvolutionFirstList.get(0), welEvolutionLastList.get(0)));
                break;
            case "evolution-three":
                assertEquals("There should be 1 from evolution first list ", 1, welEvolutionFirstList.size());
                assertEquals("There should be 1 from evolution middle list ", 1, welEvolutionMiddleList.size());
                assertEquals("There should be 1 from evolution last list ", 1, welEvolutionLastList.size());
                assertEquals("There should be 3 from evolution all list ", 3, welAllEvolutionsList.size());
                evolutionBranches.add(getEvolutionBranch(welEvolutionFirstList.get(0), welEvolutionMiddleList.get(0)));
                evolutionBranches.add(getEvolutionBranch(welEvolutionMiddleList.get(0), welEvolutionLastList.get(0)));
                break;
            case "evolution-four":
                if (pokedex == 412 || pokedex == 413 || pokedex == 414) {
                    assertEquals("There should be 1 from evolution first list ", 1, welEvolutionFirstList.size());
//                    assertEquals("There should be 0 from evolution middle list ", 0, welEvolutionMiddleList.size());
                    assertEquals("There should be 4 from evolution last list ", 4, welEvolutionLastList.size());
                    assertEquals("There should be 5 from evolution all list ", 5, welAllEvolutionsList.size());
                    evolutionBranches.add(getEvolutionBranch(welEvolutionFirstList.get(0), welEvolutionLastList.get(0)));
                    evolutionBranches.add(getEvolutionBranch(welEvolutionFirstList.get(0), welEvolutionLastList.get(3)));
                } else {
                    log.info(pokedex + ": Inside else pokedex " + pokedex);
                    assertEquals("There should be 1 from evolution first list ", 1, welEvolutionFirstList.size());
//                    assertEquals("There should be 0 from evolution middle list ", 0, welEvolutionMiddleList.size());
                    assertEquals("There should be 8 from evolution last list ", 8, welEvolutionLastList.size());
                    assertEquals("There should be 9 from evolution all list ", 9, welAllEvolutionsList.size());
                    evolutionBranches.add(getEvolutionBranch(welEvolutionFirstList.get(0), welEvolutionLastList.get(0)));
                    evolutionBranches.add(getEvolutionBranch(welEvolutionFirstList.get(0), welEvolutionLastList.get(1)));
                    evolutionBranches.add(getEvolutionBranch(welEvolutionFirstList.get(0), welEvolutionLastList.get(2)));
                    evolutionBranches.add(getEvolutionBranch(welEvolutionFirstList.get(0), welEvolutionLastList.get(3)));
                    evolutionBranches.add(getEvolutionBranch(welEvolutionFirstList.get(0), welEvolutionLastList.get(4)));
                    evolutionBranches.add(getEvolutionBranch(welEvolutionFirstList.get(0), welEvolutionLastList.get(5)));
                    evolutionBranches.add(getEvolutionBranch(welEvolutionFirstList.get(0), welEvolutionLastList.get(6)));
                    evolutionBranches.add(getEvolutionBranch(welEvolutionFirstList.get(0), welEvolutionLastList.get(7)));
                }
                break;
            case "evolution-five":
                assertEquals("There should be 1 from evolution first list ", 1, welEvolutionFirstList.size());
                assertEquals("There should be 2 from evolution middle list ", 2, welEvolutionMiddleList.size());
                assertEquals("There should be 2 from evolution last list ", 2, welEvolutionLastList.size());
                assertEquals("There should be 5 from evolution all list ", 5, welAllEvolutionsList.size());
                evolutionBranches.add(getEvolutionBranch(welEvolutionFirstList.get(0), welEvolutionMiddleList.get(0)));
                evolutionBranches.add(getEvolutionBranch(welEvolutionFirstList.get(0), welEvolutionMiddleList.get(1)));
                evolutionBranches.add(getEvolutionBranch(welEvolutionMiddleList.get(0), welEvolutionLastList.get(0)));
                evolutionBranches.add(getEvolutionBranch(welEvolutionMiddleList.get(1), welEvolutionLastList.get(1)));
                break;
            case "evolution-six":
                assertEquals("There should be 1 from evolution first list ", 1, welEvolutionFirstList.size());
                assertEquals("There should be 1 from evolution middle list ", 1, welEvolutionMiddleList.size());
                assertEquals("There should be 2 from evolution last list ", 2, welEvolutionLastList.size());
                assertEquals("There should be 4 from evolution all list ", 4, welAllEvolutionsList.size());
                evolutionBranches.add(getEvolutionBranch(welEvolutionFirstList.get(0), welEvolutionMiddleList.get(0)));
                evolutionBranches.add(getEvolutionBranch(welEvolutionMiddleList.get(0), welEvolutionLastList.get(0)));
                evolutionBranches.add(getEvolutionBranch(welEvolutionMiddleList.get(0), welEvolutionLastList.get(1)));
                break;
            case "evolution-seven":
                assertEquals("There should be 1 from evolution first list ", 1, welEvolutionFirstList.size());
//                assertEquals("There should be 0 from evolution middle list ", 0, welEvolutionMiddleList.size());
                assertEquals("There should be 2 from evolution last list ", 2, welEvolutionLastList.size());
                assertEquals("There should be 3 from evolution all list ", 3, welAllEvolutionsList.size());
                evolutionBranches.add(getEvolutionBranch(welEvolutionFirstList.get(0), welEvolutionLastList.get(0)));
                evolutionBranches.add(getEvolutionBranch(welEvolutionFirstList.get(0), welEvolutionLastList.get(1)));
                break;
            case "evolution-eight":
                assertEquals("There should be 1 from evolution first list ", 1, welEvolutionFirstList.size());
//                assertEquals("There should be 0 from evolution middle list ", 0, welEvolutionMiddleList.size());
                assertEquals("There should be 3 from evolution last list ", 3, welEvolutionLastList.size());
                assertEquals("There should be 4 from evolution all list ", 4, welAllEvolutionsList.size());
                evolutionBranches.add(getEvolutionBranch(welEvolutionFirstList.get(0), welEvolutionLastList.get(0)));
                evolutionBranches.add(getEvolutionBranch(welEvolutionFirstList.get(0), welEvolutionLastList.get(1)));
                evolutionBranches.add(getEvolutionBranch(welEvolutionFirstList.get(0), welEvolutionLastList.get(2)));
                break;
        }
        return evolutionBranches;
    }

    public String getEvolutionBranch(WebElement evolutionFrom, WebElement evolutionTo) {
        String evolutionFromPokedex = evolutionFrom.getText().replaceAll("#", "").trim();
        String evolutionToPokedex = evolutionTo.getText().replaceAll("#", "").trim();
        String result = evolutionFromPokedex + "_" + evolutionToPokedex;
        return result;
    }

    public List<String> getTexts(List<WebElement> elementList) {
        List<String> result = new ArrayList<>();
        for (WebElement element : elementList) {
            result.add(element.getText().trim());
        }
        return result;
    }
}
