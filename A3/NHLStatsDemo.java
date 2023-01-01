/**
 * This is the demo class where I have read the file and then added the info of players to a linked list and then worked on given outputs as per the instructions
 * <p>
 * Author: Jayvirsinh Raj
 * B00907110
 * <p>
 * Assignment 3 NHLStats demo class
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class NHLStatsDemo {
    public static void main(String[] args) throws FileNotFoundException {

        //inisialize a scanner class
        Scanner kb = new Scanner(System.in);
        //take the file name input
        System.out.print("Enter the filename to read from: ");
        //reading the file
        String fileName = kb.nextLine();
        Scanner inputFile = new Scanner(new File(fileName));

        //declare an object for the list
        NHLStats playerList = new NHLStats();

        //input that are required to be input
        String name, position, teamName;
        int gamesPlayed, gamesScored, assists, penalites, shots, winningGoals;

        PlayerRecord player = null;

        while (inputFile.hasNextLine()) {
            String line = inputFile.nextLine();
            StringTokenizer st = new StringTokenizer(line, "\t");

            //take input from the file
            while (st.hasMoreTokens()) {
                name = st.nextToken();
                position = st.nextToken();
                teamName = st.nextToken();
                gamesPlayed = Integer.parseInt(st.nextToken());
                gamesScored = Integer.parseInt(st.nextToken());
                assists = Integer.parseInt(st.nextToken());
                penalites = Integer.parseInt(st.nextToken());
                shots = Integer.parseInt(st.nextToken());
                winningGoals = Integer.parseInt(st.nextToken());

                //declare an object that contains the details of a player
                player = new PlayerRecord(name, position, teamName, gamesPlayed, gamesScored, assists, penalites, shots, winningGoals);
                //add the player to the list
                playerList.addPlayer(player);
            }
        }
        inputFile.close();
        System.out.println();
        System.out.println("NHL Results Summary");
        System.out.println();

        //get the player with most points
        LinkedList<PlayerRecord> mostPointsPlayers = playerList.mostPoints();
        System.out.println("Players with highest points and their teams:");

        for (int i = 0; i < mostPointsPlayers.size(); i++) {
            System.out.println("Name: " + mostPointsPlayers.getAt(i).getName() + ", Team: " + mostPointsPlayers.getAt(i).getTeamName());
        }
        //mostPointsPlayers.enumerate();
        System.out.println();

        //get the most aggressive player
        LinkedList<PlayerRecord> mostAggressivePlayers = playerList.mostAggressive();
        System.out.println("Most aggressive players, their teams and their positions:");
        for (int i = 0; i < mostAggressivePlayers.size(); i++) {
            System.out.println("Name: " + mostAggressivePlayers.getAt(i).getName() + ", Team: " + mostAggressivePlayers.getAt(i).getTeamName() + ", Position: " + mostAggressivePlayers.getAt(i).getPosition());
        }
        //mostAggressivePlayers.enumerate();
        System.out.println();

        //get mvp
        LinkedList<PlayerRecord> mvpPlayers = playerList.mvp();
        System.out.println("Most valuable players and their teams:");
        for (int i = 0; i < mvpPlayers.size(); i++) {
            System.out.println("Name: " + mvpPlayers.getAt(i).getName() + ", Team: " + mvpPlayers.getAt(i).getTeamName());
        }
        //mvpPlayers.enumerate();
        System.out.println();

        //get the most promising players
        LinkedList<PlayerRecord> mostPromisingPlayers = playerList.mostPromisingPlayer();
        System.out.println("Most promising players and their teams:");
        for (int i = 0; i < mostPromisingPlayers.size(); i++) {
            System.out.println("Name: " + mostPromisingPlayers.getAt(i).getName() + ", Team: " + mostPromisingPlayers.getAt(i).getTeamName());
        }
        //mostPromisingPlayers.enumerate();
        System.out.println();


        //teams with the most penalties
        System.out.println("Teams that had the most number of penalty minutes:");
        playerList.mostPenaltyMinutes();
        System.out.println();

        //get the teams with the most winning players
        System.out.println("Teams that had the most number of penalty minutes:");
        playerList.mostGameWinningGoals();


    }
}
