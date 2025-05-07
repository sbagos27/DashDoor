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

    private ActivityAdminBinding adminBinding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        adminBinding = ActivityAdminBinding.inflate(getLayoutInflater());
        setContentView(adminBinding.getRoot());


        adminBinding.historyButton.setOnClickListener(v -> {
            showToast("Hist button was clicked");
        });

        adminBinding.clientsinfoButton.setOnClickListener(v -> {
            StringBuilder clientInfo = new StringBuilder();
            List<String> fName;
            List<String> lName;
            List<Integer> cNum;
            List<Integer> fNum;

            fName = new ArrayList<>();
            lName = new ArrayList<>();
            cNum = new ArrayList<>();
            fNum = new ArrayList<>();

            cNum.add(0,3343);
            cNum.add(1,9102);
            cNum.add(2,7770);
            cNum.add(3,3433);

            fNum.add(0,831-111-4342);
            fNum.add(1,331-215-7600);
            fNum.add(2,111-110-2002);
            fNum.add(3,871-980-1101);

            for (int i = 0; i < 4; i++) {
                clientInfo.append("First Name: ").append(fName.get(i))
                        .append("\nLast Name: ").append(lName.get(i))
                        .append("\nCard Number: ************-").append(cNum.get(i))
                        .append("\nPhone Number: ").append(fNum.get(i))
                        .append("\n------------------------------------------------\n");
            }
            Toast.makeText(getApplicationContext(), clientInfo.toString(), Toast.LENGTH_LONG).show();
        });

        adminBinding.dontPushButton.setOnClickListener(v -> {
            showToast("destructs button was clicked");
        });
    }
  
    public static void initInfo(){

        List<String> fName;
        List<String> lName;
        List<Integer> cNum;
        List<Integer> fNum;

        fName = new ArrayList<>();
        lName = new ArrayList<>();
        cNum = new ArrayList<>();
        fNum = new ArrayList<>();

        cNum.add(0,3343);
        cNum.add(1,9102);
        cNum.add(2,7770);
        cNum.add(3,3433);

        fNum.add(0,831-111-4342);
        fNum.add(1,331-215-7600);
        fNum.add(2,111-110-2002);
        fNum.add(3,871-980-1101);


        for (int i=0; i < 4; i++){
            System.out.println("First Name " + fName.get(i));
            System.out.println("Last Name " + lName.get(i));
            System.out.println("Card Number ************-" +cNum.get(i));
            System.out.println("Phone Number " + fNum.get(i));
            System.out.println("------------------------------------------------");
        }
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    static Intent adminIntent(Context context){
        return new Intent(context, AdminActivity.class);
    }

}
