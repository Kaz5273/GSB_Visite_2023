package com.example.mygsbvisite;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.mygsbvisite.Adapters.RecyclerViewAdapter;
import com.example.mygsbvisite.Adapters.RecyclerViewVisite;
import com.example.mygsbvisite.Interfaces.GSBServices;
import com.example.mygsbvisite.Interfaces.RecyclerViewClickListener;
import com.example.mygsbvisite.Listeners.RecyclerTouchListener;
import com.example.mygsbvisite.Models.Praticien;
import com.example.mygsbvisite.Models.RetrofitClientInstance;
import com.example.mygsbvisite.Models.Visite;
import com.example.mygsbvisite.databinding.ActivityMainBinding;
import com.example.mygsbvisite.databinding.ActivityPraticienBinding;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PraticienActivity extends AppCompatActivity {
    private ActivityPraticienBinding binding;
    private String username, token;
    private Praticien praticien;
    private ArrayList<Visite> dataVisite;
    private RecyclerViewVisite myAdapterVisite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPraticienBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        Intent myIntent = getIntent();
        praticien = (Praticien)myIntent.getSerializableExtra("praticien");
        username = (String)myIntent.getSerializableExtra("username");
        token = (String)myIntent.getSerializableExtra("token");

        binding.textViewPraticiensNom.setText(praticien.getNom());
        binding.textViewPraticienPrenom.setText(praticien.getPrenom());
        binding.textViewPraticienTel.setText(praticien.getTelephone());
        binding.textViewPraticienMail.setText(praticien.getEmail());
        binding.textViewPraticienVille.setText(praticien.getVille());
        binding.textViewPraticienCp.setText(praticien.getCodePostal());
        binding.textViewPraticienRue.setText(praticien.getRue());
        binding.textViewPraticienCoef.setText(praticien.getCoef_Notoriete());

        dataVisite = new ArrayList<Visite>();
        for (String uneVisiteStr : praticien.getVisites()){
            int chaine = uneVisiteStr.lastIndexOf("/") + 1;
            String id = uneVisiteStr.substring(chaine);

            GSBServices service = RetrofitClientInstance.getRetrofitInstance().create(GSBServices.
                    class);
            Call<Visite> visiteCall = service.getVisites("Bearer " + token, id);
            visiteCall.enqueue(new Callback<Visite>() {
                @Override
                public void onResponse(Call<Visite> call, Response<Visite> response) {
                    Visite uneVisite = response.body();
                    dataVisite.add(uneVisite);
                    myAdapterVisite = new RecyclerViewVisite(dataVisite);
                    binding.recyclerViewVisite.setAdapter(myAdapterVisite);

                }

                @Override
                public void onFailure(Call<Visite> call, Throwable t) {

                }
            });
        }
        binding.recyclerViewVisite.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        binding.recyclerViewVisite.setLayoutManager(layoutManager);
        binding.recyclerViewVisite.setFocusable(false);
        binding.recyclerViewVisite.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), binding.recyclerViewVisite, new RecyclerViewClickListener() {
            @Override
            public void onClick(View view, int position) {
                Intent myIntent = new Intent(getApplicationContext(), VisitesActivity.class);
                myIntent.putExtra("visite", dataVisite.get(position));
                myIntent.putExtra("token", token);
                myIntent.putExtra("username", username);
                startActivity(myIntent);
            }
        }));
        binding.btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(getApplicationContext(), CreateVisiteActivity.class);
                startActivity(myIntent);
            }
        });
    }
}