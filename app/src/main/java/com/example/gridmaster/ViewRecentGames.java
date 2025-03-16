package com.example.gridmaster;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;

import java.util.Collections;
import java.util.List;

public class ViewRecentGames extends AppCompatActivity {
    private List<RecentGame> recentGames;
    private RecentGameAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_recent_games);

        RecyclerView recyclerView = findViewById(R.id.recycler);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                recentGames = RecentGamesDB.getInstance(ViewRecentGames.this).recentGameDao().getGames();
            }
        });

        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        List<RecentGame> shallowCopy = recentGames.subList(0, recentGames.size());
        Collections.reverse(shallowCopy);
        adapter = new RecentGameAdapter(shallowCopy);

        recyclerView.setAdapter(adapter);
        ItemTouchHelper helper = new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                AlertDialog.Builder builder = new AlertDialog.Builder(ViewRecentGames.this);
                RecentGame recentGame = adapter.getGameAtPosition(viewHolder.getAdapterPosition());
                builder.setTitle("Delete").setMessage("Are you sure?").setPositiveButton("YEAH", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        new Thread() {
                            @Override
                            public void run() {
                                super.run();

                                RecentGamesDB.getInstance(ViewRecentGames.this).recentGameDao().deleteGame(recentGame);

                            }
                        }.start();
                        adapter.deleteGame(viewHolder.getAdapterPosition());
                    }
                }).setNegativeButton("no", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        recyclerView.setAdapter(adapter);
                    }
                }).show();

            }
        });

        helper.attachToRecyclerView(recyclerView);
    }
}