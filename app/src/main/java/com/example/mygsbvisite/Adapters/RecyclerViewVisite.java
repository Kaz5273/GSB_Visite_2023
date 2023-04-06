package com.example.mygsbvisite.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mygsbvisite.Models.Visite;
import com.example.mygsbvisite.R;

import java.util.Date;
import java.util.List;

public class RecyclerViewVisite extends RecyclerView.Adapter<RecyclerViewVisite.RecyclerViewHolder>{
    private List<Visite> dataModelListVisite;

    public RecyclerViewVisite(List<Visite> dataModelListVisite){
        this.dataModelListVisite = dataModelListVisite;
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder{
        TextView textViewVisiteDate;
        TextView textViewVisiteCommentaire;

        public RecyclerViewHolder(@NonNull View itemView){
            super(itemView);
            textViewVisiteDate = itemView.findViewById(R.id.textViewVisiteDate);
            textViewVisiteCommentaire = itemView.findViewById(R.id.textViewVisiteCommentaire);
        }
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerViewHolder viewHolder;
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_visites, parent, false);
        viewHolder = new RecyclerViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {
        holder.textViewVisiteDate.setText(dataModelListVisite.get(position).getDateVisite().toString());
        holder.textViewVisiteCommentaire.setText(String.valueOf(dataModelListVisite.get(position).getCommentaire()));
    }

    @Override
    public int getItemCount() {
        return dataModelListVisite.size();
    }
    public long getItemId(int position){
        return super.getItemId(position);
    }



}
