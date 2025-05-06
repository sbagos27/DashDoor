package com.example.DashDoor;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class AdminActivity extends AppCompatActivity {

    List<String> fName;
    List<String> lName;
    List<Integer> cNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        fName = new ArrayList<>();
        lName = new ArrayList<>();
        cNum = new ArrayList<>();


        fName.add(0,"Lisa");
        fName.add(1,"Bob");
        fName.add(2,"Jason");
        fName.add(4,"Salina");

        lName.add(0,"Steller");
        lName.add(1,"Builder");
        lName.add(2,"Todd");
        lName.add(3,"Kyle");

        cNum.add(0,3343);
        cNum.add(1,9102);
        cNum.add(2,7770);
        cNum.add(3,0152);


    }
}
