package com.example.holamundo.services;

import com.example.holamundo.entities.Contact;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ContactService {

    @GET("0c216079-120b-47c9-9ec4-f8513d41a8dd")
    Call<List<Contact>> getAll();

//parametros para buscar, en este caso se llamara query puede tener otro nombre
    @GET("0c216079-120b-47c9-9ec4-f8513d41a8dd")
    Call<List<Contact>> getByQuery(@Query("query") String query);

    @POST("0c216079-120b-47c9-9ec4-f8513d41a8dd")
    Call<Contact> create(@Body Contact contact);

}
