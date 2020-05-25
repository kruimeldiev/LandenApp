package com.example.reizigers_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button inlogbutton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final Button mapsknop= (Button) findViewById(R.id.button_maps);
        mapsknop.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                                    Intent i = new Intent(v.getContext(), MapsActivity.class);
                                    startActivity(i);
            }
        });

        final Button plekknop= (Button) findViewById(R.id.button_plek);
        plekknop.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i = new Intent(v.getContext(), lijst.class);
                startActivity(i);
            }
        });
    }
}
