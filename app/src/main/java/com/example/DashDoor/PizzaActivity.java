package com.example.DashDoor;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;


import com.example.DashDoor.databinding.PizzaPlaceBinding;
public class PizzaActivity extends AppCompatActivity{

    private PizzaPlaceBinding pizzaBinding;

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pizzaBinding = PizzaPlaceBinding.inflate(getLayoutInflater());
        setContentView(pizzaBinding.getRoot());

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Pizza Place");
        }
    }


    static Intent pizzaIntentFactory(Context context){
        return new Intent(context, PizzaActivity.class);
    }
}
