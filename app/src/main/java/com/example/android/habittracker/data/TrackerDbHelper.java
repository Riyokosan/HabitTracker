package com.example.android.habittracker.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static com.example.android.habittracker.data.TrackerContract.TrackerEntry;


/**
 * Created by Ryoko on 05/10/2017.
 */

public class TrackerDbHelper extends SQLiteOpenHelper {

    public static final String LOG_TAG = TrackerDbHelper.class.getSimpleName();

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "tracker.db";

    public TrackerDbHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Create a String that contains the SQL statement to create the pets table
        String SQL_CREATE_TRACKER_TABLE =  "CREATE TABLE " + TrackerEntry.TABLE_NAME + " ("
                + TrackerEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + TrackerEntry.COLUMN_TRACKER_NAME + " TEXT NOT NULL, "
                + TrackerEntry.COLUMN_TRACKER_SLEEP + " INTEGER NOT NULL DEFAULT 0, "
                + TrackerEntry.COLUMN_TRACKER_GENDER + " INTEGER NOT NULL, "
                + TrackerEntry.COLUMN_TRACKER_WEIGHT + " INTEGER NOT NULL DEFAULT 0);";
        // Execute the SQL statement
        db.execSQL(SQL_CREATE_TRACKER_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
    }
}
