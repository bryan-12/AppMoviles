package com.example.holamundo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

public class Final_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);
        Button listar = findViewById(R.id.myList);
        Button crear = findViewById(R.id.capture);
        //Button registrar = findViewById(R.id.register);
        ImageView image = findViewById(R.id.logo);
        Picasso.get().load("https://www.movilzona.es/app/uploads/2016/12/pokemon-go-portada-varios.jpg?x=810").into(image);

        listar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Final_Activity.this,List_pokemones.class);
                startActivity(intent);
            }
        });
        crear.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Final_Activity.this,new_pokemon.class);
                startActivity(intent);
            }
        });
       /* registrar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Final_Activity.this,List_pokemones.class);
                startActivity(intent);
            }
        });*/

    }
}
