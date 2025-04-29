package com.example.DashDoor.database;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.DashDoor.database.entities.DashDoor;
import com.example.DashDoor.MainActivity;
import com.example.DashDoor.database.entities.User;
import com.example.DashDoor.database.typeConverters.LocalDateTypeConverter;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@TypeConverters(LocalDateTypeConverter.class)
@Database(entities = {DashDoor.class, User.class}, version = 1, exportSchema = false)
public abstract class DashDoorDatabase extends RoomDatabase {


    public static final String USER_TABLE = "usertable";
    private static final String DATABASE_NAME = "Gymlogdatabase";
    public static final String DASH_DOOR_TABLE = "gymLogTable";

    private static volatile DashDoorDatabase INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;

    static final ExecutorService databaseWriteExecutor = Executors.newFixedThreadPool(NUMBER_OF_THREADS);
    static DashDoorDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (DashDoorDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(
                            context.getApplicationContext(),
                            DashDoorDatabase.class,
                                    DATABASE_NAME
                            )
                            .fallbackToDestructiveMigration()
                            .addCallback(addDefaultValues)
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    private static final RoomDatabase.Callback addDefaultValues = new RoomDatabase.Callback(){
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            Log.i(MainActivity.TAG, "DATABASE CREATED!");
            databaseWriteExecutor.execute(() -> {
                UserDAO dao = INSTANCE.userDAO();
                dao.deleteAll();
                User admin = new User("admin1", "admin1");
                admin.setAdmin(true);
                dao.insert(admin);

                User textUser1 = new User("testUser1", "testUser1");
                dao.insert(textUser1);
            });
        }
    };

    public abstract DashDoorDAO gymLogDAO();

    public abstract UserDAO userDAO();
}

