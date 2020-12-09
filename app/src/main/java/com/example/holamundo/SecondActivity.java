package com.example.holamundo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.example.holamundo.adapters.ContactAdapter;
import com.example.holamundo.entities.Contact;
import com.example.holamundo.services.ContactService;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        //resiviendo datos de la primera actividad
        Intent intent=getIntent();
        String v=intent.getStringExtra("MI_CLAVEOBJECT");//resivimos el primer datos
        Contact c=new Gson().fromJson(v,Contact.class);
        /*  int i=intent.getIntExtra("MI_CLAVE_INT", 0);
        Boolean b=intent.getBooleanExtra("MI_CLAVE_BOOL", false);*/

        Log.i("MY_APP","El valor es"+ c.getId());
        Log.i("MY_APP","El valor es"+ c.getName());
        //resiviendo datos de la primera actividad FIN


        Log.i("MY_APP","Segunda actividad cargada");

        RecyclerView recyclerView= findViewById(R.id.rvContacts);
        recyclerView.setHasFixedSize(true);//para optimizar
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        /*List<String> data = new ArrayList<>();
        data.add("Elemento 1");
        data.add("Elemento 2");
        data.add("Elemento 3");
        data.add("Elemento 4");
        data.add("Elemento 5");*/


        Log.i("MAIN_APP","Iniciando el adaptador Mock");
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://webhook.site/") //debe terminar con slash(/) siempre
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ContactService service = retrofit.create(ContactService.class);
         //llamamos a toda la lista

       // Call<List<Contact>> call = service.getAll();//para el post creo xd
       /*  //prueba post
        Contact contact=new Contact();
        contact.setName("Brayan");
        List<String> phones= new ArrayList<>();
        phones.add("+51 963258741");
        phones.add("+51 963258741");
        contact.setPhones(phones);
        Call<Contact> call=service.create(contact);
        call.enqueue(new Callback<Contact>() {
            @Override
            public void onResponse(Call<Contact> call, Response<Contact> response) {

            }

            @Override
            public void onFailure(Call<Contact> call, Throwable t) {

            }
        });*/

 //comentado para probar post
        //llamamos a algunos segun el parametro
        Call<List<Contact>> call = service.getByQuery("Brayan");


        //Si responde y hay coneccion, ya sea que la app de errores igual esta respondiendo
        // el segundo metodo es cuando no responde, no hay internet por ejemplo
        call.enqueue(new Callback<List<Contact>>() {
            @Override
            public void onResponse(Call<List<Contact>> call, Response<List<Contact>> response) {
                if (response.code()==200){
                    List<Contact>contacts = response.body();
                    Log.i("MAIN_APP","Conexion exitosa");
                    Log.i("MAIN_APP",new Gson().toJson(contacts));

                    Log.i("MAIN_APP","Llenando el Adaptador Mock");
                    //el mas importante pasamos n patron adaptador, es el que contruye cada elemento con sus valores, debeoms construir un adaptador que estara en otra clase
                    recyclerView.setAdapter(new ContactAdapter(contacts));
                }else {
                    Log.i("MAIN_APP","Error con la app");
                }

            }

            @Override
            public void onFailure(Call<List<Contact>> call, Throwable t) {
                Log.i("MAIN_APP","No pudimos conectarnos con el servidor");
            }
        });


    }
}