package com.example.DashDoor;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.DashDoor.databinding.OrderPageBinding;

public class OrderPageActivity extends AppCompatActivity {

    private OrderPageBinding orderPageBinding;
    private String selectedFoodType = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        orderPageBinding = OrderPageBinding.inflate(getLayoutInflater());
        setContentView(orderPageBinding.getRoot());

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Order Page");
        }

        orderPageBinding.buttonBurger.setOnClickListener(v -> {
            Intent intent = BurgerActivity.burgerIntentFactory(this);
            startActivity(intent);
        });

        orderPageBinding.buttonPizza.setOnClickListener(v -> {
            Intent intent = PizzaActivity.pizzaIntentFactory(this);
            startActivity(intent);
        });

        orderPageBinding.placeOrderButton.setOnClickListener(v -> {
//            if (selectedFoodType == null) {
//                showToast("Please select a food type before proceeding.");
//                return;
//            }
            goToCheckoutWithChoice(selectedFoodType);
        });
    }

    private void goToCheckoutWithChoice(String foodType) {
        Intent intent = new Intent(this, CheckoutActivity.class);
        intent.putExtra("foodType", foodType);
        intent.putExtra("quantity", 1); // Default quantity, or add quantity selection in checkout
        startActivity(intent);
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    static Intent orderPageIntentFactory(Context context){
        return new Intent(context, OrderPageActivity.class);
    }
}
