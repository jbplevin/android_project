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
            "29/01/2018", "19:00",
            "Cereal","Sarnies","Pasta",
            "Biscuits");}

    @Test
    public void canGetLogItemTitle(){
        assertEquals("Monday", logItem.getLogItemTitle());}
    @Test
    public void canGetLogItemBreakfast(){
        assertEquals("Cereal", logItem.getLogItemBreakfast());}
    @Test
    public void canGetLogItemLunch(){
        assertEquals("Sarnies", logItem.getLogItemLunch());}
    @Test
    public void canGetLogItemDinner(){
        assertEquals("Pasta", logItem.getLogItemDinner());}
    @Test
    public void canGetLogItemExtras(){
        assertEquals("Biscuits", logItem.getLogItemExtras());}
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
    public void canSetLogItemBreakfast(){
        logItem.setLogItemBreakfast("Poptarts");
        assertEquals("Poptarts", logItem.getLogItemBreakfast());
    }
    @Test
    public void canSetLogItemLunch(){
        logItem.setLogItemLunch("Pasta");
        assertEquals("Pasta", logItem.getLogItemLunch());
    }
    @Test
    public void canSetLogItemDinner(){
        logItem.setLogItemDinner("Chicken Kiev");
        assertEquals("Chicken Kiev", logItem.getLogItemDinner());
    }
    @Test
    public void canSetLogItemExtras(){
        logItem.setLogItemExtras("Chocolate");
        assertEquals("Chocolate", logItem.getLogItemExtras());
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
