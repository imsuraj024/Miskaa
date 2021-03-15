package com.suraj.miskaa.data.repository;

import com.suraj.miskaa.data.models.RegionModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RegionApi {

    @GET("region/asia")
    Call<List<RegionModel>> getCountryList();

}
