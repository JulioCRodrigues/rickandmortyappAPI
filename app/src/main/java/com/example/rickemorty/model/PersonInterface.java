package com.example.rickemorty.model;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PersonInterface {

    // https://rickandmortyapi.com/api
    @GET("character/1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20")
    Call<List<PersonData>> getData();
}
