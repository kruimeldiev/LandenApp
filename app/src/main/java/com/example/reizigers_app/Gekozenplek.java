package com.example.reizigers_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Gekozenplek extends AppCompatActivity {
    private Button main_btn;
    private TextView naam;
    private Button informatie_btn;
    private Button regios_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gekozenplek);
        main_btn = (Button) findViewById(R.id.backbutton_gekozenplek) ;
        naam= findViewById(R.id.naam_gekozenplek) ;
        informatie_btn = (Button) findViewById(R.id.button_informatie_gekozenplek) ;
        regios_btn = (Button) findViewById(R.id.button_regios_gekozenplek) ;

        main_btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Gekozenplek.this, MainActivity.class);
                startActivity(i);
            }
        });

        informatie_btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Gekozenplek.this, informatie_gekozenplek.class);
                startActivity(i);
            }
        });

        regios_btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Gekozenplek.this, regios_gekozenplek.class);
                startActivity(i);
            }
        });

    }
}
