package com.example.project;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class ListCharactersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_characters);
        CharacterStorage characterStorage = CharacterStorage.getInstance();
        RecyclerView recyclerView = findViewById(R.id.rvListCharacters);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new CharacterListAdapter(getApplicationContext(),characterStorage.getCharacters()));
    }
 }
