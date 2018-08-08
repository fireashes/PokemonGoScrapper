package com.caliyeti.model;

import java.util.ArrayList;
import java.util.List;

public class Pokemon {

    public String pokemonName;
    public String pokemonPokedex;
    public List<String> formesList = new ArrayList<>();
    public String forme;
    public List<String> versionsList = new ArrayList<>();
    public String version;
    public List<String> gendersList = new ArrayList<>();
    public String gender;
    public String description;
    public List<String> TypesList = new ArrayList<>();
    public String type1;
    public String type2;
    public double baseHeightM;
    public double baseHeightIn;
    public String baseHeightFtIn;
    public double baseWeightKg;
    public double baseWeightLbs;
    public List<String> categoriesList = new ArrayList<>();
    public String category;
    public List<String> abilitiesList = new ArrayList<>();
    public String ability;

    public List<String> evolutionBranchesList = new ArrayList<>();
    public String evolutionBranch;

    public int baseStamina;
    public int baseHP;
    public int baseDefense;
    public int baseSpecialAttack;
    public int baseSpecialDefense;
    public int baseSpeed;
    public int baseStaminaPG;
    public int baseHPPG;
    public int baseAttackPG;
    public int baseDefensePG;
    public int baseAttackPGOld;
    public int baseDefensePGOld;
    public int speedModifier;
    public int scaledAttack;
    public int scaledDefense;

    public double baseCaptureRate;
    public double baseFleeRate;
    public double maleRatio;
    public double femaleRatio;
    public double genderlessRatio;
    public double rarity;

    public String evolutionFamilyCandyName;
    public int buddyCandyDistanceKm;
    public int eggHatchDistanceKm;

    public List<String> fastAttacksList = new ArrayList<>();
    public String fastAttack;
    public List<String> chargedAttacksList = new ArrayList<>();
    public String chargedAttack;

    public int currentCP;
    public int currentHp;
    public int currentWeightKg;
    public String currentWeightDescription;
    public int currentHeightM;
    public String currentHeightDescription;
    public int currentPowerUpStardustCost;
    public int currentPowerUpCandyCost;
    public List<String> currentEvolutionBranches;
    public int pastEvolutionBranch;
    public int currentEvolutionCandyCost;

    public String acquiredBy;
    public String acquiredLocation;
    public String acquiredDate;

    public String team;

    public String appraisalOverall;
    public List<String> appraisalStrongestStatList;
    public String appraisalStrongestStatRange;
    public String appraisalSize;

    public Pokemon() {
    }

}
