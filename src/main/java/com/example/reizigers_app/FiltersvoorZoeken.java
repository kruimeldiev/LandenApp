package com.example.reizigers_app;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class FiltersvoorZoeken extends AppCompatActivity {
    private ImageButton main_btn, helpbutton;
    private SeekBar sb_roomskatoliek, sb_protesant, sb_niet_reliegies, sb_islamitisch;
    private TextView tv_roomskatoliek, tv_protesant, tv_niet_reliegies, tv_islamitisch;
    private TextView tv_titel_roomskatoliek, tv_titel_protesant, tv_titel_niet_reliegies, tv_titel_islamitisch;
    private CheckBox cb_nederlands, cb_engels, cb_spaans, cb_frans, cb_duits;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filtersvoorzoeken);
        main_btn = (ImageButton) findViewById(R.id.backbutton_filter) ;

        sb_roomskatoliek = (SeekBar) findViewById(R.id.Seekbar_roomskatoliek) ;
        sb_protesant = (SeekBar) findViewById(R.id.Seekbar_protesants) ;
        sb_niet_reliegies = (SeekBar) findViewById(R.id.Seekbar_niet_religieus) ;
        sb_islamitisch = (SeekBar) findViewById(R.id.Seekbar_islamitisch) ;

        tv_roomskatoliek = (TextView) findViewById(R.id.tv_roomskatoliek) ;
        tv_protesant = (TextView) findViewById(R.id.tv__protesants) ;
        tv_niet_reliegies = (TextView) findViewById(R.id.tv_niet_religieus) ;
        tv_islamitisch = (TextView) findViewById(R.id.tv_islamitisch) ;

        cb_nederlands= (CheckBox) findViewById(R.id.Checkbox_nederlands) ;
        cb_engels= (CheckBox) findViewById(R.id.Checkbox_engels) ;
        cb_duits= (CheckBox) findViewById(R.id.Checkbox_duits) ;
        cb_frans= (CheckBox) findViewById(R.id.Checkbox_frans) ;
        cb_spaans= (CheckBox) findViewById(R.id.Checkbox_spaans) ;
        helpbutton= (ImageButton) findViewById(R.id.helpbutton_filter) ;

        helpbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder1 = new AlertDialog.Builder(FiltersvoorZoeken.this);
                builder1.setTitle("Help");
                builder1.setMessage("Je kan een land filteren op de percentage van een relegie in een land of taal/talen gesproken in een land.");
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

        main_btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent i=new Intent(FiltersvoorZoeken.this, lijst.class);
                startActivity(i);
            }
        });

        sb_roomskatoliek.getProgressDrawable().setColorFilter(Color.BLUE, PorterDuff.Mode.SRC_IN);
        sb_roomskatoliek.getThumb().setColorFilter(Color.BLACK,PorterDuff.Mode.SRC_IN);


        cb_nederlands.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
            {
                if ( isChecked )
                {
                    // perform logic
                    Toast.makeText(FiltersvoorZoeken.this, "isChecked - " + cb_nederlands.isChecked(), Toast.LENGTH_SHORT).show();
                }

            }
        });


        cb_engels.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
            {
                if ( isChecked )
                {
                    // perform logic
                    Toast.makeText(FiltersvoorZoeken.this, "isChecked - " + cb_engels.isChecked(), Toast.LENGTH_SHORT).show();
                }

            }
        });


        cb_spaans.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
            {
                if ( isChecked )
                {
                    // perform logic
                    Toast.makeText(FiltersvoorZoeken.this, "isChecked - " + cb_spaans.isChecked(), Toast.LENGTH_SHORT).show();
                }

            }
        });


        cb_frans.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
            {
                if ( isChecked )
                {
                    // perform logic
                    Toast.makeText(FiltersvoorZoeken.this, "isChecked - " + cb_frans.isChecked(), Toast.LENGTH_SHORT).show();
                }

            }
        });


        cb_duits.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
            {
                if ( isChecked )
                {
                    // perform logic
                    Toast.makeText(FiltersvoorZoeken.this, "isChecked - " + cb_duits.isChecked(), Toast.LENGTH_SHORT).show();
                }

            }
        });

        sb_roomskatoliek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                tv_roomskatoliek.setText("min "+ progress+ "/"+ sb_roomskatoliek.getMax()+"%");

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        sb_niet_reliegies.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                tv_niet_reliegies.setText("min "+ progress+ "/"+ sb_niet_reliegies.getMax()+"%");

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        sb_islamitisch.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                tv_islamitisch.setText("min "+ progress+ "/"+ sb_islamitisch.getMax()+"%");

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        sb_protesant.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                tv_protesant.setText("min "+ progress+ "/"+ sb_protesant.getMax()+"%");

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}