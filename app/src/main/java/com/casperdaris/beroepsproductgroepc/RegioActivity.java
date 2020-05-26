package com.casperdaris.beroepsproductgroepc;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.casperdaris.beroepsproductgroepc.Fragments.RegioInformatieTab;
import com.casperdaris.beroepsproductgroepc.Fragments.RegioRegioTab;
import com.casperdaris.beroepsproductgroepc.Objecten.Regio;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class RegioActivity extends AppCompatActivity {

    private TextView naamVanRegio, beschrijvingVanRegio;
    private ImageView informatie_btn, back_btn;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    private DatabaseHelper databaseHelper;

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

            databaseHelper = new DatabaseHelper(this);
            geselecteerdeRegio = databaseHelper.geselecteerdLandLaden(bundle.getString("gekozenLand"));

            naamVanRegio.setText(geselecteerdeRegio.getRegioNaam());
            beschrijvingVanRegio.setText(geselecteerdeRegio.getBeschrijving());
        }

        // Een adapter aanmaken welke de navigatie tussen fragments regelt
        RegioAdapter adapter = new RegioAdapter(getSupportFragmentManager());

        // Hier maak je nieuwe fragments aan die in de TabLayout komen te staan
        adapter.fragmentToevoegen(new RegioInformatieTab(), "Informatie");
        adapter.fragmentToevoegen(new RegioRegioTab(), "Regio's");

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

                builder1.setPositiveButton(
                        "Ok",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });

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
