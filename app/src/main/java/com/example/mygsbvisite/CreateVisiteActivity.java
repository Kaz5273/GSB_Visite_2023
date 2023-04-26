package com.example.mygsbvisite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.Toast;

import com.example.mygsbvisite.Interfaces.GSBServices;
import com.example.mygsbvisite.Models.Praticien;
import com.example.mygsbvisite.Models.RetrofitClientInstance;
import com.example.mygsbvisite.Models.Token;
import com.example.mygsbvisite.Models.Visite;
import com.example.mygsbvisite.Models.Visiteur;
import com.example.mygsbvisite.databinding.ActivityCreateVisiteBinding;
import com.example.mygsbvisite.databinding.ActivityPraticienBinding;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CreateVisiteActivity extends AppCompatActivity {
    private ActivityCreateVisiteBinding binding;
    private Visiteur visiteur;
    private Praticien praticien;
    private String username, token;
    private DatePicker datePicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCreateVisiteBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);


        // Récupérer la référence au DatePicker
        datePicker = findViewById(R.id.editTextDate);

        // Définir la date initiale sur 1er janvier 2022
        datePicker.init(2023, 0, 1, null);

        // Récupérer la date sélectionnée par l'utilisateur



        Intent myIntent = getIntent();
        praticien = (Praticien)myIntent.getSerializableExtra("praticien");
        username = (String)myIntent.getSerializableExtra("username");
        token = (String)myIntent.getSerializableExtra("token");
        visiteur = (Visiteur)myIntent.getSerializableExtra("visiteur");

        binding.btnValider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int year = datePicker.getYear();
                int month = datePicker.getMonth();
                int dayOfMonth = datePicker.getDayOfMonth();

                // Créer un objet de type Calendar pour stocker la date
                Calendar calendar = Calendar.getInstance();
                calendar.set(year, month, dayOfMonth);
                Visite uneVisite = new Visite(calendar.getTime(),binding.editTextCommentaire.getText().toString(), visiteur.formatUrlWithId(visiteur.getId()), praticien.formatUrlWithId(praticien.getId()));
                GSBServices services = RetrofitClientInstance.getRetrofitInstance().create(GSBServices.class);
               retrofit2.Call<Visite> call = services.createVisite("Bearer " + token, uneVisite);
                call.enqueue(new Callback<Visite>() {
                    @Override
                    public void onResponse(retrofit2.Call<Visite> call, Response<Visite> response) {
                        Intent myIntent = new Intent();
                        myIntent.putExtra("newVisite", uneVisite);
                        setResult(1, myIntent);
                        CreateVisiteActivity.super.onBackPressed();

                    }

                    @Override
                    public void onFailure(Call<Visite> call, Throwable t) {
                        Toast.makeText(CreateVisiteActivity.this, "Une erreur est survenue !",
                                Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
}