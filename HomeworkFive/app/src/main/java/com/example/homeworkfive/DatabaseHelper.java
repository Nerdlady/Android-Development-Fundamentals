package com.example.homeworkfive;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Nerd_lady on 29-Sep-16.
 */

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "database.fb";
    private final static int DB_VERSION = 1;
    public static final String TABLE_NAME = "foods";
    public static final String ID_COLUMN = "id";
    public static final String FOOD_NAME = "food_name";
    public static final String DESCRIPTION = "description";

    public DatabaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE IF NOT EXISTS " +
                TABLE_NAME +
                "(id INTEGER PRIMARY KEY AUTOINCREMENT," +
                FOOD_NAME + " TEXT," +
                DESCRIPTION + " TEXT)";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void addRandomData(){
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        Random random = new Random();

        for (int i = 0; i < 10; i++) {
            values.put(FOOD_NAME, "Random food name " + random.nextInt());
            values.put(DESCRIPTION, "Random food description for example. " + random.nextDouble());
            database.insert(TABLE_NAME, null, values);
        }



        database.close();


    }

    public ArrayList<Food> getData(){
        String query = "SELECT * FROM " + TABLE_NAME;
        ArrayList<Food> foods = new ArrayList<>();
        SQLiteDatabase database = this.getReadableDatabase();
        Cursor cursor = database.rawQuery(query, null);
        if (cursor.moveToFirst()){
            do {
               Food food = new Food(cursor.getLong(0),cursor.getString(1),cursor.getString(2));
                foods.add(food);
            } while (cursor.moveToNext());
        }
        return foods;
    }
}
