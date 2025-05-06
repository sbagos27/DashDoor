package com.example.DashDoor;

import android.content.Context;
import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;

public class BurgerActivity extends AppCompatActivity {

    static Intent burgerIntentFactory(Context context){
        return new Intent(context, BurgerActivity.class);
    }
}
