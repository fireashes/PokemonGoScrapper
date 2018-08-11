package com.caliyeti.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class PokemonCom {
    private final WebDriver driver;
    private WebDriverWait wait;
    //    private Wait<WebDriver> fluentWait;
    private Actions actions;

    private List<String> formesNamesList = new ArrayList<>();
    private String pokemonName = null;
    private String pokemonPokedex = null;
    private HashMap<String, String> pokemonAbilities = new HashMap<>();


    public PokemonCom(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 30);
//        fluentWait = new FluentWait<WebDriver>(driver)
//                .ignoring(NoSuchElementException.class);
        actions = new Actions(driver);
        PageFactory.initElements(driver, this);
        actions.moveToElement(pokedexPokemonPaginationTitle);
    }

    /*
        //section[contains(@class,'pokedex-pokemon-header')]
            /div[@class='pokedex-pokemon-pagination-title']

        //section[contains(@class,'pokedex-pokemon-form')]
            //div[contains(@class,'styled-select')][contains(@class,'button-black')][contains(@class,'right')]
            //div[@class='custom-select-wrapper']
                /select[@id='formes'][@name='formes']
                    /option[]
                /div[@class='custom-select-menu']
                    /label
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

     */
    @FindBy(className = "pokedex-pokemon-pagination-title")
    private WebElement pokedexPokemonPaginationTitle;

    @FindBy(xpath = "//section[contains(@class,'pokedex-pokemon-form')]")
    private WebElement pokedexPokemonForm;

    @FindBy(className = "custom-select-wrapper")
    private WebElement customSelectWrapper;

    @FindBy(id = "formes")
    private Select formes;

    @FindBys({
            @FindBy(xpath = "//select[@id='formes']" +
                    "/option")
    })
    private List<WebElement> formesOptions;

    @FindBy(xpath = "//div[@class='custom-select-menu']")
    private WebElement customSelectMenu;

    @FindBy(xpath = "//div[@class='custom-select-menu']" +
            "/label")
    private WebElement currentFormeLabel;

    @FindBys({
            @FindBy(xpath = "//div[@class='custom-select-menu']" +
                    "/ul[@data-select-name='formes']" +
                    "/li")
    })
    private List<WebElement> customSelectMenuFormesNames;

    @FindBy(xpath = "//section[contains(@class,'pokedex-pokemon-details')]" +
            "//div[@class='pokedex-pokemon-details-right']" +
            "/div[contains(@class,'version-descriptions')][contains(@class,'active')]" +
            "/p[contains(@class,'version-x')][contains(@class,'active')]")
    private WebElement versionXActiveDescription;

    @FindBy(xpath = "//section[contains(@class,'pokedex-pokemon-details')]" +
            "//div[@class='pokedex-pokemon-details-right']" +
            "/div[contains(@class,'version-descriptions')][contains(@class,'active')]" +
            "/p[contains(@class,'version-y')][contains(@class,'active')]")
    private WebElement versionYActiveDescription;

    @FindBy(xpath = "//section[contains(@class,'pokedex-pokemon-details')]" +
            "//div[@class='pokedex-pokemon-details-right']" +
            "/div[contains(@class,'version-descriptions')][contains(@class,'active')]" +
            "/p[contains(@class,'active')]")
    private WebElement description;

    @FindBys({
            @FindBy(xpath = "//section[contains(@class,'pokedex-pokemon-details')]" +
                    "//div[@class='pokedex-pokemon-details-right']" +
                    "/div[@class='version-labels']" +
                    "/span[contains(@class,'version-label')]" +
                    "/i")

    })
    private List<WebElement> versionsList;

    @FindBy(xpath = "//section[contains(@class,'pokedex-pokemon-details')]" +
            "//div[@class='pokedex-pokemon-details-right']" +
            "/div[@class='version-labels']" +
            "/span[contains(@class,'version-label')][contains(@class,'version-y')]" +
            "/i")
    private WebElement versionY;

    @FindBy(xpath = "//section[contains(@class,'pokedex-pokemon-details')]" +
            "//div[@class='pokedex-pokemon-details-right']" +
            "/div[@class='version-labels']" +
            "/span[contains(@class,'version-label')][contains(@class,'version-x')]" +
            "/i")
    private WebElement versionX;

    @FindBy(id = "cookie-dismisser")
    private WebElement cookieDismisser;

    //    @FindBy (xpath = "//div[@class='pokedex-pokemon-details-right']/div/p[1]")
    @FindBy(xpath = "//div[@class='pokedex-pokemon-details-right'" +
            "/div[contains(@class,'version-descriptions')][contains(@class,'active')]" +
            "/p[contains(@class,active)]")
    private WebElement activeVersionDescription;

    @FindBy(xpath = "//section[contains(@class,'pokedex-pokemon-details')]" +
            "//div[@class='pokedex-pokemon-details-right']" +
            "/div[contains(@class,'info')][contains(@class,'match-height-tablet')]" +
            "/div[contains(@class,'pokemon-ability-info')][contains(@class,'active')]" +
            "//span[@class='attribute-title'][contains(text(),'Height')]" +
            "/../span[@class='attribute-value']")
    private WebElement height;

    @FindBy(xpath = "//section[contains(@class,'pokedex-pokemon-details')]" +
            "//div[@class='pokedex-pokemon-details-right']" +
            "/div[contains(@class,'info')][contains(@class,'match-height-tablet')]" +
            "/div[contains(@class,'pokemon-ability-info')][contains(@class,'active')]" +
            "//span[@class='attribute-title'][contains(text(),'Weight')]" +
            "/../span[@class='attribute-value']")
    private WebElement weight;

    @FindBy(xpath = "//section[contains(@class,'pokedex-pokemon-details')]" +
            "//div[@class='pokedex-pokemon-details-right']" +
            "/div[contains(@class,'info')][contains(@class,'match-height-tablet')]" +
            "/div[contains(@class,'pokemon-ability-info')][contains(@class,'active')]" +
            "//span[@class='attribute-title'][contains(text(),'Gender')]" +
            "/../span[@class='attribute-value']")
    private WebElement genders;

    @FindBys({
            @FindBy(xpath = "//section[contains(@class,'pokedex-pokemon-details')]" +
                    "//div[@class='pokedex-pokemon-details-right']" +
                    "/div[contains(@class,'info')][contains(@class,'match-height-tablet')]" +
                    "/div[contains(@class,'pokemon-ability-info')][contains(@class,'active')]" +
                    "//span[@class='attribute-title'][contains(text(),'Gender')]" +
                    "/../span[@class='attribute-value']" +
                    "/i")
    })
    List<WebElement> genderList;

    @FindBy(xpath = "//section[contains(@class,'pokedex-pokemon-details')]" +
            "//div[@class='pokedex-pokemon-details-right']" +
            "/div[contains(@class,'info')][contains(@class,'match-height-tablet')]" +
            "/div[contains(@class,'pokemon-ability-info')][contains(@class,'active')]" +
            "//span[@class='attribute-title'][contains(text(),'Gender')]" +
            "/../span[@class='attribute-value']" +
            "/i[contains(@class,'icon_male_symbol')]")
    private WebElement genderMale;

    @FindBy(xpath = "//section[contains(@class,'pokedex-pokemon-details')]" +
            "//div[@class='pokedex-pokemon-details-right']" +
            "/div[contains(@class,'info')][contains(@class,'match-height-tablet')]" +
            "/div[contains(@class,'pokemon-ability-info')][contains(@class,'active')]" +
            "//span[@class='attribute-title'][contains(text(),'Gender')]" +
            "/../span[@class='attribute-value']" +
            "/i[contains(@class,'icon_female_symbol')]")
    private WebElement genderFemale;

    @FindBy(xpath = "//section[contains(@class,'pokedex-pokemon-details')]" +
            "//div[@class='pokedex-pokemon-details-right']" +
            "/div[contains(@class,'info')][contains(@class,'match-height-tablet')]" +
            "/div[contains(@class,'pokemon-ability-info')][contains(@class,'active')]" +
            "//span[@class='attribute-title'][contains(text(),'Gender')]" +
            "/../span[@class='attribute-value'][contains(text(),'Unknown')]")
    private WebElement genderUnknown;

    @FindBy(xpath = "//section[contains(@class,'pokedex-pokemon-details')]" +
            "//div[@class='pokedex-pokemon-details-right']" +
            "/div[contains(@class,'info')][contains(@class,'match-height-tablet')]" +
            "/div[contains(@class,'pokemon-ability-info')][contains(@class,'active')]" +
            "//span[@class='attribute-title'][contains(text(),'Category')]" +
            "/../span[@class='attribute-value']")
    private WebElement category;

    @FindBys({
            @FindBy(xpath = "//section[contains(@class,'pokedex-pokemon-details')]" +
                    "//div[@class='pokedex-pokemon-details-right']" +
                    "/div[contains(@class,'info')][contains(@class,'match-height-tablet')]" +
                    "/div[contains(@class,'pokemon-ability-info')][contains(@class,'active')]" +
                    "//span[@class='attribute-title'][contains(text(),'Abilities')]" +
                    "/../ul[@class='attribute-list']" +
                    "/li" +
                    "/a[@class='moreInfo']" +
                    "/span[@class='attribute-value']")
    })
    private List<WebElement> abilities;

    @FindBys({
            @FindBy(xpath = "//section[contains(@class,'pokedex-pokemon-details')]" +
                    "//div[@class='pokedex-pokemon-details-right']" +
                    "/div[contains(@class,'info')][contains(@class,'match-height-tablet')]" +
                    "/div[contains(@class,'pokemon-ability-info')][contains(@class,'active')]" +
                    "//span[@class='attribute-title'][contains(text(),'Abilities')]" +
                    "/..//span[@class='attribute-value']")
    })
    private List<WebElement> abilitiesLinks;

    @FindBy(xpath = "//section[contains(@class,'pokedex-pokemon-details')]" +
            "//div[@class='pokedex-pokemon-details-right']" +
            "/div[contains(@class,'info')][contains(@class,'match-height-table')]" +
            "/div[contains(@class,'pokemon-ability-info')][contains(@class,'match')][contains(@class,'active')]" +
            "/div[contains(@class,'pokemon-ability-info-detail')][contains(@class,'match')][contains(@style,'block')]" +
            "/span[@class='button-close']")
    private WebElement buttonClose;

    @FindBy(xpath = "//section[contains(@class,'pokedex-pokemon-details')]" +
            "//div[@class='pokedex-pokemon-details-right']" +
            "/div[contains(@class,'info')][contains(@class,'match-height-table')]" +
            "/div[contains(@class,'pokemon-ability-info')][contains(@class,'match')][contains(@class,'active')]" +
            "/div[contains(@class,'pokemon-ability-info-detail')][contains(@class,'match')][contains(@style,'block')]" +
            "/h3")
    private WebElement abilityHeading;

    @FindBy(xpath = "//section[contains(@class,'pokedex-pokemon-details')]" +
            "//div[@class='pokedex-pokemon-details-right']" +
            "/div[contains(@class,'info')][contains(@class,'match-height-table')]" +
            "/div[contains(@class,'pokemon-ability-info')][contains(@class,'match')][contains(@class,'active')]" +
            "/div[contains(@class,'pokemon-ability-info-detail')][contains(@class,'match')][contains(@style,'block')]" +
            "/p")
    private WebElement abilityDescription;

    @FindBys({
            @FindBy(xpath = "//section[contains(@class,'pokedex-pokemon-details')]" +
                    "//div[@class='pokedex-pokemon-details-right']" +
                    "/div[contains(@class,'info')][contains(@class,'match-height-tablet')]" +
                    "/div[contains(@class,'pokedex-pokemon-attributes')][contains(@class,'active')]" +
                    "/div[@class='dtm-type']" +
                    "/h3[contains(text(),'Type')]" +
                    "/..//a")
    })
    private List<WebElement> types;

    public void dismissCookie() {
        try {
            cookieDismisser.click();
            sleepMillis(500);
        } catch (Exception e) {
            // Do nothing
        }
    }

    public String getCurrentTimestamp() {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        return timestamp.toString();
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public String getPaginationTitle() {
        actions.moveToElement(pokedexPokemonPaginationTitle);
        wait.until(ExpectedConditions.visibilityOf(pokedexPokemonPaginationTitle));
        if (pokedexPokemonPaginationTitle.isDisplayed()) {
            return pokedexPokemonPaginationTitle.getText();
        } else {
            fail("Could not get pagination title");
            return null;
        }
    }

    public void findPokemonNamePokedexFormes() {
        String pokemonNameFromTitle = getTitle().replace(" | Pokédex", "").trim();
        String pokemonNamePokedexFromPaginationTitle = getPaginationTitle();

        assertTrue("Pokemon name from title " + pokemonNameFromTitle + " should match pokemon name displayed " + pokemonNamePokedexFromPaginationTitle, pokemonNamePokedexFromPaginationTitle.contains(pokemonNameFromTitle));
        pokemonName = pokemonNameFromTitle;
        pokemonPokedex = pokemonNamePokedexFromPaginationTitle
                .replace(pokemonName, "")
                .trim();
        assertTrue(pokemonPokedex + ": Pokemon name from url should match pokemon name", driver.getCurrentUrl().toLowerCase().contains(pokemonName.toLowerCase()));

        int numberOfDivInForme = driver.findElements(By.xpath("//section[contains(@class,'pokedex-pokemon-form')]//div")).size();
        if (numberOfDivInForme == 2) {
            formesNamesList.add(pokemonName);
        } else {
            try {
                wait.until(ExpectedConditions.visibilityOf(currentFormeLabel));
                currentFormeLabel.click();
                sleepMillis(500);
                wait.until(ExpectedConditions.visibilityOfAllElements(customSelectMenuFormesNames));
                sleepMillis(500);
            } catch (Exception e) {
                fail(e.getMessage());
            }
            for (WebElement customSelectMenuFormesName : customSelectMenuFormesNames) {
                String thisFormName = customSelectMenuFormesName.getText().trim();
                formesNamesList.add(customSelectMenuFormesName.getText().trim());
            }
        }
    }

    public String getPokemonName() {
        return pokemonName;
    }

    public String getPokemonPokedex() {
        return pokemonPokedex;
    }

    public int getPokedex() {
        return Integer.parseInt(pokemonPokedex.replace("#", ""));
    }

    public List<String> getFormesNameList() {
        return formesNamesList;
    }

    public void selectForme(String formeName) {
        if (pokemonName == null || pokemonPokedex == null || formesNamesList == null || pokemonName.isEmpty() || pokemonPokedex.isEmpty() || formesNamesList.size() == 0) {
            findPokemonNamePokedexFormes();
        }
        pokedexPokemonPaginationTitle.click();
        if (formesNamesList.size() == 1) {
            if (formeName.equals(pokemonName)) {
                // Do Nothing
            } else {
                fail("Forme not found");
            }
        } else {
            if (formeName.equals(currentFormeLabel.getText().trim())) {
                // Do Nothing
            } else {
                for (int i = 0; i < formesNamesList.size(); i++) {
                    if (formeName.equals(formesNamesList.get(i))) {
                        try {
                            pokedexPokemonPaginationTitle.click();
                            sleepMillis(500);
                            wait.until(ExpectedConditions.visibilityOf(currentFormeLabel));
                            currentFormeLabel.click();
                            sleepMillis(500);
                            wait.until(ExpectedConditions.visibilityOfAllElements(customSelectMenuFormesNames));
                            sleepMillis(500);
                            customSelectMenuFormesNames.get(i).click();
                            sleepMillis(500);
                            wait.until(ExpectedConditions.textToBePresentInElement(currentFormeLabel, formeName));
                        } catch (Exception e) {
                            fail(e.getMessage());
                        }
                    } else {
                        // Do Nothing, check next one
                    }
                }
                if (formeName.equals(currentFormeLabel.getText().trim())) {
                    // Do Nothing
                } else {
                    fail("Forme not loaded");
                }
            }
        }
    }

    public int getNumberOfVersions() {
        wait.until(ExpectedConditions.visibilityOfAllElements(versionsList));
        wait.until(ExpectedConditions.visibilityOf(versionX));
        wait.until(ExpectedConditions.visibilityOf(versionY));
        assertEquals(pokemonPokedex + ": There should be two version X and Y", versionsList.size(), 2);
        return versionsList.size();
    }

    public List<String> getVersions() {
        wait.until(ExpectedConditions.visibilityOfAllElements(versionsList));
        wait.until(ExpectedConditions.visibilityOf(versionX));
        wait.until(ExpectedConditions.visibilityOf(versionY));
        assertEquals(pokemonPokedex + ": There should be two version X and Y", versionsList.size(), 2);
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
    }

    public void selectVersionX() {
        wait.until(ExpectedConditions.visibilityOf(versionX));
        versionX.click();
        sleepMillis(500);
    }

    public void selectVersionY() {
        wait.until(ExpectedConditions.visibilityOf(versionY));
        versionY.click();
        sleepMillis(500);
    }

    public String getDesctiption() {
        wait.until(ExpectedConditions.visibilityOf(description));
        return description.getText().trim();
    }

    public String getTextVersionYActiveDescription() {
        wait.until(ExpectedConditions.visibilityOf(versionYActiveDescription));
        if (versionYActiveDescription.isDisplayed()) {
            return versionYActiveDescription.getText().trim();
        } else {
            return null;
        }
    }

    public String getTextVersionXActiveDescription() {
        wait.until(ExpectedConditions.visibilityOf(versionX));
        versionX.click();
        wait.until(ExpectedConditions.visibilityOf(versionXActiveDescription));
        if (versionXActiveDescription.isDisplayed()) {
            return versionXActiveDescription.getText().trim();
        } else {
            return null;
        }
    }


    public String getFormName(int j) {
        pokedexPokemonPaginationTitle.click();
        currentFormeLabel.click();
        customSelectMenuFormesNames.get(j).click();
        pokedexPokemonPaginationTitle.click();
        return customSelectMenuFormesNames.get(j).getText();
    }

    public String getHeight() {
        if (height.isDisplayed()) {
            return height.getText();
        } else {
            return null;
        }
    }

    public String getWeight() {
        if (weight.isDisplayed()) {
            return weight.getText();
        } else {
            return null;
        }
    }

    public List<String> getGenders() {
        List<String> gList = new ArrayList<>();
        if (genders.getText().equals("Unknown")) {
            gList.add(genders.getText());
        } else {
            for (WebElement gender : genderList) {
                if (gender.getAttribute("class").contains("icon_male_symbol")) {
                    gList.add("Male");
                } else if (gender.getAttribute("class").contains("icon_female_symbol")) {
                    gList.add("Female");
                }
            }
        }
        return gList;
    }

    public String getCategory() {
        if (category.isDisplayed()) {
            return category.getText();
        } else {
            return null;
        }
    }

    public HashMap<String, String> findAbilities() {
        pokemonAbilities.clear();
        wait.until(ExpectedConditions.visibilityOfAllElements(abilitiesLinks));
        for (WebElement ability : abilitiesLinks) {
            wait.until(ExpectedConditions.visibilityOf(ability));
            wait.until(ExpectedConditions.elementToBeClickable(ability));

            String abilityName = ability.getText().trim();

            ability.click();
            sleepMillis(1000);

            wait.until(ExpectedConditions.visibilityOf(abilityHeading));
            assertEquals(pokemonPokedex + ": Ability name should be equal to ability heading", abilityName, abilityHeading.getText().trim());

            wait.until(ExpectedConditions.visibilityOf(abilityDescription));
            String abilityInfo = abilityDescription.getText().trim();

            pokemonAbilities.put(abilityName, abilityInfo);

            wait.until(ExpectedConditions.visibilityOf(buttonClose));
            buttonClose.click();
            sleepMillis(1000);
        }
        return pokemonAbilities;
    }

    public HashMap<String, String> getPokemonAbilities() {
        return pokemonAbilities;
    }

    public List<String> getAbilities() {
        List<String> abilityList = new ArrayList<>();
        for (Object o : pokemonAbilities.entrySet()) {
            Map.Entry pair = (Map.Entry) o;
            abilityList.add(pair.getKey().toString());
        }
        return abilityList;
    }


    public String getAbilityInfo(String ability) {
//        pokedexPokemonPaginationTitle.click();
//        wait.until(ExpectedConditions.elementToBeClickable(By.linkText(ability))).click();
        wait.until(ExpectedConditions.visibilityOf(buttonClose));
        assertEquals(pokemonPokedex + ": Ability heading should be equal to ability", abilityHeading.getText().trim(), ability);
        wait.until(ExpectedConditions.visibilityOf(abilityDescription));
        String abilityInfo = abilityDescription.getText().trim();
        buttonClose.click();
        System.out.println(ability + ".info=" + abilityInfo);
        return abilityInfo;
    }

    public List<String> getTypes() {
        List<String> typeList = new ArrayList<>();
        for (WebElement type : types) {
            if (type.isDisplayed()) {
                typeList.add(type.getText());
            }
        }
        return typeList;
    }

    public void sleepMillis(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            fail(e.getMessage());
        }
    }
}
