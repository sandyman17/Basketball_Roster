import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public class PlayerList {
    private ArrayList<Player> players;

    public PlayerList(ArrayList<Player> players) {

        this.players = players;
    }

    public ArrayList<Player> getPlayers() {

        return players;
    }

    public void setPlayers(ArrayList<Player> players) {

        this.players = players;
    }

    public void addPLayer(Player newPlayer) {


    }

    public Player findPG() {
        ArrayList<Player> posPlayers = new ArrayList<>();
        Player newPlayer;
        for (int i = 0; i < players.size(); i ++) {
            if (players.get(i).getPosition().equalsIgnoreCase("pg")) {
                posPlayers.add(players.get(i));
            }
        }

        ArrayList<Player> skillPlayers = new ArrayList<Player>();

        for (int j = 0; j < posPlayers.size(); j ++) {
            if (posPlayers.get(j).checkSkill("Point Phenom")) {
                skillPlayers.add(posPlayers.get(j));
            }
        }
        if (skillPlayers.size() == 0) {
            skillPlayers.add(posPlayers.get(0));
        }

        ArrayList<Player> attPlayers = new ArrayList<Player>();

        for (int k = 0; k < skillPlayers.size(); k ++) {
            if (skillPlayers.get(k).getLayup() + skillPlayers.get(k).getShooting() + skillPlayers.get(k).getPassing() > 280) {
                attPlayers.add(skillPlayers.get(k));
            }
        }
        if (attPlayers.size() == 0) {
            attPlayers.add(posPlayers.get(0));
        }

        int specAtt = 0;
        int index = 0;

        for (int a = 0; a < attPlayers.size(); a ++) {
            if (attPlayers.get(a).getDefense() > specAtt) {
                specAtt = attPlayers.get(a).getDefense();
                index = a;
            }
        }
        newPlayer = attPlayers.get(index);

        return newPlayer;
    }

    public Player findSG() {
        Player newPlayer;
        ArrayList<Player> posPlayers = new ArrayList<>();

        for (int i = 0; i < players.size(); i ++) {
            if (players.get(i).getPosition().equalsIgnoreCase("sg")) {
                posPlayers.add(players.get(i));
            }
        }
        for (int j = 0; j < posPlayers.size(); j ++) {
            if (posPlayers.get(j).checkSkill("GOAT")) {
                newPlayer = posPlayers.get(j);
                return newPlayer;
            }
        }
        int specAtt = 0;
        int index = 0;

        for (int a = 0; a < posPlayers.size(); a ++) {
            if (posPlayers.get(a).getDefense() + posPlayers.get(a).getShooting() + posPlayers.get(a).getPassing() + posPlayers.get(a).getLayup() + posPlayers.get(a).getAthletics() > specAtt) {
                specAtt = posPlayers.get(a).getDefense() + posPlayers.get(a).getShooting() + posPlayers.get(a).getPassing() + posPlayers.get(a).getLayup() + posPlayers.get(a).getAthletics();
                index = a;
            }
        }
        newPlayer = posPlayers.get(index);

        return newPlayer;
    }

    public Player findSF() throws IOException{
        Player newPlayer;
        ArrayList<Player> skillPlayers = new ArrayList<Player>();
        ArrayList<Player> posPlayers = new ArrayList<>();

        for (int i = 0; i < players.size(); i ++) {
            if (players.get(i).getPosition().equalsIgnoreCase("sf")) {
                posPlayers.add(players.get(i));
            }
        }

        for (int j = 0; j < posPlayers.size(); j ++) {
            if (posPlayers.get(j).checkSkill("Floor General")) {
                skillPlayers.add(posPlayers.get(j));
            }
            if (posPlayers.get(j).checkSkill("The King")) {
                skillPlayers.add(posPlayers.get(j));
            }
        }
        if (skillPlayers.size() == 0) {
            skillPlayers.add(posPlayers.get(0));
        }

        int specAtt = 0;
        int index = 0;

        for (int a = 0; a < skillPlayers.size(); a ++) {
            if (skillPlayers.get(a).getTotalAttribute() > specAtt) {
                specAtt =skillPlayers.get(a).getTotalAttribute();
                index = a;
            }
        }
        newPlayer = skillPlayers.get(index);

        return newPlayer;
    }

    public Player findPF() throws IOException {
        String message = "no position players found!";
        ArrayList<Player> posPlayers = new ArrayList<>();
        Player newPlayer;
        for (int i = 0; i < players.size(); i ++) {
            if (players.get(i).getPosition().equalsIgnoreCase("pf")) {
                posPlayers.add(players.get(i));
            }
        }

        ArrayList<Player> attPlayers = new ArrayList<>();
        if (posPlayers.size() == 0) {
            try {
                throw new UnsupportedRosterException(message);
            } catch (UnsupportedRosterException e) {
                e.printStackTrace();
            }
        }

        for (int j = 0; j < posPlayers.size(); j ++) {
            if (posPlayers.get(j).getShooting() > 80) {
                attPlayers.add(posPlayers.get(j));
            }
            if (posPlayers.get(j).getLayup() > 95) {
                attPlayers.add(posPlayers.get(j));
            }

        }
        if (attPlayers.size() == 0) {
            attPlayers.add(posPlayers.get(0));
        }

        int specAtt = 0;
        int index = 0;

        for (int a = 0; a < attPlayers.size(); a ++) {
            if (attPlayers.get(a).getDefense() + attPlayers.get(a).getRebound() + attPlayers.get(a).getAthletics() > specAtt) {
                specAtt = attPlayers.get(a).getDefense() + attPlayers.get(a).getRebound() + attPlayers.get(a).getAthletics();
                index = a;
            }
        }
        newPlayer = attPlayers.get(index);

        return newPlayer;
    }

    public Player findC() throws IOException{
        ArrayList<Player> posPlayers = new ArrayList<>();
        Player newPlayer;
        for (int i = 0; i < players.size(); i ++) {
            if (players.get(i).getPosition().equalsIgnoreCase("c")) {
                posPlayers.add(players.get(i));
            }
        }
        ArrayList<Player> skillPlayers = new ArrayList<Player>();
        for (int j = 0; j < posPlayers.size(); j ++) {
            if (posPlayers.get(j).checkSkill("Paint Dominator")) {
                skillPlayers.add(posPlayers.get(j));
            }
        }
        if (skillPlayers.size() == 0) {
            skillPlayers.add(posPlayers.get(0));
            throw new UnsupportedEncodingException();
        }

        int specAtt = 0;
        int index = 0;

        for (int a = 0; a < skillPlayers.size(); a ++) {
            if (skillPlayers.get(a).getDefense() + skillPlayers.get(a).getShooting() + skillPlayers.get(a).getRebound() + skillPlayers.get(a).getLayup() + skillPlayers.get(a).getAthletics() > specAtt) {
                specAtt = skillPlayers.get(a).getDefense() + skillPlayers.get(a).getShooting() + skillPlayers.get(a).getRebound() + skillPlayers.get(a).getLayup() + skillPlayers.get(a).getAthletics();
                index = a;
            }
        }
        newPlayer = posPlayers.get(index);

        return newPlayer;
    }

}
