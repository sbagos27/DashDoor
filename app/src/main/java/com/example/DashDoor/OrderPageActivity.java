package com.example.DashDoor;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.DashDoor.databinding.OrderPageBinding;

public class OrderPageActivity extends AppCompatActivity {

    private OrderPageBinding orderPageBinding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        orderPageBinding = OrderPageBinding.inflate(getLayoutInflater());
        setContentView(orderPageBinding.getRoot());

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Order Page");
        }

        orderPageBinding.placeOrderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View viewPlaceOrderBtn) {
                navigateToCheckout();
            }
        });
    }

    private void navigateToCheckout() {
        int selectedRadioId = orderPageBinding.foodTypeRadioGroup.getCheckedRadioButtonId();
        if (selectedRadioId == -1) {
            displayToastMessage("Please select a food type.");
            return;
        }

        RadioButton selectedFoodTypeRadio = findViewById(selectedRadioId);
        String selectedFoodType = selectedFoodTypeRadio.getText().toString();

        String enteredQuantityString = orderPageBinding.quantityEditText.getText().toString().trim();
        if (TextUtils.isEmpty(enteredQuantityString)) {
            displayToastMessage("Please enter a choice quantity.");
            return;
        }

        int enteredQuantity;
        try {
            enteredQuantity = Integer.parseInt(enteredQuantityString);
            if (enteredQuantity <= 0) {
                displayToastMessage("Quantity must be greater than zero.");
                return;
            }
        } catch (NumberFormatException e) {
            displayToastMessage("Invalid quantity.");
            return;
        }

        // Pass order details to CheckoutActivity
        Intent checkoutIntent = new Intent(this, CheckoutActivity.class);
        checkoutIntent.putExtra("foodType", selectedFoodType);
        checkoutIntent.putExtra("quantity", enteredQuantity);
        startActivity(checkoutIntent);
    }

    private void displayToastMessage(String messageToShow) {
        Toast.makeText(this, messageToShow, Toast.LENGTH_SHORT).show();
    }
}
