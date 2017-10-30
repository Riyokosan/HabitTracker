package com.example.android.habittracker;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.android.habittracker.data.TrackerDbHelper;

import static com.example.android.habittracker.data.TrackerContract.TrackerEntry;


public class CatalogActivity extends AppCompatActivity {

    private TrackerDbHelper mDbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mDbHelper = new TrackerDbHelper(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        displayDatabaseInfo();
    }

    /**
     * Temporary helper method to display information in the onscreen TextView about the state of
     * the tracker database.
     */
    private void displayDatabaseInfo() {
        // To access our database, we instantiate our subclass of SQLiteOpenHelper
        // and pass the context, which is the current activity.
        TrackerDbHelper mDbHelper = new TrackerDbHelper(this);

        // Create and/or open a database to read from it
        SQLiteDatabase db = mDbHelper.getReadableDatabase();

        // Perform this raw SQL query "SELECT * FROM pets"
        // to get a Cursor that contains all rows from the pets table.

        String[] projection = {
                TrackerEntry._ID,
                TrackerEntry.COLUMN_TRACKER_NAME,
                TrackerEntry.COLUMN_TRACKER_SLEEP,
                TrackerEntry.COLUMN_TRACKER_GENDER,
                TrackerEntry.COLUMN_TRACKER_WEIGHT
        };

        Cursor cursor = db.query(
                TrackerEntry.TABLE_NAME,
                projection,
                null,
                null,
                null,
                null,
                null
        );
    }

    private void insertTracker(){
        // Gets the data repository in write mode
        SQLiteDatabase db = mDbHelper.getWritableDatabase();

        // Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
        values.put(TrackerEntry.COLUMN_TRACKER_NAME, "Peter");
        values.put(TrackerEntry.COLUMN_TRACKER_SLEEP, "6");
        values.put(TrackerEntry.COLUMN_TRACKER_GENDER, TrackerEntry.GENDER_MALE);
        values.put(TrackerEntry.COLUMN_TRACKER_WEIGHT, "7");

        // Insert the new row, returning the primary key value of the new row
        long newRowId = db.insert(TrackerEntry.TABLE_NAME, null, values);

    }

}
