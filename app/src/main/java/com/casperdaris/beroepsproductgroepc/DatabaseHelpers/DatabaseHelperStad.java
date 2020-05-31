package com.casperdaris.beroepsproductgroepc.DatabaseHelpers;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.casperdaris.beroepsproductgroepc.Objecten.RegioSport;
import com.casperdaris.beroepsproductgroepc.Objecten.Stad;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelperStad extends SQLiteOpenHelper {

    public static final String STEDEN_TABLE = "STAD_TABLE";
    public static final String COLUMN_STAD_NAAM = "STAD_NAAM";
    public static final String COLUMN_STAD_REGIO = "STAD_REGIO";

    public DatabaseHelperStad(@Nullable Context context) {
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

    public Stad geselecteerdeRegio(String landNaam) {
        Stad geselecteerdLand;
        String query = "SELECT * FROM " + STEDEN_TABLE + " WHERE " + COLUMN_STAD_REGIO + " = '" + landNaam + "'";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        if (cursor.moveToFirst()) {
            String stadNaam = cursor.getString(0);
            String regioNaam = cursor.getString(1);
            geselecteerdLand = new Stad(stadNaam, regioNaam);
        } else {
            geselecteerdLand = new Stad("fout", "fout");
        }
        cursor.close();
        db.close();

        return geselecteerdLand;
    }
}