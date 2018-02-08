package com.example.user.myfoodtracker;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverter;

import java.io.Serializable;

/**
 * Created by user on 07/02/2018.
 */

@Entity(tableName = "logs")
public class LogItem implements Serializable {

    @PrimaryKey(autoGenerate = true)
    private long logItemId;
    @ColumnInfo(name = "log_title")
    private String logItemTitle;
    @ColumnInfo(name = "log_meal_time")
    private String logItemMealTime;
    @ColumnInfo(name = "log_meals")
    private String logItemMeals;
    @ColumnInfo(name = "log_date")
    private String logItemDate;
    @ColumnInfo(name = "log_time")
    private String logItemTime;

    public LogItem(String logItemTitle,
                   String logItemMealTime,
                   String logItemMeals,
                   String logItemDate,
                   String logItemTime){
        this.logItemTitle = logItemTitle;
        this.logItemMealTime = logItemMealTime;
        this.logItemMeals = logItemMeals;
        this.logItemDate = logItemDate;
        this.logItemTime = logItemTime;
    }

    public long getLogItemId(){ return logItemId; }
    public String getLogItemTitle(){ return logItemTitle; }
    public String getLogItemMealTime(){ return logItemMealTime; }
    public String getLogItemMeals(){ return logItemMeals; }
    public String getLogItemDate(){ return logItemDate; }
    public String getLogItemTime(){ return logItemTime; }

    public void setLogItemId(long logItemId) { this.logItemId = logItemId; }
    public void setLogItemTitle(String logItemTitle) { this.logItemTitle = logItemTitle; }
    public void setLogItemMealTime(String logItemMealTime) { this.logItemMealTime = logItemMealTime; }
    public void setLogItemMeals(String logItemMeals) { this.logItemMeals = logItemMeals; }
    public void setLogItemDate(String logItemDate) { this.logItemDate = logItemDate; }
    public void setLogItemTime(String logItemTime) { this.logItemTime = logItemTime; }



}
