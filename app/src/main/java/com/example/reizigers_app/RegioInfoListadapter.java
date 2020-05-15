package com.example.reizigers_app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class RegioInfoListadapter extends ArrayAdapter<regio_info> {

    private int resourcelayout;
    private Context context;

    public  RegioInfoListadapter(Context context, int resource, List<regio_info> items){
        super(context, resource, items);
        this.context=context;
        this.resourcelayout= resource;
    }

    public View getView(int position, View convertView, ViewGroup parent){
        View v= convertView;
        if(v==null){
            LayoutInflater vi;
            vi = LayoutInflater.from(context);
            v = vi.inflate(resourcelayout,null);
        }
        regio_info regioinfo = getItem(position);
        if (regioinfo!= null){
            TextView tvregio = v.findViewById(R.id.tvli_regio_RegioInfo);
            TextView tvhoofdregio = v.findViewById(R.id.tvli_hoofdregio_RegioInfo);
            TextView tvhoofdstad = v.findViewById(R.id.tvli_hoofdstad_RegioInfo);
            TextView tvpopulatie = v.findViewById(R.id.tvli_populatie_RegioInfo);
            TextView tvvaluta = v.findViewById(R.id.tvli_valuta_RegioInfo);
            TextView tvalarmnummer = v.findViewById(R.id.tvli_alarmnummer_RegioInfo);
            TextView tvbeschrijving = v.findViewById(R.id.tvli_beschrijving_RegioInfo);
            TextView tvsoort = v.findViewById(R.id.tvli_soort_RegioInfo);

            int intpopulatie= regioinfo.getPopulatie();
            String strpopulatie= Integer.toString(intpopulatie);

            if(tvregio != null){
                tvregio.setText("Regio: "+ regioinfo.getRegio());
            }
            if(tvhoofdregio!= null){
                tvhoofdregio.setText("Hoofdregio: "+regioinfo.getHoofdregio());
            }
            if(tvhoofdstad != null){
                tvhoofdstad.setText("Hoofdstad: "+regioinfo.getHoofdstad());
            }
            if(tvpopulatie!= null){
                tvpopulatie.setText("Zwanger: "+strpopulatie);
            }
            if(tvvaluta != null){
                tvvaluta.setText("Valuta: "+regioinfo.getValuta());
            }
            if(tvalarmnummer!= null){
                tvalarmnummer.setText("Alarmnummer: "+regioinfo.getAlarmnummer());
            }
            if(tvbeschrijving != null){
                tvbeschrijving.setText("Beschrijving: "+regioinfo.getBeschrijving());
            }
            if(tvsoort!= null){
                tvsoort.setText("Soort: "+regioinfo.getSoort());
            }
        }
        return v;
    }
}

