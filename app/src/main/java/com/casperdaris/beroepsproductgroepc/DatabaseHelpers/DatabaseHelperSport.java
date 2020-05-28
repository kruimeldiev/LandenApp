package com.casperdaris.beroepsproductgroepc.DatabaseHelpers;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelperSport extends SQLiteOpenHelper {

    public static final String SPORT_TABLE = "SPORT_TABLE";
    public static final String COLUMN_SPORT_NAAM = "SPORT_NAAM";
    public static final String COLUMN_SPORT_REGIO = "SPORT_REGIO";

    public DatabaseHelperSport(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, "sportDatabase", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String sportTableMakenStatement = "CREATE TABLE " + SPORT_TABLE + " (" + COLUMN_SPORT_NAAM + " TEXT PRIMARY KEY, " + COLUMN_SPORT_REGIO + " TEXT PRIMARY KEY, FOREIGN KEY (" + COLUMN_SPORT_REGIO + ") REFERENCES REGIO_TABLE(REGIO_NAAM));";
        db.execSQL(sportTableMakenStatement);

        db.execSQL("INSERT INTO " + SPORT_TABLE + " VALUES ('Schaatsen', 'Nederland')");
        db.execSQL("INSERT INTO " + SPORT_TABLE + " VALUES ('Voetbal', 'Nederland')");
        db.execSQL("INSERT INTO " + SPORT_TABLE + " VALUES ('Atletiek', 'Nederland')");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
