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

public class DatabaseHelper extends SQLiteOpenHelper {

    // Deze strings zijn de namen van een tabel en columns in de database
    private static final String REGIO_TABLE = "REGIO_TABLE";
    private static final String COLUMN_REGIO_NAAM = "REGIO_NAAM";
    private static final String COLUMN_REGIO_BESCHRIJVING = "REGIO_BESCHRIJVING";
    private static final String COLUMN_HOOFD_REGIO = "HOOFD_REGIO";
    private static final String COLUMN_HOOFD_STAD = "HOOFD_STAD";
    private static final String COLUMN_POPULATIE = "POPULATIE";
    private static final String COLUMN_REGIO_VALUTA = "REGIO_VALUTA";
    private static final String COLUMN_REGIO_SOORT = "REGIO_SOORT";
    private static final String COLUMN_ALARM_NUMMER = "ALARM_NUMMER";

    private static final String BEZIENSWAARDIGHEID_TABLE = "BEZIENSWAARDIGHEID_TABLE";
    private static final String COLUMN_BEZ_NAAM = "BEZIENSWAARDIGHEID_NAAM";
    private static final String COLUMN_BEZ_REGIO = "BEZIENSWAARDIGHEID_REGIO";
    private static final String COLUMN_BEZ_STAD = "BEZIENSWAARDIGHEID_STAD";
    private static final String COLUMN_BEZ_BETALING = "BEZIENSWAARDIGHEID_BETALING";
    private static final String COLUMN_BEZ_BESCH = "BEZIENSWAARDIGHEID_BESCHRIJVING";

    private static final String RELIGIE_TABLE = "RELIGIE_TABLE";
    private static final String RELIGIE_KOPPEL_TABLE = "RELIGIE_KOPPEL_TABLE";
    private static final String COLUMN_RELIGIE_NAAM = "RELIGIE_NAAM";
    private static final String COLUMN_RELIGIE_REGIO = "RELIGIE_REGIO";
    private static final String COLUMN_RELIGIE_PERCENTAGE = "RELIGIE_PERCENTAGE";

    private static final String SPORT_TABLE = "SPORT_TABLE";
    private static final String SPORT_KOPPEL_TABLE = "SPORT_KOPPEL_TABLE";
    private static final String COLUMN_SPORT_NAAM = "SPORT_NAAM";
    private static final String COLUMN_SPORT_REGIO = "SPORT_REGIO";

    private static final String SPECIALITEIT_TABLE = "SPECIALITEIT_TABLE";
    private static final String SPECIALITEIT_KOPPEL_TABLE = "SPECIALITEIT_KOPPEL_TABLE";
    private static final String COLUMN_SPECIALITEIT_NAAM = "SPECIALITEIT_NAAM";
    private static final String COLUMN_SPECIALITEIT_REGIO = "SPECIALITEIT_REGIO";

    private static final String STEDEN_TABLE = "STAD_TABLE";
    private static final String COLUMN_STAD_NAAM = "STAD_NAAM";

    private static final String TAAL_TABLE = "TAAL_TABLE";
    private static final String TAAL_KOPPEL_TABLE = "TAAL_KOPPEL_TABLE";
    private static final String COLUMN_TAAL_NAAM = "TAAL_NAAM";
    private static final String COLUMN_TAAL_REGIO = "TAAL_REGIO";
    private static final String COLUMN_TAAL_PERCENTAGE = "TAAL_PERCENTAGE";

    private static final String VALUTA_TABLE = "VALUTA_TABLE";

    private static final String SOORT_TABLE = "SOORT_TABLE";

    public DatabaseHelper(@Nullable Context context) {
        super(context, "regioDatabase", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        // Een string aanmaken om vervolgens een tabel mee te maken in de database
        String regioTableMakenStatement = "CREATE TABLE " + REGIO_TABLE + " (" + COLUMN_REGIO_NAAM + " TEXT PRIMARY KEY, " + COLUMN_REGIO_BESCHRIJVING + " TEXT, " + COLUMN_HOOFD_REGIO + " TEXT, " + COLUMN_HOOFD_STAD + " TEXT, " + COLUMN_POPULATIE + " INTEGER, " + COLUMN_REGIO_VALUTA + " TEXT, " + COLUMN_REGIO_SOORT + " TEXT, " + COLUMN_ALARM_NUMMER + " TEXT, FOREIGN KEY (" + COLUMN_REGIO_SOORT + ") REFERENCES SOORT_TABLE(REGIO_SOORT), FOREIGN KEY (" + COLUMN_REGIO_VALUTA + ") REFERENCES VALUTA_TABLE(REGIO_VALUTA));";
        db.execSQL(regioTableMakenStatement);

        String bezienswaardigheidTableMakenStatement = "CREATE TABLE " + BEZIENSWAARDIGHEID_TABLE + " (" + COLUMN_BEZ_NAAM + " TEXT PRIMARY KEY, " + COLUMN_BEZ_BESCH + " TEXT, " + COLUMN_BEZ_REGIO + " TEXT, " + COLUMN_BEZ_STAD + " TEXT, " + COLUMN_BEZ_BETALING + " TEXT, FOREIGN KEY (" + COLUMN_BEZ_REGIO + ") REFERENCES REGIO_TABLE(REGIO_NAAM));";
        db.execSQL(bezienswaardigheidTableMakenStatement);

        String religieTableMakenStatement = "CREATE TABLE " + RELIGIE_TABLE + " (" + COLUMN_RELIGIE_NAAM + " TEXT PRIMARY KEY);";
        db.execSQL(religieTableMakenStatement);

        String religieKoppelTableMakenStatement = "CREATE TABLE " + RELIGIE_KOPPEL_TABLE + " (" + COLUMN_RELIGIE_NAAM + " TEXT, " + COLUMN_RELIGIE_REGIO + " TEXT, " + COLUMN_RELIGIE_PERCENTAGE + " REAL, FOREIGN KEY (" + COLUMN_RELIGIE_REGIO + ") REFERENCES REGIO_TABLE(REGIO_NAAM), FOREIGN KEY (" + COLUMN_RELIGIE_NAAM + ") REFERENCES RELIGIE_TABLE(RELIGIE_NAAM));";
        db.execSQL(religieKoppelTableMakenStatement);

        String sportTableMakenStatement = "CREATE TABLE " + SPORT_TABLE + " (" + COLUMN_SPORT_NAAM + " TEXT PRIMARY KEY);";
        db.execSQL(sportTableMakenStatement);

        String sportKoppelTableMakenStatement = "CREATE TABLE " + SPORT_KOPPEL_TABLE + " (" + COLUMN_SPORT_NAAM + " TEXT, " + COLUMN_SPORT_REGIO + " TEXT, FOREIGN KEY (" + COLUMN_SPORT_REGIO + ") REFERENCES REGIO_TABLE(REGIO_NAAM), FOREIGN KEY (" + COLUMN_SPORT_NAAM + ") REFERENCES SPORT_TABLE(SPORT_NAAM));";
        db.execSQL(sportKoppelTableMakenStatement);

        String specialiteitTableMakenStatement = "CREATE TABLE " + SPECIALITEIT_TABLE + " (" + COLUMN_SPECIALITEIT_NAAM + "TEXT PRIMARY KEY);";
        db.execSQL(specialiteitTableMakenStatement);

        String specialiteitKoppelTableMakenStatement = "CREATE TABLE " + SPECIALITEIT_KOPPEL_TABLE + " (" + COLUMN_SPECIALITEIT_NAAM + " TEXT, " + COLUMN_SPECIALITEIT_REGIO + " TEXT, FOREIGN KEY (" + COLUMN_SPECIALITEIT_REGIO + ") REFERENCES REGIO_TABLE(REGIO_NAAM), FOREIGN KEY (" + COLUMN_SPECIALITEIT_NAAM + ") REFERENCES SPECIALITEIT_TABLE(SPECIALITEIT_NAAM));";
        db.execSQL(specialiteitKoppelTableMakenStatement);

        String stedenTableMakenStatement = "CREATE TABLE " + STEDEN_TABLE + " (" + COLUMN_STAD_NAAM + " TEXT);";
        db.execSQL(stedenTableMakenStatement);

        String taalTableMakenStatement = "CREATE TABLE " + TAAL_TABLE + " (" + COLUMN_TAAL_NAAM + " TEXT);";
        db.execSQL(taalTableMakenStatement);

        String taalKoppelTableMakenStatement = "CREATE TABLE " + TAAL_KOPPEL_TABLE + " (" + COLUMN_TAAL_NAAM + " TEXT, " + COLUMN_TAAL_REGIO + " TEXT, " + COLUMN_TAAL_PERCENTAGE + " REAL, FOREIGN KEY (" + COLUMN_TAAL_REGIO + ") REFERENCES REGIO_TABLE(REGIO_NAAM), FOREIGN KEY (" + COLUMN_TAAL_NAAM + ") REFERENCES TAAL_TABLE(TAAL_NAAM));";
        db.execSQL(taalKoppelTableMakenStatement);

        String valutaTableMakenStatement = "CREATE TABLE " + VALUTA_TABLE + " (" + COLUMN_REGIO_VALUTA + " TEXT PRIMARY KEY);";
        db.execSQL(valutaTableMakenStatement);
        db.execSQL("INSERT INTO " + VALUTA_TABLE + " VALUES ('Euro')");
        db.execSQL("INSERT INTO " + VALUTA_TABLE + " VALUES ('Dollar')");
        db.execSQL("INSERT INTO " + VALUTA_TABLE + " VALUES ('Pond')");
        db.execSQL("INSERT INTO " + VALUTA_TABLE + " VALUES ('Yen')");
        db.execSQL("INSERT INTO " + VALUTA_TABLE + " VALUES ('Dinar')");
        db.execSQL("INSERT INTO " + VALUTA_TABLE + " VALUES ('Kroon')");

        String soortTableMakenStatement = "CREATE TABLE " + SOORT_TABLE + " (" + COLUMN_REGIO_SOORT + " TEXT PRIMARY KEY);";
        db.execSQL(soortTableMakenStatement);
        db.execSQL("INSERT INTO " + SOORT_TABLE + " VALUES ('Land');");
        db.execSQL("INSERT INTO " + SOORT_TABLE + " VALUES ('Provincie');");
        db.execSQL("INSERT INTO " + SOORT_TABLE + " VALUES ('Omgeving');");

        // Landen toevoegen bij het maken van de database
        db.execSQL("INSERT INTO " + REGIO_TABLE + " VALUES ('Nederland', 'Een land is west Europa. Bekend van tulpen, kaas en klompen.', null, 'Amsterdam', '17000000', 'Euro', 'Land', '112')");
        db.execSQL("INSERT INTO " + REGIO_TABLE + " VALUES ('België', 'België ligt tussen Nederland en Frankrijk in. Het land staat bekend om hun chocolade en wafels.', null, 'Brussel', '11460000', 'Euro', 'Land', '112')");
        db.execSQL("INSERT INTO " + REGIO_TABLE + " VALUES ('Duitsland', 'Een van de grootste landen in Europa met een oppervlakte van 357.022 vierkante kilometer.', null, 'Berlijn', '80594017', 'Euro', 'Land', '112')");
        db.execSQL("INSERT INTO " + REGIO_TABLE + " VALUES ('Noord-Brabant', 'De mooiste provincie van heel Nederland.', 'Nederland', 'Den Bosch', '2500000', null, 'Provincie', null)");

        db.execSQL("INSERT INTO " + BEZIENSWAARDIGHEID_TABLE + " VALUES ('De Domtoren', 'Een gotische kerk in Utrecht. Gebouwd vanaf 1254.', 'Nederland', 'Utrecht', null)");

        db.execSQL("INSERT INTO " + RELIGIE_TABLE + " VALUES ('Rooms-katholiek'), ('Protestants'), ('Islamitisch')");

        db.execSQL("INSERT INTO " + RELIGIE_KOPPEL_TABLE + " VALUES ('Rooms-katholiek', 'Nederland', 24.00)");
        db.execSQL("INSERT INTO " + RELIGIE_KOPPEL_TABLE + " VALUES ('Protestants', 'Nederland', 15.00)");
        db.execSQL("INSERT INTO " + RELIGIE_KOPPEL_TABLE + " VALUES ('Islamitisch', 'Nederland', 5.00)");

        db.execSQL("INSERT INTO " + SPORT_TABLE + " VALUES ('Schaatsen'), ('Voetbal'), ('Atletiek')");

        db.execSQL("INSERT INTO " + SPORT_KOPPEL_TABLE + " VALUES ('Schaatsen', 'Nederland')");
        db.execSQL("INSERT INTO " + SPORT_KOPPEL_TABLE + " VALUES ('Voetbal', 'Nederland')");
        db.execSQL("INSERT INTO " + SPORT_KOPPEL_TABLE + " VALUES ('Atletiek', 'Nederland')");

        db.execSQL("INSERT INTO " + SPECIALITEIT_TABLE + " VALUES ('Kaas')");

        db.execSQL("INSERT INTO " + SPECIALITEIT_KOPPEL_TABLE + " VALUES ('Kaas', 'Nederland')");

        db.execSQL("INSERT INTO " + STEDEN_TABLE + " VALUES ('Utrecht')");
        db.execSQL("INSERT INTO " + STEDEN_TABLE + " VALUES ('Amsterdam')");
        db.execSQL("INSERT INTO " + STEDEN_TABLE + " VALUES ('Londen')");
        db.execSQL("INSERT INTO " + STEDEN_TABLE + " VALUES ('Parijs')");
        db.execSQL("INSERT INTO " + STEDEN_TABLE + " VALUES ('Madrid')");

        db.execSQL("INSERT INTO " + TAAL_KOPPEL_TABLE + " VALUES ('Nederlands', 'Nederland', 95.00)");
        db.execSQL("INSERT INTO " + TAAL_KOPPEL_TABLE + " VALUES ('Engels', 'Nederland', 75.00)");

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
