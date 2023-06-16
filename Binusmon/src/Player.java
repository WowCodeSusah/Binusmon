import java.util.ArrayList;

public class Player {
    public String name;
    public ArrayList<Students> party = new ArrayList<>();
    public String commend;

    public void setName(String name) {
        this.name = name;
    }
    public void addParty(Students party) {
        this.party.add(party);
    }
    public void replaceParty(Students party, int i) {
        this.party.set(i, party);
    }
    public Students getParty_One() {
        return party.get(0);
    }
    public Students getParty_Two() {
        return party.get(1);
    }
    public Students getParty_Three() {
        return party.get(2);
    }
    public Students getParty_Four() {
        return party.get(3);
    }
    public void setCommend(String commend) {
        this.commend = commend;
    }
}
