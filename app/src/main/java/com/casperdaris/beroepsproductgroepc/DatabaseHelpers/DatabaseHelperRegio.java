package com.casperdaris.beroepsproductgroepc.DatabaseHelpers;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.casperdaris.beroepsproductgroepc.Objecten.Regio;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelperRegio extends SQLiteOpenHelper {

    // Deze strings zijn de namen van een tabel en columns in de database
    public static final String REGIO_TABLE = "REGIO_TABLE";
    public static final String COLUMN_REGIO_NAAM = "REGIO_NAAM";
    public static final String COLUMN_REGIO_BESCHRIJVING = "REGIO_BESCHRIJVING";
    public static final String COLUMN_HOOFD_REGIO = "HOOFD_REGIO";
    public static final String COLUMN_HOOFD_STAD = "HOOFD_STAD";
    public static final String COLUMN_POPULATIE = "POPULATIE";
    public static final String COLUMN_REGIO_VALUTA = "REGIO_VALUTA";
    public static final String COLUMN_REGIO_SOORT = "REGIO_SOORT";
    public static final String COLUMN_ALARM_NUMMER = "ALARM_NUMMER";

    public DatabaseHelperRegio(@Nullable Context context) {
        super(context, "regioDatabase", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        // Een string aanmaken om vervolgens een tabel mee te maken in de database
        String regioTableMakenStatement = "CREATE TABLE " + REGIO_TABLE + " (" + COLUMN_REGIO_NAAM + " TEXT PRIMARY KEY, " + COLUMN_REGIO_BESCHRIJVING + " TEXT, " + COLUMN_HOOFD_REGIO + " TEXT, " + COLUMN_HOOFD_STAD + " TEXT, " + COLUMN_POPULATIE + " INTEGER, " + COLUMN_REGIO_VALUTA + " TEXT, " + COLUMN_REGIO_SOORT + " TEXT, " + COLUMN_ALARM_NUMMER + " TEXT)";
        db.execSQL(regioTableMakenStatement);

        // Landen toevoegen bij het maken van de database
        db.execSQL("INSERT INTO " + REGIO_TABLE + " VALUES ('Nederland', 'Een land is west Europa. Bekend van tulpen, kaas en klompen.', null, 'Amsterdam', '17000000', 'Euro', 'Land', '112')");
        db.execSQL("INSERT INTO " + REGIO_TABLE + " VALUES ('België', 'België ligt tussen Nederland en Frankrijk in. Het land staat bekend om hun chocolade en wafels.', null, 'Brussel', '11460000', 'Euro', 'Land', '112')");
        db.execSQL("INSERT INTO " + REGIO_TABLE + " VALUES ('Duitsland', 'Een van de grootste landen in Europa met een oppervlakte van 357.022 vierkante kilometer.', null, 'Berlijn', '80594017', 'Euro', 'Land', '112')");
        db.execSQL("INSERT INTO " + REGIO_TABLE + " VALUES ('Noord-Brabant', 'De mooiste provincie van heel Nederland.', 'Nederland', 'Den Bosch', '2500000', null, 'Provincie', null)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    // Methode maken om regio's toe te voegen aan de database
    public boolean regioToevoegen(Regio regio) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_REGIO_NAAM, regio.getRegioNaam());
        cv.put(COLUMN_REGIO_BESCHRIJVING, regio.getBeschrijving());
        cv.put(COLUMN_HOOFD_REGIO, regio.getHoofdRegio());
        cv.put(COLUMN_HOOFD_STAD, regio.getHoofdStad());
        cv.put(COLUMN_POPULATIE, regio.getPopulatie());
        cv.put(COLUMN_REGIO_VALUTA, regio.getRegioValuta());
        cv.put(COLUMN_REGIO_SOORT, regio.getRegioSoort());
        cv.put(COLUMN_ALARM_NUMMER, regio.getAlarmNummer());

        // Als het toevoegen succesvol is, krijg je 1 terug, anders -1
        long insert = db.insert(REGIO_TABLE, null, cv);

        if (insert == -1) {
            return false;
        } else {
            return true;
        }
    }

    // Een lijst maken welke weergegeven kan worden in de ListView
    // Deze lijst bevat ALLE regio's
    public List<String> regioLijstLaden() {

        // Een lijst maken welke wordt teruggegeven aan het einde van de methode
        List<String> returnList = new ArrayList<>();

        // StringQuery maken om de gewenste data uit de database op te halen
        String query = "SELECT * FROM " + REGIO_TABLE;

        SQLiteDatabase db = this.getReadableDatabase();

        // De cursor is een soort van ResultSet
        Cursor cursor = db.rawQuery(query, null);

        // Eerst kijken of er data opgehaald kan worden
        if (cursor.moveToFirst()) {

            // Vervolgens de data die wordt opgehaald in de return lijst plaatsten zolang er nieuwe data is
            do {
                String regioNaam = cursor.getString(0);
                String regioBeschrijving = cursor.getString(1);
                String hoofdRegio = cursor.getString(2);
                String hoofdStad = cursor.getString(3);
                Integer populatie = cursor.getInt(4);
                String regioValuta = cursor.getString(5);
                String regioSoort = cursor.getString(6);
                String alarmNummer = cursor.getString(7);

                Regio nieuweRegio = new Regio(regioNaam, regioBeschrijving, hoofdRegio, hoofdStad, populatie, regioValuta, regioSoort, alarmNummer);
                returnList.add(nieuweRegio.getRegioNaam());

            } while (cursor.moveToNext());

            // Anders gebeurt er niets
        } else {

        }

        // Connectie met de database sluiten (als je een lokale database al een connectie wilt noemen)
        cursor.close();
        db.close();

        return returnList;
    }

    public List<String> landenLijstLaden() {

        List<String> returnList = new ArrayList<>();
        String query = "SELECT * FROM " + REGIO_TABLE + " WHERE " + COLUMN_REGIO_SOORT + " = 'Land'";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        if (cursor.moveToFirst()) {
            do {
                String regioNaam = cursor.getString(0);
                String regioBeschrijving = cursor.getString(1);
                String hoofdRegio = cursor.getString(2);
                String hoofdStad = cursor.getString(3);
                Integer populatie = cursor.getInt(4);
                String regioValuta = cursor.getString(5);
                String regioSoort = cursor.getString(6);
                String alarmNummer = cursor.getString(7);
                Regio nieuwLand = new Regio(regioNaam, regioBeschrijving, hoofdRegio, hoofdStad, populatie, regioValuta, regioSoort, alarmNummer);
                returnList.add(nieuwLand.getRegioNaam());
            } while (cursor.moveToNext());
        } else {

        }
        cursor.close();
        db.close();
        return  returnList;
    }

    public Regio geselecteerdeRegioLaden(String landNaam) {

        Regio geselecteerdLand;
        String query = "SELECT * FROM " + REGIO_TABLE + " WHERE " + COLUMN_REGIO_NAAM + " = '" + landNaam + "'";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        if (cursor.moveToFirst()) {
            String regioNaam = cursor.getString(0);
            String regioBeschrijving = cursor.getString(1);
            String hoofdRegio = cursor.getString(2);
            String hoofdStad = cursor.getString(3);
            Integer populatie = cursor.getInt(4);
            String regioValuta = cursor.getString(5);
            String regioSoort = cursor.getString(6);
            String alarmNummer = cursor.getString(7);
            geselecteerdLand = new Regio(regioNaam, regioBeschrijving, hoofdRegio, hoofdStad, populatie, regioValuta, regioSoort, alarmNummer);
        } else {
            geselecteerdLand = new Regio("fout", null, null, null, null, null, null, null);
        }
        cursor.close();
        db.close();
        return geselecteerdLand;
    }
}
