package com.example.rickemorty.viewModel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.rickemorty.adapters.PersonAdapter;
import com.example.rickemorty.databinding.ActivityMainBinding;
import com.example.rickemorty.model.PersonData;
import com.example.rickemorty.model.PersonInterface;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private PersonInterface personInterface;
    private RecyclerView.Adapter personAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        setupRetrofit();
        setupPersonList();
    }

    private void setupPersonList() {
        binding.recyclerView.setHasFixedSize(true);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        personInterface.getData().enqueue(new Callback<List<PersonData>>() {
            @Override
            public void onResponse(Call<List<PersonData>> call, Response<List<PersonData>> response) {
                if(response.isSuccessful()){
                    List<PersonData> persons = response.body();
                    personAdapter = new PersonAdapter(persons);
                    binding.recyclerView.setAdapter(personAdapter);
                } else {
                    showErrorMessage();
                }
            }

            @Override
            public void onFailure(Call<List<PersonData>> call, Throwable t) {
                showErrorMessage();
            }
        });
    }

    // Carrega informações da lib retrofit
    private void setupRetrofit() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://rickandmortyapi.com/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

       personInterface = retrofit.create(PersonInterface.class);
    }

    // Lista os dados retornados da API


    private void showErrorMessage(){
        Snackbar.make(binding.getRoot(), "Erro de conexão!", Snackbar.LENGTH_LONG).show();
    }
}