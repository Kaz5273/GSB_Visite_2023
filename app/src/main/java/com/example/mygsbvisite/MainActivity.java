package com.example.mygsbvisite;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.mygsbvisite.Interfaces.GSBServices;
import com.example.mygsbvisite.Models.RetrofitClientInstance;
import com.example.mygsbvisite.Models.Token;
import com.example.mygsbvisite.Models.Visiteur;
import com.example.mygsbvisite.databinding.ActivityMainBinding;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private Token unToken;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);


        binding.btnConnexion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Visiteur unVisiteur = new Visiteur(binding.txtLogin.getText().toString(), binding.txtPassword.getText().toString());
                GSBServices services = RetrofitClientInstance.getRetrofitInstance().create(GSBServices.class);
                Call<Token> call = services.getToken(unVisiteur);
                call.enqueue(new Callback<Token>() {
                    @Override
                    public void onResponse(Call<Token> call, Response<Token> response) {
                        unToken = response.body();
                        Intent myIntent = new Intent(getApplicationContext(), VisiteurActivity.class);
                        myIntent.putExtra("username", binding.txtLogin.getText().toString());
                        myIntent.putExtra("token", unToken.getToken());
                        startActivity(myIntent);
                    }

                    @Override
                    public void onFailure(Call<Token> call, Throwable t) {
                        Toast.makeText(MainActivity.this, "Une erreur est survenue !",
                                Toast.LENGTH_SHORT).show();
                    }
                });


            }
        });
    }
}