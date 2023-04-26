package com.example.mygsbvisite.Interfaces;

import com.example.mygsbvisite.Models.Praticien;
import com.example.mygsbvisite.Models.Token;
import com.example.mygsbvisite.Models.Visite;
import com.example.mygsbvisite.Models.Visiteur;
import com.example.mygsbvisite.Models.Visiteurs;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface GSBServices {
    @POST("login_check")
    Call<Token> getToken(@Body Visiteur visiteur);

    @GET("visiteurs")
    Call<Visiteurs> getAllVisiteurs(@Header("Authorization")String authorization);

    @GET("praticiens/{id}")
    Call<Praticien> getPraticiens(@Header("Authorization") String authorization, @Path("id") String id);

    @GET("visites/{id}")
    Call<Visite> getVisites(@Header("Authorization") String authorization, @Path("id") String id);

    @POST("visites")
    Call<Visite> createVisite(@Header("Authorization")String authorization, @Body Visite visite);
}
