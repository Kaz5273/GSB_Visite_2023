package com.example.mygsbvisite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.mygsbvisite.Models.Visite;
import com.example.mygsbvisite.databinding.ActivityCreateVisiteBinding;
import com.example.mygsbvisite.databinding.ActivityPraticienBinding;

public class CreateVisiteActivity extends AppCompatActivity {
    private ActivityCreateVisiteBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCreateVisiteBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.btnValider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Visite uneVisite = new Visite();
            }
        });
    }
}