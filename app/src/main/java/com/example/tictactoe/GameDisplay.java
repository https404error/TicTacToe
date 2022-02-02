package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class GameDisplay extends AppCompatActivity {

    private TicTacToeBoard ticTacToeBoard;
    private Button homeButton;
    private Button playAgain;
    private TextView playerTurn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_display);

        ticTacToeBoard = (findViewById(R.id.ticTacToeBoard));
        homeButton = (findViewById(R.id.homeBtn));
        playAgain = (findViewById(R.id.playAgain));
        playerTurn = (findViewById(R.id.textSurface));

        playAgain.setVisibility(View.GONE);
        homeButton.setVisibility(View.GONE);

        String[] playerNames = getIntent().getStringArrayExtra("PLAYER_NAMES");

        if (playerTurn != null) {
            playerTurn.setText((playerNames[0] + "'s Turn"));
        }

        ticTacToeBoard.setUpGame(playAgain, homeButton, playerTurn, playerNames);

        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                homeScreen();
            }
        });

        playAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playAgain();
            }
        });

    }

    public void playAgain () {
        ticTacToeBoard.resetGame();
        ticTacToeBoard.invalidate();
    }

    public void homeScreen () {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}