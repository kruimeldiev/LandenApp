package com.casperdaris.beroepsproductgroepc.Activities;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.casperdaris.beroepsproductgroepc.DatabaseHelpers.DatabaseHelperRegio;
import com.casperdaris.beroepsproductgroepc.DatabaseHelpers.DatabaseHelperReligie;
import com.casperdaris.beroepsproductgroepc.DatabaseHelpers.DatabaseHelperSpecialiteit;
import com.casperdaris.beroepsproductgroepc.DatabaseHelpers.DatabaseHelperSport;
import com.casperdaris.beroepsproductgroepc.DatabaseHelpers.DatabaseHelperTaal;
import com.casperdaris.beroepsproductgroepc.Objecten.Regio;
import com.casperdaris.beroepsproductgroepc.Objecten.RegioReligie;
import com.casperdaris.beroepsproductgroepc.Objecten.RegioSpecialiteit;
import com.casperdaris.beroepsproductgroepc.Objecten.RegioSport;
import com.casperdaris.beroepsproductgroepc.R;

public class RegiosInfoActiviteit extends AppCompatActivity {
    private ImageButton main_btn, help_btn;
    private TextView naam;
    TextView tvtaal, tvvaluta, tvhoofdstad, tvreligie, tvsport, tvspecialiteit;
    private Regio geselecteerdeRegio;
    private DatabaseHelperRegio databaseHelperregio;
    private DatabaseHelperReligie databaseHelperReligie;
    private DatabaseHelperSpecialiteit databaseHelperSpecialiteit;
    private String geselecteerdeSportRegio,geselecteerdeTaalRegio, geselecteerdeReligieRegio, geselecteerdeSpecialiteitRegio;
    private DatabaseHelperSport databaseHelperSport;
    private DatabaseHelperTaal databaseHelperTaal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regios_info_activiteit);
        main_btn = (ImageButton) findViewById(R.id.backbutton_regios_info_activiteit) ;
        help_btn = (ImageButton) findViewById(R.id.helpbutton_regios_info_activiteit) ;
        naam= findViewById(R.id.naam_regios_gekozenplek);


         Bundle bundle = getIntent().getExtras();
        String Title= bundle.getString("landNaam");
        if (bundle != null) {


            databaseHelperregio = new DatabaseHelperRegio(this);
            databaseHelperReligie = new DatabaseHelperReligie(this);
            databaseHelperSpecialiteit = new DatabaseHelperSpecialiteit(this);
            databaseHelperSport = new DatabaseHelperSport(this);
            databaseHelperTaal= new DatabaseHelperTaal(this);
            geselecteerdeRegio = databaseHelperregio.geselecteerdeRegioLaden(bundle.getString("landNaam"));
            geselecteerdeReligieRegio = databaseHelperReligie.geselecteerdeRegio(bundle.getString("landNaam"));
            geselecteerdeSpecialiteitRegio = databaseHelperSpecialiteit.geselecteerdeRegio(bundle.getString("landNaam"));
            geselecteerdeSportRegio = databaseHelperSport.geselecteerdeRegio(bundle.getString("landNaam"));
            geselecteerdeTaalRegio = databaseHelperTaal.geselecteerdeRegio(bundle.getString("landNaam"));

            tvtaal= (TextView) findViewById(R.id.taalVanRegio_infoactiviteit);
            tvtaal.setText(geselecteerdeTaalRegio);
            tvvaluta= (TextView) findViewById(R.id.valutaVanRegio_infoactiviteit);
            tvvaluta.setText(geselecteerdeRegio.getRegioValuta());
            tvhoofdstad= (TextView) findViewById(R.id.hoofdstadVanRegio_infoactiviteit);
            tvhoofdstad.setText(geselecteerdeRegio.getHoofdStad());
            tvreligie= (TextView) findViewById(R.id.religieVanRegio_infoactiviteit);
            tvreligie.setText(geselecteerdeReligieRegio);
            tvsport= (TextView) findViewById(R.id.sportVanRegio_infoactiviteit);
            tvsport.setText(geselecteerdeSportRegio);
            tvspecialiteit= (TextView) findViewById(R.id.specialiteitVanRegio_infoactiviteit);
            tvspecialiteit.setText(geselecteerdeSpecialiteitRegio);
        }


        naam.setText(Title);

        main_btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent i=new Intent(RegiosInfoActiviteit.this, RegioActivity.class);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        help_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder1 = new AlertDialog.Builder(RegiosInfoActiviteit.this);
                builder1.setTitle("Help");
                builder1.setMessage("Hier ligt informatie of de gekozen Regio en kan je meer over de gekozen regio vinden.");
                builder1.setCancelable(true);
                AlertDialog alert11 = builder1.create();
                alert11.show();

            }
        });
    }
}
