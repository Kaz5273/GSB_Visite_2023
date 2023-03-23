package com.example.mygsbvisite.Interfaces;

import com.example.mygsbvisite.Models.Visiteur;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface GSBServices {
    @POST("login_check")
    Call<Visiteur> getToken();
}
