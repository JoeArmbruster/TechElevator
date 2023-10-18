package com.lendingcatalog;

import com.lendingcatalog.model.*;
import com.lendingcatalog.util.FileStorageService;
import com.lendingcatalog.util.exception.FileStorageException;

import java.io.File;
import java.time.LocalDate;
import java.util.*;

public class App {

    private final Scanner keyboard = new Scanner(System.in);
    private static final String FILE_BASE_PATH = "src/main/resources/";

    // The regex string to split the Strings in the dataset.
    private static final String FIELD_DELIMITER = "\\|";
    private List<Team> teams = new ArrayList<>();
    private List<Game> allGames = new ArrayList<>();

    public static void main(String[] args) {

        App app = new App();
        app.initialize();
        app.run();
    }

    private void initialize() {
        // Requirement: Data transformation

        String fileName = FILE_BASE_PATH + "teams.dat";
        List<String> teamInfo = new ArrayList<>();

        try {
            teamInfo = FileStorageService.readContentsOfFile(fileName);
        } catch (FileStorageException e) {
            throw new RuntimeException(e);
        }

        for (String teamLineOfText : teamInfo) {
            String[] singleTeamData = teamLineOfText.split(FIELD_DELIMITER);
            String city = singleTeamData[0];
            String mascot = singleTeamData[1];
            String coach = singleTeamData[2];

            Team team = new Team(city, mascot, coach);
            teams.add(team);
        }

        /*
            Read all game files in results folder
            and add to allGames List
         */
        String logsPath = FILE_BASE_PATH + "results";
        File logDirectory = new File(logsPath);
        // get names of all files in results folder
        String[] logFileNames = logDirectory.list();

        for (String logFileName : logFileNames) {
            System.out.println(logFileName);
            List<Game> daysGames = processDailyGames(FILE_BASE_PATH + "/results/" + logFileName);
            allGames.addAll(daysGames);
        }

    }

    private List<Game> processDailyGames(String dataFileName) {

        List<Game> gamesThatDay = new ArrayList<>();

        List<String> linesOfText = new ArrayList<>();
        try {
            linesOfText = FileStorageService.readContentsOfFile(dataFileName);
        } catch (Exception e) {
            System.out.println("Error reading file: " + dataFileName);
        }

        String dateString = linesOfText.get(0);
        LocalDate date = LocalDate.parse(dateString);

        for (int i = 1; i < linesOfText.size(); i++) {
            String[] gameInfo = linesOfText.get(i).split(FIELD_DELIMITER);
            String team1Name = gameInfo[0];
            int team1Score = Integer.parseInt(gameInfo[1]);
            String team2Name = gameInfo[2];
            int team2Score = Integer.parseInt(gameInfo[3]);

            /* Identify each Team by name listed in File */
            Team team1 = null;
            Team team2 = null;
            for (Team team : teams) {
                if (team.getMascot().equals(team1Name)) {
                    team1 = team;
                } else if (team.getMascot().equals(team2Name)) {
                    team2 = team;
                }
            }

            Game game = new Game(date, team1, team2, team1Score, team2Score);
            gamesThatDay.add(game);
        }
        return gamesThatDay;
    }


    private void run() {

        if (teams.isEmpty()) {
            System.out.println("Teams not loaded");
        } else {
            while (true) {
                // Main menu loop
                printMainMenu();
                int mainMenuSelection = promptForMenuSelection("Please choose an option: ");
                if (mainMenuSelection == 1) {
                    displayTeams();
                } else if (mainMenuSelection == 2) {
                    displayGames();
                }
                // Display data and subsets loop
            }
        }
    }

    // UI methods

    private void printMainMenu() {
        System.out.println("1: Display teams");
        System.out.println("2: Display games");
        System.out.println("0: Exit");
        System.out.println();
    }

    private void displayTeams() {

        for (Team team : teams) {
            System.out.println(team + " Coach: " + team.getCoach());
        }
        System.out.println();
        promptForReturn();
    }

    private void displayGames() {

        for (Game game : allGames) {
            System.out.println(game);
        }
        System.out.println();
        promptForReturn();
    }

    private int promptForMenuSelection(String prompt) {
        System.out.print(prompt);
        int menuSelection;
        try {
            menuSelection = Integer.parseInt(keyboard.nextLine());
        } catch (NumberFormatException e) {
            menuSelection = -1;
        }
        return menuSelection;
    }

    private String promptForString(String prompt) {
        System.out.print(prompt);
        return keyboard.nextLine();
    }


    private void promptForReturn() {
        System.out.println("Press RETURN to continue.");
        keyboard.nextLine();
    }
}
