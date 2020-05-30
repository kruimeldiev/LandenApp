package com.casperdaris.beroepsproductgroepc.DatabaseHelpers;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.casperdaris.beroepsproductgroepc.Objecten.RegioReligie;
import com.casperdaris.beroepsproductgroepc.Objecten.RegioSpecialiteit;

public class DatabaseHelperSpecialiteit extends SQLiteOpenHelper {

    public static final String SPECIALITEIT_TABLE = "SPECIALITEIT_TABLE";
    public static final String COLUMN_SPECIALITEIT_NAAM = "SPECIALITEIT_NAAM";
    public static final String COLUMN_SPECIALITEIT_REGIO = "SPECIALITEIT_REGIO";

    public DatabaseHelperSpecialiteit(@Nullable Context context) {
        super(context, "specialiteitDatabase", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String specialiteitTableMakenStatement = "CREATE TABLE " + SPECIALITEIT_TABLE + " (" + COLUMN_SPECIALITEIT_NAAM + " TEXT PRIMARY KEY, " + COLUMN_SPECIALITEIT_REGIO + " TEXT)";
        db.execSQL(specialiteitTableMakenStatement);

        db.execSQL("INSERT INTO " + SPECIALITEIT_TABLE + " VALUES ('Kaas', 'Nederland')");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public RegioSpecialiteit geselecteerdeRegio(String landNaam) {

        RegioSpecialiteit geselecteerdLand;
        String query = "SELECT * FROM " + SPECIALITEIT_TABLE + " WHERE " + COLUMN_SPECIALITEIT_REGIO + " = '" + landNaam + "'";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        if (cursor.moveToFirst()) {
            String specialiteitNaam = cursor.getString(0);
            String regioNaam = cursor.getString(1);
            geselecteerdLand = new RegioSpecialiteit(specialiteitNaam);

        } else {
            geselecteerdLand = new RegioSpecialiteit("fout");
        }
        cursor.close();
        db.close();
        return geselecteerdLand;
    }
}
