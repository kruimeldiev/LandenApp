package com.casperdaris.beroepsproductgroepc.DatabaseHelpers;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.casperdaris.beroepsproductgroepc.Objecten.RegioSport;
import com.casperdaris.beroepsproductgroepc.Objecten.RegioTaal;

public class DatabaseHelperTaal extends SQLiteOpenHelper {

    public static final String TAAL_TABLE = "TAAL_TABLE";
    public static final String COLUMN_TAAL_NAAM = "TAAL_NAAM";
    public static final String COLUMN_TAAL_REGIO = "TAAL_REGIO";
    public static final String COLUMN_TAAL_PERCENTAGE = "TAAL_PERCENTAGE";

    public DatabaseHelperTaal(@Nullable Context context) {
        super(context, "taalDatabase", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String taalTableMakenStatement = "CREATE TABLE " + TAAL_TABLE + " (" + COLUMN_TAAL_NAAM + " TEXT PRIMARY KEY, " + COLUMN_TAAL_REGIO + " TEXT, " + COLUMN_TAAL_PERCENTAGE + " REAL)";
        db.execSQL(taalTableMakenStatement);

        db.execSQL("INSERT INTO " + TAAL_TABLE + " VALUES ('Nederlands', 'Nederland', 95.00)");
        db.execSQL("INSERT INTO " + TAAL_TABLE + " VALUES ('Engels', 'Nederland', 75.00)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public RegioTaal geselecteerdeRegio(String landNaam) {

        RegioTaal geselecteerdLand;
        String query = "SELECT * FROM " + TAAL_TABLE + " WHERE " + COLUMN_TAAL_REGIO + " = '" + landNaam + "'";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        if (cursor.moveToFirst()) {
            String taalNaam = cursor.getString(0);
            String regioNaam = cursor.getString(1);
            geselecteerdLand = new RegioTaal(taalNaam);

        } else {
            geselecteerdLand = new RegioTaal("fout");
        }
        cursor.close();
        db.close();
        return geselecteerdLand;
    }
}
