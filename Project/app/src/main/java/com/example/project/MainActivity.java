package com.example.project;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void switchToListCharactersActivity(View view) {
        Intent intent = new Intent(this,ListCharactersActivity.class);
        startActivity(intent);
    }

    public void generateCharacter(View view) {
        CharacterStorage characters = CharacterStorage.getInstance();
        Character character = generateAttributes();
        generateName(character);
        characters.addCharacterToStorage(character);
        notifyCharacterGenerated();
    }
    private Character generateAttributes() {
        /*Replicates the method in DnD where we roll 4 dice, remove the lowest roll, add together*/
        /*We will repeat this for every stat of the character*/
        ArrayList<Integer> stats = new ArrayList<>();
        String[] races = getResources().getStringArray(R.array.Races);
        String[] classes = getResources().getStringArray(R.array.Classes);
        Random random = new Random();
        for (int i = 0;i<6;i++) {
            ArrayList<Integer> diceRolls = new ArrayList<>();
            for (int y = 0; y<4;y++) {
                diceRolls.add(random.nextInt(6)+1);
            }
            Collections.sort(diceRolls);
            diceRolls.remove(0);
            System.out.println(diceRolls);
            Integer stat = diceRolls.stream().reduce(0, Integer::sum);
            System.out.println(stat);
            stats.add(stat);
        }
        /*Select a random class and race*/
        String charClass = classes[random.nextInt(classes.length)];
        String charRace = races[random.nextInt(races.length)];
        int classImg = this.getResources().getIdentifier(charClass, "drawable", this.getPackageName());
        int raceImg = this.getResources().getIdentifier(charRace, "drawable", this.getPackageName());
        return new Character("",stats.get(0),stats.get(1),stats.get(2),stats.get(3),stats.get(4),stats.get(5),charClass,charRace,classImg,raceImg);
    }
    private void generateName(Character character) {
        StringBuilder name = new StringBuilder();
        ArrayList<String> generateName = new ArrayList<>();
        String[] vowels;
        String[] consonants;
        Random random = new Random();
        int letterChoice = random.nextInt(2);
        int nameLength = random.nextInt(6)+3;
        int vowelWeight = 0;
        int consonantWeight = 0;
        switch (character.charRace) {
            case "human":
                vowels = new String[]{"a", "e", "i", "o", "u"};
                consonants = new String[]{"c", "d", "f", "g", "h", "j", "k", "l", "m", "n", "p", "r", "s", "t", "v"};
                break;
            case "elf":
                vowels = new String[]{"a", "e", "o", "u", "y"};
                consonants = new String[]{"c", "d", "f", "g", "h", "k", "l", "m", "n", "p", "q", "r", "s", "t", "v", "w"};
                break;
            case "orc":
                vowels = new String[]{"a", "i", "o", "u", "ö"};
                consonants = new String[]{"c", "d", "f", "g", "h", "j", "k", "m", "n", "p", "r", "s", "t", "x", "z"};
                break;
            default:
                vowels = new String[]{"o", "u", "ä", "ö", "y"};
                consonants = new String[]{"b", "c", "d", "f", "g", "p", "r", "s", "t", "x", "z"};
                break;
        }
        /*Randomly pick a vowel or consonant and add it to the end of the array*/
        /*no more than 2 consonants or vowels allowed in a row*/
        for (int i = 0; i<nameLength; i++) {
            if (letterChoice==0) {
                generateName.add(vowels[random.nextInt(vowels.length)]);


                vowelWeight+=1;
            } else {
                generateName.add(consonants[random.nextInt(consonants.length)]);
                consonantWeight+=1;
            }
            if (vowelWeight>=2) {
                letterChoice=1;
                vowelWeight=0;
                continue;
            }
            if (consonantWeight>=2) {
                letterChoice=0;
                consonantWeight=0;
                continue;
            }
            letterChoice = random.nextInt(2);
        }
        /*Check if first 2 letters are consonants, if they are switch the first letter to a vocal.*/
        if (checkIfContainsConsonant(generateName.get(0),consonants) && checkIfContainsConsonant(generateName.get(1),consonants)) {
            generateName.set(0, vowels[random.nextInt(vowels.length)]);
        }
        generateName.set(0,generateName.get(0).toUpperCase());
        /*Use the values in the array to generate the final string*/
        for (int i = 0;i< generateName.size();i++) {
            name.append(generateName.get(i));
        }
        character.name = String.valueOf(name);
    }
    private boolean checkIfContainsConsonant(String letter, String[] consonants) {
        for (String consonant : consonants) {
            if (Objects.equals(letter, consonant)) {
                return true;
            }
        }
        return false;
    }
    private void notifyCharacterGenerated() {
        MediaPlayer sound;
        sound = MediaPlayer.create(this, R.raw.sound);
        sound.setOnCompletionListener(mp -> {
            mp.reset();
            mp.release();
        });
        sound.start();
        TextView notification = findViewById(R.id.txtNotifyCharacterGenerated);
        notification.append("Character has been generated!");
        new CountDownTimer(1500, 1000){
            public void onTick(long millisUntilFinished){
            }
            public  void onFinish(){
                notification.setText("");
            }
        }.start();
    }
}