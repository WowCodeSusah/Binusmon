package com.example.binusmon_project;
import java.util.ArrayList;
public class Character {
    public String name;
    public ArrayList<Students> party = new ArrayList<>();
    public String commend;
    public Character(String name, String commend) {
        this.name = name;
        this.commend = commend;
    }
    public Character(String name, ArrayList<Students> party, String commend) {
        this.name = name;
        this.party = party;
        this.commend = commend;
    }
}
