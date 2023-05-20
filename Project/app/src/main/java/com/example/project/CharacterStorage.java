package com.example.project;

import java.util.ArrayList;

public class CharacterStorage {
    ArrayList<Character> characters = new ArrayList<Character>();
    private static CharacterStorage characterStorage = null;
    private CharacterStorage(){}

    public static CharacterStorage getInstance() {
        if (characterStorage==null) {
            characterStorage = new CharacterStorage();
        }
        return characterStorage;
    }

    public void addCharacterToStorage(Character character) {
        characters.add(character);
    }

    public ArrayList<Character> getCharacters() {
        return characters;
    }
}
