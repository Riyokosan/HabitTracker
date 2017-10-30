package com.example.android.habittracker.data;

import android.provider.BaseColumns;

/**
 * Created by Ryoko on 05/10/2017.
 */

public class TrackerContract {

    private TrackerContract() {}

    public static abstract class TrackerEntry implements BaseColumns {

        public static final String TABLE_NAME = "tracker";
        public static final String _ID = BaseColumns._ID;
        public static final String COLUMN_TRACKER_NAME = "name";
        public static final String COLUMN_TRACKER_SLEEP = "sleep";
        public static final String COLUMN_TRACKER_GENDER = "gender";
        public static final String COLUMN_TRACKER_WEIGHT = "weight";

        /**
         * Possible values for the gender.
         */
        public static final int GENDER_OTHER = 0;
        public static final int GENDER_MALE = 1;
        public static final int GENDER_FEMALE = 2;

    }
}
