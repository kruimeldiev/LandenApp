package com.example.reizigers_app;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> implements Filterable {

    private Context context;
    private List<Flag> mdata;
    private List<Flag> mdata_full;

    public RecyclerAdapter(Context context, List<Flag> mdata){
        this.mdata=mdata;
        this.context=context;
        mdata_full= new ArrayList<>(mdata);
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cardview_item_flag, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        final Flag flag = mdata.get(position);
        holder.title.setText(flag.getTitle());
        holder.picture.setImageResource(flag.getThumbnail());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(context, Gekozenplek.class);

                intent.putExtra("Title", mdata.get(position).getTitle());
                intent.putExtra("Thumbnail", mdata.get(position).getThumbnail());

                context.startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return mdata.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView picture;
        TextView title;
        CardView cardView;

        public MyViewHolder(View itemView) {
            super(itemView);
            picture= itemView.findViewById(R.id.album);
            title= itemView.findViewById(R.id.album_title);
            cardView= itemView.findViewById(R.id.cardview_id);
        }

    }

    @Override
    public Filter getFilter() {
        return exampleFilter;
    }

    private Filter exampleFilter =new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<Flag> filteredList =new ArrayList<>();

            if (constraint== null|| constraint.length()==0){
                filteredList.addAll(mdata_full);
            }else {
                String FilterPattern= constraint.toString().toLowerCase().trim();

                for (Flag item: mdata_full){
                    if (item.getTitle().toLowerCase().contains(FilterPattern)){
                        filteredList.add(item);
                    }

                }
            }

            FilterResults results= new FilterResults();
            results.values= filteredList;
            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            mdata.clear();
            mdata.addAll((List) results.values);
            notifyDataSetChanged();
        }
    };
}
