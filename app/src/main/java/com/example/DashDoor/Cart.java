package com.example.DashDoor;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private static Cart cartInstance;
    private final List<CartItem> cartItemList = new ArrayList<>();

    public static Cart getInstance() {
        if (cartInstance == null) {
            cartInstance = new Cart();
        }
        return cartInstance;
    }

    public void addItem(String itemName, double itemPrice, int itemQuantity) {
        for (CartItem cartItem : cartItemList) {
            if (cartItem.itemName.equals(itemName)) {
                cartItem.itemQuantity += itemQuantity;
                return;
            }
        }
        cartItemList.add(new CartItem(itemName, itemPrice, itemQuantity));
    }

    public List<CartItem> getItems() {
        return cartItemList;
    }

    public void clear() {
        cartItemList.clear();
    }

    public static class CartItem {
        public String itemName;
        public double itemPrice;
        public int itemQuantity;

        public CartItem(String itemName, double itemPrice, int itemQuantity) {
            this.itemName = itemName;
            this.itemPrice = itemPrice;
            this.itemQuantity = itemQuantity;
        }
    }
}
