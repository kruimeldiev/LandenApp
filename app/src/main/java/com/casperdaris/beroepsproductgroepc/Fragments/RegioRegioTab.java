package com.casperdaris.beroepsproductgroepc.Fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.casperdaris.beroepsproductgroepc.Activities.LandenLijstActivity;
import com.casperdaris.beroepsproductgroepc.Activities.RegioActivity;
import com.casperdaris.beroepsproductgroepc.Activities.RegiosInfoActiviteit;
import com.casperdaris.beroepsproductgroepc.DatabaseHelpers.DatabaseHelperRegio;
import com.casperdaris.beroepsproductgroepc.Objecten.Regio;
import com.casperdaris.beroepsproductgroepc.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class RegioRegioTab extends Fragment {

    View v;
    private List<String> list;
    private Regio geselecteerdeRegio;
    private DatabaseHelperRegio databaseHelper;
    private TextView textView;


    public RegioRegioTab() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        v=inflater.inflate(R.layout.fragment_regio_tab, container, false);
        Bundle bundle = this.getArguments();

        // Inflate the layout for this fragment
        if (bundle != null) {

            databaseHelper = new DatabaseHelperRegio(getActivity());
            geselecteerdeRegio = databaseHelper.geselecteerdeRegioRegios(bundle.getString("gekozenLand"));

            ListView listView= (ListView) v.findViewById(R.id.landenListRegios);

            list= new ArrayList<>();
            if(geselecteerdeRegio.getRegioNaam()!= "fout"){
                list.add(geselecteerdeRegio.getRegioNaam());
            }else{
                textView= v.findViewById(R.id.titelregiolist);
                textView.setText("Geen Regios voor deze land beschikbaar");
            }

            ArrayAdapter <String> ListViewAdapter= new ArrayAdapter<String>(
                    getActivity(),android.R.layout.simple_list_item_1, list
            );
            listView.setAdapter(ListViewAdapter);

            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Bundle geselecteerdLand = new Bundle();
                    geselecteerdLand.putString("landNaam", listView.getItemAtPosition(position).toString());
                    Intent i = new Intent(getActivity(), RegiosInfoActiviteit.class);
                    i.putExtras(bundle);
                    i.putExtras(geselecteerdLand);
                    startActivity(i);

                }
            });

        }

        return v;
    }

}
