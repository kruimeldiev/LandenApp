package com.example.reizigers_app;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabasehelperRegioInfo extends SQLiteOpenHelper {

        public final static String TABLE_NAME = "RegioInfo";

        public static final String COL_REGIO = "regio";
        public static final String COL_HOOFDREGIO = "hoofdregio";
        public static final String COL_HOOFDSTAD = "hoofdstad ";
        public static final String COL_POPULATIE = "populatie";
        public static final String COL_VALUTA = "valuta";
        public static final String COL_ALARMNUMMER = "alarmnummer";
        public static final String COL_BESCHRIJVING = "beschrijving";
        public static final String COL_SOORT = "soort ";


    public DatabasehelperRegioInfo(Context context) {
        super(context, TABLE_NAME, null, 1);
    }

        @Override
        public void onCreate (SQLiteDatabase db){
        String strcreatetable = "CREATE TABLE " + TABLE_NAME + "("
                + COL_REGIO + " INTEGER PRIMARY KEY, " +
                COL_HOOFDREGIO + " TEXT, " +
                COL_HOOFDSTAD + " INTEGER, " +
                COL_POPULATIE + " TEXT, " +
                COL_VALUTA + " TEXT, " +
                COL_ALARMNUMMER + " TEXT, " +
                COL_BESCHRIJVING + " TEXT, " +
                COL_SOORT + " INTEGER)";
        db.execSQL(strcreatetable);

    }

        @Override
        public void onUpgrade (SQLiteDatabase db,int oldVersion, int newVersion){

    }


    public Cursor getRegioInfoData(){
        SQLiteDatabase db= this.getWritableDatabase();
        String strQuery = " SELECT* FROM " + TABLE_NAME;
        Cursor cursor= db.rawQuery(strQuery, null);
        return cursor;
    }

    public boolean searchregio (String regio) {
        SQLiteDatabase db = getReadableDatabase();
        String strQuery = " SELECT "+ COL_REGIO +"  FROM "+ TABLE_NAME+ " WHERE "+ COL_REGIO +" = '" + regio + "' ";
        Cursor cursor = db.rawQuery(strQuery,null);
        try {
            if (cursor.moveToFirst()) {
                // read column data
                return true;
            }
        } finally {
            cursor.close();
        }
        return false;
    }

}
