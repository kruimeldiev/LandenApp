package com.example.reizigers_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class zoeken extends AppCompatActivity {
    private Button main_btn;
    private TextView naam;
    private Button filter_btn;
    private Button zoek_btn;
    private EditText etnaam;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zoeken);
        main_btn = (Button) findViewById(R.id.backbutton_zoeken) ;
        naam= findViewById(R.id.naam_zoeken) ;
        etnaam= findViewById(R.id.etnaam_zoeken) ;
        filter_btn = (Button) findViewById(R.id.button_filter_zoeken) ;
        zoek_btn = (Button) findViewById(R.id.button_zoek_zoeken) ;

        main_btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent i=new Intent(zoeken.this, MainActivity.class);
                startActivity(i);
            }
        });

        filter_btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent i=new Intent(zoeken.this, FiltersvoorZoeken.class);
                startActivity(i);
            }
        });
    }
}
