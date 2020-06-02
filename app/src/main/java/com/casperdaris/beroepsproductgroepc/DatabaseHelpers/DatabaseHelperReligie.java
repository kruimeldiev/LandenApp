package com.casperdaris.beroepsproductgroepc.DatabaseHelpers;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.casperdaris.beroepsproductgroepc.Objecten.Regio;
import com.casperdaris.beroepsproductgroepc.Objecten.RegioReligie;
import com.casperdaris.beroepsproductgroepc.Objecten.RegioSport;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelperReligie extends SQLiteOpenHelper {

    public static final String RELIGIE_TABLE = "RELIGIE_TABLE";
    public static final String COLUMN_RELIGIE_NAAM = "RELIGIE_NAAM";
    public static final String COLUMN_RELIGIE_REGIO = "RELIGIE_REGIO";
    public static final String COLUMN_RELIGIE_PERCENTAGE = "RELIGIE_PERCENTAGE";

    public DatabaseHelperReligie(@Nullable Context context) {
        super(context, "religieDatabase", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String religieTableMakenStatement = "CREATE TABLE " + RELIGIE_TABLE + " (" + COLUMN_RELIGIE_NAAM + " TEXT PRIMARY KEY, " + COLUMN_RELIGIE_REGIO + " TEXT, " + COLUMN_RELIGIE_PERCENTAGE + " REAL)";
        db.execSQL(religieTableMakenStatement);

        db.execSQL("INSERT INTO " + RELIGIE_TABLE + " VALUES ('Rooms-katholiek', 'Nederland', 24.00)");
        db.execSQL("INSERT INTO " + RELIGIE_TABLE + " VALUES ('Protestants', 'Nederland', 15.00)");
        db.execSQL("INSERT INTO " + RELIGIE_TABLE + " VALUES ('Islamitisch', 'Nederland', 5.00)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


}
