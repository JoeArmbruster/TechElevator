import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.*;

public class App {
    private final Scanner sc = new Scanner(System.in);
    private final String FILE_PATH = "src/main/data/runner_data.txt";
    File dataFile = new File(FILE_PATH);
    private static int nextId;

    private Map<Integer, Runner> runners = new HashMap<>();

    private static int getNextid() {
        return nextId;
    }

    private static void incrementId() {
        nextId++;
    }

    public static void main(String[] args) throws FileNotFoundException {
        App app = new App();
        app.loadRunners();
        app.run();
    }

    private void loadRunners() throws FileNotFoundException {

        try (Scanner fileReader = new Scanner(dataFile)) {
            nextId = Integer.parseInt(fileReader.nextLine());
            System.out.println("next id: " + nextId);
            while (fileReader.hasNextLine()) {

                String lineOfInput = fileReader.nextLine();
                String[] runnerData = lineOfInput.split("\\s+");
                int bibNumber = Integer.parseInt(runnerData[0]);
                String firstName = runnerData[1];
                String lastName = runnerData[2];

                Runner runner = new Runner(firstName, lastName, bibNumber);
                runners.put(bibNumber, runner);
            }
            sortRunners();
        } catch (FileNotFoundException e) {
            // Could not find the file at the specified path
            System.out.println("The runner data file was not found at " + dataFile.getAbsolutePath());
        }
    }

    private Runner generateRunner() {
        String firstName = null;
        String lastName = null;
        int id = getNextId();
        incrementId();

        do {
            System.out.print("Enter runner's first name: ");
            firstName = sc.nextLine();
        } while (firstName == null || firstName.isBlank());
        do {
            System.out.print("Enter runner's last name: ");
            lastName = sc.nextLine();
        } while (lastName == null || lastName.isBlank());

        return new Runner(firstName, lastName, id);
    }

    private void addRunnerToFile(Runner runner) {
        try (PrintWriter dataOutput = new PrintWriter(new FileOutputStream(FILE_PATH, true))) {
            String runnerString = "\n" + runner.getFirstName() + '\t' + runner.getLastName() + '\t' + runner.getBibNumber();
            dataOutput.print(runnerString);
        } catch (FileNotFoundException e) {
            System.err.println("Cannot open the file for writing.");
        }
    }

    private void run() {

        while (true) {
            // Main menu loop
            printMainMenu();
            int mainMenuSelection = promptForMenuSelection("Please choose an option: ");
            if (mainMenuSelection == 1) {
                displayAllRunners();
            } else if (mainMenuSelection == 2) {
                int bibNumber = -1;
                do {
                    System.out.print("Please enter the runner's bib number: ");
                    try {
                        bibNumber = Integer.parseInt(sc.nextLine());
                        System.out.println("Looking up bib number " + bibNumber);
                        Runner selectedRunner = runners.get(bibNumber);
                        if (selectedRunner == null) {
                            System.out.println("**Bib number " + bibNumber + " not found.**");
                            bibNumber = -1;
                        } else {
                            System.out.println(selectedRunner);
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid entry. Need a valid integer.");
                        bibNumber = -1;
                    }
                } while (bibNumber == -1) ;



            } else if (mainMenuSelection == 3) {
                System.out.println("Add new runners here");
                Runner newRunner = generateRunner();
                System.out.println("Adding new runner:");
                System.out.println(newRunner);
                runners.put(newRunner.getBibNumber(), newRunner);

            } else if (mainMenuSelection == 4) {
                System.out.println("Saving new configuration");
                try (PrintWriter outputFile = new PrintWriter(dataFile)) {
                    System.out.println(getNextid());
                    outputFile.println(getNextid());

                    runners = new TreeMap<>(runners); // sorts it by key (bib number)
                    for (Map.Entry<Integer, Runner> runner : runners.entrySet()) {
                        System.out.println(runner.getValue().singleLineString());
                        outputFile.println(runner.getValue().singleLineString());
                    }
                    // outputFile.flush();
                } catch (FileNotFoundException e) {
                    System.out.println("Error writing to file at " + dataFile.getAbsolutePath());
                }


            } else if (mainMenuSelection == 0) {
                break;
            }
        }
    }

    // UI methods

    private static int getNextId() {
        return nextId;
    }

    private void printMainMenu() {
        System.out.println("\n**OPTIONS**");
        System.out.println("1: Display all runners");
        System.out.println("2: Display a single runner");
        System.out.println("3: Add a runner");
        System.out.println("4: Save information to file");
        System.out.println("0: Exit");
        System.out.println();
    }

    private int promptForMenuSelection(String prompt) {
        System.out.print(prompt);
        int menuSelection;
        try {
            menuSelection = Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            menuSelection = -1;
        }
        return menuSelection;
    }

    public void displayAllRunners() {
        for (Map.Entry<Integer, Runner> runner : runners.entrySet()) {
            System.out.println(runner);
        }
    }

    public void sortRunners() {
        runners = new TreeMap<>(runners); // sorts it by key (bib number)
    }

}
