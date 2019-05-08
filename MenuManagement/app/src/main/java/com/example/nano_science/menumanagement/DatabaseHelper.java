package com.example.nano_science.menumanagement;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "menu.db";
    public static final String TABLE_NAME = "menu_table";

    public static final String COLUMN_MENU_ID = "menuId";
    public static final String COLUMN_FOOD_CODE = "foodCode";
    public static final String COLUMN_FOOD_NAME = "foodName";
    public static final String COLUMN_FOOD_TYPE = "foodType";
    public static final String COLUMN_RECIPE = "recipe";
    public static final String COLUMN_PRICE = "price";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME + " (menuId INTEGER, foodCode TEXT PRIMARY KEY, foodName TEXT, foodType TEXT, recipe TEXT, price DOUBLE )");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);

    }

    public boolean insertData(String menuId, String foodCode, String foodName, String foodType, String recipe, String price){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_MENU_ID,menuId);
        contentValues.put(COLUMN_FOOD_CODE,foodCode);
        contentValues.put(COLUMN_FOOD_NAME,foodName);
        contentValues.put(COLUMN_FOOD_TYPE,foodType);
        contentValues.put(COLUMN_RECIPE,recipe);
        contentValues.put(COLUMN_PRICE,price);

        long result = db.insert(TABLE_NAME, null, contentValues);

        if (result == -1)
            return false;
        else
            return true;


    }

}

