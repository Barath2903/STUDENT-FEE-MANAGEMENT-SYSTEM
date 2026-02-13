import java.util.Scanner; // Provides console input utilities.

public class MainApp { // Main entry point for the console app.
    private static final Scanner SCANNER = new Scanner(System.in); // Shared scanner for all input.

    public static void main(String[] args) { // Application start.
        System.out.println("Student Fee Management System"); // Print title.
        System.out.println("--------------------------------"); // Print separator.

        String studentId = readNonEmptyString("Enter Student ID: "); // Read required ID.
        String name = readNonEmptyString("Enter Student Name: "); // Read required name.

        Student student = new Student(studentId, name); // Create Student object.

        boolean running = true; // Controls the main loop.
        while (running) { // Repeat until user chooses exit.
            printMenu(); // Show available menu options.
            int choice = readInt("Select an option: "); // Read menu choice.
            switch (choice) { // Branch based on user choice.
                case 1 -> handleSetTotalFee(student); // Option 1: set total fee.
                case 2 -> handlePayFee(student); // Option 2: pay fee.
                case 3 -> handleViewDetails(student); // Option 3: view details.
                case 4 -> { // Option 4: exit.
                    running = false; // Stop the loop.
                    System.out.println("Exiting. Goodbye!"); // Exit message.
                }
                default -> System.out.println("Invalid option. Please choose between 1 and 4."); // Invalid choice.
            }
        }
    }

    private static void printMenu() { // Prints the menu to the console.
        System.out.println(); // Blank line for spacing.
        System.out.println("1. Set Total Fee"); // Menu item 1.
        System.out.println("2. Pay Fee"); // Menu item 2.
        System.out.println("3. View Fee Details"); // Menu item 3.
        System.out.println("4. Exit"); // Menu item 4.
    }

    private static void handleSetTotalFee(Student student) { // Handles total fee setup.
        double totalFee = readDouble("Enter total fee amount: "); // Read total fee amount.
        try { // Protect against invalid fee values.
            student.setTotalFee(totalFee); // Apply total fee.
            System.out.println("Total fee set to: " + String.format("%.2f", student.getTotalFee())); // Confirm.
        } catch (IllegalArgumentException ex) { // Catch invalid fee input.
            System.out.println(ex.getMessage()); // Print error.
        }
    }

    private static void handlePayFee(Student student) { // Handles fee payment.
        if (!student.isTotalFeeSet()) { // Ensure total fee is set.
            System.out.println("Total fee is not set. Please set the total fee first."); // Warn user.
            return; // Stop this action.
        }
        double amount = readDouble("Enter payment amount: "); // Read payment.
        String result = student.payFee(amount); // Apply payment via Student class.
        System.out.println(result); // Display result.
    }

    private static void handleViewDetails(Student student) { // Displays current fee details.
        System.out.println("Student ID: " + student.getStudentId()); // Show student ID.
        System.out.println("Student Name: " + student.getName()); // Show student name.
        if (!student.isTotalFeeSet()) { // If total fee not set yet,
            System.out.println("Total Fee: Not set"); // Show not-set status.
            System.out.println("Paid Amount: 0.00"); // Show zero paid.
            System.out.println("Balance: 0.00"); // Show zero balance.
            return; // Skip remaining output.
        }
        System.out.println("Total Fee: " + String.format("%.2f", student.getTotalFee())); // Show total fee.
        System.out.println("Paid Amount: " + String.format("%.2f", student.getPaidAmount())); // Show paid amount.
        System.out.println("Balance: " + String.format("%.2f", student.getBalance())); // Show balance.
        if (student.getBalance() == 0.0) { // If balance is fully paid,
            System.out.println("Fee paid completely."); // Print completion message.
        }
    }

    private static String readNonEmptyString(String prompt) { // Reads a non-empty string.
        while (true) { // Loop until valid input.
            System.out.print(prompt); // Display prompt.
            String input = SCANNER.nextLine().trim(); // Read and trim input.
            if (!input.isEmpty()) { // Validate non-empty input.
                return input; // Return valid input.
            }
            System.out.println("Input cannot be empty. Please try again."); // Error message.
        }
    }

    private static int readInt(String prompt) { // Reads an integer from input.
        while (true) { // Loop until valid integer.
            System.out.print(prompt); // Display prompt.
            try { // Attempt to parse integer.
                int value = Integer.parseInt(SCANNER.nextLine().trim()); // Parse input.
                return value; // Return valid integer.
            } catch (NumberFormatException ex) { // Handle invalid integer.
                System.out.println("Please enter a valid number."); // Error message.
            }
        }
    }

    private static double readDouble(String prompt) { // Reads a decimal number from input.
        while (true) { // Loop until valid number.
            System.out.print(prompt); // Display prompt.
            try { // Attempt to parse decimal.
                double value = Double.parseDouble(SCANNER.nextLine().trim()); // Parse input.
                return value; // Return valid decimal.
            } catch (NumberFormatException ex) { // Handle invalid decimal.
                System.out.println("Please enter a valid amount."); // Error message.
            }
        }
    }
}
