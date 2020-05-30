package com.casperdaris.beroepsproductgroepc.Activities;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.casperdaris.beroepsproductgroepc.DatabaseHelpers.DatabaseHelperRegio;
import com.casperdaris.beroepsproductgroepc.DatabaseHelpers.DatabaseHelperReligie;
import com.casperdaris.beroepsproductgroepc.DatabaseHelpers.DatabaseHelperSpecialiteit;
import com.casperdaris.beroepsproductgroepc.DatabaseHelpers.DatabaseHelperSport;
import com.casperdaris.beroepsproductgroepc.Fragments.RegioInformatieTab;
import com.casperdaris.beroepsproductgroepc.Fragments.RegioRegioTab;
import com.casperdaris.beroepsproductgroepc.Objecten.Regio;
import com.casperdaris.beroepsproductgroepc.Objecten.RegioReligie;
import com.casperdaris.beroepsproductgroepc.Objecten.RegioSpecialiteit;
import com.casperdaris.beroepsproductgroepc.Objecten.RegioSport;
import com.casperdaris.beroepsproductgroepc.R;
import com.casperdaris.beroepsproductgroepc.Adapters.RegioAdapter;
import com.google.android.material.tabs.TabLayout;

public class RegioActivity extends AppCompatActivity {

    private TextView naamVanRegio, beschrijvingVanRegio;
    private ImageView informatie_btn, back_btn;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    private DatabaseHelperRegio databaseHelperRegio;

    private Regio geselecteerdeRegio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regio);

        naamVanRegio = findViewById(R.id.naamVanRegio);
        beschrijvingVanRegio = findViewById(R.id.beschrijvingVanRegio);

        back_btn = findViewById(R.id.backbutton_regioactivity);
        informatie_btn = findViewById(R.id.helpbutton_regioactivity);

        tabLayout = findViewById(R.id.regioTabLayout);
        viewPager =  findViewById(R.id.regioViewPager);

        Bundle bundle = getIntent().getExtras();

        if (bundle != null) {

            databaseHelperRegio = new DatabaseHelperRegio(this);
            geselecteerdeRegio = databaseHelperRegio.geselecteerdeRegioLaden(bundle.getString("gekozenLand"));
            naamVanRegio.setText(geselecteerdeRegio.getRegioNaam());
            beschrijvingVanRegio.setText(geselecteerdeRegio.getBeschrijving());
        }

        // Een adapter aanmaken welke de navigatie tussen fragments regelt
        RegioAdapter adapter = new RegioAdapter(getSupportFragmentManager());
        RegioInformatieTab regioinfo = new RegioInformatieTab();
        RegioRegioTab regioregio= new RegioRegioTab();

        regioregio.setArguments(bundle);
        regioinfo.setArguments(bundle);

        // Hier maak je nieuwe fragments aan die in de TabLayout komen te staan
        adapter.fragmentToevoegen( regioinfo, "Informatie");
        adapter.fragmentToevoegen( regioregio, "Regio's");

        // Hier link je de TabLayout (de tabs waar je op kunt klikken) en de ViewPager (het swipen tussen fragments)
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

        informatie_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder1 = new AlertDialog.Builder(RegioActivity.this);
                builder1.setTitle("Help");
                builder1.setMessage("Hier ligt informatie of de gekozen land en kan je meer over een regio vinden van de gekozen land.");
                builder1.setCancelable(true);
                AlertDialog alert11 = builder1.create();
                alert11.show();

            }
        });

        back_btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent i = new Intent(RegioActivity.this, LandenLijstActivity.class);
                startActivity(i);
            }
        });
    }
}
