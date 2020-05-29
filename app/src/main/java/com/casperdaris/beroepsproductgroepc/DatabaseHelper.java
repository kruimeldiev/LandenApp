package com.casperdaris.beroepsproductgroepc;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import com.casperdaris.beroepsproductgroepc.Objecten.Regio;
import com.casperdaris.beroepsproductgroepc.Objecten.Religie;
import com.casperdaris.beroepsproductgroepc.Objecten.Taal;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {

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

    public static final String BEZIENSWAARDIGHEID_TABLE = "BEZIENSWAARDIGHEID_TABLE";
    public static final String COLUMN_BEZ_NAAM = "BEZIENSWAARDIGHEID_NAAM";
    public static final String COLUMN_BEZ_REGIO = "BEZIENSWAARDIGHEID_REGIO";
    public static final String COLUMN_BEZ_STAD = "BEZIENSWAARDIGHEID_STAD";
    public static final String COLUMN_BEZ_BETALING = "BEZIENSWAARDIGHEID_BETALING";
    public static final String COLUMN_BEZ_BESCH = "BEZIENSWAARDIGHEID_BESCHRIJVING";

    public static final String STEDEN_TABLE = "STAD_TABLE";
    public static final String COLUMN_STAD_NAAM = "STAD_NAAM";
    public static final String COLUMN_STAD_REGIO = "STAD_REGIO";

    public static final String SPECIALITEIT_TABLE = "SPECIALITEIT_TABLE";
    public static final String COLUMN_SPECIALITEIT_NAAM = "SPECIALITEIT_NAAM";
    public static final String COLUMN_SPECIALITEIT_REGIO = "SPECIALITEIT_REGIO";

    public static final String SPORT_TABLE = "SPORT_TABLE";
    public static final String COLUMN_SPORT_NAAM = "SPORT_NAAM";
    public static final String COLUMN_SPORT_REGIO = "SPORT_REGIO";

    public static final String RELIGIE_TABLE = "RELIGIE_TABLE";
    public static final String COLUMN_RELIGIE_NAAM = "RELIGIE_NAAM";
    public static final String COLUMN_RELIGIE_REGIO = "RELIGIE_REGIO";
    public static final String COLUMN_RELIGIE_PERCENTAGE = "RELIGIE_PERCENTAGE";

    public static final String TAAL_TABLE = "TAAL_TABLE";
    public static final String COLUMN_TAAL_NAAM = "TAAL_NAAM";
    public static final String COLUMN_TAAL_REGIO = "TAAL_REGIO";
    public static final String COLUMN_TAAL_PERCENTAGE = "TAAL_PERCENTAGE";

    public DatabaseHelper(@Nullable Context context) {
        super(context, "regioDatabase", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        // Een string aanmaken om vervolgens een tabel mee te maken in de database
        String regioTableMakenStatement = "CREATE TABLE " + REGIO_TABLE + " (" + COLUMN_REGIO_NAAM + " TEXT PRIMARY KEY, " + COLUMN_REGIO_BESCHRIJVING + " TEXT, " + COLUMN_HOOFD_REGIO + " TEXT, " + COLUMN_HOOFD_STAD + " TEXT, " + COLUMN_POPULATIE + " INTEGER, " + COLUMN_REGIO_VALUTA + " TEXT, " + COLUMN_REGIO_SOORT + " TEXT, " + COLUMN_ALARM_NUMMER + " TEXT)";
        db.execSQL(regioTableMakenStatement);

        String bezienswaardigheidTableMakenStatement = "CREATE TABLE " + BEZIENSWAARDIGHEID_TABLE + " (" + COLUMN_BEZ_NAAM + " TEXT PRIMARY KEY, " + COLUMN_BEZ_BESCH + " TEXT, " + COLUMN_BEZ_REGIO + " TEXT, " + COLUMN_BEZ_STAD + " TEXT, " + COLUMN_BEZ_BETALING + "TEXT)";
        db.execSQL(bezienswaardigheidTableMakenStatement);

        String stedenTableMakenStatement = "CREATE TABLE " + STEDEN_TABLE + " (" + COLUMN_STAD_NAAM + " TEXT PRIMARY KEY, " + COLUMN_STAD_REGIO + " TEXT)";
        db.execSQL(stedenTableMakenStatement);

        String specialiteitTableMakenStatement = "CREATE TABLE " + SPECIALITEIT_TABLE + " (" + COLUMN_SPECIALITEIT_NAAM + " TEXT PRIMARY KEY, " + COLUMN_SPECIALITEIT_REGIO + " TEXT)";
        db.execSQL(specialiteitTableMakenStatement);

        String sportTableMakenStatement = "CREATE TABLE " + SPORT_TABLE + " (" + COLUMN_SPORT_NAAM + " TEXT PRIMARY KEY, " + COLUMN_SPORT_REGIO + " TEXT)";
        db.execSQL(sportTableMakenStatement);

        String religieTableMakenStatement = "CREATE TABLE " + RELIGIE_TABLE + " (" + COLUMN_RELIGIE_NAAM + " TEXT PRIMARY KEY, " + COLUMN_RELIGIE_REGIO + " TEXT, " + COLUMN_RELIGIE_PERCENTAGE + " REAL)";
        db.execSQL(religieTableMakenStatement);

        String taalTableMakenStatement = "CREATE TABLE " + TAAL_TABLE + " (" + COLUMN_TAAL_NAAM + " TEXT PRIMARY KEY, " + COLUMN_TAAL_REGIO + " TEXT, " + COLUMN_TAAL_PERCENTAGE + " REAL)";
        db.execSQL(taalTableMakenStatement);

        // Landen toevoegen bij het maken van de database
        db.execSQL("INSERT INTO " + REGIO_TABLE + " VALUES ('Nederland', 'Een land is west Europa. Bekend van tulpen, kaas en klompen.', null, 'Amsterdam', '17000000', 'Euro', 'Land', '112')");
        db.execSQL("INSERT INTO " + REGIO_TABLE + " VALUES ('België', 'België ligt tussen Nederland en Frankrijk in. Het land staat bekend om hun chocolade en wafels.', null, 'Brussel', '11460000', 'Euro', 'Land', '112')");
        db.execSQL("INSERT INTO " + REGIO_TABLE + " VALUES ('Duitsland', 'Een van de grootste landen in Europa met een oppervlakte van 357.022 vierkante kilometer.', null, 'Berlijn', '80594017', 'Euro', 'Land', '112')");
        db.execSQL("INSERT INTO " + REGIO_TABLE + " VALUES ('Noord-Brabant', 'De mooiste provincie van heel Nederland.', 'Nederland', 'Den Bosch', '2500000', null, 'Provincie', null)");

        db.execSQL("INSERT INTO " + TAAL_TABLE + " VALUES ('Nederlands', 'Nederland', 92.0 )");
        db.execSQL("INSERT INTO " + TAAL_TABLE + " VALUES ('Duits', 'Duitsland', 92.0 )");
        db.execSQL("INSERT INTO " + TAAL_TABLE + " VALUES ('Frans', 'Frankrijk', 92.0 )");
        db.execSQL("INSERT INTO " + TAAL_TABLE + " VALUES ('Portugees', 'Portugal', 92.0 )");
        db.execSQL("INSERT INTO " + TAAL_TABLE + " VALUES ('Spaans', 'Spanje', 92.0 )");
        db.execSQL("INSERT INTO " + TAAL_TABLE + " VALUES ('Italiaans', 'Italië', 92.0 )");
        db.execSQL("INSERT INTO " + TAAL_TABLE + " VALUES ('Turks', 'Turkije', 92.0 )");
        db.execSQL("INSERT INTO " + TAAL_TABLE + " VALUES ('Grieks', 'Griekenland', 92.0 )");

        db.execSQL("INSERT INTO " + RELIGIE_TABLE + " VALUES ('Rooms-Katholiek', 'Portugal', 92.0 )");
        db.execSQL("INSERT INTO " + RELIGIE_TABLE + " VALUES ('Orthodox-Katholiek', 'Spanje', 92.0 )");
        db.execSQL("INSERT INTO " + RELIGIE_TABLE + " VALUES ('Protestants-Christelijk', 'Portugal', 92.0 )");
        db.execSQL("INSERT INTO " + RELIGIE_TABLE + " VALUES ('Islamitisch', 'Spanje', 92.0 )");
        db.execSQL("INSERT INTO " + RELIGIE_TABLE + " VALUES ('Joods', 'Portugal', 92.0 )");
        db.execSQL("INSERT INTO " + RELIGIE_TABLE + " VALUES ('Boeddhisme', 'Spanje', 92.0 )");
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
        return returnList;
    }

    public Regio geselecteerdLandLaden(String landNaam) {

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


    /**
     * Methode voor het ophalen van een lijst met alle unieke talen in de database
     *
     * @return List met talen
     */
    public List<Taal> getTalen() {
        List<Taal> talen = new ArrayList<>();
        String query = "SELECT DISTINCT " + COLUMN_TAAL_NAAM + " FROM " + TAAL_TABLE;
        try (SQLiteDatabase db = getWritableDatabase(); Cursor cursor = db.rawQuery(query, null)) {
            while (cursor.moveToNext()) {
                Taal taal = new Taal(cursor.getString(cursor.getColumnIndex(COLUMN_TAAL_NAAM)));
                talen.add(taal);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return talen;
    }

    /**
     * Methode voor het ophalen van een lijst met alle unieke religies in de database
     *
     * @return List met religies
     */
    public List<Religie> getReligies() {
        List<Religie> religies = new ArrayList<>();
        String query = "SELECT DISTINCT " + COLUMN_RELIGIE_NAAM + " FROM " + RELIGIE_TABLE;
        try (SQLiteDatabase db = getWritableDatabase(); Cursor cursor = db.rawQuery(query, null)) {
            while (cursor.moveToNext()) {
                Religie religie = new Religie(cursor.getString(cursor.getColumnIndex(COLUMN_RELIGIE_NAAM)));
                religies.add(religie);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return religies;
    }
}
