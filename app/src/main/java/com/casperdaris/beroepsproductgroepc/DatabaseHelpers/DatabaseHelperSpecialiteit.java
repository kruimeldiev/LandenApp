package com.casperdaris.beroepsproductgroepc.DatabaseHelpers;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.casperdaris.beroepsproductgroepc.Objecten.RegioReligie;
import com.casperdaris.beroepsproductgroepc.Objecten.RegioSpecialiteit;

import java.util.ArrayList;
import java.util.List;

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
}
