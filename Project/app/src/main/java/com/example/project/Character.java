package com.example.project;

public class Character {
    protected String name;
    protected int strength;
    protected int dexterity;
    protected int constitution;
    protected int intelligence;
    protected int wisdom;
    protected int charisma;
    protected String charClass;
    protected String charRace;
    protected int raceImage;
    protected int classImage;

    public Character(String name,int strength, int dexterity, int constitution, int intelligence, int wisdom, int charisma, String charClass, String charRace, int raceImage, int classImage) {
        this.name = name;
        this.strength = strength;
        this.dexterity = dexterity;
        this.constitution = constitution;
        this.intelligence = intelligence;
        this.wisdom = wisdom;
        this.charisma = charisma;
        this.charClass = charClass;
        this.charRace = charRace;
        this.raceImage = raceImage;
        this.classImage = classImage;
    }

    public String getName() {
        return name;
    }
}
