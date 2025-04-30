package com.example.DashDoor.database.entities;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.example.DashDoor.database.DashDoorDatabase;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity(tableName = DashDoorDatabase.DASH_DOOR_TABLE)
public class DashDoor {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String location;
    private String foodType;
    private double cost;
    private LocalDateTime date;
    private int userId;

    // Empty constructor required by Room
    public DashDoor() {}

    // Constructor matching all fields (except id, which is auto-generated)
    public DashDoor(String location, String foodType, double cost, LocalDateTime date, int userId) {
        this.location = location;
        this.foodType = foodType;
        this.cost = cost;
        this.date = date;
        this.userId = userId;
    }

    public DashDoor(String mLocation, double mFoodType, int mCost, int loggedInUserId) {
    }

    @NonNull
    @Override
    public String toString() {
        return  location + '\n' +
                "foodType: " + foodType + '\n' +
                "cost: " + cost + '\n' +
                "date: " + date.toString() + '\n' +
                "=-=-=-=-=-=-=-=-=-=" + '\n';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        DashDoor log = (DashDoor) o;
        return id == log.id &&
                Objects.equals(foodType, log.foodType) &&
                cost == log.cost &&
                userId == log.userId &&
                Objects.equals(location, log.location) &&
                Objects.equals(date, log.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, location, foodType, cost, date, userId);
    }

    // Getters and setters

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public String getFoodType() { return foodType; }
    public void setFoodType(String foodType) { this.foodType = foodType; }

    public double getCost() { return cost; }
    public void setCost(double cost) { this.cost = cost; }

    public LocalDateTime getDate() { return date; }
    public void setDate(LocalDateTime date) { this.date = date; }

    public int getUserId() { return userId; }
    public void setUserId(int userId) { this.userId = userId; }
}
