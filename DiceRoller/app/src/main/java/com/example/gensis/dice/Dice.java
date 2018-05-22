package com.example.gensis.dice;

public class Dice {

    public String diceRoll(int pSelectedDice){

        int random = (int) (Math.random() * pSelectedDice + 1);

        return Integer.toString(random);
    }

}
