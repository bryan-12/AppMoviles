package com.example.holamundo.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.holamundo.R;
import com.example.holamundo.entities.Contact;

import java.util.List;

//la clase adapter esesita extender de adapter y mandar el view holder
public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ContactViewHolder> {

    //creamos lista de elementos
    private List<Contact> mData;

    public ContactAdapter(List<Contact> data){
        mData=data;
    }


    @NonNull
    @Override
    public ContactViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        //transformamos el xml en una clase para usarlo
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_contact, parent,false);
        ContactViewHolder vh = new ContactViewHolder(view);
        return vh;
    }

    //para ver la lista de elementos
    @Override
    public void onBindViewHolder(@NonNull ContactViewHolder holder, int position) {
        TextView tvContact = holder.itemView.findViewById(R.id.tvContact);
        TextView tvPhones = holder.itemView.findViewById(R.id.tvNumero);
        Contact contact = mData.get(position);
        tvContact.setText(contact.getName());
        tvPhones.setText(String.join("\n",contact.getPhones()));
    }

    //retorna el numero de elementos de la lista
    @Override
    public int getItemCount() {
        return mData.size();
    }

    //por cada clse adapter nesesito una clase view holder
    public class ContactViewHolder extends RecyclerView.ViewHolder{

        public ContactViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
