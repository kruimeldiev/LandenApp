package com.example.reizigers_app;

import android.app.Dialog;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.view.menu.MenuView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerAdapterRegios extends RecyclerView.Adapter<RecyclerAdapterRegios.MyViewHolderRegios> {

    Context context;
    private List<String> list;
    Dialog dialog;

    public RecyclerAdapterRegios( Context context,List<String> list){
        this.context= context;
        this.list=list;
    }


    @Override
    public RecyclerAdapterRegios.MyViewHolderRegios onCreateViewHolder(final ViewGroup parent, int viewType) {
        View v;
        v=LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_regio, parent, false);

        final MyViewHolderRegios itemView = new MyViewHolderRegios(v);

        dialog= new Dialog(context);
        dialog.setContentView(R.layout.dialogregio);

        itemView.itemregio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView dialog_titel_tv= (TextView) dialog.findViewById(R.id.regio_titel);
                TextView dialog_naam_tv= (TextView) dialog.findViewById(R.id.regio_naam);

                final String regionaam = list.get((itemView.getAdapterPosition()));
                dialog_titel_tv.setText("Regio");
                dialog_naam_tv.setText(regionaam);
                dialog.show();
            }
        });

        return itemView;
    }

    @Override
    public void onBindViewHolder(RecyclerAdapterRegios.MyViewHolderRegios holder, final int position) {
        final String regionaam = list.get(position);
        holder.regio.setText(regionaam);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MyViewHolderRegios extends RecyclerView.ViewHolder {

        TextView regio;
        LinearLayout itemregio;

        public MyViewHolderRegios(View itemView) {
            super(itemView);
            itemregio= (LinearLayout) itemView.findViewById(R.id.item_regio_id);
            regio= (TextView) itemView.findViewById(R.id.item_regio_naam);
        }

    }
}
