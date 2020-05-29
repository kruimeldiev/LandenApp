package com.casperdaris.beroepsproductgroepc.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.casperdaris.beroepsproductgroepc.DatabaseHelpers.DatabaseHelper;
import com.casperdaris.beroepsproductgroepc.Objecten.Regio;
import com.casperdaris.beroepsproductgroepc.R;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Button testKnop, toevoegKnop;
    private EditText regioNaamEditText, regioBeschrijvingEditText, regioHoofdstadEditText, regioPopulatieEditText, regioAlarmnummerEditText;
    private Spinner hoofdRegioSpinner, valutaSpinner, soortSpinner;

    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        databaseHelper = new DatabaseHelper(MainActivity.this);

        testKnop = findViewById(R.id.naarTabButton);
        toevoegKnop = findViewById(R.id.regioToevoegKnop);
        regioNaamEditText = findViewById(R.id.regioNaamEditText);
        regioBeschrijvingEditText = findViewById(R.id.regioBeschrijvingEditText);
        hoofdRegioSpinner = findViewById(R.id.hoofdRegioSpinner);
        regioHoofdstadEditText = findViewById(R.id.hoofdStadEditText);
        regioPopulatieEditText = findViewById(R.id.populatieEditText);
        valutaSpinner = findViewById(R.id.valutaSpinner);
        soortSpinner = findViewById(R.id.soortSpinner);
        regioAlarmnummerEditText = findViewById(R.id.alarmNummerEditText);

        testKnop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), LandenLijstActivity.class);
                startActivity(i);
            }
        });

        // De data voor de hoofdregio spinner ophalen
        List<String> alleLanden = databaseHelper.landenLijstLaden();
        ArrayAdapter<String> hoofdRegioSpinnerAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, alleLanden);
        hoofdRegioSpinner.setAdapter(hoofdRegioSpinnerAdapter);

        // Adapter voor de valuta spinner maken
        ArrayAdapter<CharSequence> valutaSpinnerAdapter = ArrayAdapter.createFromResource(this, R.array.valuta, android.R.layout.simple_spinner_item);
        valutaSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        valutaSpinner.setAdapter(valutaSpinnerAdapter);

        // Adapter maken voor de regio soort spinner
        ArrayAdapter<CharSequence> regioSoortSpinnerAdapter = ArrayAdapter.createFromResource(this, R.array.regioSoort, android.R.layout.simple_spinner_item);
        regioSoortSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        soortSpinner.setAdapter(regioSoortSpinnerAdapter);

        toevoegKnop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Regio maken om aan database toe te voegen
                Regio regio;

                // Proberen om een nieuwe regio aan te maken, anders een foutmelding geven
                try {
                    regio = new Regio(regioNaamEditText.getText().toString(), regioBeschrijvingEditText.getText().toString(), hoofdRegioSpinner.getSelectedItem().toString(), regioHoofdstadEditText.getText().toString(), Integer.parseInt(regioPopulatieEditText.getText().toString()), valutaSpinner.getSelectedItem().toString(), soortSpinner.getSelectedItem().toString(), regioAlarmnummerEditText.getText().toString());
                    Toast.makeText(MainActivity.this, "Regio toevoegen gelukt", Toast.LENGTH_LONG).show();

                    // De database helper gebruiken om een nieuwe regio toe te voegen aan de database
                    databaseHelper.regioToevoegen(regio);
                } catch (Exception e) {
                    Toast.makeText(MainActivity.this, "Er is een fout opgetreden", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
