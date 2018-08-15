package com.caliyeti.model;

public class AttackMoveCombination {
    public FastAttack fastAttack;
    public ChargedAttack chargedAttack;

    public AttackMoveCombination() {
    }

    public AttackMoveCombination(FastAttack fastAttack, ChargedAttack chargedAttack) {
        this.fastAttack = fastAttack;
        this.chargedAttack = chargedAttack;
    }

}
