package com.example.project;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CharacterListAdapter extends RecyclerView.Adapter<CharacterViewHolder>{
    private final Context context;
    private final ArrayList<Character> characters;

    public CharacterListAdapter(Context context, ArrayList<Character> characters) {
        this.context = context;
        this.characters = characters;
    }
    @NonNull
    @Override
    public CharacterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CharacterViewHolder(LayoutInflater.from(context).inflate(R.layout.character_view,parent,false));
    }
    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull CharacterViewHolder holder, int position) {
        holder.name.setText(characters.get(position).name);
        holder.charClass.setText(characters.get(position).charClass.substring(0,1).toUpperCase()+(characters.get(position).charClass.substring(1).toLowerCase()));
        holder.charRace.setText(characters.get(position).charRace.substring(0,1).toUpperCase()+(characters.get(position).charRace.substring(1).toLowerCase()));
        holder.strength.setText("Strength: "+characters.get(position).strength);
        holder.dexterity.setText("Dexterity: "+characters.get(position).dexterity);
        holder.constitution.setText("Constitution: "+characters.get(position).constitution);
        holder.intelligence.setText("Intelligence: "+characters.get(position).intelligence);
        holder.wisdom.setText("Wisdom: "+characters.get(position).wisdom);
        holder.charisma.setText("Charisma: "+characters.get(position).charisma);
        holder.imgClass.setImageResource(characters.get(position).classImage);
        holder.imgRace.setImageResource(characters.get(position).raceImage);
        holder.imgBorder1.setImageResource(R.drawable.border);
        holder.imgBorder2.setImageResource(R.drawable.border);
    }

    @Override
    public int getItemCount() {
        return characters.size();
    }
}
