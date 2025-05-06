package com.example.DashDoor;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.DashDoor.databinding.ActivityCheckoutBinding;

public class CheckoutActivity extends AppCompatActivity {

    private ActivityCheckoutBinding checkoutBinding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        checkoutBinding = ActivityCheckoutBinding.inflate(getLayoutInflater());
        setContentView(checkoutBinding.getRoot());

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Checkout");
        }

        // Retrieve passed order details from Intent
        Intent checkoutIntent = getIntent();
        String selectedFoodType = checkoutIntent.getStringExtra("foodType");
        int selectedQuantity = checkoutIntent.getIntExtra("quantity", 1);

        // Set order summary dynamically
        String dynamicOrderSummary = "• " + selectedFoodType + " x" + selectedQuantity;
        checkoutBinding.orderItemsTextView.setText(dynamicOrderSummary);

        // Optionally, set a dynamic price (for demonstration, $10 per item)
        double dynamicPricePerItem = 10.0;
        double calculatedTotalPrice = dynamicPricePerItem * selectedQuantity;
        checkoutBinding.totalPriceTextView.setText("Total: $" + String.format("%.2f", calculatedTotalPrice));

        checkoutBinding.placeOrderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View placeOrderButtonView) {
                handlePlaceOrder(selectedFoodType, selectedQuantity, calculatedTotalPrice);
            }
        });
    }

    private void handlePlaceOrder(String selectedFoodType, int selectedQuantity, double calculatedTotalPrice) {
        String enteredDeliveryAddress = checkoutBinding.deliveryAddressEditText.getText().toString().trim();
        String enteredPaymentInfo = checkoutBinding.paymentInfoEditText.getText().toString().trim();

        if (TextUtils.isEmpty(enteredDeliveryAddress)) {
            displayToast("Please enter a delivery address.");
            return;
        }
        if (TextUtils.isEmpty(enteredPaymentInfo) || enteredPaymentInfo.length() < 8) {
            displayToast("Please enter a valid card number.");
            return;
        }

        // TODO: Save order to database or send to backend here

        displayToast("Order placed!\n" +
                selectedFoodType + " x" + selectedQuantity + "\n" +
                "Total: $" + String.format("%.2f", calculatedTotalPrice));

        // Optionally, return to the main screen or clear the cart
        startActivity(MainActivity.mainActivityIntentFactory(this, getLoggedInUserIdFromIntent()));
        finish();
    }

    private void displayToast(String toastMessage) {
        Toast.makeText(this, toastMessage, Toast.LENGTH_LONG).show();
    }

    // Utility to get logged-in user ID (adapt as needed)
    private int getLoggedInUserIdFromIntent() {
        // Example: retrieve from SharedPreferences or Intent
        return getIntent().getIntExtra(MainActivity.MAIN_ACTIVITY_USER_ID, -1);
    }

    public static Intent checkoutIntentFactory(Context context, int userId, String selectedFoodType, int selectedQuantity) {
        Intent checkoutIntent = new Intent(context, CheckoutActivity.class);
        checkoutIntent.putExtra(MainActivity.MAIN_ACTIVITY_USER_ID, userId);
        checkoutIntent.putExtra("foodType", selectedFoodType);
        checkoutIntent.putExtra("quantity", selectedQuantity);
        return checkoutIntent;
    }
}
