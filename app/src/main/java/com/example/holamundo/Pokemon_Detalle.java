package com.example.holamundo;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.holamundo.entities.Pokemon;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

public class Pokemon_Detalle extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detalle_pokemon);
        ImageView imagen = findViewById(R.id.imagenPokemon);
        TextView nombre = findViewById(R.id.nombreP);
        TextView tipo = findViewById(R.id.tipoP);
        TextView codigo = findViewById(R.id.codigoP);
        Button irA = findViewById(R.id.goP);

        Intent intent = getIntent();
        String clase = intent.getStringExtra("clase");
        Pokemon pokemon = new Gson().fromJson(clase, Pokemon.class);

        Log.i("Nombre: ",pokemon.getNombre());

        nombre.setText(pokemon.getNombre());
        tipo.setText(pokemon.getTipo());
        codigo.setText(pokemon.getCodigo());
        Picasso.get().load("https://servicanto.com.co/images/giphy.gif").into(imagen);

        irA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Pokemon_Detalle.this, MapsActivity.class);

                String nombre = String.valueOf(pokemon.getNombre());
                Double latitud = Double.valueOf(pokemon.getLatitude());
                Double longitud = Double.valueOf(pokemon.getLongitude());
                intent.putExtra("Descripcion",nombre);
                intent.putExtra("Latitud",latitud);
                intent.putExtra("Longitud",longitud);

                Log.i("MY_APP", String.valueOf(latitud));
                startActivity(intent);
            }
        });

    }

}
