package com.example.mygsbvisite.Interfaces;

import com.example.mygsbvisite.Models.Token;
import com.example.mygsbvisite.Models.Visiteur;
import com.example.mygsbvisite.Models.Visiteurs;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface GSBServices {
    @POST("login_check")
    Call<Token> getToken(@Body Visiteur visiteur);

    @GET("visiteurs")
    Call<Visiteurs> getAllVisiteurs(@Header("Authorization")String authorization);
}
