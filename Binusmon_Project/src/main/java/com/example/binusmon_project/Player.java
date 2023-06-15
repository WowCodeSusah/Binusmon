package com.example.binusmon_project;
import java.util.ArrayList;
public class Player extends Character implements Character_Interface {
    public Player(String name, String commend) {
        super(name, commend);
    }
    public Player(String name, ArrayList<Students> party, String commend) {
        super(name, party, commend);
    }
    public void setName(String name) {
        this.name = name;
    }
    public void addParty(Students party) {
        this.party.add(party);
    }
    public void replaceParty(Students party, int i) {
        this.party.set(i, party);
    }
    public Students getParty(int i) {
        return party.get(i);
    }
    public void setCommend(String commend) {
        this.commend = commend;
    }
}
