package com.example.gridmaster;

import static androidx.core.content.ContextCompat.startActivity;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class ChooseDiffDialog extends Dialog {
    private int mode;
    private Context context;


    public ChooseDiffDialog(@NonNull Context context, int mode) {
        super(context);
        this.mode = mode;
        this.context = context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chooes_diff_dialog_layout);

        TextView msgTxt = findViewById(R.id.dialogMsgTv);
        Button easyMode = findViewById(R.id.easyBtn);
        Button mediumMode = findViewById(R.id.mediumBtn);
        Button hardMode = findViewById(R.id.hardBtn);


        easyMode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startAddPlayersActivity(ChooseDiffDialog.this.mode, 1);
            }
        });

        mediumMode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startAddPlayersActivity(ChooseDiffDialog.this.mode, 2);
            }
        });

        hardMode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startAddPlayersActivity(ChooseDiffDialog.this.mode, 3);
            }
        });

    }
    private void startAddPlayersActivity(int mode, int diff) {
        Intent intent = new Intent(context, AddPlayers.class);
        intent.putExtra("difficulty", diff); // Pass the difficulty as an extra
        intent.putExtra("gamemode", mode);
        context.startActivity(intent);
        dismiss();
    }

}
