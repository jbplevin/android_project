package com.example.user.myfoodtracker;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by user on 08/02/2018.
 */

public class LogItemTest {

    LogItem logItem;

    @Before
    public void before() {logItem = new LogItem("Monday",
            "Breakfast: Cereal, Lunch: Sandwiches, " +
             "Dinner: Spaghetti Bolognese, Extras: Biscuits",
            "29/01/2018", "19:00");}

    @Test
    public void canGetLogItemTitle(){
        assertEquals("Monday", logItem.getLogItemTitle());}
    @Test
    public void canGetLogItemMeals(){
        assertEquals("Breakfast: Cereal, " +
                "Lunch: Sandwiches, Dinner: Spaghetti Bolognese," +
                " Extras: Biscuits", logItem.getLogItemMeals());}
    @Test
    public void canGetLogItemDate(){
        assertEquals("29/01/2018", logItem.getLogItemDate());}
    @Test
    public void canGetLogItemTime(){
        assertEquals("19:00", logItem.getLogItemTime());}


    @Test
    public void canSetLogItemTitle(){
        logItem.setLogItemTitle("Wednesday");
        assertEquals("Wednesday", logItem.getLogItemTitle());
    }
    @Test
    public void canSetLogItemMeals(){
        logItem.setLogItemMeals("Breakfast: Poptarts");
        assertEquals("Breakfast: Poptarts", logItem.getLogItemMeals());
    }
    @Test
    public void canSetLogItemDate(){
        logItem.setLogItemDate("1/7/2015");
        assertEquals("1/7/2015", logItem.getLogItemDate());
    }
    @Test
    public void canSetLogItemTime(){
        logItem.setLogItemTime("12:00");
        assertEquals("12:00", logItem.getLogItemTime());
    }


}
