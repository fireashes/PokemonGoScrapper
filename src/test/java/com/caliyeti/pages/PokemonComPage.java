package com.caliyeti.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class PokemonComPage {
    private final Logger log = LoggerFactory.getLogger(PokemonComPage.class);
    private final WebDriver driver;
    private WebDriverWait wait;
    //    private Wait<WebDriver> fluentWait;
    private Actions actions;

    private List<String> formesNamesList = new ArrayList<>();
    private String pokemonName = "";
    private String pokemonNameSimple = "";
    private String pokedexTxt = "";
    private int pokedex = 0;

    private List<String> evolutionBranches = new ArrayList<>();

    private HashMap<String, String> pokemonAbilitiesAndDescriptions = new HashMap<>();

    public PokemonComPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 30);
        actions = new Actions(driver);
        PageFactory.initElements(driver, this);
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
    private List<WebElement> weTypes;

    @FindBy(xpath = "//section[contains(@class,'pokedex-pokemon-evolution')]")
    private WebElement wePokedexPokemonEvolution;

    @FindBys({
            @FindBy(xpath = "//section[contains(@class,'pokedex-pokemon-evolution')]" +
                    "//span[@class='pokemon-number']")
    })
    private List<WebElement> welAllEvolutionsList;

    @FindBys({
            @FindBy(xpath = "//section[contains(@class,'pokedex-pokemon-evolution')]" +
                    "//ul" +
                    "/li[@class='first']" +
                    "//h3" +
                    "/span[@class='pokemon-number']")
    })
    private List<WebElement> weEvolutionFirstList;

    @FindBys({
            @FindBy(xpath = "//section[contains(@class,'pokedex-pokemon-evolution')]" +
                    "//ul" +
                    "/li[@class='middle']" +
                    "//h3" +
                    "/span[@class='pokemon-number']")
    })
    private List<WebElement> weEvolutionMiddleList;

    @FindBys({
            @FindBy(xpath = "//section[contains(@class,'pokedex-pokemon-evolution')]" +
                    "//ul" +
                    "/li[@class='last']" +
                    "//h3" +
                    "/span[@class='pokemon-number']")
    })
    private List<WebElement> weEvolutionLastList;

    public void dismissCookie() {
        wait.until(ExpectedConditions.elementToBeClickable(weCookieDismisser))
                .click();
        sleepMillis(500);
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public void sleepMillis(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            fail(e.getMessage());
        }
    }

    public void findPokemonNamePokedex() {
        pokemonName = getTitle()
                .replace(" | Pokédex", "")
                .trim();
//        log.debug("pokemonName from title = " + pokemonName);
        String pokedexPokemonPaginationTitleTxt = wait.until(ExpectedConditions.visibilityOf(wePokedexPokemonPaginationTitle))
                .getText()
                .trim();
//        log.debug("pokemon name and pokedex displayed, pokedexPokemonPaginationTitleTxt = " + pokedexPokemonPaginationTitleTxt);
        String pokemonNameDisplayed = pokedexPokemonPaginationTitleTxt
                .replaceAll("#.*", "")
                .trim();
//        log.debug("pokemonNameDisplayed = " + pokemonNameDisplayed);
        assertTrue("Pokemon name from page tile " + pokemonName + " should be same with pokemon name displayed " + pokemonNameDisplayed, pokemonName.equals(pokemonNameDisplayed));
        pokedexTxt = pokedexPokemonPaginationTitleTxt
                .replaceAll(".*#", "")
                .trim();
//        log.debug("pokedexTxt = " + pokedexTxt);
        pokedex = Integer.parseInt(pokedexTxt);
//        log.debug("pokedex = " + pokedex);
        pokemonNameSimple = driver.getCurrentUrl()
                .replaceAll(".*/", "")
                .trim();
//        log.debug("pokemonNameSimple = " + pokemonNameSimple);
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
//        log.debug("Tag of styled selected webElement, styledSelectTagName = " + styledSelectTagName);
        int numberOfDivInForme = driver.findElements(By.xpath("//section[contains(@class,'pokedex-pokemon-form')]//div")).size();
//        log.debug("numberOfDivInForme = " + numberOfDivInForme);
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
//        log.info("formesNamesList = " + formesNamesList);
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
//            log.info("formeName = " + formeName);
//            log.info("pokemonName = " + pokemonName);
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
//                log.debug("Number of formes = " + formesNamesList.size());
                for (int i = 0; i < formesNamesList.size(); i++) {
                    if (formeName.equals(formesNamesList.get(i))) {
//                        log.debug("forme name " + formeName + " found.");
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
//                log.debug("Current selected forme label = " + weCurrentFormeLabel.getText().trim());
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
        assertEquals(pokedexTxt + ": There should be two version X and Y", welVersionsList.size(), 2);
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
//            log.debug("ability name = " + abilityName);
            wait.until(ExpectedConditions.elementToBeClickable(ability))
                    .click();
            sleepMillis(500);

            String abilityHeading = wait.until(ExpectedConditions.visibilityOf(weAbilityHeading))
                    .getText()
                    .trim();

//            log.debug("ability heading = " + abilityHeading);
            assertEquals(pokedexTxt + ": Ability name should be equal to ability heading", abilityName, abilityHeading);

            String abilityInfo = wait.until(ExpectedConditions.visibilityOf(weAbilityDescription))
                    .getText()
                    .trim();
//            log.debug("ability info = " + abilityInfo);
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
        for (WebElement type : weTypes) {
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
        switch (evolutionClass) {
            case "evolution-one":
                assertEquals(weEvolutionFirstList.size(), 1);
//                assertEquals(weEvolutionMiddleList.size(), 0);
//                assertEquals(weEvolutionLastList.size(), 0);
                assertEquals(welAllEvolutionsList.size(), 1);
                evolutionBranches.add(getEvolutionBranch(weEvolutionFirstList.get(0), weEvolutionFirstList.get(0)));
                break;
            case "evolution-two":
                assertEquals(weEvolutionFirstList.size(), 1);
//                assertEquals(weEvolutionMiddleList.size(), 0);
                assertEquals(weEvolutionLastList.size(), 1);
                assertEquals(welAllEvolutionsList.size(), 2);
                evolutionBranches.add(getEvolutionBranch(weEvolutionFirstList.get(0), weEvolutionLastList.get(0)));
                break;
            case "evolution-three":
                assertEquals(weEvolutionFirstList.size(), 1);
                assertEquals(weEvolutionMiddleList.size(), 1);
                assertEquals(weEvolutionLastList.size(), 1);
                assertEquals(welAllEvolutionsList.size(), 3);
                evolutionBranches.add(getEvolutionBranch(weEvolutionFirstList.get(0), weEvolutionMiddleList.get(0)));
                evolutionBranches.add(getEvolutionBranch(weEvolutionMiddleList.get(0), weEvolutionLastList.get(0)));
                break;
            case "evolution-four":
                if (pokedex == 412 || pokedex == 413 || pokedex == 414) {
                    assertEquals(weEvolutionFirstList.size(), 1);
//                assertEquals(weEvolutionMiddleList.size(), 0);
                    assertEquals(weEvolutionLastList.size(), 4);
                    assertEquals(welAllEvolutionsList.size(), 5);
                    evolutionBranches.add(getEvolutionBranch(weEvolutionFirstList.get(0), weEvolutionLastList.get(0)));
                    evolutionBranches.add(getEvolutionBranch(weEvolutionFirstList.get(0), weEvolutionLastList.get(4)));
                } else {
                    assertEquals(weEvolutionFirstList.size(), 1);
//                assertEquals(weEvolutionMiddleList.size(), 0);
                    assertEquals(weEvolutionLastList.size(), 8);
                    assertEquals(welAllEvolutionsList.size(), 9);
                    evolutionBranches.add(getEvolutionBranch(weEvolutionFirstList.get(0), weEvolutionLastList.get(0)));
                    evolutionBranches.add(getEvolutionBranch(weEvolutionFirstList.get(0), weEvolutionLastList.get(1)));
                    evolutionBranches.add(getEvolutionBranch(weEvolutionFirstList.get(0), weEvolutionLastList.get(2)));
                    evolutionBranches.add(getEvolutionBranch(weEvolutionFirstList.get(0), weEvolutionLastList.get(3)));
                    evolutionBranches.add(getEvolutionBranch(weEvolutionFirstList.get(0), weEvolutionLastList.get(4)));
                    evolutionBranches.add(getEvolutionBranch(weEvolutionFirstList.get(0), weEvolutionLastList.get(5)));
                    evolutionBranches.add(getEvolutionBranch(weEvolutionFirstList.get(0), weEvolutionLastList.get(6)));
                    evolutionBranches.add(getEvolutionBranch(weEvolutionFirstList.get(0), weEvolutionLastList.get(7)));
                }
                break;
            case "evolution-five":
                assertEquals(weEvolutionFirstList.size(), 1);
                assertEquals(weEvolutionMiddleList.size(), 2);
                assertEquals(weEvolutionLastList.size(), 2);
                assertEquals(welAllEvolutionsList.size(), 5);
                evolutionBranches.add(getEvolutionBranch(weEvolutionFirstList.get(0), weEvolutionMiddleList.get(0)));
                evolutionBranches.add(getEvolutionBranch(weEvolutionFirstList.get(0), weEvolutionMiddleList.get(1)));
                evolutionBranches.add(getEvolutionBranch(weEvolutionMiddleList.get(0), weEvolutionLastList.get(0)));
                evolutionBranches.add(getEvolutionBranch(weEvolutionMiddleList.get(1), weEvolutionLastList.get(1)));
                break;
            case "evolution-six":
                assertEquals(weEvolutionFirstList.size(), 1);
                assertEquals(weEvolutionMiddleList.size(), 1);
                assertEquals(weEvolutionLastList.size(), 2);
                assertEquals(welAllEvolutionsList.size(), 4);
                evolutionBranches.add(getEvolutionBranch(weEvolutionFirstList.get(0), weEvolutionMiddleList.get(0)));
                evolutionBranches.add(getEvolutionBranch(weEvolutionMiddleList.get(0), weEvolutionLastList.get(0)));
                evolutionBranches.add(getEvolutionBranch(weEvolutionMiddleList.get(0), weEvolutionLastList.get(1)));
                break;
            case "evolution-seven":
                assertEquals(weEvolutionFirstList.size(), 1);
//                assertEquals(weEvolutionMiddleList.size(), 0);
                assertEquals(weEvolutionLastList.size(), 2);
                assertEquals(welAllEvolutionsList.size(), 3);
                evolutionBranches.add(getEvolutionBranch(weEvolutionFirstList.get(0), weEvolutionLastList.get(0)));
                evolutionBranches.add(getEvolutionBranch(weEvolutionFirstList.get(0), weEvolutionLastList.get(1)));
                break;
            case "evolution-eight":
                assertEquals(weEvolutionFirstList.size(), 1);
//                assertEquals(weEvolutionMiddleList.size(), 0);
                assertEquals(weEvolutionLastList.size(), 3);
                assertEquals(welAllEvolutionsList.size(), 4);
                evolutionBranches.add(getEvolutionBranch(weEvolutionFirstList.get(0), weEvolutionLastList.get(0)));
                evolutionBranches.add(getEvolutionBranch(weEvolutionFirstList.get(0), weEvolutionLastList.get(1)));
                evolutionBranches.add(getEvolutionBranch(weEvolutionFirstList.get(0), weEvolutionLastList.get(2)));
                break;
        }
        return evolutionBranches;
    }

    public String getEvolutionBranch(WebElement evolutionFrom, WebElement evolutionTo) {
        return evolutionFrom.getText().replace("#", "").trim()
                + "_" +
                evolutionTo.getText().replace("#", "").trim();
    }

}
