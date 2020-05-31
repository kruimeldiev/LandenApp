package com.casperdaris.beroepsproductgroepc.Fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.casperdaris.beroepsproductgroepc.Activities.RegiosInfoActiviteit;
import com.casperdaris.beroepsproductgroepc.Activities.StadInfo;
import com.casperdaris.beroepsproductgroepc.DatabaseHelpers.DatabaseHelperRegio;
import com.casperdaris.beroepsproductgroepc.DatabaseHelpers.DatabaseHelperStad;
import com.casperdaris.beroepsproductgroepc.Objecten.Regio;
import com.casperdaris.beroepsproductgroepc.Objecten.Stad;
import com.casperdaris.beroepsproductgroepc.R;

import java.util.ArrayList;
import java.util.List;

public class RegioStadTab extends Fragment {

    View v;
    private List<String> list;
    private Stad  geselecteerdeRegio;
    private DatabaseHelperStad databaseHelper;
    private TextView textView;


    public RegioStadTab() {
        // Required empty public constructor
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        v=inflater.inflate(R.layout.fragment_regio_stad_tab, container, false);
        Bundle bundle = this.getArguments();

        // Inflate the layout for this fragment
        if (bundle != null) {

            databaseHelper = new DatabaseHelperStad(getActivity());
            geselecteerdeRegio = databaseHelper.geselecteerdeRegio(bundle.getString("gekozenLand"));

            ListView listView= (ListView) v.findViewById(R.id.landenListSteden);

            list= new ArrayList<>();
            if(geselecteerdeRegio.getStadNaam()!= "fout"){
                list.add(geselecteerdeRegio.getStadNaam());
            }else{
                textView= v.findViewById(R.id.titelstadlist);
                textView.setText("Geen Steden voor deze land beschikbaar");
            }

            ArrayAdapter<String> ListViewAdapter= new ArrayAdapter<String>(
                    getActivity(),android.R.layout.simple_list_item_1, list
            );
            listView.setAdapter(ListViewAdapter);

            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Bundle geselecteerdLand = new Bundle();
                    geselecteerdLand.putString("landNaam", listView.getItemAtPosition(position).toString());
                    Intent i = new Intent(getActivity(), StadInfo.class);
                    i.putExtras(bundle);
                    i.putExtras(geselecteerdLand);
                    startActivity(i);

                }
            });

        }

        return v;
    }

}

