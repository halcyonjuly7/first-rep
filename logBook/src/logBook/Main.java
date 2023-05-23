package logBook;

import logBook.Borrower;
import logBook.Borrowers;

import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {

    // Define admin username and password
    static String adminUsername = "admin";
    static String adminPassword = "123";

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // Create an Object to store borrowers
        Borrowers borrowersRepo = new Borrowers();
        while (true) {
            System.out.println("1. Log in as admin");
            System.out.println("2. Exit");
            System.out.print("Enter your choice: ");
            int choice = in.nextInt();
            in.nextLine();
            if (choice == 1) {
                System.out.print("Enter username: ");
                String username = in.nextLine();
                System.out.print("Enter password: ");
                String password = in.nextLine();

                // Check if the entered credentials match the admin username and password
                if (username.equals(adminUsername) && password.equals(adminPassword)) {
                    while (true) {
                        System.out.println("1. Add borrower");
                        System.out.println("2. View borrowers");
                        System.out.println("3. Search borrower by name");
                        System.out.println("4. Delete borrower by name");
                        System.out.println("5. Logout");
                        System.out.print("Enter your choice: ");
                        int adminChoice = in.nextInt();
                        in.nextLine();
                        if (adminChoice == 1) {
                            // Add a new borrower
                            System.out.print("Enter date: ");
                            String date = in.nextLine();
                            System.out.print("Enter time: ");
                            String time = in.nextLine();
                            System.out.print("Enter item: ");
                            String item = in.nextLine();
                            System.out.print("Enter quantity: ");
                            String quantity = in.nextLine();
                            System.out.print("Enter grade level: ");
                            String gradeLevel = in.nextLine();
                            System.out.print("Enter section: ");
                            String section = in.nextLine();
                            System.out.print("Enter name: ");
                            String name = in.nextLine();

                            // Create a new Borrower object and add it to the borrowers ArrayList
                            borrowersRepo.addBorrower(new Borrower(
                                    date,
                                    time,
                                    item,
                                    quantity,
                                    gradeLevel,
                                    section,
                                    name));
                            System.out.println("Borrower added successfully!");
                        } else if (adminChoice == 2) {
                            if (borrowersRepo.isEmpty()) {
                                System.out.println("There are no borrowers for today. Try another option.");
                            } else {
                                // View all borrowers
                                borrowersRepo.viewAllBorrowers();

                            }
                        } else if (adminChoice == 3) {
                            if (borrowersRepo.isEmpty()) {
                                System.out.println("There are no borrowers yet.");
                            } else {
                                // Search for a borrower by name
                                // Multiple borrowers could have the same name

                                System.out.print("Enter name to search: ");
                                String nameToSearch = in.nextLine();
                                List<Borrower> foundBorrowers = borrowersRepo.searchByName(nameToSearch);
                                if (foundBorrowers.isEmpty()) {
                                    System.out.println("No borrower found with the given name.");
                                }
                                // Will not iterate for loop if borrowers are empty
                                for (Borrower foundBorrower: foundBorrowers) {
                                    System.out.println(foundBorrower);
                                }

                            }
                        } else if (adminChoice == 4) {
                            System.out.print("Enter name to delete: ");
                            String nameToDelete = in.nextLine();
                            // Multiple borrowers could have the same name
                            boolean hasDeleted = borrowersRepo.deleteBorrowerByName(nameToDelete);
                            System.out.println(hasDeleted ? "Borrower deleted successfully!": "Borrower not found.");

                        } else if (adminChoice == 5) {
                            // Logout from the admin account
                            break;
                        } else {
                            System.out.println("Invalid choice!");
                        }
                    }
                } else {
                    System.out.println("Invalid login credentials!");
                }
            } else if (choice == 2) {
                // Exit the program
                System.out.println("Thank you for using our library!");
                System.exit(0);
            } else {
                System.out.println("Invalid choice!");
            }
        }
    }
}
