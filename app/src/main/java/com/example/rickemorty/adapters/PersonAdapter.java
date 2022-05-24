package com.example.rickemorty.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.rickemorty.R;
import com.example.rickemorty.databinding.ActivityItemPersonBinding;
import com.example.rickemorty.databinding.ActivityMainBinding;
import com.example.rickemorty.model.PersonData;

import java.util.List;

public class PersonAdapter extends RecyclerView.Adapter<PersonAdapter.ViewHolder> {

    private List<PersonData> persons;

    public PersonAdapter(List<PersonData> persons) {
        this.persons = persons;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View item = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_item_person, parent, false);
        return new ViewHolder(item);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        PersonData personagem = persons.get(position);
        Context context = holder.itemView.getContext();

        // Usando o Glide para recuperar as imagens
        Glide.with(context).load(personagem.getImage()).into(holder.image);

        holder.person.setText(personagem.getName());
        holder.gender.setText(personagem.getGender());
        holder.specie.setText(personagem.getSpecies());
        //holder.image.setImageResource(1);



    }

    @Override
    public int getItemCount() {
        return persons.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView person;
        TextView gender;
        TextView specie;
        ImageView image;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            person = itemView.findViewById(R.id.tvPerson);
            gender = itemView.findViewById(R.id.tvGender);
            specie = itemView.findViewById(R.id.tvSpecie);
            image = itemView.findViewById(R.id.imageView);
        }
    }
}
