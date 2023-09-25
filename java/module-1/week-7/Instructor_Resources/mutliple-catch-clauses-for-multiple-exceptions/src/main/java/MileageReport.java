import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.InputMismatchException;
import java.util.Scanner;


public class MileageReport {
    public static void main(String[] args) {

        final DecimalFormat FORMAT = new DecimalFormat("0.0");
        String fileName = "MileageData.txt";
        int months = 0;
        double monthlyMileage;
        double totalMiles = 0.0;
        double averageMiles;

        try {
            // Open the file
            File file = new File (fileName);
            Scanner inputFile = new Scanner (file);

            // Process the contents of the file
            while (inputFile.hasNext()) {
                // Get a month's sales amount
                monthlyMileage = inputFile.nextDouble();

                // Add to total sales
                totalMiles += monthlyMileage;

                // Increment the month counter
                months++;
            }

            averageMiles = totalMiles / months;

            System.out.println("Months: " + months);
            System.out.println("Total Miles: " + FORMAT.format(totalMiles));
            System.out.println("Average Miles: " + FORMAT.format(averageMiles));

            // Close the file
            inputFile.close();

        } catch (FileNotFoundException e) {
            // Thrown by Scanner constructor when file is not found
            System.err.println("The file " + fileName + " doesn't exist");
        } catch (InputMismatchException e) {
            // Thrown by the Scanner class's nextDouble() method
            // when it encounters non-numeric data
            System.err.println("Non-numeric data found in the file");
        }

        System.out.println("Do we reach this code? ");
    }
}
