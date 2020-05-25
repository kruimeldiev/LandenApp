package com.example.reizigers_app;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.SearchView;

import java.util.ArrayList;
import java.util.List;

public class lijst extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerAdapter recyclerAdapter;
    List<Flag> lstFlag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lijst);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        lstFlag= new ArrayList<>();
        lstFlag.add(new Flag("Spanje", R.drawable.spainflag));
        lstFlag.add(new Flag("Nederland", R.drawable.netherlandsvlag));
        lstFlag.add(new Flag("Duitsland", R.drawable.duitsland));
        lstFlag.add(new Flag("Frankrijk", R.drawable.frankrijk));
        lstFlag.add(new Flag("Italië", R.drawable.italie));
        lstFlag.add(new Flag("Verenigd Koningkrijk", R.drawable.uk));
        lstFlag.add(new Flag("Griekenland", R.drawable.greece));
        lstFlag.add(new Flag("Zwitserland", R.drawable.switserland));
        lstFlag.add(new Flag("Zweden", R.drawable.sweden));
        lstFlag.add(new Flag("Polen", R.drawable.polen));
        lstFlag.add(new Flag("Verenigde Staten van Amerika", R.drawable.america));
        lstFlag.add(new Flag("Canada", R.drawable.canada));
        lstFlag.add(new Flag("Curacao", R.drawable.curacao));

        recyclerView= findViewById(R.id.recyclerView);
        layoutManager= new LinearLayoutManager(this);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);
        recyclerAdapter = new RecyclerAdapter(this,lstFlag);
        recyclerView.setAdapter(recyclerAdapter);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(null);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater= getMenuInflater();
        menuInflater.inflate(R.menu.example_menu, menu);

        MenuItem searchItem= menu.findItem(R.id.action_search);
        MenuItem filterItem= menu.findItem(R.id.action_filter);
        MenuItem helpItem= menu.findItem(R.id.action_help);
        MenuItem mapItem= menu.findItem(R.id.action_map);
        SearchView searchView= (SearchView) searchItem.getActionView();

        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_arrow_back_black_24dp);// set drawable icon
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        filterItem.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                Intent i = new Intent(lijst.this, FiltersvoorZoeken.class);
                startActivity(i);
                return false;
            }
        });

        mapItem.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                Intent i = new Intent(lijst.this, MapsActivity.class);
                startActivity(i);
                return false;
            }
        });

        helpItem.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                AlertDialog.Builder builder1 = new AlertDialog.Builder(lijst.this);
                builder1.setTitle("Help");
                builder1.setMessage("Hier kan je een land zoeken of filteren van de lijst. Er is ook een map om alle landen te zien waar ze liggen.");
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
                return false;
            }
        });

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                recyclerAdapter.getFilter().filter(newText);
                return false;
            }
        });
        return true;
    }
}
