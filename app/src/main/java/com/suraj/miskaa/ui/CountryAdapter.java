package com.suraj.miskaa.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.suraj.miskaa.data.models.LanguageModel;
import com.suraj.miskaa.data.models.RegionModel;
import com.suraj.miskaa.databinding.RecylerItemBinding;

import java.util.List;

public class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.ViewHolder> {

    private Context context;
    private List<RegionModel> regionModel;

    public CountryAdapter(Context context, List<RegionModel> regionModel) {
        this.context = context;
        this.regionModel = regionModel;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecylerItemBinding binding = RecylerItemBinding.inflate(LayoutInflater.from(parent.getContext()),parent, false);
        return new ViewHolder(binding);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.binding.textName.setText(regionModel.get(position).getName());
        holder.binding.textCapital.setText(regionModel.get(position).getCapital());
        holder.binding.textRegion.setText(regionModel.get(position).getRegion());
        holder.binding.textSubRegion.setText(regionModel.get(position).getSubregion());
        holder.binding.textPopulation.setText(""+regionModel.get(position).getPopulation());
        Glide.with(context)
                .load(regionModel.get(position).getFlag())
                .into(holder.binding.imageFlag);

    }

    @Override
    public int getItemCount() {
        return regionModel.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        RecylerItemBinding binding;

        public ViewHolder(@NonNull RecylerItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
