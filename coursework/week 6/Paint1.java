import java.util.InputMismatchException;
import java.util.Scanner;

public class Paint1 {

    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        double wallHeight = 0.0;
        double wallWidth = 0.0;
        double wallArea = 0.0;
        double gallonsPaintNeeded = 0.0;
        
        final double squareFeetPerGallons = 350.0;
        
        // Loops until the user enters a valid number greater than 0
        do {
            // Re-prompt the user on every attempt
            System.out.println("Enter wall height (feet): ");
            try {
                wallHeight = scnr.nextDouble();
            } catch (InputMismatchException exception) {
                // Remove invalidinput from scanner
                scnr.next();
            }
        } while (wallHeight <= 0);

        // Loopsuntil the user enters a valid number greater than 0

        do {
            // Re-prompt the user on every attempt
            System.out.println("Enter wall width (feet): ");
            try {
                wallWidth = scnr.nextDouble();
            } catch (InputMismatchException exception) {
                // Remove invalid input from scanner
                scnr.next();
            }
        } while (wallWidth <= 0);

        scnr.close();
        
        // Estimate the paint required 
        wallArea = wallHeight * wallWidth;
        System.out.println("\nWall area: " + wallArea + " square feet");

        gallonsPaintNeeded = wallArea / squareFeetPerGallons;
        System.out.println("Paint needed: " + gallonsPaintNeeded + " gallons\n");

    }
}