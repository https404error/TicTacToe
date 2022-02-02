package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LaunchActivity extends AppCompatActivity {
    private static final String TAG = "LaunchActivity";

    private EditText player1;
    private EditText player2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch);

        Button play = (Button) (findViewById(R.id.playButton));
        player1 = (EditText) findViewById(R.id.playerName1);
        player2 = (EditText) findViewById(R.id.playerName2);

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "LAUNCH ACTIVITY STARTED");
                submitButtonClick();
            }
        });
    }

    public void submitButtonClick () throws NullPointerException {
        try {
            String playerName1 = player1.getText().toString();
            String playerName2 = player2.getText().toString();
            Intent intent = new Intent(this, GameDisplay.class);
            intent.putExtra("PLAYER_NAMES", new String[] {playerName1, playerName2});
            startActivity(intent);
        } catch (NullPointerException e) {
            Log.d(TAG, e.getMessage());
        }
    }
}