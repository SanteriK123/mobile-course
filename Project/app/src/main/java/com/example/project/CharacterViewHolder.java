package com.example.project;

import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CharacterViewHolder extends RecyclerView.ViewHolder {
    public TextView name;
    public TextView charClass;
    public TextView charRace;
    public TextView strength;
    public TextView dexterity;
    public TextView constitution;
    public TextView intelligence;
    public TextView wisdom;
    public TextView charisma;
    public ImageView imgClass, imgRace, imgBorder1, imgBorder2;
    public CharacterViewHolder(@NonNull View itemView) {
        super(itemView);
        name = itemView.findViewById(R.id.txtName);
        charClass = itemView.findViewById(R.id.txtClass);
        charRace = itemView.findViewById(R.id.txtRace);
        strength = itemView.findViewById(R.id.txtStrength);
        dexterity = itemView.findViewById(R.id.txtDexterity);
        constitution = itemView.findViewById(R.id.txtConstitution);
        intelligence = itemView.findViewById(R.id.txtIntelligence);
        wisdom = itemView.findViewById(R.id.txtWisdom);
        charisma = itemView.findViewById(R.id.txtCharisma);
        imgClass = itemView.findViewById(R.id.imgClass);
        imgRace = itemView.findViewById(R.id.imgRace);
        imgBorder1 = itemView.findViewById(R.id.imgBorder);
        imgBorder2 = itemView.findViewById(R.id.imgBorder2);
    }
}
