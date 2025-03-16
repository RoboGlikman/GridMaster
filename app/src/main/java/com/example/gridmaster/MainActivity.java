package com.example.gridmaster;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button threeByThreeBtn,fourByFourBtn, fiveByFiveBtn,btnShowRecent;
    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView welcomeTv = findViewById(R.id.welcomeTv);
        Animation animationBounce;
        animationBounce = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.bounce);
        welcomeTv.startAnimation(animationBounce);

        Animation scaleUp, scaleDown;
        threeByThreeBtn = findViewById(R.id.three_by_three_btn);
        fourByFourBtn = findViewById(R.id.four_by_four_btn);
        fiveByFiveBtn = findViewById(R.id.five_by_five_btn);
        btnShowRecent = findViewById(R.id.viewRecentBtn);

        scaleUp = AnimationUtils.loadAnimation(this, R.anim.scale_up);
        scaleDown = AnimationUtils.loadAnimation(this, R.anim.scale_down);

        threeByThreeBtn.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN){
                    threeByThreeBtn.startAnimation(scaleUp);
                }else if (event.getAction() == MotionEvent.ACTION_UP){
                    threeByThreeBtn.startAnimation(scaleDown);
                }
                return false;
            }
        });

        fourByFourBtn.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN){
                    fourByFourBtn.startAnimation(scaleUp);
                }else if (event.getAction() == MotionEvent.ACTION_UP){
                    fourByFourBtn.startAnimation(scaleDown);
                }
                return false;
            }
        });

        fiveByFiveBtn.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN){
                    fiveByFiveBtn.startAnimation(scaleUp);
                }else if (event.getAction() == MotionEvent.ACTION_UP){
                   fiveByFiveBtn.startAnimation(scaleDown);
                }
                return false;
            }
        });

        btnShowRecent.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN){
                    btnShowRecent.startAnimation(scaleUp);
                }else if (event.getAction() == MotionEvent.ACTION_UP){
                   btnShowRecent.startAnimation(scaleDown);
                }
                return false;
            }
        });


        btnShowRecent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ViewRecentGames.class);
                startActivity(intent);
            }
        });

        /*  other option, using a popup menu. implemented because of the requirements, not used because the dialog looks way better.
        threeByThreeBtn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               PopupMenu popupMenu = new PopupMenu(MainActivity.this, threeByThreeBtn);
               popupMenu.getMenuInflater().inflate(R.menu.menu_3by3, popupMenu.getMenu());
               popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                   @Override
                   public boolean onMenuItemClick(MenuItem item) {
                       int itemId = item.getItemId();
                       if (itemId == R.id.three_by_three_diff1) { //cannot use switch here.
                           Intent intent = new Intent(MainActivity.this, AddPlayers.class);
                           intent.putExtra("gamemode", 1);
                           intent.putExtra("difficulty", 1);
                           startActivity(intent);
                       } else if (itemId == R.id.three_by_three_diff2) {
                           Intent intent = new Intent(MainActivity.this, AddPlayers.class);
                           intent.putExtra("gamemode", 1);
                           intent.putExtra("difficulty", 2);
                           startActivity(intent);
                       } else if (itemId == R.id.three_by_three_diff3) {
                           Intent intent = new Intent(MainActivity.this, AddPlayers.class);
                           intent.putExtra("gamemode", 1);
                           intent.putExtra("difficulty", 3);
                           startActivity(intent);
                       }
                       return false;
                   }
               });
               popupMenu.show();
           }
       });



        fourByFourBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popupMenu = new PopupMenu(MainActivity.this, fourByFourBtn);
                popupMenu.getMenuInflater().inflate(R.menu.menu_4by4, popupMenu.getMenu());
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        int itemId = item.getItemId();
                        if (itemId == R.id.three_by_three_diff1){
                            Toast.makeText(MainActivity.this, "clicked on regular", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(MainActivity.this, AddPlayers.class);
                            intent.putExtra("gamemode", 2);
                            intent.putExtra("difficulty", 1);
                            startActivity(intent);
                        } else if (itemId == R.id.four_by_four_diff2){
                            Toast.makeText(MainActivity.this, "clicked on random start", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(MainActivity.this, AddPlayers.class);
                            intent.putExtra("gamemode", 2);
                            intent.putExtra("difficulty", 2);
                            startActivity(intent);
                        } else if (itemId == R.id.four_by_four_diff3) {
                            Toast.makeText(MainActivity.this, "clicked on random start+limited", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(MainActivity.this, AddPlayers.class);
                            intent.putExtra("gamemode", 2);
                            intent.putExtra("difficulty", 3);
                            startActivity(intent);
                        }
                        return false;
                    }
                });
                popupMenu.show();
            }
        });

        fiveByFiveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popupMenu = new PopupMenu(MainActivity.this, fiveByFiveBtn);
                popupMenu.getMenuInflater().inflate(R.menu.menu_5by5, popupMenu.getMenu());
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        int itemId = item.getItemId();
                        if (itemId == R.id.five_by_five_diff1){
                            Toast.makeText(MainActivity.this, "clicked on regular", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(MainActivity.this, AddPlayers.class);
                            intent.putExtra("gamemode", 3);
                            intent.putExtra("difficulty", 1);
                            startActivity(intent);
                        } else if (itemId == R.id.five_by_five_diff2){
                            Toast.makeText(MainActivity.this, "clicked on random start", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(MainActivity.this, AddPlayers.class);
                            intent.putExtra("gamemode", 3);
                            intent.putExtra("difficulty", 2);
                            startActivity(intent);
                        } else if (itemId == R.id.five_by_five_diff3) {
                            Toast.makeText(MainActivity.this, "clicked on random start+limited", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(MainActivity.this, AddPlayers.class);
                            intent.putExtra("gamemode", 3);
                            intent.putExtra("difficulty", 3);
                            startActivity(intent);
                        }
                        return false;
                    }
                });
                popupMenu.show();
            }
        });
        */



        threeByThreeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ChooseDiffDialog chooseDiffDialog = new ChooseDiffDialog(MainActivity.this,  1);
                chooseDiffDialog.setCancelable(true);
                chooseDiffDialog.show();
            }
        });

        fourByFourBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ChooseDiffDialog chooseDiffDialog = new ChooseDiffDialog(MainActivity.this,  2);
                chooseDiffDialog.setCancelable(true);
                chooseDiffDialog.show();
            }
        });

        fiveByFiveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ChooseDiffDialog chooseDiffDialog = new ChooseDiffDialog(MainActivity.this,  3);
                chooseDiffDialog.setCancelable(true);
                chooseDiffDialog.show();
            }
        });

    }
}