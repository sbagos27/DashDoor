package com.example.DashDoor;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.DashDoor.databinding.PizzaPlaceBinding;

public class PizzaActivity extends AppCompatActivity{

    private PizzaPlaceBinding pizzaPlaceBinding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        pizzaPlaceBinding = PizzaPlaceBinding.inflate(getLayoutInflater());
        setContentView(pizzaPlaceBinding.getRoot());

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Pizza Place");
        }

        pizzaPlaceBinding.pepperButton.setOnClickListener(v -> {
            Cart.getInstance().addItem("Pepperoni Pizza", 15.0, 1);
            showToast("Added pepperoni pizza to Cart");
        });

        pizzaPlaceBinding.cheeseButton.setOnClickListener(v -> {
            Cart.getInstance().addItem("Cheese Pizza", 12.0, 1);
            showToast("Added cheese pizza to Cart");
        });

        pizzaPlaceBinding.meatloverButton.setOnClickListener(v -> {
            Cart.getInstance().addItem("Meatlovers Pizza", 50.0, 1);
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
