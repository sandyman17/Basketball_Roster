import java.util.ArrayList;
import java.io.IOException;

public class Player {
    private String firstName;
    private String lastName;
    private String position;
    private int shooting;
    private int passing;
    private int layup;
    private int athletics;
    private int defense;
    private int rebound;
    private ArrayList<String> skills;
    private int totalAttribute;

    public Player(String firstName, String lastName, String position, int shooting, int passing, int layup, int athletics, int defense, int rebound, ArrayList<String> skills) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.position = position;
        this.shooting = shooting;
        this.passing = passing;
        this.layup = layup;
        this.athletics = athletics;
        this.defense = defense;
        this.rebound = rebound;
        this.skills = skills;
        this.totalAttribute = shooting + passing + layup + athletics + defense + rebound;
    }
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {

        this.firstName = firstName;
    }

    public String getLastName() {

        return lastName;
    }

    public void setLastName(String lastName) {

        this.lastName = lastName;
    }

    public String getPosition() {

        return position;
    }

    public void setPosition(String position) {

        this.position = position;
    }

    public int getShooting() {

        return shooting;
    }

    public void setShooting(int shooting) {

        this.shooting = shooting;
    }

    public int getPassing() {

        return passing;
    }

    public void setPassing(int passing) {

        this.passing = passing;
    }

    public int getLayup() {
        return layup;
    }

    public void setLayup(int layup) {

        this.layup = layup;
    }

    public int getAthletics() {

        return athletics;
    }

    public void setAthletics(int athletics) {

        this.athletics = athletics;
    }

    public int getDefense() {

        return defense;
    }

    public void setDefense(int defense) {

        this.defense = defense;
    }

    public int getRebound() {

        return rebound;
    }

    public void setRebound(int rebound) {

        this.rebound = rebound;
    }

    public ArrayList<String> getSkills() {

        return skills;
    }

    public void setSkills(ArrayList<String> skills) {

        this.skills = skills;
    }

    public int getTotalAttribute() {

        return totalAttribute;
    }

    public void setTotalAttribute(int totalAttribute) {

        this.totalAttribute = totalAttribute;
    }

    public boolean checkSkill(String skill) {
        for (int i = 0; i < this.skills.size(); i ++) {
            if (skills.get(i).equalsIgnoreCase(skill)) {
                return true;
            }
        }
        return false;


    }

}
