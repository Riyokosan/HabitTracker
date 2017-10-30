package com.example.android.habittracker;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.android.habittracker.data.TrackerDbHelper;

import static com.example.android.habittracker.data.TrackerContract.TrackerEntry;



public class EditorActivity extends AppCompatActivity {

    /** EditText field to enter the pet's name */
    private EditText mNameEditText;

    /** EditText field to enter the pet's sleep */
    private EditText mSleepEditText;

    /** EditText field to enter the pet's weight */
    private EditText mWeightEditText;

    /** EditText field to enter the pet's gender */
    private Spinner mGenderSpinner;

    /**
     * Gender of the user. The possible values are:
     * 0 for other gender, 1 for male, 2 for female.
     */
    private int mGender = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    /**
     * Get user input from editor and save new tracker into database
     */

    private void insertTracker(){
        String nameString = mNameEditText.getText().toString().trim();
        String sleepString = mSleepEditText.getText().toString().trim();
        int sleep = Integer.parseInt(sleepString);
        String weightString = mWeightEditText.getText().toString().trim();
        int weight = Integer.parseInt(weightString);

        // Create database helper
        TrackerDbHelper mDbHelper = new TrackerDbHelper(this);

        // Gets the data repository in write mode
        SQLiteDatabase db = mDbHelper.getWritableDatabase();

        // Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
        values.put(TrackerEntry.COLUMN_TRACKER_NAME, nameString);
        values.put(TrackerEntry.COLUMN_TRACKER_SLEEP, sleepString);
        values.put(TrackerEntry.COLUMN_TRACKER_GENDER, mGender);
        values.put(TrackerEntry.COLUMN_TRACKER_WEIGHT, weight);

        // Insert the new row, returning the primary key value of the new row
        long newRowId = db.insert(TrackerEntry.TABLE_NAME, null, values);

        // Show a toast message depending on whether or not the insertion was successful
        if (newRowId ==-1) {
            Toast.makeText(this, "Error with saving tracker entry", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Tracker saved with id: " + newRowId, Toast.LENGTH_SHORT).show();
        }
    }

}
