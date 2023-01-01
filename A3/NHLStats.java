/**
 * Assignment 3 NHLStats class
 *
 * This class contains the required methods in regard to an unordered list in which the player details are needed to be added
 *
 */

import java.util.ArrayList;

public class NHLStats {
    private LinkedList<PlayerRecord> playerRecordList;

    //constructor
    public NHLStats() {
        playerRecordList = new LinkedList<>();
    }

    /**
     * This method adds all the players from the file to the linked list
     * @param a - player details that is input
     */
    public void addPlayer(PlayerRecord a) {
        playerRecordList.add(a);
    }

    /**
     * This file calculates the most points scored by the player
     * most points means the total goals and the total assists by a Player
     * @return - a linked list of all the players who scored the maximum number of points
     */
    public LinkedList<PlayerRecord> mostPoints() {

        int check = playerRecordList.getAt(0).getAssists() + playerRecordList.getAt(0).getGoalsScored();
        LinkedList<PlayerRecord> points = new LinkedList<>();
        PlayerRecord max;

        for (int i = 0; i < playerRecordList.size(); i++) {

            int temp = playerRecordList.getAt(i).getAssists() + playerRecordList.getAt(i).getGoalsScored();

            max = playerRecordList.getAt(i);
            if (temp > check) {
                points.clear();
                points.add(max);
                check = temp;
            } else if (temp == check) {
                points.add(max);
            }
            //get max and return that player
        }
        return points;
    }

    /**
     * This method calculate the most aggressive players in the list
     * most aggressive player is the player with the most penalties minutes
     * @return - a linked list of the players with highest penalites minutes
     */
    public LinkedList<PlayerRecord> mostAggressive() {
        int check = playerRecordList.getAt(0).getPenaltiesMinutes();

        LinkedList<PlayerRecord> points = new LinkedList<>();
        PlayerRecord max;

        for (int i = 0; i < playerRecordList.size(); i++) {

            int temp = playerRecordList.getAt(i).getPenaltiesMinutes();

            max = playerRecordList.getAt(i);
            if (temp > check) {
                points.clear();
                points.add(max);
                check = temp;
            } else if (temp == check) {
                points.add(max);
            }
        }
        return points;
    }

    /**
     * This method calculates the players with most winning goals
     * @return - linked list with the player with most winning goals
     */
    public LinkedList<PlayerRecord> mvp() {

        int check = playerRecordList.getAt(0).getGameWinningGoals();

        LinkedList<PlayerRecord> points = new LinkedList<>();
        PlayerRecord max;

        for (int i = 0; i < playerRecordList.size(); i++) {

            int temp = playerRecordList.getAt(i).getGameWinningGoals();

            max = playerRecordList.getAt(i);
            if (temp > check) {
                points.clear();
                points.add(max);
                check = temp;
            } else if (temp == check) {
                points.add(max);
            }
        }
        return points;
    }

    /**
     * This method returns the players with most shots on the goal
     * @return - linked list of all the players
     */
    public LinkedList<PlayerRecord> mostPromisingPlayer() {
        int check = playerRecordList.getAt(0).getShotOnGoal();

        LinkedList<PlayerRecord> points = new LinkedList<>();
        PlayerRecord max;

        for (int i = 0; i < playerRecordList.size(); i++) {

            int temp = playerRecordList.getAt(i).getShotOnGoal();

            max = playerRecordList.getAt(i);
            if (temp > check) {
                points.clear();
                points.add(max);
                check = temp;
            } else if (temp == check) {
                points.add(max);
            }
        }
        return points;
    }

    /**
     * This method prints all the team with the highest number of penalty minutes
     */
    public void mostPenaltyMinutes() {

        //add all the team names to a different linked list
        ArrayList<String> teams = teams();

        //where the penalities of all teams will be saved
        int[] minutes = new int[teams.size()];
        ArrayList<Integer> minScore = new ArrayList<>();

        //extracts the position of all the teams that have maximum minutes
        for (int i = 0; i < teams.size(); i++) {
            for (int j = 0; j < playerRecordList.size(); j++) {
                if (teams.get(i).equals(playerRecordList.getAt(j).getTeamName())) {
                    minutes[i] += playerRecordList.getAt(j).getPenaltiesMinutes();
                }
            }
            minScore.add(minutes[i]);
        }

        //find the max number of minutes
        int max = 0;
        int check = 0;
        for (int temp1 : minScore) {
            if (max < temp1) {
                max = temp1;
            }
        }
        //extract the team names with the highest penalty minutes and prints the list
        extractTeamNames(teams, minScore, max);

    }

    /**
     * This method extracts the team with the most winning goals
     * That is the sum of total winning goals that all the players of the team have scored
     */
    public void mostGameWinningGoals() {

        //add all the distinct teams to this list
        ArrayList<String> teams = teams();

        //where the total goals of the team will be saved
        int[] winningGoals = new int[teams.size()];
        ArrayList<Integer> timeAll = new ArrayList<>();

        //position of the teams from the teams arraylist is stored
        for (int i = 0; i < teams.size(); i++) {
            for (int j = 0; j < playerRecordList.size(); j++) {
                if (teams.get(i).equals(playerRecordList.getAt(j).getTeamName())) {
                    winningGoals[i] += playerRecordList.getAt(j).getGameWinningGoals();
                }
            }
            timeAll.add(winningGoals[i]);
        }

        //find the maximum number of minutes
        int max = timeAll.get(0);
        int check = 0;
        for (int temp1 : timeAll) {
            if (max < temp1) {
                max = temp1;
            }
        }

        //extract all the distinct teams from the arraylist
        extractTeamNames(teams, timeAll, max);

    }

    /**
     * This method gathers all the distinct teams name in the file of all the players
     *
     * @return - an arraylist of all the distinct teams
     */
    public ArrayList<String> teams() {

        ArrayList<String> teams = new ArrayList<>();

        String teamName = playerRecordList.getAt(0).getTeamName();
        teams.add(teamName);
        for (int i = 0; i < playerRecordList.size(); i++) {
            String teamnameTemp = playerRecordList.getAt(i).getTeamName();
            if (!(teams.contains(teamnameTemp))) {
                teams.add(teamnameTemp);
            }
        }
        return teams;
    }

    /**
     * This method compares the position of the teams arraylist and (total winning goals or the penalty minutes) are prints the team with the highest penalty minutes
     *
     * @param teams - arraylist of all distinct teams
     * @param minScore - total winning goals or the penalty minutes of all teams
     * @param max - the largest int the miScore arraylist
     */
    private void extractTeamNames(ArrayList<String> teams, ArrayList<Integer> minScore, int max) {
        ArrayList<Integer> pos = new ArrayList<>();
        for (int i = 0; i < minScore.size(); i++) {
            if (minScore.get(i) == max) {
                pos.add(i);
            }
        }

        for (Integer po : pos) {
            System.out.println(teams.get(po));
        }
    }

    /**
     * This method is not required but I added this to check if the txt file is added to the list I have added this method
     *
     * This methods prints the whole linked list
     */
    public void printList() {
        playerRecordList.enumerate();
    }
}
