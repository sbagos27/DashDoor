package com.example.DashDoor;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;

import com.example.DashDoor.database.DashDoorRepository;
import com.example.DashDoor.database.entities.DashDoor;
import com.example.DashDoor.database.entities.User;
import com.example.DashDoor.databinding.ActivityMainBinding;

import java.util.ArrayList;

//TESTING IF IT CHANGES

public class MainActivity extends AppCompatActivity {
    private static final String MAIN_ACTIVITY_USER_ID = "com.example.DashDoor.MAIN_ACTIVITY_USER_ID";
    static final String SHARED_PREFERENCE_USERID_KEY = "com.example.DashDoor.SHARED_PREFERENCE_USERID_KEY";
    static final String SHARED_PREFERENCE_USERID_VALUE = "com.example.DashDoor.SHARED_PREFERENCE_USERID_VALUE";

    private static final int LOGGED_OUT = -1;
    private ActivityMainBinding binding;
    private DashDoorRepository repository;


    public static final String TAG = "DAC_DashDoor";

    String mLocation = "";
    String mFoodType = "";
    double mCost = 0;

    private int loggedInUserId = -1;
    private User user;

    // Add reference for admin button
    private Button adminOnlyButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("DashDoor");
        }

        repository = DashDoorRepository.getRepository(getApplication());
        loginUser();

        // Reference the admin button
        adminOnlyButton = findViewById(R.id.adminOnlyButton);
        // Hide it by default (redundant if already gone in XML)
        if (adminOnlyButton != null) {
            adminOnlyButton.setVisibility(View.GONE);
        }

        if (loggedInUserId == -1) {
            Intent intent = LoginActivity.loginIntentFactory(getApplicationContext());
            startActivity(intent);
        }

        binding.logDisplayTextView.setMovementMethod(new ScrollingMovementMethod());

        updateDisplay();

        binding.logButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getInformationFromDisplay();
                insertDashDoorRecord();
                updateDisplay();
            }
        });
        binding.LocationInputEditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateDisplay();
            }
        });

    }

    private void loginUser() {
        SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences(SHARED_PREFERENCE_USERID_KEY,
                Context.MODE_PRIVATE);
        loggedInUserId = sharedPreferences.getInt(SHARED_PREFERENCE_USERID_VALUE, LOGGED_OUT);
        if (loggedInUserId != LOGGED_OUT) {
            return;
        }
        loggedInUserId = getIntent().getIntExtra(MAIN_ACTIVITY_USER_ID, LOGGED_OUT);
        if (loggedInUserId == LOGGED_OUT) {
            return;
        }
        LiveData<User> userObserver = repository.getUserByUserId(loggedInUserId);
        userObserver.observe(this, userObj -> {
            if (userObj != null) {
                user = userObj;
                invalidateOptionsMenu();

                // Show adminOnlyButton if username is "admin1"
                if (adminOnlyButton != null) {
                    if ("admin1".equals(user.getUsername())) {
                        adminOnlyButton.setVisibility(View.VISIBLE);
                    } else {
                        adminOnlyButton.setVisibility(View.GONE);
                    }
                }
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.logout_menu, menu);
        return true;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        MenuItem item = menu.findItem(R.id.logoutMenuItem);
        item.setVisible(true);
        if (user == null) {
            return false;
        }
        item.setTitle(user.getUsername());
        item.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(@NonNull MenuItem item) {
                showLogoutDialog();
                return false;
            }
        });
        return true;
    }

    private void showLogoutDialog() {
        AlertDialog.Builder alertBuilder = new AlertDialog.Builder(MainActivity.this);
        final AlertDialog alertDialog = alertBuilder.create();

        alertBuilder.setMessage("Logout");

        alertBuilder.setPositiveButton("Logout?", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                logout();
            }
        });
        alertBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                alertDialog.dismiss();
            }
        });

        alertBuilder.create().show();
    }

    private void logout() {
        SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences(SHARED_PREFERENCE_USERID_KEY, Context.MODE_PRIVATE);
        SharedPreferences.Editor sharedPrefEditor = sharedPreferences.edit();
        sharedPrefEditor.putInt(SHARED_PREFERENCE_USERID_KEY, LOGGED_OUT);
        sharedPrefEditor.apply();

        getIntent().putExtra(MAIN_ACTIVITY_USER_ID, LOGGED_OUT);

        startActivity(LoginActivity.loginIntentFactory(getApplicationContext()));
    }

    static Intent mainActivityIntentFactory(Context context, int userId) {
        Intent intent = new Intent(context, MainActivity.class);
        intent.putExtra(MAIN_ACTIVITY_USER_ID, userId);
        return intent;
    }

    private void insertDashDoorRecord() {
        if (mLocation.isEmpty()) {
            return;
        }
        DashDoor log = new DashDoor(mLocation, mFoodType, mCost, loggedInUserId);
        repository.insertDashDoor(log);
    }

    private void updateDisplay() {
        ArrayList<DashDoor> allLogs = repository.getAllLogs();
        if (allLogs.isEmpty()) {
            binding.logDisplayTextView.setText(R.string.nothing_to_show_time_to_eat);
        }
        StringBuilder sb = new StringBuilder();
        for (DashDoor log : allLogs) {
            sb.append(log);
        }
        binding.logDisplayTextView.setText(sb.toString());
    }

    private void getInformationFromDisplay() {
        mLocation = binding.LocationInputEditText.getText().toString();
        try {
            mFoodType = String.valueOf(Double.parseDouble(binding.FoodTypeInputEditText.getText().toString()));
        } catch (NumberFormatException e) {
            Log.d(TAG, "Error reading value from FoodType Edit Text.");
        }

        try {
            mCost = Integer.parseInt(binding.costInputEditText.getText().toString());
        } catch (NumberFormatException e) {
            Log.d(TAG, "Error reading value from cost Edit Text.");
        }
    }
}
