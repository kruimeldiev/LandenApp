package com.casperdaris.beroepsproductgroepc.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.casperdaris.beroepsproductgroepc.DatabaseHelper;
import com.casperdaris.beroepsproductgroepc.Objecten.Regio;
import com.casperdaris.beroepsproductgroepc.R;

import java.util.List;

public class RegioInformatieTab extends Fragment {

    // Dit is een test listview om regio's in weer te geven
    private ListView regioListView;

    public RegioInformatieTab() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_informatie_tab, container, false);

        regioListView = view.findViewById(R.id.regioListView);

        // Database helper aanmaken. Deze wordt vervolgens gebruikt om een lijst te maken met alle regio's uit de database
        DatabaseHelper databaseHelper = new DatabaseHelper(this.getContext());
        List<String> alleRegios = databaseHelper.regioLijstLaden();

        // ArrayAdapter aanmaken en deze adapter vervolgens gebruiken om de ListView mee te vullen
        ArrayAdapter regioArrayAdapter = new ArrayAdapter<String>(this.getContext(), android.R.layout.simple_list_item_1, alleRegios);
        regioListView.setAdapter(regioArrayAdapter);

        return view;
    }
}
