package com.suraj.miskaa.ui;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.suraj.miskaa.BuildConfig;
import com.suraj.miskaa.MyApplication;
import com.suraj.miskaa.data.models.RegionModel;
import com.suraj.miskaa.data.repository.RegionApi;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CountryViewModel extends ViewModel {

    private MutableLiveData<List<RegionModel>> countriesMutableList;

    public LiveData<List<RegionModel>> getRegionModelLiveData() {
       if (countriesMutableList == null){
           countriesMutableList = new MutableLiveData<List<RegionModel>>();
           LoadData();
       }
       return countriesMutableList;
    }

    private void LoadData() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(MyApplication.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RegionApi regionApi = retrofit.create(RegionApi.class);

        Call<List<RegionModel>> call = regionApi.getCountryList();

        call.enqueue(new Callback<List<RegionModel>>() {
            @Override
            public void onResponse(Call<List<RegionModel>> call, Response<List<RegionModel>> response) {
                countriesMutableList.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<RegionModel>> call, Throwable t) {
                countriesMutableList.setValue(null);
            }
        });
    }


}