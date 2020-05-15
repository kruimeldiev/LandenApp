package com.example.reizigers_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class informatie_gekozenplek extends AppCompatActivity {
    private Button main_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informatie_gekozenplek);
        main_btn = (Button) findViewById(R.id.backbutton_informatie_gekozenplek) ;

        main_btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent i=new Intent(informatie_gekozenplek.this, Gekozenplek.class);
                startActivity(i);
            }
        });
    }
}
