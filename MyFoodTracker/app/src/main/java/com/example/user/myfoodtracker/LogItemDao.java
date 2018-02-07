package com.example.user.myfoodtracker;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;
import java.util.List;
import com.example.user.myfoodtracker.LogItem;

/**
 * Created by user on 29/01/2018.
 */

@Dao
public interface LogItemDao {

    @Query("SELECT * FROM logs")
    List<LogItem> getAll();

    @Query("SELECT * from logs where logItemId = :logItemId")
    LogItem findById(int logItemId);

    @Query("SELECT COUNT(*) from logs")
    int countLogItems();

    @Insert
    void insertAll(LogItem... logItems);

    @Insert
    long insertLogItem(LogItem logItem);

    @Update
    void updateLogItems(LogItem logItems);

    @Delete
    void delete(LogItem logItems);

    @Query("DELETE FROM logs")
    void deleteAll();

}