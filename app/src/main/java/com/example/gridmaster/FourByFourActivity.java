package com.example.gridmaster;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class FourByFourActivity extends AppCompatActivity {
    private Random rand = new Random();
    private List<int[]> winCombinations = new ArrayList<>();
    private int[] boxPositions = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};

    private int playerTurn = rand.nextInt(2) + 1;
    private int totalSelectedBoxes = 1;
    private LinearLayout playerOneLayout, playerTwoLayout;
    private TextView playerOneName, playerTwoName;
    private ImageView img0,img1,img2,img3,img4,img5,img6,img7,img8,img9,img10,img11,img12,img13,img14,img15;
    private int diff;
    private String strDiff;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_four_by_four);

        playerOneName = findViewById(R.id.playerOneName);
        playerTwoName = findViewById(R.id.playerTwoName);

        playerOneLayout = findViewById(R.id.playerOneLayout);
        playerTwoLayout = findViewById(R.id.playerTwoLayout);

        img0 = findViewById(R.id.img0);
        img1 = findViewById(R.id.img1);
        img2 = findViewById(R.id.img2);
        img3 = findViewById(R.id.img3);
        img4 = findViewById(R.id.img4);
        img5 = findViewById(R.id.img5);
        img6 = findViewById(R.id.img6);
        img7 = findViewById(R.id.img7);
        img8 = findViewById(R.id.img8);
        img9 = findViewById(R.id.img9);
        img10 = findViewById(R.id.img10);
        img11 = findViewById(R.id.img11);
        img12 = findViewById(R.id.img12);
        img13 = findViewById(R.id.img13);
        img14 = findViewById(R.id.img14);
        img15 = findViewById(R.id.img15);

        /* sequence of 3 combinations
        winCombinations.add(new int[]{0, 1, 2});
        winCombinations.add(new int[]{1, 2, 3});
        winCombinations.add(new int[]{4, 5, 6});
        winCombinations.add(new int[]{5, 6, 7});
        winCombinations.add(new int[]{8, 9, 10});
        winCombinations.add(new int[]{9, 10, 11});
        winCombinations.add(new int[]{12, 13, 14});
        winCombinations.add(new int[]{13, 14, 15});
        //^row win

        winCombinations.add(new int[]{0, 5, 10});
        winCombinations.add(new int[]{5, 10, 15});
        winCombinations.add(new int[]{4, 9, 14});
        winCombinations.add(new int[]{3, 6, 9});
        winCombinations.add(new int[]{6, 9, 12});
        winCombinations.add(new int[]{7, 10, 13});
        winCombinations.add(new int[]{1, 6, 11});
        winCombinations.add(new int[]{2, 5, 8});
        //^cross win

        winCombinations.add(new int[]{0, 4, 8});
        winCombinations.add(new int[]{4, 8, 12});
        winCombinations.add(new int[]{1, 5, 9});
        winCombinations.add(new int[]{5, 9, 13});
        winCombinations.add(new int[]{2, 6, 10});
        winCombinations.add(new int[]{6, 10, 14});
        winCombinations.add(new int[]{3, 7, 11});
        winCombinations.add(new int[]{7, 11, 15});
        //^column win
        */

        winCombinations.add(new int[]{0,1,2,3});
        winCombinations.add(new int[]{4,5,6,7});
        winCombinations.add(new int[]{8,9,10,11});
        winCombinations.add(new int[]{12,13,14,15});
        winCombinations.add(new int[]{0,5,10,15});
        winCombinations.add(new int[]{3,6,9,12});
        winCombinations.add(new int[]{0,4,8,12});
        winCombinations.add(new int[]{1,5,9,13});
        winCombinations.add(new int[]{2, 6, 10, 14});
        winCombinations.add(new int[]{3,7,11,15});

        final String getPlayerOneName = getIntent().getStringExtra("playerOne");
        final String getPlayerTwoName = getIntent().getStringExtra("playerTwo");
        diff = getIntent().getIntExtra("difficulty", 1);
        if (diff == 1){
            strDiff = "REGULAR";
        } else if (diff == 2) {
            strDiff = "MEDIUM";
        } else {
            strDiff = "HARD";
        }
        playerOneName.setText(getPlayerOneName);
        playerTwoName.setText(getPlayerTwoName);

        if (diff == 1){
            playerTurn = rand.nextInt(2) + 1;
            if (playerTurn == 1){
                playerOneLayout.setBackgroundResource(R.drawable.round_back_black_border);
            } else {
                playerTwoLayout.setBackgroundResource(R.drawable.round_back_black_border);
            }
            img0.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (isBoxSelectable(0)){
                        performGameDiff1and2(img0, 0);
                    }
                }
            });
            img1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (isBoxSelectable(1)){
                        performGameDiff1and2(img1, 1);
                    }
                }
            });
            img2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (isBoxSelectable(2)){
                        performGameDiff1and2(img2, 2);
                    }
                }
            });
            img3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (isBoxSelectable(3)){
                        performGameDiff1and2(img3, 3);
                    }
                }
            });
            img4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (isBoxSelectable(4)){
                        performGameDiff1and2(img4, 4);
                    }
                }
            });
            img5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (isBoxSelectable(5)){
                        performGameDiff1and2(img5, 5);
                    }
                }
            });
            img6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (isBoxSelectable(6)){
                        performGameDiff1and2(img6, 6);
                    }
                }
            });
            img7.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (isBoxSelectable(7)){
                        performGameDiff1and2(img7, 7);
                    }
                }
            });
            img8.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (isBoxSelectable(8)){
                        performGameDiff1and2(img8, 8);
                    }
                }
            });
            img9.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (isBoxSelectable(9)){
                        performGameDiff1and2(img9, 9);
                    }
                }
            });
            img10.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (isBoxSelectable(10)){
                        performGameDiff1and2(img10, 10);
                    }
                }
            });
            img11.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (isBoxSelectable(11)){
                        performGameDiff1and2(img11, 11);
                    }
                }
            });
            img12.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (isBoxSelectable(12)){
                        performGameDiff1and2(img12, 12);
                    }
                }
            });
            img13.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (isBoxSelectable(13)){
                        performGameDiff1and2(img13, 13);
                    }
                }
            });
            img14.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (isBoxSelectable(14)){
                        performGameDiff1and2(img14, 14);
                    }
                }
            });
            img15.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (isBoxSelectable(15)){
                        performGameDiff1and2(img15, 15);
                    }
                }
            });
        } else if (diff == 2) {
            initDiff2();
            img0.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (isBoxSelectable(0)){
                        performGameDiff1and2(img0, 0);
                    }
                }
            });
            img1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (isBoxSelectable(1)){
                        performGameDiff1and2(img1, 1);
                    }
                }
            });
            img2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (isBoxSelectable(2)){
                        performGameDiff1and2(img2, 2);
                    }
                }
            });
            img3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (isBoxSelectable(3)){
                        performGameDiff1and2(img3, 3);
                    }
                }
            });
            img4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (isBoxSelectable(4)){
                        performGameDiff1and2(img4, 4);
                    }
                }
            });
            img5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (isBoxSelectable(5)){
                        performGameDiff1and2(img5, 5);
                    }
                }
            });
            img6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (isBoxSelectable(6)){
                        performGameDiff1and2(img6, 6);
                    }
                }
            });
            img7.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (isBoxSelectable(7)){
                        performGameDiff1and2(img7, 7);
                    }
                }
            });
            img8.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (isBoxSelectable(8)){
                        performGameDiff1and2(img8, 8);
                    }
                }
            });
            img9.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (isBoxSelectable(9)){
                        performGameDiff1and2(img9, 9);
                    }
                }
            });
            img10.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (isBoxSelectable(10)){
                        performGameDiff1and2(img10, 10);
                    }
                }
            });
            img11.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (isBoxSelectable(11)){
                        performGameDiff1and2(img11, 11);
                    }
                }
            });
            img12.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (isBoxSelectable(12)){
                        performGameDiff1and2(img12, 12);
                    }
                }
            });
            img13.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (isBoxSelectable(13)){
                        performGameDiff1and2(img13, 13);
                    }
                }
            });
            img14.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (isBoxSelectable(14)){
                        performGameDiff1and2(img14, 14);
                    }
                }
            });
            img15.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (isBoxSelectable(15)){
                        performGameDiff1and2(img15, 15);
                    }
                }
            });
        } else if (diff == 3) {
            ImageView p2Img = findViewById(R.id.playerTwoImg);
            p2Img.setImageResource(R.drawable.blue_x);
            playerTurn = rand.nextInt(2) + 1;
            if (playerTurn == 1){
                playerOneLayout.setBackgroundResource(R.drawable.round_back_black_border);
            } else {
                playerTwoLayout.setBackgroundResource(R.drawable.round_back_black_border);
            }
            img0.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (isBoxSelectable(0)){
                        performGameDiff3(img0, 0);
                    }
                }
            });
            img1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (isBoxSelectable(1)){
                        performGameDiff3(img1, 1);
                    }
                }
            });
            img2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (isBoxSelectable(2)){
                        performGameDiff3(img2, 2);
                    }
                }
            });
            img3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (isBoxSelectable(3)){
                        performGameDiff3(img3, 3);
                    }
                }
            });
            img4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (isBoxSelectable(4)){
                        performGameDiff3(img4, 4);
                    }
                }
            });
            img5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (isBoxSelectable(5)){
                        performGameDiff3(img5, 5);
                    }
                }
            });
            img6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (isBoxSelectable(6)){
                        performGameDiff3(img6, 6);
                    }
                }
            });
            img7.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (isBoxSelectable(7)){
                        performGameDiff3(img7, 7);
                    }
                }
            });
            img8.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (isBoxSelectable(8)){
                        performGameDiff3(img8, 8);
                    }
                }
            });
            img9.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (isBoxSelectable(9)){
                        performGameDiff3(img9, 9);
                    }
                }
            });
            img10.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (isBoxSelectable(10)){
                        performGameDiff3(img10, 10);
                    }
                }
            });
            img11.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (isBoxSelectable(11)){
                        performGameDiff3(img11, 11);
                    }
                }
            });
            img12.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (isBoxSelectable(12)){
                        performGameDiff3(img12, 12);
                    }
                }
            });
            img13.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (isBoxSelectable(13)){
                        performGameDiff3(img13, 13);
                    }
                }
            });
            img14.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (isBoxSelectable(14)){
                        performGameDiff3(img14, 14);
                    }
                }
            });
            img15.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (isBoxSelectable(15)){
                        performGameDiff3(img15, 15);
                    }
                }
            });
        }
    }


    private void performGameDiff3(ImageView imgView, int selectedBoxPos){
        boxPositions[selectedBoxPos] = 1;

        if (playerTurn == 1){
                imgView.setImageResource(R.drawable.ximage);

                if (checkPlayerWin3()) {
                    new Thread(){
                        @Override
                        public void run() {
                            super.run();
                            RecentGame recentGame = new RecentGame(playerOneName.getText().toString(), playerTwoName.getText().toString(), "android.resource://" + getPackageName() + "/drawable/blue_x","4*4 " + strDiff,
                                    "Winner: " + playerOneName.getText().toString());
                            RecentGamesDB.getInstance(FourByFourActivity.this).recentGameDao().addGame(recentGame);
                        }
                    }.start();
                    WinDialog winDialog = new WinDialog(FourByFourActivity.this, playerOneName.getText().toString() + " Has won the game!", FourByFourActivity.this, 1, diff);
                    winDialog.setCancelable(false);
                    winDialog.show();
                } else {
                    changePlayerTurn(2);

                    totalSelectedBoxes++;
                }
        }
        else {
            imgView.setImageResource(R.drawable.blue_x);

            if (checkPlayerWin3()) {
                new Thread(){
                    @Override
                    public void run() {
                        super.run();
                        RecentGame recentGame = new RecentGame(playerOneName.getText().toString(), playerTwoName.getText().toString(), "android.resource://" + getPackageName() + "/drawable/blue_x","4*4 " + strDiff,
                                "Winner: " + playerTwoName.getText().toString());
                        RecentGamesDB.getInstance(FourByFourActivity.this).recentGameDao().addGame(recentGame);
                    }
                }.start();
                WinDialog winDialog = new WinDialog(FourByFourActivity.this, playerTwoName.getText().toString() + " Has won the game!", FourByFourActivity.this, 2, diff);
                winDialog.setCancelable(false);
                winDialog.show();
            }else {
                changePlayerTurn(1);

                totalSelectedBoxes++;
            }
        }
    }


    private void performGameDiff1and2(ImageView imgView, int selectedBoxPos){
        boxPositions[selectedBoxPos] = playerTurn;

        if (playerTurn == 1){
            imgView.setImageResource(R.drawable.ximage);

            if (checkPlayerWin()){
                new Thread(){
                    @Override
                    public void run() {
                        super.run();
                        RecentGame recentGame = new RecentGame(playerOneName.getText().toString(), playerTwoName.getText().toString(), "android.resource://" + getPackageName() + "/drawable/blue_circle","4*4 " + strDiff,
                                "Winner: " + playerOneName.getText().toString());
                        RecentGamesDB.getInstance(FourByFourActivity.this).recentGameDao().addGame(recentGame);
                    }
                }.start();
                WinDialog winDialog = new WinDialog(FourByFourActivity.this, playerOneName.getText().toString() + " Has won the game!", FourByFourActivity.this, 1, diff);
                winDialog.setCancelable(false);
                winDialog.show();
            }
            else if (totalSelectedBoxes == 16){
                new Thread(){
                    @Override
                    public void run() {
                        super.run();
                        RecentGame recentGame = new RecentGame(playerOneName.getText().toString(), playerTwoName.getText().toString(), "android.resource://" + getPackageName() + "/drawable/blue_circle","4*4 " + strDiff,
                                "DRAW");
                        RecentGamesDB.getInstance(FourByFourActivity.this).recentGameDao().addGame(recentGame);
                    }
                }.start();
                WinDialog winDialog = new WinDialog(FourByFourActivity.this, "it`s a draw!", FourByFourActivity.this, 3, diff);
                winDialog.setCancelable(false);
                winDialog.show();
            }
            else {
                changePlayerTurn(2);

                totalSelectedBoxes++;
            }
        }
        else {
            imgView.setImageResource(R.drawable.blue_circle);

            if (checkPlayerWin()){
                new Thread(){
                    @Override
                    public void run() {
                        super.run();
                        RecentGame recentGame = new RecentGame(playerOneName.getText().toString(), playerTwoName.getText().toString(), "android.resource://" + getPackageName() + "/drawable/blue_circle","4*4 " + strDiff,
                                "Winner: " + playerTwoName.getText().toString());
                        RecentGamesDB.getInstance(FourByFourActivity.this).recentGameDao().addGame(recentGame);
                    }
                }.start();
                WinDialog winDialog = new WinDialog(FourByFourActivity.this, playerTwoName.getText().toString() + " Has won the game!", FourByFourActivity.this, 2, diff);
                winDialog.setCancelable(false);
                winDialog.show();
            }
            else if (totalSelectedBoxes == 16){
                new Thread(){
                    @Override
                    public void run() {
                        super.run();
                        RecentGame recentGame = new RecentGame(playerOneName.getText().toString(), playerTwoName.getText().toString(), "android.resource://" + getPackageName() + "/drawable/blue_circle","4*4 " + strDiff,
                                "DRAW");
                        RecentGamesDB.getInstance(FourByFourActivity.this).recentGameDao().addGame(recentGame);
                    }
                }.start();
                WinDialog winDialog = new WinDialog(FourByFourActivity.this, "it`s a draw!", FourByFourActivity.this, 3, diff);
                winDialog.setCancelable(false);
                winDialog.show();
            }
            else {
                changePlayerTurn(1);

                totalSelectedBoxes++;
            }
        }
    }
    private boolean isBoxSelectable(int boxPos){
        return boxPositions[boxPos] == 0;
    }

    private boolean checkPlayerWin(){
        for (int i=0; i<winCombinations.size(); i++){
            final int[] combination = winCombinations.get(i);
            if (boxPositions[combination[0]] == playerTurn && boxPositions[combination[1]] == playerTurn && boxPositions[combination[2]] == playerTurn && boxPositions[combination[3]] == playerTurn)
                return true;
        }
        return false;
    }
    private boolean checkPlayerWin3(){
        for (int i=0; i<winCombinations.size(); i++){
            final int[] combination = winCombinations.get(i);
            if (boxPositions[combination[0]] == 1 && boxPositions[combination[1]] == 1 && boxPositions[combination[2]] == 1 && boxPositions[combination[3]] == 1)
                return true;
        }
        return false;
    }

    private void changePlayerTurn(int currentPlayerTurn){
        playerTurn = currentPlayerTurn;

        if (playerTurn == 1){
            playerTwoLayout.setBackgroundResource(R.drawable.round_back_black);
            playerOneLayout.setBackgroundResource(R.drawable.round_back_black_border);
        }
        else {
            playerOneLayout.setBackgroundResource(R.drawable.round_back_black);
            playerTwoLayout.setBackgroundResource(R.drawable.round_back_black_border);
        }
    }

    public void restartMatch(int diff){
        boxPositions = new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};

        playerTurn = rand.nextInt(2)+1;
        totalSelectedBoxes = 1;

        img0.setImageResource(R.drawable.transparent_back);
        img1.setImageResource(R.drawable.transparent_back);
        img2.setImageResource(R.drawable.transparent_back);
        img3.setImageResource(R.drawable.transparent_back);
        img4.setImageResource(R.drawable.transparent_back);
        img5.setImageResource(R.drawable.transparent_back);
        img6.setImageResource(R.drawable.transparent_back);
        img7.setImageResource(R.drawable.transparent_back);
        img8.setImageResource(R.drawable.transparent_back);
        img9.setImageResource(R.drawable.transparent_back);
        img10.setImageResource(R.drawable.transparent_back);
        img11.setImageResource(R.drawable.transparent_back);
        img12.setImageResource(R.drawable.transparent_back);
        img13.setImageResource(R.drawable.transparent_back);
        img14.setImageResource(R.drawable.transparent_back);
        img15.setImageResource(R.drawable.transparent_back);

        playerOneLayout.setBackgroundResource(R.drawable.round_back_black);
        playerTwoLayout.setBackgroundResource(R.drawable.round_back_black);

        if(diff == 2){
            initDiff2();
        }

        if (playerTurn == 1){
            playerOneLayout.setBackgroundResource(R.drawable.round_back_black_border);
        } else {
            playerTwoLayout.setBackgroundResource(R.drawable.round_back_black_border);
        }
    }

    private void initDiff2(){
        playerTurn = rand.nextInt(2) + 1;
        if (playerTurn == 1){
            playerOneLayout.setBackgroundResource(R.drawable.round_back_black_border);
        } else {
            playerTwoLayout.setBackgroundResource(R.drawable.round_back_black_border);
        }
        final ImageView[] images = {img0,img1,img2,img3,img4,img5,img6,img7,img8,img9,img10,img11,img12,img13,img14,img15};
        Set<Integer> uniqueNumbers = new HashSet<>();

        while (uniqueNumbers.size() < 4) {
            int num = rand.nextInt(16);
            uniqueNumbers.add(num);
        }

        Integer[] uniqueArray = uniqueNumbers.toArray(new Integer[0]);
        int firstNumber = uniqueArray[0];
        int secondNumber = uniqueArray[1];
        int thirdNumber = uniqueArray[2];
        int fourthNumber = uniqueArray[3];

        boxPositions[firstNumber] = 1;
        boxPositions[secondNumber] = 1;
        boxPositions[thirdNumber] = 2;
        boxPositions[fourthNumber] = 2;
        totalSelectedBoxes = 5;

        images[firstNumber].setImageResource(R.drawable.ximage);
        images[secondNumber].setImageResource(R.drawable.ximage);
        images[thirdNumber].setImageResource(R.drawable.blue_circle);
        images[fourthNumber].setImageResource(R.drawable.blue_circle);

    }
}