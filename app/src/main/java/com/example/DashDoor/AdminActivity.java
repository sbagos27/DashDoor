package com.example.DashDoor;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import androidx.annotation.Nullable;
import com.example.DashDoor.databinding.ActivityAdminBinding;

import java.util.ArrayList;
import java.util.List;

public class AdminActivity extends AppCompatActivity {

    List<String> fName;
    List<String> lName;
    List<Integer> cNum;

    private ActivityAdminBinding adminBinding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        adminBinding = ActivityAdminBinding.inflate(getLayoutInflater());
        setContentView(adminBinding.getRoot());

        adminBinding.historyButton.setOnClickListener(v -> {
            showToast("Hist button was clicked");
        });

        adminBinding.clientsinfoButton.setOnClickListener(v -> {
            showToast("client button was clicked");
        });

        adminBinding.dontPushButton.setOnClickListener(v -> {
            showToast("destructs button was clicked");
        });

//        fName = new ArrayList<>();
//        lName = new ArrayList<>();
//        cNum = new ArrayList<>();
//
//
//        fName.add(0,"Lisa");
//        fName.add(1,"Bob");
//        fName.add(2,"Jason");
//        fName.add(4,"Salina");
//
//        lName.add(0,"Steller");
//        lName.add(1,"Builder");
//        lName.add(2,"Todd");
//        lName.add(3,"Kyle");
//
//        cNum.add(0,3343);
//        cNum.add(1,9102);
//        cNum.add(2,7770);
//        cNum.add(3,0152);
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    static Intent adminIntent(Context context){
        return new Intent(context, AdminActivity.class);
    }
}
