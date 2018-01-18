package com.example.demouser.scarnes_dice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.Random;
import android.widget.ImageView;
import android.os.Handler;

public class MainActivity extends AppCompatActivity {

    private Integer userOverallScore = 0;
    private Integer userTurnScore = 0;
    private Integer computerOverallScore = 0;
    private Integer computerTurnScore = 0;
    private Random rand = new Random();
    public Button rollButton;
    public Button holdButton;
    public Button resetButton;
    public TextView myText;
    public ImageView diceImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rollButton = findViewById(R.id.Roll_Button);
        holdButton = findViewById(R.id.Hold_Button);
        resetButton = findViewById(R.id.Reset_Button);
        myText = findViewById(R.id.scoresText);
        diceImage = findViewById(R.id.dieImage);
        rollButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                int result = rand.nextInt(6) + 1;
                if (result == 1) {
                    diceImage.setImageResource(R.drawable.dice1);
                } else if (result == 2) {
                    diceImage.setImageResource(R.drawable.dice2);
                } else if (result == 3) {
                    diceImage.setImageResource(R.drawable.dice3);
                } else if (result == 4) {
                    diceImage.setImageResource(R.drawable.dice4);
                } else if (result == 5) {
                    diceImage.setImageResource(R.drawable.dice5);
                } else {
                    diceImage.setImageResource(R.drawable.dice6);
                }

                if (result == 1) {
                    userTurnScore = 0;
                    computerTurn();
                } else {
                    userTurnScore += result;
                }
                myText.setText("Your score: " + userOverallScore +  "\nComputer Score: " + computerOverallScore + "\nYour turn score: " + userTurnScore);
            }
        });

        resetButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                myText.setText("Your score: 0\nComputer Score: 0");
                userOverallScore = 0;
                userTurnScore = 0;
                computerOverallScore = 0;
                computerTurnScore = 0;
            }
        });

        holdButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                userOverallScore += userTurnScore;
                myText.setText("Your score: " + userOverallScore + "\nComputer Score: " + computerOverallScore);
                userTurnScore = 0;
                computerTurn();
            }
        });
    }

    private void computerTurn() {
        rollButton.setEnabled(false);
        holdButton.setEnabled(false);
        final Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    boolean rolledOne = false;
                    int result = rand.nextInt(6) + 1;
                    if (result == 1) {
                        diceImage.setImageResource(R.drawable.dice1);
                    } else if (result == 2) {
                        diceImage.setImageResource(R.drawable.dice2);
                    } else if (result == 3) {
                        diceImage.setImageResource(R.drawable.dice3);
                    } else if (result == 4) {
                        diceImage.setImageResource(R.drawable.dice4);
                    } else if (result == 5) {
                        diceImage.setImageResource(R.drawable.dice5);
                    } else {
                        diceImage.setImageResource(R.drawable.dice6);
                    }

                    if (result == 1) {
                        computerTurnScore = 0;
                        rolledOne = true;
                        myText.setText("Computer rolled a one!");
                    } else {
                        computerTurnScore += result;
                    }
                    myText.setText("Your score: " + userOverallScore + "\nComputer Score: " + computerOverallScore + "\nComputer turn score: " + computerTurnScore);
                    if (computerTurnScore < 20 && !rolledOne) {
                        computerTurn();
                    } else {
                        endCompTurn();
                    }
                }
            }, 1000);
    }

    private void endCompTurn() {
        myText.setText("Computer holds!");
        computerOverallScore += computerTurnScore;
        computerTurnScore = 0;
        myText.setText("Your score: " + userOverallScore + "\nComputer Score: " + computerOverallScore);
        rollButton.setEnabled(true);
        holdButton.setEnabled(true);
    }

    /*
    private void computerTurn() {
        rollButton.setEnabled(false);
        holdButton.setEnabled(false);
        boolean rolledOne = false;
        while (computerTurnScore < 20 && !rolledOne) {
            int result = rand.nextInt(6) + 1;
            if (result == 1) {
                diceImage.setImageResource(R.drawable.dice1);
            } else if (result == 2) {
                diceImage.setImageResource(R.drawable.dice2);
            } else if (result == 3) {
                diceImage.setImageResource(R.drawable.dice3);
            } else if (result == 4) {
                diceImage.setImageResource(R.drawable.dice4);
            } else if (result == 5) {
                diceImage.setImageResource(R.drawable.dice5);
            } else {
                diceImage.setImageResource(R.drawable.dice6);
            }

            if (result == 1) {
                computerTurnScore = 0;
                rolledOne = true;
                myText.setText("Computer rolled a one!");
            } else {
                computerTurnScore += result;
            }
            myText.setText("Your score: " + userOverallScore + "\nComputer Score: " + computerOverallScore + "\nComputer turn score: " + computerTurnScore);
        }
        myText.setText("Computer holds!");
        computerOverallScore += computerTurnScore;
        computerTurnScore = 0;
        myText.setText("Your score: " + userOverallScore + "\nComputer Score: " + computerOverallScore);
        rollButton.setEnabled(true);
        holdButton.setEnabled(true);
    }
    */

}
