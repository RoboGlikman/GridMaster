package com.example.gridmaster;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;

public class WinDialog extends Dialog {
    private ThreeByThreeActivity threeByThreeActivity;
    private FourByFourActivity fourByFourActivity;
    private FiveByFiveActivity fiveByFiveActivity;
    private int usedMode;
    private Context context;
    private final String msg;
    private int won;
    private int diff;
    public WinDialog(@NonNull Context context, String msg, ThreeByThreeActivity threeByThreeActivity, int won, int diff) {
        super(context);
        this.context = context;
        this.msg = msg;
        this.threeByThreeActivity = threeByThreeActivity;
        this.usedMode = 1;
        this.won = won;
        this.diff = diff;
    }

    public WinDialog(@NonNull Context context, String msg, FourByFourActivity fourByFourActivity, int won, int diff) {
        super(context);
        this.context = context;
        this.msg = msg;
        this.fourByFourActivity = fourByFourActivity;
        this.usedMode = 2;
        this.won = won;
        this.diff = diff;
    }

    public WinDialog(@NonNull Context context, String msg, FiveByFiveActivity fiveByFiveActivity, int won, int diff) {
        super(context);
        this.context = context;
        this.msg = msg;
        this.fiveByFiveActivity = fiveByFiveActivity;
        this.usedMode = 3;
        this.won = won;
        this.diff = diff;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (this.won == 1){
            setContentView(R.layout.x_won_dialog_layout);
        }
        else if (this.won == 2) {
            setContentView(R.layout.circle_won_dialog_layout);
        } else {
            setContentView(R.layout.win_dialog_layout);
        }

        final TextView msgText = findViewById(R.id.winMessageTv);
        final Button startAgainBtn = findViewById(R.id.playAgainBtn);
        final Button backHomeBtn = findViewById(R.id.backBtn);

        msgText.setText(WinDialog.this.msg);

        startAgainBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (WinDialog.this.usedMode){
                    case 1:
                        WinDialog.this.threeByThreeActivity.restartMatch(diff);
                        break;
                    case 2:
                        WinDialog.this.fourByFourActivity.restartMatch(diff);
                        break;
                    case 3:
                        WinDialog.this.fiveByFiveActivity.restartMatch(diff);
                        break;
                }
                dismiss();
            }
        });

        backHomeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, MainActivity.class);
                context.startActivity(intent);
                dismiss();
            }
        });
    }
}
