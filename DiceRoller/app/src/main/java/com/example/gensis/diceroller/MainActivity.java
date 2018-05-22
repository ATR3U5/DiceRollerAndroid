package com.example.gensis.diceroller;

import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.gensis.dice.Dice;

import org.w3c.dom.Text;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    private ImageButton dice20;
    private ImageButton dice4;
    private ImageButton dice6;
    private ImageButton dice8;
    private ImageButton dice12;
    private ImageButton dice10;
    private TextView diceName;
    private TextView number;

    private Dice dice = new Dice();
    private ArrayList<ImageButton> buttonList = new ArrayList<>();
    private String[] diceNames = {"d4", "d6", "d8", "d10", "d12", "d20"};
    private int counter = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //No manual Edit of Dice Result possible
        number = findViewById(R.id.diceNumber);
        number.setKeyListener(null);

        //No Edit of DiceName Possible
        diceName = findViewById(R.id.TextName);
        diceName.setKeyListener(null);


        //setting onClick Events for Buttons -------------------------------------------------------

        dice6 = findViewById(R.id.diceButtonD6);
        dice6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number.setText(dice.diceRoll(6));
            }
        });

        dice4 = findViewById(R.id.diceButtonD4);
        dice4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number.setText(dice.diceRoll(4));


            }
        });

        dice8 = findViewById(R.id.diceButtonD8);
        dice8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                number.setText(dice.diceRoll(8));

            }
        });


        dice10 = findViewById(R.id.diceButtonD10);
        dice10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                number.setText(dice.diceRoll(10));


            }
        });

        dice12 = findViewById(R.id.diceButtonD12);
        dice12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                number.setText(dice.diceRoll(12));


            }
        });

        dice20 = findViewById(R.id.diceButtonD20);
        dice20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                number.setText(dice.diceRoll(20));


            }
        });

        // -----------------------------------------------------------------------------------------

        //adding image buttons to array list
        buttonList.add(dice4);
        buttonList.add(dice6);
        buttonList.add(dice8);
        buttonList.add(dice10);
        buttonList.add(dice12);
        buttonList.add(dice20);

        //adding onClick events for Arrow Buttons
        //Arrows move up and down through ArrayList

        ImageButton rightArrow = findViewById(R.id.scrollRight);
        ImageButton leftArrow = findViewById(R.id.scrollLeft);

        rightArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int intermediate = counter;
                counter++;
                if(counter>5){
                    counter = 0;
                }

                buttonList.get(intermediate).setVisibility(View.INVISIBLE);
                buttonList.get(counter).setVisibility(View.VISIBLE);
                diceName.setText(diceNames[counter]);

            }
        });

        leftArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int intermediate = counter;
                counter--;
                if(counter<0){
                    counter = 5;
                }

                buttonList.get(intermediate).setVisibility(View.INVISIBLE);
                buttonList.get(counter).setVisibility(View.VISIBLE);
                diceName.setText(diceNames[counter]);

            }
        });


        }

    }

