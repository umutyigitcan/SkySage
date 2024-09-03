package com.example.skysage

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class SelectedCity(mContext:Context):SQLiteOpenHelper(mContext,"selectedCity",null,1) {
    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL("CREATE TABLE selectedCity(cityName TEXT);")
        db.execSQL("INSERT INTO selectedCity(cityName) VALUES('Istanbul')")
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS selectedCity",null)
        onCreate(db)
    }
}