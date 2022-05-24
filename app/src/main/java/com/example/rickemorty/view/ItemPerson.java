package com.example.rickemorty.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.rickemorty.databinding.ActivityItemPersonBinding;

public class ItemPerson extends AppCompatActivity {

    private ActivityItemPersonBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityItemPersonBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
    }
}