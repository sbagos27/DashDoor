package com.example.DashDoor;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.DashDoor.database.DashDoorRepository;
import com.example.DashDoor.databinding.ActivityMainBinding;

public class AdminActivity extends AppCompatActivity {


    private com.example.DashDoor.databinding.ActivityMainBinding binding;
    private DashDoorRepository repository;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        repository = DashDoorRepository.getRepository(getApplication());

        binding.introTexView.setMovementMethod(new ScrollingMovementMethod());
        updateDisplay();

        binding.logButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getInformationFromDisplay();
                inserdashdoorRecord();
                updateDisplay();
            }



        });

    }




}
