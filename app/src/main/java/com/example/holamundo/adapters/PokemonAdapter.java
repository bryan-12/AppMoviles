package com.example.holamundo.adapters;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.holamundo.R;
import com.example.holamundo.entities.Pokemon;
import com.squareup.picasso.Picasso;

import java.util.List;

public class PokemonAdapter extends RecyclerView.Adapter<PokemonAdapter.PokemonViewHolder>
        implements View.OnClickListener {

    List<Pokemon> mData;
    private View.OnClickListener listener;

    public PokemonAdapter(List<Pokemon> mData) {
        this.mData = mData;
    }

    @NonNull
    @Override
    public PokemonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pokemon, parent, false);
        v.setOnClickListener(this);
        PokemonAdapter.PokemonViewHolder viewHolder = new PokemonAdapter.PokemonViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull PokemonViewHolder holder, int position) {
        TextView name = holder.itemView.findViewById(R.id.nombre);
        TextView tipe = holder.itemView.findViewById(R.id.tipo);
        ImageView image = holder.itemView.findViewById(R.id.imageAnime);

        String nombre = String.valueOf(mData.get(position).getNombre());
        String tipo = String.valueOf(mData.get(position).getTipo());
        String imagen = String.valueOf(mData.get(position).getUrl_imagen());

        Log.i("LOL", nombre + " " + tipo);

        name.setText(nombre);
        tipe.setText(tipo);
        Picasso.get().load(imagen).into(image);

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public void OnClickListener(View.OnClickListener listener){
        this.listener = listener;
    }
    @Override
    public void onClick(View v) {
        if (listener != null){
            listener.onClick(v);
        }
    }

    public class PokemonViewHolder extends RecyclerView.ViewHolder{
        public PokemonViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
