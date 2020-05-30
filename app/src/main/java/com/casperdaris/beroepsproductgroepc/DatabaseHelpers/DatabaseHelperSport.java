package com.casperdaris.beroepsproductgroepc.DatabaseHelpers;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.casperdaris.beroepsproductgroepc.Objecten.RegioSpecialiteit;
import com.casperdaris.beroepsproductgroepc.Objecten.RegioSport;

public class DatabaseHelperSport extends SQLiteOpenHelper {

    public static final String SPORT_TABLE = "SPORT_TABLE";
    public static final String COLUMN_SPORT_NAAM = "SPORT_NAAM";
    public static final String COLUMN_SPORT_REGIO = "SPORT_REGIO";

    public DatabaseHelperSport(@Nullable Context context) {
        super(context, "sportDatabase", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String sportTableMakenStatement = "CREATE TABLE " + SPORT_TABLE + " (" + COLUMN_SPORT_NAAM + " TEXT PRIMARY KEY, " + COLUMN_SPORT_REGIO + " TEXT)";
        db.execSQL(sportTableMakenStatement);

        db.execSQL("INSERT INTO " + SPORT_TABLE + " VALUES ('Schaatsen', 'Nederland')");
        db.execSQL("INSERT INTO " + SPORT_TABLE + " VALUES ('Voetbal', 'Nederland')");
        db.execSQL("INSERT INTO " + SPORT_TABLE + " VALUES ('Atletiek', 'Nederland')");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public RegioSport geselecteerdeRegio(String landNaam) {

        RegioSport geselecteerdLand;
        String query = "SELECT * FROM " + SPORT_TABLE + " WHERE " + COLUMN_SPORT_REGIO + " = '" + landNaam + "'";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        if (cursor.moveToFirst()) {
            String sportNaam = cursor.getString(0);
            geselecteerdLand = new RegioSport(sportNaam);

        } else {
            geselecteerdLand = new RegioSport("fout");
        }
        cursor.close();
        db.close();
        return geselecteerdLand;
    }
}
