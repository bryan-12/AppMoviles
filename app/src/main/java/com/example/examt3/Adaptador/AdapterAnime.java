package com.example.examt3.Adaptador;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.examt3.MainActivity;
import com.example.examt3.R;

import java.util.ArrayList;

public class AdapterAnime extends RecyclerView.Adapter<AdapterAnime.AnimeViewHolder>{
    private boolean favorito = true;
    ArrayList<MainActivity.Anime> mData;
    Context context;

    public AdapterAnime(ArrayList<MainActivity.Anime> anime, Context context) {

        mData = anime;
        this.context=context;
    }

    @NonNull
    @Override
    public AnimeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.anime, parent, false);
        AdapterAnime.AnimeViewHolder vh = new AdapterAnime.AnimeViewHolder(v,context);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull AnimeViewHolder holder, int position) {
        Context context = holder.context;
        TextView nombre = holder.itemView.findViewById(R.id.nombre);
        TextView descri = holder.itemView.findViewById(R.id.info);
        ImageView image = holder.itemView.findViewById(R.id.imagen);
/*
        ImageButton boton = holder.itemView.findViewById(R.id.estrella);

        int pos = boton.getTop();

        Log.i("MYAPP","numero de boton: " + pos);

        boton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if(favorito){
                    favorito = false;
                    boton.setImageResource(R.drawable.favorito);
                    Toast.makeText(context.getApplicationContext(),"Añadido a favoritos", Toast.LENGTH_LONG).show();
                }else
                {
                    favorito = true;
                    boton.setImageResource(R.drawable.no_favorito);
                    Toast.makeText(context.getApplicationContext(),"Eliminado de favoritos", Toast.LENGTH_LONG).show();

                }
            }
        });*/

        String nomb = mData.get(position).getTitulo();
        String desc = mData.get(position).getDescripcion();
        String imag = mData.get(position).getImage();
        nombre.setText(nomb);
        descri.setText(desc);
        Glide.with(context).load(imag).into(image);

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class AnimeViewHolder extends RecyclerView.ViewHolder{
        public Context context;
        public AnimeViewHolder(@NonNull View itemView, Context context) {
            super(itemView);
            this.context = context;
        }
    }

}
