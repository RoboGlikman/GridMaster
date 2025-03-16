package com.example.gridmaster;

import android.content.Context;
import android.util.Log;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {RecentGame.class}, version = 1, exportSchema = false)
abstract public class RecentGamesDB extends RoomDatabase {
    private static final String LOG_TAG = RecentGamesDB.class.getSimpleName();
    private static final Object LOCK = new Object();
    private static final String DATABASE_NAME = "gamesList";
    private static RecentGamesDB sInstance;

    public static RecentGamesDB getInstance(Context context){
        if (sInstance == null) {
            synchronized (LOCK) {
                Log.d(LOG_TAG, "Creating new database instance");
                sInstance = Room.databaseBuilder(context.getApplicationContext(),
                        RecentGamesDB.class, RecentGamesDB.DATABASE_NAME).build();
            }
        }
        Log.d(LOG_TAG, "Getting the database instance");
        return sInstance;
    }
    public abstract RecentGameDao recentGameDao();
}
