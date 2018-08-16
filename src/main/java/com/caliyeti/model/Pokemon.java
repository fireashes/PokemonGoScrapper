package com.caliyeti.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Pokemon {

    public String pokemonName;
    public String pokemonNameSimple;
    public String pokedexPound;
    public String pokedexTxt;
    public int pokedex;

    public int generation;
    public String region;

    public List<String> availableFormes = new ArrayList<>();
    public String forme;

    public List<String> availableVersions = new ArrayList<>();
    public String version;

    public List<String> availableGenders = new ArrayList<>();
    public String gender;

    public String description;

    public HashMap<Type, Type> types = new HashMap<>();
    public Type type1;
    public Type type2;

    public double heightBaseM;
    public double heightBaseIn;
    public String heightBaseFtIn;
    public double weightBaseKg;
    public double weightBaseLbs;

    public double heightM;
    public double weightKg;
    public String heightDescription;
    public String weightDescription;

    public String category;
    public List<Ability> availableAbilities = new ArrayList<>();
    public List<Ability> abilities = new ArrayList<>();

    public int familyCandyPokedex;
    public EvolutionBranch evolutionBranch;
    public List<EvolutionBranch> allEvolutionBranches = new ArrayList<>();
    public List<EvolutionBranch> availableEvolutionBranches = new ArrayList<>();
    public List<EvolutionBranch> evolvedBranches;

    public int staminaBase;
    public int hpBase;
    public int attackBase;
    public int defenseBase;
    public int specialAttackBase;
    public int specialDefenseBase;
    public int speedBase;

    public int staminaBasePG;
    public int hpBasePG;
    public int attackBasePG;
    public int defenseBasePG;

    public int staminaIV;
    public int hpIV;
    public int attackIV;
    public int defenseIV;
    public List<IvCombination> ivCombinations = new ArrayList<>();

    public int stamina;
    public int attack;
    public int defense;

    public int attackOldBasePG;
    public int defenseOldBasePG;
    public int speedModifierBasePG;
    public int scaledAttackBasePG;
    public int scaledDefenseBasePG;

    public double baseCaptureRate;
    public double baseFleeRate;
    public double maleRatio;
    public double femaleRatio;
    public double genderlessRatio;
    public double rarity;
    public String legendry;

    public String buddySize;
    public int buddyCandyDistanceKm;
    public int eggHatchDistanceKm;

    public List<FastAttack> availableFastAttacks = new ArrayList<>();
    public String fastAttackName;
    public List<ChargedAttack> availableChargedAttacks = new ArrayList<>();
    public String chargedAttackName;
    public List<AttackMoveCombination> availableAttackMoveCombination;
    public AttackMoveCombination attackMoveCombination;

    public double level;
    public int cp;
    public int hp;
    public int powerUpStardustCost;
    public int powerUpCandyCost;

    public int cpAtLevel15;
    public int cpAtLevel20;
    public int cpAtLevel25;
    public int cpAtLevel30;
    public int cpAtLevel35;
    public int cpAtLevel40;
    public int cpAtMaxLevelFor0IV;
    public int cpAtMaxLevelForFullIV;

    public int hpAtLevel15;
    public int hpAtLevel20;
    public int hpAtLevel25;
    public int hpAtLevel30;
    public int hpAtLevel35;
    public int hpAtLevel40;
    public int hpAtMaxLevelFor0IV;
    public int hpAtMaxLevelForFullIV;

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

    public Pokemon(int pokedex) {
        this.pokedex = pokedex;
    }
}
