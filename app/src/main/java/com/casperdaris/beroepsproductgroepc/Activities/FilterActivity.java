package com.casperdaris.beroepsproductgroepc.Activities;

import android.content.Intent;
import android.os.Bundle;

import com.casperdaris.beroepsproductgroepc.R;
import com.casperdaris.beroepsproductgroepc.viewmodel.FilterViewModel;
import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class FilterActivity extends AppCompatActivity {

    private FilterViewModel filterViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter);
        setSupportActionBar(findViewById(R.id.tbFilter));
        filterViewModel = new ViewModelProvider(this).get(FilterViewModel.class);
        Set<String> selectedTalen = new HashSet<>();
        Set<String> selectedReligies = new HashSet<>();
        ChipGroup cgTalen = findViewById(R.id.talenChipGroup);
        filterViewModel.getTalen().observe(this, talen -> {
            cgTalen.removeAllViews();
            talen.forEach(taal -> {
                Chip chip = new Chip(this);
                chip.setCheckable(true);
                chip.setText(taal.getTaal());
                chip.setOnCheckedChangeListener((buttonView, isChecked) -> {
                    String taalNaam = chip.getText().toString();
                    if (chip.isChecked()) {
                        selectedTalen.add(taalNaam);
                    } else {
                        selectedTalen.remove(taalNaam);
                    }
                });
                cgTalen.addView(chip);
            });
        });
        ChipGroup cgReligie = findViewById(R.id.religieChipGroup);
        filterViewModel.getReligies().observe(this, religies -> {
            cgReligie.removeAllViews();
            religies.forEach(religie -> {
                Chip chip = new Chip(this);
                chip.setCheckable(true);
                chip.setText(religie.getReligie());
                chip.setOnCheckedChangeListener((buttonView, isChecked) -> {
                    String religieNaam = chip.getText().toString();
                    if (chip.isChecked()) {
                        selectedReligies.add(religieNaam);
                    } else {
                        selectedReligies.remove(religieNaam);
                    }
                });
                cgReligie.addView(chip);
            });
        });
        Button bevestigen = findViewById(R.id.filterBevestigen);
        bevestigen.setOnClickListener(view -> {
            filterViewModel.setSelectedTalen(selectedTalen);
            filterViewModel.setSelectedReligies(selectedReligies);
            ArrayList<String> taalList = new ArrayList<>();
            ArrayList<String> religieList = new ArrayList<>();
            taalList.addAll(selectedTalen);
            religieList.addAll(selectedReligies);

            Intent intent = new Intent(this, LandenLijstActivity.class);

            Bundle bundle = new Bundle();
            bundle.putStringArrayList("talen", taalList);
            bundle.putStringArrayList("religie", religieList);
            intent.putExtras(bundle);
            startActivity(intent);
        });
    }

    /**
     * onCreate voor constructie van het OptionsMenu in de ActionBar
     * Constructie kan niet plaatsvinden indien er geen ActionBar is
     *
     * @param menu Het OptionsMenu in de ActionBar
     * @return boolean of het menu wel of niet geconstrueerd is
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        try {
            getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_arrow_back_black_24dp);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getMenuInflater().inflate(R.menu.filter_toolbar, menu);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    /**
     * ActionHandler voor interacties met items op de toolbar
     * Controleert of het item wel of niet het geselecteerde item is
     * Terugknop start de in het AndroidManifest beschreven parentActivity
     *
     * @param item MenuItem van de ActionBar
     * @return boolean of het MenuItem wel of niet geselecteerd is
     */
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.action_informatie) {
            informatieDialog().show();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * AlertDialog met extra instructies/informatie voor de gebruiker
     * AlertDialog wordt opgebouwd met de aangegeven resources
     *
     * @return AlertDialog met instructies/informatie
     */
    private AlertDialog informatieDialog() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setTitle(R.string.informatie);
        alertDialogBuilder.setMessage(R.string.infoText);
        alertDialogBuilder.setCancelable(false);
        alertDialogBuilder.setPositiveButton(R.string.infoConfirm, null);
        return alertDialogBuilder.create();
    }
}