package com.example.DashDoor.database;

import android.app.Application;
import android.util.Log;

import androidx.lifecycle.LiveData;

import com.example.DashDoor.database.entities.DashDoor;
import com.example.DashDoor.MainActivity;
import com.example.DashDoor.database.entities.User;

import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class DashDoorRepository {
    private final DashDoorDAO dashDoorDAO;
    private final UserDAO userDao;
    private ArrayList<DashDoor> allLogs;

    private static DashDoorRepository repository;

    private DashDoorRepository(Application application) {
        DashDoorDatabase db = DashDoorDatabase.getDatabase(application);
        this.dashDoorDAO = db.gymLogDAO();
        this.userDao = db.userDAO();
        this.allLogs = (ArrayList<DashDoor>) this.dashDoorDAO.getAllRecords();
    }

    public static DashDoorRepository getRepository(Application application) {
        if (repository != null) {
            return repository;
        }
        Future<DashDoorRepository> future = DashDoorDatabase.databaseWriteExecutor.submit(
                new Callable<DashDoorRepository>() {
                    @Override
                    public DashDoorRepository call() throws Exception {
                        return new DashDoorRepository(application);
                    }
                }
        );
        try {
            return future.get();
        } catch (InterruptedException | ExecutionException e) {
            Log.d(MainActivity.TAG,"Problem getting repository, thread error");
        }
        return null;
    }

    public ArrayList<DashDoor> getAllLogs() {
        Future<ArrayList<DashDoor>> future = DashDoorDatabase.databaseWriteExecutor.submit(
                new Callable<ArrayList<DashDoor>>() {
                    @Override
                    public ArrayList<DashDoor> call() throws Exception {
                        return (ArrayList<DashDoor>) dashDoorDAO.getAllRecords();
                    }
                }
        );
        try {
            return future.get();
        } catch (InterruptedException | ExecutionException e) {
            Log.i(MainActivity.TAG,"Problem getting all logs");
        }
        return null;
    }

    public void insertGymLog(DashDoor dashDoor) {
        DashDoorDatabase.databaseWriteExecutor.execute(() -> {
            dashDoorDAO.insert(dashDoor);
        });
    }

    public void insertUser(User... user) {
        DashDoorDatabase.databaseWriteExecutor.execute(() -> {
            userDao.insert(user);
        });
    }

    public LiveData<User> getUserByUserName(String username) {
        return userDao.getUserByUserName(username);
    }

    public LiveData<User> getUserByUserId(int userId) {
        return userDao.getUserByUserId(userId);
    }
}