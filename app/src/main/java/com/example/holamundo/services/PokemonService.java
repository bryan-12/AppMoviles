package com.example.holamundo.services;

import com.example.holamundo.entities.Pokemon;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface PokemonService {
    @GET("pokemons/N00028768")
    Call<List<Pokemon>> getAll();

    @POST("pokemons/N00028768/crear")
    Call<Pokemon> create(@Body Pokemon pokemon);

}
