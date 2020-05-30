package com.casperdaris.beroepsproductgroepc.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.casperdaris.beroepsproductgroepc.DatabaseHelpers.DatabaseHelperRegio;
import com.casperdaris.beroepsproductgroepc.DatabaseHelpers.DatabaseHelperReligie;
import com.casperdaris.beroepsproductgroepc.DatabaseHelpers.DatabaseHelperSpecialiteit;
import com.casperdaris.beroepsproductgroepc.DatabaseHelpers.DatabaseHelperSport;
import com.casperdaris.beroepsproductgroepc.DatabaseHelpers.DatabaseHelperTaal;
import com.casperdaris.beroepsproductgroepc.Objecten.Regio;
import com.casperdaris.beroepsproductgroepc.Objecten.RegioReligie;
import com.casperdaris.beroepsproductgroepc.Objecten.RegioSpecialiteit;
import com.casperdaris.beroepsproductgroepc.Objecten.RegioSport;
import com.casperdaris.beroepsproductgroepc.Objecten.RegioTaal;
import com.casperdaris.beroepsproductgroepc.R;

public class RegioInformatieTab extends Fragment {
    View v;

    TextView tvtaal, tvvaluta, tvhoofdstad, tvreligie, tvsport, tvspecialiteit;
    private Regio geselecteerdeRegio;
    private DatabaseHelperRegio databaseHelperregio;
    private RegioReligie geselecteerdeReligieRegio;
    private DatabaseHelperReligie databaseHelperReligie;
    private RegioSpecialiteit geselecteerdeSpecialiteitRegio;
    private DatabaseHelperSpecialiteit databaseHelperSpecialiteit;
    private RegioSport geselecteerdeSportRegio;
    private DatabaseHelperSport databaseHelperSport;
    private RegioTaal geselecteerdeTaalRegio;
    private DatabaseHelperTaal databaseHelperTaal;



    public RegioInformatieTab() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v=inflater.inflate(R.layout.fragment_informatie_tab, container, false);
        Bundle bundle = this.getArguments();
        if (bundle != null) {

            databaseHelperregio = new DatabaseHelperRegio(getActivity());
            databaseHelperReligie = new DatabaseHelperReligie(getActivity());
            databaseHelperSpecialiteit = new DatabaseHelperSpecialiteit(getActivity());
            databaseHelperSport = new DatabaseHelperSport(getActivity());
            databaseHelperTaal= new DatabaseHelperTaal(getActivity());
            geselecteerdeRegio = databaseHelperregio.geselecteerdeRegioLaden(bundle.getString("gekozenLand"));
            geselecteerdeReligieRegio = databaseHelperReligie.geselecteerdeRegio(bundle.getString("gekozenLand"));
            geselecteerdeSpecialiteitRegio = databaseHelperSpecialiteit.geselecteerdeRegio(bundle.getString("gekozenLand"));
            geselecteerdeSportRegio = databaseHelperSport.geselecteerdeRegio(bundle.getString("gekozenLand"));
            geselecteerdeTaalRegio = databaseHelperTaal.geselecteerdeRegio(bundle.getString("gekozenLand"));



            tvtaal= (TextView) v.findViewById(R.id.taalVanRegio);
            tvtaal.setText(geselecteerdeTaalRegio.getTaalNaam());
            tvvaluta= (TextView) v.findViewById(R.id.valutaVanRegio);
            tvvaluta.setText(geselecteerdeRegio.getRegioValuta());
            tvhoofdstad= (TextView) v.findViewById(R.id.hoofdstadVanRegio);
            tvhoofdstad.setText(geselecteerdeRegio.getHoofdStad());
            tvreligie= (TextView) v.findViewById(R.id.religieVanRegio);
            tvreligie.setText(geselecteerdeReligieRegio.getReligieNaam());
            tvsport= (TextView) v.findViewById(R.id.sportVanRegio);
            tvsport.setText(geselecteerdeSportRegio.getSportNaam());
            tvspecialiteit= (TextView) v.findViewById(R.id.specialiteitVanRegio);
            tvspecialiteit.setText(geselecteerdeSpecialiteitRegio.getSpecialiteitNaam());
        }

        return v;
    }
}
