package com.casperdaris.beroepsproductgroepc.Activities;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.casperdaris.beroepsproductgroepc.DataBaseHelper;
import com.casperdaris.beroepsproductgroepc.DatabaseHelpers.DatabaseHelper;
import com.casperdaris.beroepsproductgroepc.DatabaseHelpers.DatabaseHelperBezienswaardigheid;
import com.casperdaris.beroepsproductgroepc.DatabaseHelpers.DatabaseHelperRegio;
import com.casperdaris.beroepsproductgroepc.DatabaseHelpers.DatabaseHelperReligie;
import com.casperdaris.beroepsproductgroepc.DatabaseHelpers.DatabaseHelperSpecialiteit;
import com.casperdaris.beroepsproductgroepc.DatabaseHelpers.DatabaseHelperSport;
import com.casperdaris.beroepsproductgroepc.DatabaseHelpers.DatabaseHelperTaal;
import com.casperdaris.beroepsproductgroepc.Objecten.Bezienswaardigheid;
import com.casperdaris.beroepsproductgroepc.Objecten.Regio;
import com.casperdaris.beroepsproductgroepc.Objecten.Stad;
import com.casperdaris.beroepsproductgroepc.R;

public class StadInfo extends AppCompatActivity {
    private ImageButton main_btn, help_btn;
    private TextView naam;
    TextView tvbetaling, tvbezienswaardigheid, tvbeschrijving, tvregio;
    private Bezienswaardigheid geselecteerdeStad;
    private DatabaseHelper databaseHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stad_info);
            main_btn = (ImageButton) findViewById(R.id.backbutton_stad) ;
            help_btn = (ImageButton) findViewById(R.id.helpbutton_stad) ;
            naam= findViewById(R.id.naam_stad_gekozenplek);


            Bundle bundle = getIntent().getExtras();
            String Title= bundle.getString("landNaam");
            if (bundle != null) {


                databaseHelper = new DatabaseHelper(this);
                geselecteerdeStad = databaseHelper.geselecteerdeStadBezienswaardigheid(bundle.getString("landNaam"));

                tvbezienswaardigheid= (TextView) findViewById(R.id.bezienswaardigheidVanStad);
                tvbezienswaardigheid.setText(geselecteerdeStad.getBezienswaardigheidNaam());
                tvbeschrijving= (TextView) findViewById(R.id.bescrijvingVanStad);
                tvbeschrijving.setText(geselecteerdeStad.getBeschrijving());
                tvregio= (TextView) findViewById(R.id.RegioVanStad);
                tvregio.setText(geselecteerdeStad.getRegio());
                tvbetaling= (TextView) findViewById(R.id.betalingVanStad);
                tvbetaling.setText(geselecteerdeStad.getBetaling());
            }
            naam.setText(Title);

            main_btn.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    Intent i=new Intent(StadInfo.this, RegioActivity.class);
                    i.putExtras(bundle);
                    startActivity(i);
                }
            });

            help_btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AlertDialog.Builder builder1 = new AlertDialog.Builder(StadInfo.this);
                    builder1.setTitle("Help");
                    builder1.setMessage("Hier ligt informatie of de gekozen Stad en kan je meer over de gekozen Stad vinden.");
                    builder1.setCancelable(true);
                    AlertDialog alert11 = builder1.create();
                    alert11.show();

                }
            });
        }
    }

