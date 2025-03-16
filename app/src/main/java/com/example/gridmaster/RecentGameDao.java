package com.example.gridmaster;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface RecentGameDao {
    @Query("SELECT * FROM RecentGame")
    public List<RecentGame> getGames();

    @Query("Select * FROM RecentGame WHERE id = :id")
    public RecentGame getGame(int id);

    @Insert (onConflict = OnConflictStrategy.REPLACE)
    public void addGame(RecentGame recentGame);

    @Delete
    public void deleteGame(RecentGame recentGame);

}
