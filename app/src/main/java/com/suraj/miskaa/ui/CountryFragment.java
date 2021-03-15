package com.suraj.miskaa.ui;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.suraj.miskaa.R;
import com.suraj.miskaa.data.models.RegionModel;
import com.suraj.miskaa.databinding.CountryFragmentBinding;

import java.util.List;

public class CountryFragment extends Fragment {

    private CountryFragmentBinding binding;
    private CountryAdapter adapter;

    CountryViewModel mViewModel;

    public static CountryFragment newInstance() {
        return new CountryFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(CountryViewModel.class);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = CountryFragmentBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.recyclerCountries.setLayoutManager(new LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false));

        mViewModel.getRegionModelLiveData().observe(requireActivity(), regionModel -> {
            if (regionModel != null){
                adapter = new CountryAdapter(requireContext(), regionModel);
                binding.recyclerCountries.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            } else {
                Log.e("ViewModel","Empty");
            }
        });

    }
}