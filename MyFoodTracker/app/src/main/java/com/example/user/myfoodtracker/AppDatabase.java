package com.example.user.myfoodtracker;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverter;
import android.arch.persistence.room.TypeConverters;
import android.content.Context;

import com.example.user.myfoodtracker.LogItem;
import com.example.user.myfoodtracker.LogItemDao;

/**
 * Created by user on 29/01/2018.
 */
@Database(entities = {LogItem.class}, version = 1)
@TypeConverters({Converters.class})


public abstract class AppDatabase extends RoomDatabase {

    private static AppDatabase INSTANCE;


    public abstract LogItemDao getLogItemDao();

    public static AppDatabase getAppDatabase(Context context) {
        if (INSTANCE == null) {
            INSTANCE =
                    Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, "app-database")
                            // allow queries on the main thread.
                            // Don't do this on a real app! See PersistenceBasicSample for an example.
                            .allowMainThreadQueries()
                            .build();
        }
        return INSTANCE;
    }

    public static void destroyInstance() {
        INSTANCE = null;
    }
}