package com.caliyeti.pages;

import com.caliyeti.model.AttackMoveCombination;
import com.caliyeti.model.ChargedAttack;
import com.caliyeti.model.FastAttack;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import static org.junit.Assert.*;

public class DbPokemonGoHubNetPage extends PokemonPage {
    private final Logger log = LoggerFactory.getLogger(getClass().getEnclosingClass().getName());

    String baseUrl = "https://db.pokemongohub.net";

    public DbPokemonGoHubNetPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public DbPokemonGoHubNetPage load(String url) {
        driver.get(url);
        sleepMillis(1000);
        return this;
    }

    public DbPokemonGoHubNetPage load(int pokedex) {
        return load(baseUrl + "/pokemon/" + pokedex);
    }

    public DbPokemonGoHubNetPage load(int pokedex, String form) {
        if (!form.equals("Alolan")) {
            log.info("form " + form + " is not Alolan");
        }
        return load(baseUrl + "/pokemon/" + pokedex + "?form=" + form);
    }

    private WebElement weDetails;
    private WebElement weMoves;
    private WebElement weCounters;
    private WebElement weCpChart;
    private WebElement weIvChart;
    private WebElement weHpChart;

    private WebElement weCpMax;
    private WebElement weAttack;
    private WebElement weDefense;
    private WebElement weStamina;

    private WebElement weCatchRate;
    private WebElement weBuddyKM;
    private WebElement weGeneration;
    private WebElement weEvolutionCost;
    private WebElement weCategory;
    private WebElement weHeight;
    private WebElement weWeight;

    private WebElement wePokedexEntry;

    private List<FastAttack> fastAttackList;
    private List<ChargedAttack> chargedAttackList;
    private List<AttackMoveCombination> attackMoveCombinationList;

}
