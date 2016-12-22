package org.ligi.fahrplan;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class AlarmsDBOpenHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 2;

    private static final String ALARMS_TABLE_CREATE =
            "CREATE TABLE " + FahrplanContract.AlarmsTable.NAME + " (" +
            FahrplanContract.AlarmsTable.Columns.ID + " INTEGER PRIMARY KEY, " +
            FahrplanContract.AlarmsTable.Columns.EVENT_TITLE + " TEXT, " +
            FahrplanContract.AlarmsTable.Columns.ALARM_TIME_IN_MIN + " INTEGER DEFAULT " +
            FahrplanContract.AlarmsTable.Defaults.ALARM_TIME_IN_MIN_DEFAULT + ", " +
            FahrplanContract.AlarmsTable.Columns.TIME + " INTEGER, " +
            FahrplanContract.AlarmsTable.Columns.TIME_TEXT + " STRING," +
            FahrplanContract.AlarmsTable.Columns.EVENT_ID + " INTEGER," +
            FahrplanContract.AlarmsTable.Columns.DISPLAY_TIME + " INTEGER," +
            FahrplanContract.AlarmsTable.Columns.DAY + " INTEGER);";

    public static final String[] allcolumns = {
            FahrplanContract.AlarmsTable.Columns.ID,
            FahrplanContract.AlarmsTable.Columns.EVENT_TITLE,
            FahrplanContract.AlarmsTable.Columns.ALARM_TIME_IN_MIN,
            FahrplanContract.AlarmsTable.Columns.TIME,
            FahrplanContract.AlarmsTable.Columns.TIME_TEXT,
            FahrplanContract.AlarmsTable.Columns.EVENT_ID,
            FahrplanContract.AlarmsTable.Columns.DISPLAY_TIME,
            FahrplanContract.AlarmsTable.Columns.DAY
    };

    AlarmsDBOpenHelper(Context context) {
        super(context, FahrplanContract.AlarmsTable.NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(ALARMS_TABLE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if ((oldVersion < 2) && (newVersion >= 2)) {
            db.execSQL("ALTER TABLE " + FahrplanContract.AlarmsTable.NAME + " ADD " +
                       FahrplanContract.AlarmsTable.Columns.ALARM_TIME_IN_MIN + " INTEGER DEFAULT" +
                       FahrplanContract.AlarmsTable.Defaults.ALARM_TIME_IN_MIN_DEFAULT);
        }
    }
}
