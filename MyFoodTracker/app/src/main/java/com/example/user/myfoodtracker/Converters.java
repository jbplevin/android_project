package com.example.user.myfoodtracker;

import android.arch.persistence.room.TypeConverter;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by user on 30/01/2018.
 */

public class Converters {
    @TypeConverter
    public static ArrayList<String> arrayFromString(String value) {
        Type listType = new TypeToken<ArrayList<String>>() {
        }.getType();
        return new Gson().fromJson(value, listType);
    }


    @TypeConverter
    public static String stringFromArrayList(ArrayList<String> list) {
        Gson gson = new Gson();
        String json = gson.toJson(list);
        return json;
    }

    @TypeConverter
    public static String stringFromLong(long value) {
        Gson gson = new Gson();
        String json = gson.toJson(value);
        return json;
    }


    @TypeConverter
    public static HashMap<String, Float> hashFromString(String value) {
        Type listType = new TypeToken<HashMap<String, Float>>() {
        }.getType();
        return new Gson().fromJson(value, listType);
    }

    @TypeConverter
    public static String stringFromHashMap(HashMap<String, Float> list) {
        Gson gson = new Gson();
        String json = gson.toJson(list);
        return json;
    }

    @TypeConverter
    public static long longFromString(String value) {
        Gson gson = new GsonBuilder().create();
        return gson.fromJson(value, Long.class);
    }



}
