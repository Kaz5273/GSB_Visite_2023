package com.example.mygsbvisite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.mygsbvisite.databinding.ActivityMainBinding;
import com.example.mygsbvisite.databinding.ActivityPraticienBinding;

public class PraticienActivity extends AppCompatActivity {
    private ActivityPraticienBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPraticienBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
    }
}