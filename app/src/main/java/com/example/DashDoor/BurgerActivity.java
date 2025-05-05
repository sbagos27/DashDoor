package com.example.DashDoor;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.DashDoor.databinding.BurgerPlaceBinding;


public class BurgerActivity extends AppCompatActivity {

    private BurgerPlaceBinding burgerBinding;


    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        burgerBinding = BurgerPlaceBinding.inflate(getLayoutInflater());
        setContentView(burgerBinding.getRoot());

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Burger Place");
        }
    }

    static Intent burgerIntentFactory(Context context){
        return new Intent(context, BurgerActivity.class);
    }
}
