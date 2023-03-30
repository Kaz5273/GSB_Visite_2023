package com.example.mygsbvisite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.mygsbvisite.Interfaces.GSBServices;
import com.example.mygsbvisite.Models.RetrofitClientInstance;
import com.example.mygsbvisite.Models.Visiteur;
import com.example.mygsbvisite.Models.Visiteurs;
import com.example.mygsbvisite.databinding.ActivityMainBinding;
import com.example.mygsbvisite.databinding.ActivityVisiteurBinding;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class VisiteurActivity extends AppCompatActivity {
    private ActivityVisiteurBinding binding;
    private String username, token;
    private Visiteurs lesVisiteurs;
    private Visiteur visiteur;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityVisiteurBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        Intent myIntent = getIntent();
         username = (String)myIntent.getSerializableExtra("username");
         token = (String)myIntent.getSerializableExtra("token");
        Toast.makeText(VisiteurActivity.this, username, Toast.LENGTH_SHORT).show();
        Toast.makeText(VisiteurActivity.this, token, Toast.LENGTH_SHORT).show();

        GSBServices service =
                RetrofitClientInstance.getRetrofitInstance().create(GSBServices.
                        class);
        Call<Visiteurs> call = service.getAllVisiteurs("Bearer " + token);
        call.enqueue(new Callback<Visiteurs>() {
            @Override
            public void onResponse(Call<Visiteurs> call, Response<Visiteurs>
                    response) {
               lesVisiteurs = response.body();
               for (Visiteur unVisiteur : lesVisiteurs.getVisiteurs()){
                   if(unVisiteur.getUsername().equals(username)){
                       visiteur = unVisiteur;
                   }
               }
               binding.textViewVisiteurNom.setText(visiteur.getNom());
               binding.textViewVisiteurPrenom.setText(visiteur.getPrenom());
               binding.textViewVisiteurTel.setText(visiteur.getTelephone());
               binding.textViewVisiteurMail.setText(visiteur.getMail());
               binding.txtMatricule.setText(visiteur.getMatricule());
            }
            @Override
            public void onFailure(Call<Visiteurs> call, Throwable t) {
                Toast.makeText(VisiteurActivity.this, "Une erreur est survenue !",
                        Toast.LENGTH_SHORT).show();
            }
        });

    }
}