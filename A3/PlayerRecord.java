/**
 * Assignment 3 PlayerRecord Class
 * This class contains the required information regarding a hockey player
 *
 */

import java.util.Objects;

public class PlayerRecord {

    //inisialised required variables
    private String name;
    private String position;
    private String teamName;
    private int gamesPlayed;
    private int goalsScored;
    private int assists;
    private int penaltiesMinutes;
    private int shotOnGoal;
    private int gameWinningGoals;

    //constructor class
    public PlayerRecord(String name, String position, String teamName, int gamesPlayed, int gamesScored, int assists, int penaltiesMinutes, int shotOnGoal, int gameWinningGoals) {
        this.name = name;
        this.position = position;
        this.teamName = teamName;
        this.gamesPlayed = gamesPlayed;
        this.goalsScored = gamesScored;
        this.assists = assists;
        this.penaltiesMinutes = penaltiesMinutes;
        this.shotOnGoal = shotOnGoal;
        this.gameWinningGoals = gameWinningGoals;
    }

    //getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public int getGamesPlayed() {
        return gamesPlayed;
    }

    public void setGamesPlayed(int gamesPlayed) {
        this.gamesPlayed = gamesPlayed;
    }

    public int getGoalsScored() {
        return goalsScored;
    }

    public void setGamesScored(int gamesScored) {
        this.goalsScored = gamesScored;
    }

    public int getAssists() {
        return assists;
    }

    public void setAssists(int assists) {
        this.assists = assists;
    }

    public int getPenaltiesMinutes() {
        return penaltiesMinutes;
    }

    public void setPenaltiesMinutes(int penaltiesMinutes) {
        this.penaltiesMinutes = penaltiesMinutes;
    }

    public int getShotOnGoal() {
        return shotOnGoal;
    }

    public void setShotOnGoal(int shotOnGoal) {
        this.shotOnGoal = shotOnGoal;
    }

    public int getGameWinningGoals() {
        return gameWinningGoals;
    }

    public void setGameWinningGoals(int gameWinningGoals) {
        this.gameWinningGoals = gameWinningGoals;
    }


    //toString method
    @Override
    public String toString() {
        return "PlayerRecord{" +
                "name='" + name + '\'' +
                ", position='" + position + '\'' +
                ", teamName='" + teamName + '\'' +
                ", gamesPlayed=" + gamesPlayed +
                ", gamesScored=" + goalsScored +
                ", assists=" + assists +
                ", penaltiesMinutes=" + penaltiesMinutes +
                ", shotOnGoal=" + shotOnGoal +
                ", gameWinningGoals=" + gameWinningGoals +
                '}';
    }
}
