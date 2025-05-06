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

        // Build order summary from Cart
        StringBuilder orderSummary = new StringBuilder();
        double total = 0.0;
        for (Cart.CartItem cartItem : Cart.getInstance().getItems()) {
            orderSummary.append("• ")
                    .append(cartItem.itemName)
                    .append(" x")
                    .append(cartItem.itemQuantity)
                    .append(" ($")
                    .append(String.format("%.2f", cartItem.itemPrice * cartItem.itemQuantity))
                    .append(")\n");
            total += cartItem.itemPrice * cartItem.itemQuantity;
        }
        checkoutBinding.orderItemsTextView.setText(orderSummary.toString());
        checkoutBinding.totalPriceTextView.setText("Total: $" + String.format("%.2f", total));

        checkoutBinding.placeOrderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View placeOrderButtonView) {
                handlePlaceOrder();
            }
        });
    }

    private void handlePlaceOrder() {
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

        displayToast("Order placed!\nThank you for your purchase!");

        Cart.getInstance().clear(); // Clear the cart after order is placed

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
