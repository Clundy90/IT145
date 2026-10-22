

package coursework.ModuleFiveMileStone;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * The Driver class serves as the main user interface for the
 * Grazioso Salvare Rescue Animal Management System. It handles animal intake,
 * reservation management, and inventory reporting for rescue dogs and monkeys.
 */

public class Driver {
    private static ArrayList<Dog> dogList = new ArrayList<Dog>();
    private static ArrayList<Monkey> monkeyList = new ArrayList<Monkey>();
    
    // Official Grazioso Salvare allowed monkey species array
    private static String[] allowedSpecies = {
        "Capuchin", "Guenon", "Howler", "Marmoset", "Squirrel monkey", "Tamarin"
    };

    /**
     * Main application method. Initializes data, displays menu options, and executes
     * user commands until the user chooses to exit.
     */
    public static void main(String[] args) {

        initializeDogList();
        initializeMonkeyList();

        Scanner scanner = new Scanner(System.in);

        String menuSelection = "";
        
        // Using a do-while loop to call the displayMenu() method and process user input 
        // until the user chooses to quit

        do {
            displayMenu();
            menuSelection = scanner.nextLine().trim();

            switch (menuSelection) {
                case "1":
                    intakeNewDog(scanner);
                    break;
                case "2":
                    intakeNewMonkey(scanner);
                    break;
                case "3":
                    reserveAnimal(scanner);
                    break;
                case "4":
                    printAnimals("dog");
                    break;
                case "5":
                    printAnimals("monkey");
                    break;
                case "6":
                    printAnimals("available");
                    break;
                case "q":
                    System.out.println("Exiting application.");
                    break;
                default:
                    System.out.println("Invalid menu selection. Please try again.");
            }
        } while (!menuSelection.equalsIgnoreCase("q"));
        
        scanner.close();

    }

    // This method prints the menu options
    public static void displayMenu() {
        System.out.println("\n\n");
        System.out.println("\t\t\t\tRescue Animal System Menu");
        System.out.println("[1] Intake a new dog");
        System.out.println("[2] Intake a new monkey");
        System.out.println("[3] Reserve an animal");
        System.out.println("[4] Print a list of all dogs");
        System.out.println("[5] Print a list of all monkeys");
        System.out.println("[6] Print a list of all animals that are not reserved");
        System.out.println("[q] Quit application");
        System.out.println();
        System.out.println("Enter a menu selection");
    }


    // Adds dogs to a list for testing
    public static void initializeDogList() {
        Dog dog1 = new Dog("Spot", "German Shepherd", "male", "1", "25.6", "05-12-2019", "United States", "intake", false, "United States");
        Dog dog2 = new Dog("Rex", "Great Dane", "male", "3", "35.2", "02-03-2020", "United States", "Phase I", false, "United States");
        Dog dog3 = new Dog("Bella", "Chihuahua", "female", "4", "25.6", "12-12-2019", "Canada", "in service", true, "Canada");

        dogList.add(dog1);
        dogList.add(dog2);
        dogList.add(dog3);
    }


    // Adds monkeys to a list for testing
    //Optional for testing
    public static void initializeMonkeyList() {
    // Create three new Monkey objects
    Monkey monkey1 = new Monkey("George", "Capuchin", "4.2", "15.0", "12.0", "male", "2", "15.0", "01-01-2020", "United States", "intake", false, "United States");
    Monkey monkey2 = new Monkey("Lucy", "Tamarin", "3.1", "10.0", "8.5", "female", "5", "10.0", "06-06-2020", "Colombia", "Phase I", false, "Colombia");
    Monkey monkey3 = new Monkey("Max", "Howler", "5.0", "20.0", "16.0", "male", "7", "20.0", "03-03-2019", "Congo", "in service", true, "Congo");

    // Add the monkeys to the monkeyList
    monkeyList.add(monkey1);
    monkeyList.add(monkey2);
    monkeyList.add(monkey3);
}


    /**
     * Method to prompt the user for dog details using the Scanner,
     * validates that the dog does not already exist in the system then instantiates 
     * a new Dog object, and adds it to dogList.
     */


    public static void intakeNewDog(Scanner scanner) {
        System.out.println("What is the dog's name?");
        String name = scanner.nextLine().trim();
        for (Dog dog: dogList) {
            if(dog.getName().equalsIgnoreCase(name)) {
                System.out.println("\n\nThis dog is already in our system\n\n");
                return; //returns to menu
            }
        }

        // Since the dog is not already in the system, prompt user for the details of the new dog
        System.out.println("What is the dog's breed?");
        String breed = scanner.nextLine().trim();

        System.out.println("What is the dog's gender?");
        String gender = scanner.nextLine().trim();

        System.out.println("What is the dog's age?");
        String age = scanner.nextLine().trim();

        System.out.println("What is the dog's weight?");
        String weight = scanner.nextLine().trim();
    
        System.out.println("What is the dog's acquisition date?");
        String acquisitionDate = scanner.nextLine().trim();

        System.out.println("What is the dog's acquisition country?");
        String acquisitionCountry = scanner.nextLine().trim();

        System.out.println("What is the dog's status?");
        String status = scanner.nextLine().trim();

        System.out.println("Is the dog reserved?");
        boolean reserved = Boolean.parseBoolean(scanner.nextLine().trim());

        System.out.println("What is the dog's in-service country?");
        String inServiceCountry = scanner.nextLine().trim();

        // Instantiate new Dog using collected parameters and add to dog list
        Dog newDog = new Dog(name, breed, gender, age, weight, acquisitionDate, acquisitionCountry, status, reserved, inServiceCountry);
        dogList.add(newDog);
        System.out.println("Dog added successfully.");
    }


    /*
     * Prompts the user for monkey details using the Scanner, then input
     * validation to ensure that the monkey does not already exist in the system and that its 
     * species is allowed, prompts the user for additonal monkey details, 
     * then instantiates a new Monkey object, and adds it to monkeyList.
     */

    public static void intakeNewMonkey(Scanner scanner) {
        System.out.println("What is the monkey's name?");
        String name = scanner.nextLine().trim();
        for (Monkey monkey : monkeyList) {
            if (monkey.getName().equalsIgnoreCase(name)) {
                System.out.println("\n\nThis monkey is already in our system\n\n");
                return;
            }
        }

        System.out.println("What is the monkey's species?");
        String species = scanner.nextLine().trim();
        if (species.isEmpty()) {
            System.out.println("Species cannot be empty.");
            return;
        }
        
        // Input Validation: Check if the entered species is in the allowed species array
        boolean speciesAllowed = false;
        for (String allowed : allowedSpecies) {
            if (allowed.equalsIgnoreCase(species)) {
                speciesAllowed = true;
                break;
            }
        }

        if (!speciesAllowed) {
            System.out.println("That monkey species is not accepted.");
            return;
        }


        // Since the monkey is not already in the system and the species is allowed, prompt user for the details
        System.out.println("What is the monkey's tail length?");
        String tailLength = scanner.nextLine().trim();
        
        System.out.println("What is the monkey's height?");
        String height = scanner.nextLine().trim();

        System.out.println("What is the monkey's body length?");
        String bodyLength = scanner.nextLine().trim();

        System.out.println("What is the monkey's gender?");
        String gender = scanner.nextLine().trim();

        System.out.println("What is the monkey's age?");
        String age = scanner.nextLine().trim();

        System.out.println("What is the monkey's weight?");
        String weight = scanner.nextLine().trim();

        System.out.println("What is the monkey's acquisition date?");
        String acquisitionDate = scanner.nextLine().trim();

        System.out.println("What is the monkey's acquisition country?");
        String acquisitionCountry = scanner.nextLine().trim();

        System.out.println("What is the monkey's status?");
        String status = scanner.nextLine().trim();

        System.out.println("Is the monkey reserved?");
        boolean reserved = Boolean.parseBoolean(scanner.nextLine().trim());

        System.out.println("What is the monkey's in-service country?");
        String inServiceCountry = scanner.nextLine().trim();

        // Instantiate new Monkey using the parameters and add to system list
       Monkey newMonkey = new Monkey(name, species, tailLength, height, bodyLength, gender, age, weight,
        acquisitionDate, acquisitionCountry, status, reserved, inServiceCountry);
        monkeyList.add(newMonkey);
        System.out.println("Monkey added successfully.");
    }

    /**
     * Method to reserve an animal based on user input. Prompts the user for the animal type and in-service country,
     * searches the corresponding list for a trained, unreserved animal in that country, and reserves it if found.
     * If no matching animal is found, informs the user.
     */

   public static void reserveAnimal(Scanner scanner) {
       // Prompt for animal type and in-service country
        System.out.println("Enter animal type (dog or monkey):");
        String animalType = scanner.nextLine().trim();

        System.out.println("Enter the in-service country:");
        String country = scanner.nextLine().trim();

        // Search dogs if user requested "dog"
        if (animalType.equalsIgnoreCase("dog")) {
            for (Dog dog : dogList) {
                // Check for a trained, unreserved dog in the requested country
                if (dog.getInServiceCountry().equalsIgnoreCase(country) &&
                    dog.getTrainingStatus().equalsIgnoreCase("in service") &&
                    !dog.getReserved()) {
                    
                    // Reserve the matching dog
                    dog.setReserved(true);
                    System.out.println("Dog " + dog.getName() + " has been successfully reserved.");
                    return;
                }
            }
        } 
        // Search monkeys if user requested "monkey"
        else if (animalType.equalsIgnoreCase("monkey")) {
            for (Monkey monkey : monkeyList) {
                // Check for a trained, unreserved monkey in the requested country
                if (monkey.getInServiceCountry().equalsIgnoreCase(country) &&
                    monkey.getTrainingStatus().equalsIgnoreCase("in service") &&
                    !monkey.getReserved()) {
                    
                    // Reserve the matching monkey
                    monkey.setReserved(true);
                    System.out.println("Monkey " + monkey.getName() + " has been successfully reserved.");
                    return;
                }
            }
        } else {
            // Handle an invalid animal type
            System.out.println("Invalid animal type.");
            return;
        }

        // No matching animal was found
        System.out.println("No available " + animalType + " found in " + country + ".");
    }

    // Print animals based on the requested list type.
    public static void printAnimals(String listType) {
        // Print all dogs.
        if (listType.equalsIgnoreCase("dog")) {
            for (Dog dog : dogList) {
                System.out.println("Name: " + dog.getName() + ", Status: " 
                + dog.getTrainingStatus() + ", Acquisition Country: " + dog.getAcquisitionLocation() + 
                ", Reserved: " + dog.getReserved());
            }
        } 
        // Print all monkeys.
        else if (listType.equalsIgnoreCase("monkey")) {
            for (Monkey monkey : monkeyList) {
                System.out.println("Name: " + monkey.getName() + ", Status: " + 
                monkey.getTrainingStatus() + ", Acquisition Country: " + monkey.getAcquisitionLocation() + 
                ", Reserved: " + monkey.getReserved() + ", Species: " + monkey.getSpecies() +
                ", Tail Length: " + monkey.getTailLength() + ", Height: " + monkey.getHeight() +
                ", Body Length: " + monkey.getBodyLength());
            }
        } 
        // Print all trained, unreserved animals.
        else if (listType.equalsIgnoreCase("available")) {
            for (Dog dog : dogList) {
                if (dog.getTrainingStatus().equalsIgnoreCase("in service") && !dog.getReserved()) {
                    System.out.println("Name: " + dog.getName() + ", Status: " + 
                    dog.getTrainingStatus() + ", Acquisition Country: " + dog.getAcquisitionLocation() + 
                    ", Reserved: " + dog.getReserved());
                }
            }
            
            for (Monkey monkey : monkeyList) {
                if (monkey.getTrainingStatus().equalsIgnoreCase("in service") && !monkey.getReserved()) {
                    System.out.println("Name: " + monkey.getName() + ", Status: " + 
                    monkey.getTrainingStatus() + ", Acquisition Country: " + monkey.getAcquisitionLocation() + 
                    ", Reserved: " + monkey.getReserved());
                }
            }
        } 
        // Handle an invalid list type.
        else {
            System.out.println("This option needs to be implemented");
        }
    }
}