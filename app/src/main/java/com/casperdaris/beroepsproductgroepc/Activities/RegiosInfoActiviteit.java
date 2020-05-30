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
            geselecteerdeRegio = databaseHelperregio.geselecteerdeRegioLaden(bundle.getString("landNaam"));


            tvvaluta= (TextView) findViewById(R.id.valutaVanRegio_infoactiviteit);
            tvvaluta.setText(geselecteerdeRegio.getRegioValuta());
            tvhoofdstad= (TextView) findViewById(R.id.hoofdstadVanRegio_infoactiviteit);
            tvhoofdstad.setText(geselecteerdeRegio.getHoofdStad());
            tvreligie= (TextView) findViewById(R.id.religieVanRegio_infoactiviteit);
            tvsport= (TextView) findViewById(R.id.sportVanRegio_infoactiviteit);
            tvspecialiteit= (TextView) findViewById(R.id.specialiteitVanRegio_infoactiviteit);
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
                builder1.setMessage("Hier ligt informatie of de gekozen Regio en kan je meer over de gekozen regio.");
                builder1.setCancelable(true);
                AlertDialog alert11 = builder1.create();
                alert11.show();

            }
        });
    }
}
