package com.example.DashDoor;

import android.content.Context;
import android.content.Intent;

public class BurgerActivity {

    static Intent burgerIntentFactory(Context context){
        return new Intent(context, BurgerActivity.class);
    }
}
