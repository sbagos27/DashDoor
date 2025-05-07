package com.example.DashDoor;

import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;

public class AdminActivityTest extends TestCase {

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

}