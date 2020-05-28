package com.casperdaris.beroepsproductgroepc.Activities;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import androidx.appcompat.widget.Toolbar;

import com.casperdaris.beroepsproductgroepc.DatabaseHelpers.DatabaseHelperRegio;
import com.casperdaris.beroepsproductgroepc.Objecten.Regio;
import com.casperdaris.beroepsproductgroepc.R;

import java.util.List;

public class LandenLijstActivity extends AppCompatActivity {

    private ListView landenLijstListView;
    private Toolbar landenLijstToolbar;
    private ArrayAdapter landenArrayAdapter;
    private DatabaseHelperRegio databaseHelperRegio;

    public Regio geselecteerdeRegio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landen_lijst);

        landenLijstListView = findViewById(R.id.landenListView);
        landenLijstToolbar = findViewById(R.id.landenLijstToolbar);

        // Database helper aanmaken. Deze wordt vervolgens gebruikt om een lijst te maken met alle regio's uit de database
        databaseHelperRegio = new DatabaseHelperRegio(this);
        List<String> alleLanden = databaseHelperRegio.landenLijstLaden();

        // ArrayAdapter aanmaken en deze adapter vervolgens gebruiken om de ListView mee te vullen
        landenArrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, alleLanden);
        landenLijstListView.setAdapter(landenArrayAdapter);

        setSupportActionBar(landenLijstToolbar);
        getSupportActionBar().setTitle(null);

        landenLijstListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Bundle geselecteerdLand = new Bundle();
                geselecteerdLand.putString("landNaam", landenLijstListView.getItemAtPosition(position).toString());
                Intent i = new Intent(LandenLijstActivity.this, RegioActivity.class);
                i.putExtra("gekozenLand", landenLijstListView.getItemAtPosition(position).toString());
                startActivity(i);
            }
        });
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
                Intent i = new Intent(LandenLijstActivity.this, FiltersvoorZoeken.class);
                startActivity(i);
                return false;
            }
        });

        mapItem.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                Intent i = new Intent(LandenLijstActivity.this, MapsActivity.class);
                startActivity(i);
                return false;
            }
        });

        helpItem.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                AlertDialog.Builder builder1 = new AlertDialog.Builder(LandenLijstActivity.this);
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

                landenArrayAdapter.getFilter().filter(newText);
                return false;
            }
        });
        return true;
    }
}
