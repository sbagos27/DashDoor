package com.example.DashDoor;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.DashDoor.databinding.PizzaPlaceBinding;

public class PizzaActivity extends AppCompatActivity{

    private PizzaPlaceBinding pizzaPlaceBinding;

    public void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        pizzaPlaceBinding = PizzaPlaceBinding.inflate(getLayoutInflater());
        setContentView(pizzaPlaceBinding.getRoot());

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Pizza Place");
        }

        pizzaPlaceBinding.pepperButton.setOnClickListener(v -> {
            showToast("Added pepperoni pizza to Cart");
        });

        pizzaPlaceBinding.cheeseButton.setOnClickListener(v -> {
            showToast("Added cheese pizza to Cart");

        });

        pizzaPlaceBinding.meatloverButton.setOnClickListener(v -> {
            showToast("Added meatlovers pizza to Cart");

        });

    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    static Intent pizzaIntentFactory(Context context){
        return new Intent(context, PizzaActivity.class);
    }
}
