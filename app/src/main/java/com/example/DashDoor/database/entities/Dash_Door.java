package com.example.DashDoor.database.entities;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.example.DashDoor.database.DashDoorDatabase;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity(tableName = DashDoorDatabase.DASH_DOOR_TABLE)
public class Dash_Door {

    @PrimaryKey(autoGenerate = true)
    private String location;
    private String food;


    public Dash_Door(String location, String food) {
        this.location = location;
        this.food = food;
    }

    @NonNull
    @Override
    public String toString() {
        return  location + '\n' +
                "food: " + food + '\n' +
                "*********************************" + '\n';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Dash_Door dashDoor = (Dash_Door) o;
        return Objects.equals(location, dashDoor.location) && Objects.equals(food, dashDoor.food);
    }

    @Override
    public int hashCode() {
        return Objects.hash(location, food);
    }


    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }
}
