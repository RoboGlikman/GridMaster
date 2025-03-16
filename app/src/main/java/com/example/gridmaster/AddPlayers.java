package com.example.gridmaster;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class AddPlayers extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_players);

        final EditText playerOne = findViewById(R.id.playerOneName);
        final EditText playerTwo = findViewById(R.id.playerTwoName);
        final Button nextBtn = findViewById(R.id.nextBtn);

        final int gamemode = getIntent().getIntExtra("gamemode", 1);
        final int difficulty = getIntent().getIntExtra("difficulty", 1);
        if (difficulty == 3){
            ImageView imageView = findViewById(R.id.playerTwoImg);
            imageView.setImageResource(R.drawable.blue_x);
        }
        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String getPlayerOneName = playerOne.getText().toString();
                final String getPlayerTwoName = playerTwo.getText().toString();

                if (getPlayerOneName.isEmpty() || getPlayerTwoName.isEmpty()){
                    Toast.makeText(AddPlayers.this, "Please enter both player names", Toast.LENGTH_SHORT).show();
                } else {
                   switch (gamemode){
                       case 1:
                           Intent intent1 = new Intent(AddPlayers.this, ThreeByThreeActivity.class);
                           intent1.putExtra("playerOne", getPlayerOneName);
                           intent1.putExtra("playerTwo", getPlayerTwoName);
                           intent1.putExtra("difficulty", difficulty);
                           startActivity(intent1);
                           break; // never get here
                       case 2:
                           Intent intent2 = new Intent(AddPlayers.this, FourByFourActivity.class);
                           intent2.putExtra("playerOne", getPlayerOneName);
                           intent2.putExtra("playerTwo", getPlayerTwoName);
                           intent2.putExtra("difficulty", difficulty);
                           startActivity(intent2);
                           break;
                       case 3:
                           Intent intent3 = new Intent(AddPlayers.this, FiveByFiveActivity.class);
                           intent3.putExtra("playerOne", getPlayerOneName);
                           intent3.putExtra("playerTwo", getPlayerTwoName);
                           intent3.putExtra("difficulty", difficulty);
                           startActivity(intent3);
                           break;
                   }
                }
            }
        });

    }
}