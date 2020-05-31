package com.casperdaris.beroepsproductgroepc.DatabaseHelpers;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.casperdaris.beroepsproductgroepc.Objecten.Bezienswaardigheid;
import com.casperdaris.beroepsproductgroepc.Objecten.Regio;
import com.casperdaris.beroepsproductgroepc.Objecten.Stad;

public class DatabaseHelperBezienswaardigheid extends SQLiteOpenHelper {

    public static final String BEZIENSWAARDIGHEID_TABLE = "BEZIENSWAARDIGHEID_TABLE";
    public static final String COLUMN_BEZ_NAAM = "BEZIENSWAARDIGHEID_NAAM";
    public static final String COLUMN_BEZ_REGIO = "BEZIENSWAARDIGHEID_REGIO";
    public static final String COLUMN_BEZ_STAD = "BEZIENSWAARDIGHEID_STAD";
    public static final String COLUMN_BEZ_BETALING = "BEZIENSWAARDIGHEID_BETALING";
    public static final String COLUMN_BEZ_BESCH = "BEZIENSWAARDIGHEID_BESCHRIJVING";

    public DatabaseHelperBezienswaardigheid(@Nullable Context context) {
        super(context, "bezienswaardigheidDatabase", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String bezienswaardigheidTableMakenStatement = "CREATE TABLE " + BEZIENSWAARDIGHEID_TABLE + " (" + COLUMN_BEZ_NAAM + " TEXT PRIMARY KEY, " + COLUMN_BEZ_BESCH + " TEXT, " + COLUMN_BEZ_REGIO + " TEXT, " + COLUMN_BEZ_STAD + " TEXT, " + COLUMN_BEZ_BETALING + " TEXT)";
        db.execSQL(bezienswaardigheidTableMakenStatement);

        db.execSQL("INSERT INTO " + BEZIENSWAARDIGHEID_TABLE + " VALUES ('De Domtoren', 'Een gotische kerk in Utrecht. Gebouwd vanaf 1254.', 'Nederland', 'Utrecht', 'false')");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public Bezienswaardigheid geselecteerdeStadLaden(String landNaam) {

        Bezienswaardigheid geselecteerdLand;
        String query = "SELECT * FROM " + BEZIENSWAARDIGHEID_TABLE + " WHERE " + COLUMN_BEZ_STAD + " = '" + landNaam + "'";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        if (cursor.moveToFirst()) {
            String bezienswaardigheidNaam = cursor.getString(0);
            String beschrijving = cursor.getString(1);
            String regio = cursor.getString(2);
            String stad = cursor.getString(3);
            String betaling = cursor.getString(4);
            geselecteerdLand = new Bezienswaardigheid(bezienswaardigheidNaam, beschrijving, regio, stad, betaling);

        } else {
            geselecteerdLand = new Bezienswaardigheid("fout", "fout", "fout", "fout", "fout");
        }
        cursor.close();
        db.close();
        return geselecteerdLand;
    }
}
