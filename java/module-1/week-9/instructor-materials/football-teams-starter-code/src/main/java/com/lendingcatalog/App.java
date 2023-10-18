package com.lendingcatalog;

import com.lendingcatalog.model.*;
import com.lendingcatalog.util.FileStorageService;
import com.lendingcatalog.util.exception.FileStorageException;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.*;

public class App {

    private final Scanner keyboard = new Scanner(System.in);
    private static final String FILE_BASE_PATH = "src/main/resources/";

    // The regex string to split the Strings in the dataset.
    private static final String FIELD_DELIMITER = "\\|";
    private String[] gameDays = {"oct_8", "oct_15", "oct_22"};
    private List<Team> teams = new ArrayList<>();
    private List <Game> allGames = new ArrayList<>();

    public static void main(String[] args) {

        App app = new App();
        app.initialize();
        app.run();
    }

    private void initialize() {
        // Use this method to populate teams and allGames


    }




    private void run() {

            while(true)
            {
                // Main menu loop
                printMainMenu();
                int mainMenuSelection = promptForMenuSelection("Please choose an option: ");
                if (mainMenuSelection == 1) {
                    displayTeams();
                } else if (mainMenuSelection == 2) {
                    displayGames();
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
        System.out.println("** TEAMS **");
        for (Team team : teams) {
            System.out.println(team); // NOTE: display coach info here
        }
        System.out.println();
        promptForReturn();
    }

    private void displayGames() {
        System.out.println("** GAMES **");
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
