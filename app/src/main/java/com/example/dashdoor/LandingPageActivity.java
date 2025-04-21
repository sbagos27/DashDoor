package com.example.dashdoor;

import android.os.Bundle;
import android.view.View;

import com.example.dashdoor.databinding.LoginPageBinding;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;


public class LandingPageActivity extends AppCompatActivity {

    private LoginPageBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = LoginPageBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

//        binding.loginButton.setOnClickListener();


    }


}
