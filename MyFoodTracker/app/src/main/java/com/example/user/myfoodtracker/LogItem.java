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
    @ColumnInfo(name = "log_breakfast")
    private String logItemBreakfast;
    @ColumnInfo(name = "log_lunch")
    private String logItemLunch;
    @ColumnInfo(name = "log_dinner")
    private String logItemDinner;
    @ColumnInfo(name = "log_extras")
    private String logItemExtras;
    @ColumnInfo(name = "log_date")
    private String logItemDate;
    @ColumnInfo(name = "log_time")
    private String logItemTime;

    public LogItem(String logItemTitle,
                   String logItemDate,
                   String logItemTime,
                   String logItemBreakfast,
                   String logItemLunch,
                   String logItemDinner,
                   String logItemExtras){
        this.logItemTitle = logItemTitle;
        this.logItemDate = logItemDate;
        this.logItemTime = logItemTime;
        this.logItemBreakfast = logItemBreakfast;
        this.logItemLunch = logItemLunch;
        this.logItemDinner = logItemDinner;
        this.logItemExtras = logItemExtras;
    }

    public long getLogItemId(){ return logItemId; }
    public String getLogItemTitle(){ return logItemTitle; }
    public String getLogItemBreakfast(){ return logItemBreakfast; }
    public String getLogItemLunch(){ return logItemLunch; }
    public String getLogItemDinner(){ return logItemDinner; }
    public String getLogItemExtras(){ return logItemExtras; }
    public String getLogItemDate(){ return logItemDate; }
    public String getLogItemTime(){ return logItemTime; }

    public void setLogItemId(long logItemId) { this.logItemId = logItemId; }
    public void setLogItemTitle(String logItemTitle) { this.logItemTitle = logItemTitle; }
    public void setLogItemBreakfast(String logItemBreakfast) { this.logItemBreakfast = logItemBreakfast; }
    public void setLogItemLunch(String logItemLunch) { this.logItemLunch = logItemLunch; }
    public void setLogItemDinner(String logItemDinner) { this.logItemDinner = logItemDinner; }
    public void setLogItemExtras(String logItemExtras) { this.logItemExtras = logItemExtras; }
    public void setLogItemDate(String logItemDate) { this.logItemDate = logItemDate; }
    public void setLogItemTime(String logItemTime) { this.logItemTime = logItemTime; }



}
