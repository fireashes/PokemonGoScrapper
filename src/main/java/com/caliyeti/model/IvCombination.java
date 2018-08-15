package com.caliyeti.model;

public class IvCombination {
    public int pokedex;
    public double level;
    public int staminaIV;
    public int hpIV;
    public int attackIV;
    public int defenseIV;
    public boolean isDiscarded = false;

    public IvCombination(int staminaIV, int attackIV, int defenseIV) {
        this.staminaIV = staminaIV;
        this.attackIV = attackIV;
        this.defenseIV = defenseIV;
    }
}
