package com.example.reizigers_app;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Gekozenplek extends AppCompatActivity implements Informatie_Tab.OnFragmentInteractionListener, Regios_Tab.OnFragmentInteractionListener{
    private TextView naam;
    private Button informatie_btn;
    private Button regios_btn;
    private ImageView imageView, helpbutton,main_btn;
    private Bundle bundle;
    private TabLayout tabs;
    private ViewPager pager;
    private PagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gekozenplek);
        main_btn = (ImageView) findViewById(R.id.backbutton_gekozenplek) ;
        naam= findViewById(R.id.naam_gekozenplek) ;
        informatie_btn = (Button) findViewById(R.id.button_informatie_gekozenplek) ;
        regios_btn = (Button) findViewById(R.id.button_regios_gekozenplek) ;
        imageView= findViewById(R.id.vlag_gekozenplek);
        naam= findViewById(R.id.naam_gekozenplek);
        tabs = (TabLayout) findViewById(R.id.tab_layout);
        pager= findViewById(R.id.pager);
        helpbutton= findViewById(R.id.helpbutton_gekozenplek);

        bundle = getIntent().getExtras();
        String Title= bundle.getString("Title");
        int Thumbnail= bundle.getInt("Thumbnail");

        naam.setText(Title);
        imageView.setImageResource(Thumbnail);

        tabs.addTab(tabs.newTab().setText("Informatie"));
        tabs.addTab(tabs.newTab().setText("Regio's"));

        adapter= new PagerAdapter(getSupportFragmentManager(), tabs.getTabCount());

        helpbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder1 = new AlertDialog.Builder(Gekozenplek.this);
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



        pager.setAdapter(adapter);
        pager.setOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabs));
        tabs.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                pager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        main_btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Gekozenplek.this, lijst.class);
                startActivity(i);
            }
        });

        informatie_btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Gekozenplek.this, informatie_gekozenplek.class);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        regios_btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Gekozenplek.this, regios_gekozenplek.class);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
