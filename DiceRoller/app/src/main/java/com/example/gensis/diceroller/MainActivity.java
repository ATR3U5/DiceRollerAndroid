package com.example.gensis.diceroller;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import com.example.gensis.dice.Dice;



import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {


    private TextView diceName;

    private ArrayList<Dice> buttonList = new ArrayList<>();
    private int counter = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //No manual Edit of Dice Result possible
        TextView number = findViewById(R.id.diceNumber);
        number.setKeyListener(null);

        //No Edit of DiceName Possible
        diceName = findViewById(R.id.TextName);
        diceName.setKeyListener(null);

        //dice objects

        Dice dice4 = new Dice(4, "d4", (ImageButton) findViewById(R.id.diceButtonD4), number);
        Dice dice6 = new Dice(6, "d6", (ImageButton) findViewById(R.id.diceButtonD6), number);
        Dice dice8 = new Dice(8, "d8", (ImageButton) findViewById(R.id.diceButtonD8), number);
        Dice dice10 = new Dice(10, "d10", (ImageButton) findViewById(R.id.diceButtonD10), number);
        Dice dice12 = new Dice(12, "d12", (ImageButton) findViewById(R.id.diceButtonD12), number);
        Dice dice20 = new Dice(20, "d20", (ImageButton) findViewById(R.id.diceButtonD20), number);

        //adding dice objects to array list
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

                arrowClick(intermediate);

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

                arrowClick(intermediate);

            }
        });


    }

    //adding arrow click event

    public void arrowClick(int pIntermediate){

        buttonList.get(pIntermediate).diceImage.setVisibility(View.INVISIBLE);
        buttonList.get(counter).diceImage.setVisibility(View.VISIBLE);
        diceName.setText(buttonList.get(counter).diceText);

    }

}
