package com.example.DashDoor;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.DashDoor.databinding.BurgerPlaceBinding;

public class BurgerActivity extends AppCompatActivity {

    private BurgerPlaceBinding burgerPlaceBinding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        burgerPlaceBinding = BurgerPlaceBinding.inflate(getLayoutInflater());
        setContentView(burgerPlaceBinding.getRoot());

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Burger Place");
        }

        burgerPlaceBinding.button3.setOnClickListener(v -> {
            Cart.getInstance().addItem("Omega Burger", 13.0, 1);
            showToast("Added Omega Burger to Cart");
        });

        burgerPlaceBinding.button4.setOnClickListener(v -> {
            Cart.getInstance().addItem("Fry Fries", 5.0, 1);
            showToast("Added Fry Fries to Cart");
        });

        burgerPlaceBinding.button5.setOnClickListener(v -> {
            Cart.getInstance().addItem("Chez Burger", 8.0, 1);
            showToast("Added Chez Burger to Cart");
        });
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    static Intent burgerIntentFactory(Context context){
        return new Intent(context, BurgerActivity.class);
    }
}
