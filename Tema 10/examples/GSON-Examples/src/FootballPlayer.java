// https://github.com/RicardoMoya/Gson_Example
// https://jarroba.com/gson-json-java-ejemplos/

import java.util.List;

public class FootballPlayer {

    private int dorsal;
    private String name;
    private List<String> demarcation;
    private String team;

    public FootballPlayer() {
    }

    public FootballPlayer(int dorsal, String name, List<String> demarcation, String team) {
        this.dorsal = dorsal;
        this.name = name;
        this.demarcation = demarcation;
        this.team = team;
    }

    public int getDorsal() {
        return dorsal;
    }

    public void setDorsal(int dorsal) {
        this.dorsal = dorsal;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getDemarcation() {
        return demarcation;
    }

    public void setDemarcation(List<String> demarcation) {
        this.demarcation = demarcation;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    @Override
    public String toString() {
        return "Dorsal=" + dorsal + ", Name=" + name + ", Demarcation=" + demarcation + ", Team=" + team;
    }

}
