import java.util.ArrayList;
import java.util.Scanner;

class Destination {
    String name;
    String startDate;
    String endDate;
    double budget;

    Destination(String name, String startDate, String endDate, double budget) {
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.budget = budget;
    }

    @Override
    public String toString() {
        return String.format("Destination: %s\nStart Date: %s\nEnd Date: %s\nBudget: $%.2f\n", name, startDate, endDate, budget);
    }
}

public class TravelItineraryPlanner1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Destination> itinerary = new ArrayList<>();
        boolean planning = true;

        System.out.println("Welcome to the Travel Itinerary Planner!");

        while (planning) {
            System.out.println("\nPlease choose an option:");
            System.out.println("1. Add a destination");
            System.out.println("2. View itinerary");
            System.out.println("3. Calculate total budget");
            System.out.println("4. Exit");
            System.out.print("Your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    // Add a destination
                    System.out.print("Enter destination name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter start date (YYYY-MM-DD): ");
                    String startDate = scanner.nextLine();
                    System.out.print("Enter end date (YYYY-MM-DD): ");
                    String endDate = scanner.nextLine();
                    System.out.print("Enter budget for this destination: ");
                    double budget = scanner.nextDouble();
                    scanner.nextLine(); // Consume newline

                    itinerary.add(new Destination(name, startDate, endDate, budget));
                    System.out.println("Destination added successfully!");
                    break;

                case 2:
                    // View itinerary
                    if (itinerary.isEmpty()) {
                        System.out.println("Your itinerary is empty.");
                    } else {
                        System.out.println("\nYour Travel Itinerary:");
                        for (Destination destination : itinerary) {
                            System.out.println(destination);
                        }
                    }
                    break;

                case 3:
                    // Calculate total budget
                    double totalBudget = 0;
                    for (Destination destination : itinerary) {
                        totalBudget += destination.budget;
                    }
                    System.out.printf("\nTotal Budget: $%.2f\n", totalBudget);
                    break;

                case 4:
                    // Exit
                    System.out.println("Thank you for using the Travel Itinerary Planner. Have a great trip!");
                    planning = false;
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }
}