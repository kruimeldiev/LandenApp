package com.casperdaris.beroepsproductgroepc.DatabaseHelpers;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelperStad extends SQLiteOpenHelper {

    public static final String STEDEN_TABLE = "STAD_TABLE";
    public static final String COLUMN_STAD_NAAM = "STAD_NAAM";
    public static final String COLUMN_STAD_REGIO = "STAD_REGIO";

    public DatabaseHelperStad(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, "stedenDatabase", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String stedenTableMakenStatement = "CREATE TABLE " + STEDEN_TABLE + " (" + COLUMN_STAD_NAAM + " TEXT PRIMARY KEY, " + COLUMN_STAD_REGIO + " TEXT, FOREIGN KEY (" + COLUMN_STAD_REGIO + ") REFERENCES REGIO_TABLE(REGIO_NAAM));";
        db.execSQL(stedenTableMakenStatement);

        db.execSQL("INSERT INTO " + STEDEN_TABLE + " VALUES ('Utrecht', 'Nederland')");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
