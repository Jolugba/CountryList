package com.e.countrylist.Api;

import com.e.countrylist.Model;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
    @GET ("all")
    Call<List<Model>> getALLCountries();
}
