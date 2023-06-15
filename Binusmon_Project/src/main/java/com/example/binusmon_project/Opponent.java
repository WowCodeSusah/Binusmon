package com.example.binusmon_project;
import java.util.ArrayList;
public class Opponent extends Character implements Character_Interface{
    public Opponent(String name, String commend) {
        super(name, commend);
    }
    public Opponent(String name, ArrayList<Students> party, String commend) {
        super(name, party, commend);
    }
    public void setName(String name) {
        this.name = name;
    }
    public void addParty(Students party) {
        if (this.party.size() > 3) {
            System.out.println("No");
        } else if (this.party.size() <= 3) {
            this.party.add(party);
        }
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
