package com.example.DashDoor.database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.DashDoor.database.entities.DashDoor;


import java.util.List;


@Dao
public interface DashDoorDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(DashDoor dashDoor);

    @Query("SELECT * FROM " + DashDoorDatabase.DASH_DOOR_TABLE + " ORDER BY date DESC")
    List<DashDoor> getAllRecords();
}
