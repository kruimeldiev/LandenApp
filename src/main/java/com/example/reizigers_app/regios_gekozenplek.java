package com.example.reizigers_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class regios_gekozenplek extends AppCompatActivity {
    private Button main_btn;
    private ImageView imageView;
    private TextView naam;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regios_gekozenplek);
        main_btn = (Button) findViewById(R.id.backbutton_regios_gekozenplek) ;
        imageView= findViewById(R.id.vlag_regios_gekozenplek);
        naam= findViewById(R.id.naam_regios_gekozenplek);


        final Bundle bundle = getIntent().getExtras();
        String Title= bundle.getString("Title");
        int Thumbnail= bundle.getInt("Thumbnail");


        naam.setText(Title);
        imageView.setImageResource(Thumbnail);

        main_btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent i=new Intent(regios_gekozenplek.this, Gekozenplek.class);
                i.putExtras(bundle);
                startActivity(i);
            }
        });
    }
}
