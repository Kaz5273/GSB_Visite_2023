package com.example.mygsbvisite;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.mygsbvisite.Adapters.RecyclerViewAdapter;
import com.example.mygsbvisite.Interfaces.GSBServices;
import com.example.mygsbvisite.Interfaces.RecyclerViewClickListener;
import com.example.mygsbvisite.Listeners.RecyclerTouchListener;
import com.example.mygsbvisite.Models.Praticien;
import com.example.mygsbvisite.Models.RetrofitClientInstance;
import com.example.mygsbvisite.Models.Visiteur;
import com.example.mygsbvisite.Models.Visiteurs;
import com.example.mygsbvisite.databinding.ActivityMainBinding;
import com.example.mygsbvisite.databinding.ActivityVisiteurBinding;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class VisiteurActivity extends AppCompatActivity {
    private ActivityVisiteurBinding binding;
    private String username, token;
    private Visiteurs lesVisiteurs;
    private Visiteur visiteur;
    private ArrayList<Praticien> dataPraticiens;
    private RecyclerViewAdapter myAdapterPraticien;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityVisiteurBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);



        Intent myIntent = getIntent();
         username = (String)myIntent.getSerializableExtra("username");
         token = (String)myIntent.getSerializableExtra("token");
        dataPraticiens = new ArrayList<Praticien>();
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

                for (String unPraticienStr : visiteur.getPraticiensStr()){
                    int chaine = unPraticienStr.lastIndexOf("/") + 1;
                    String id = unPraticienStr.substring(chaine);

                    Call<Praticien> praticienCall = service.getPraticiens("Bearer " + token, id );
                    praticienCall.enqueue(new Callback<Praticien>() {
                        @Override
                        public void onResponse(Call<Praticien> call, Response<Praticien> response) {
                            Praticien unPraticien = response.body();
                            dataPraticiens.add(unPraticien);
                            myAdapterPraticien = new RecyclerViewAdapter(dataPraticiens);
                            binding.recyclerViewPraticiens.setAdapter(myAdapterPraticien);

                        }

                        @Override
                        public void onFailure(Call<Praticien> call, Throwable t) {

                        }
                    });
                }

               binding.recyclerViewPraticiens.setHasFixedSize(true);
                LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
                binding.recyclerViewPraticiens.setLayoutManager(layoutManager);
                binding.recyclerViewPraticiens.setFocusable(false);
                binding.recyclerViewPraticiens.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), binding.recyclerViewPraticiens, new RecyclerViewClickListener() {
                    @Override
                    public void onClick(View view, int position) {
                        Intent myIntent = new Intent(getApplicationContext(), PraticienActivity.class);
                        myIntent.putExtra("praticien", dataPraticiens.get(position));
                        myIntent.putExtra("token", token);
                        myIntent.putExtra("username", username);
                        myIntent.putExtra("visiteur", visiteur);
                        startActivity(myIntent);
                    }
                }));


            }
            @Override
            public void onFailure(Call<Visiteurs> call, Throwable t) {
                Toast.makeText(VisiteurActivity.this, "Une erreur est survenue !",
                        Toast.LENGTH_SHORT).show();
            }
        });

    }
}