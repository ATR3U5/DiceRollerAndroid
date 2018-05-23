package com.example.gensis.dice;

import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class Dice {

    private int diceRandomNumber = 0;
    private TextView textView = null;

    public String diceText = null;
    public ImageButton diceImage = null;

    //dice attributes and on-click in constructor

    public Dice(int pSides, String pdiceName, ImageButton pdiceButton, TextView pTextview){

        this.diceRandomNumber = pSides;
        this.diceText = pdiceName;
        this.diceImage = pdiceButton;
        this.textView = pTextview;

        diceImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                textView.setText(diceRoll());

            }
        });

    }

    //dice roll functionality (used in constructor on-click)

    private String diceRoll(){

        int random = (int) (Math.random() * diceRandomNumber + 1);

        return Integer.toString(random);
    }

}
