package com.casperdaris.beroepsproductgroepc.DatabaseHelpers;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelperBezienswaardigheid extends SQLiteOpenHelper {

    public static final String BEZIENSWAARDIGHEID_TABLE = "BEZIENSWAARDIGHEID_TABLE";
    public static final String COLUMN_BEZ_NAAM = "BEZIENSWAARDIGHEID_NAAM";
    public static final String COLUMN_BEZ_REGIO = "BEZIENSWAARDIGHEID_REGIO";
    public static final String COLUMN_BEZ_STAD = "BEZIENSWAARDIGHEID_STAD";
    public static final String COLUMN_BEZ_BETALING = "BEZIENSWAARDIGHEID_BETALING";
    public static final String COLUMN_BEZ_BESCH = "BEZIENSWAARDIGHEID_BESCHRIJVING";

    public DatabaseHelperBezienswaardigheid(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, "bezienswaardigheidDatabase", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String bezienswaardigheidTableMakenStatement = "CREATE TABLE " + BEZIENSWAARDIGHEID_TABLE + " (" + COLUMN_BEZ_NAAM + " TEXT PRIMARY KEY, " + COLUMN_BEZ_BESCH + " TEXT, " + COLUMN_BEZ_REGIO + " TEXT, " + COLUMN_BEZ_STAD + " TEXT, " + COLUMN_BEZ_BETALING + " TEXT, FOREIGN KEY (" + COLUMN_BEZ_REGIO + ") REFERENCES REGIO_TABLE(REGIO_NAAM));";
        db.execSQL(bezienswaardigheidTableMakenStatement);

        db.execSQL("INSERT INTO " + BEZIENSWAARDIGHEID_TABLE + " VALUES ('De Domtoren', 'Een gotische kerk in Utrecht. Gebouwd vanaf 1254.', 'Nederland', 'Utrecht', false)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
