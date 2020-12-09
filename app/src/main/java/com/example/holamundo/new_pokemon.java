package com.example.holamundo;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.holamundo.entities.Pokemon;
import com.example.holamundo.services.PokemonService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class new_pokemon extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_pokemon);
        EditText nombre = findViewById(R.id.name);
        EditText tipo = findViewById(R.id.tipe);
        EditText imagen = findViewById(R.id.image);
        EditText latitud = findViewById(R.id.latitud);
        EditText longitud = findViewById(R.id.longitud);
        Button crear = findViewById(R.id.newPokemon);

        crear.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                String name = nombre.getText().toString().trim();
                String tipos = tipo.getText().toString().trim();
                String image = imagen.getText().toString().trim();
                String latitude = latitud.getText().toString().trim();
                String longitude = longitud.getText().toString().trim();

                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl("https://upn.lumenes.tk")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                PokemonService service = retrofit.create(PokemonService.class);

                Pokemon pokemon = new Pokemon();
                pokemon.setNombre(name);
                pokemon.setTipo(tipos);
                pokemon.setUrl_imagen(image);
                pokemon.setLatitude(latitude);
                pokemon.setLongitude(longitude);

                Call<Pokemon> call = service.create(pokemon);

                call.enqueue(new Callback<Pokemon>() {
                    @Override
                    public void onResponse(Call<Pokemon> call, Response<Pokemon> response) {
                        if(response.code() == 200){
                            Log.i("Web","Conexion todo ok :D");
                        }else {
                            Log.i("Web","Conexion nada ok F");
                        }
                    }
                    @Override
                    public void onFailure(Call<Pokemon> call, Throwable t) {
                        Log.i("Web","NO pudimos conectarnos al servidor");
                    }
                });
                Intent intent = new Intent(new_pokemon.this,Final_Activity.class);
                startActivity(intent);
            }
        });

    }
}
