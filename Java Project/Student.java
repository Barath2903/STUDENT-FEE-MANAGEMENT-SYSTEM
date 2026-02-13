public class Student { // Represents one student's fee data and logic.
    private final String studentId; // Unique student identifier.
    private final String name; // Student name.
    private double totalFee; // Total fee amount that must be paid.
    private double paidAmount; // Amount paid so far.
    private boolean totalFeeSet; // Tracks whether total fee has been defined.

    public Student(String studentId, String name) { // Constructs a student with ID and name.
        this.studentId = studentId; // Store student ID.
        this.name = name; // Store student name.
        this.totalFee = 0.0; // Initialize total fee to zero.
        this.paidAmount = 0.0; // Initialize paid amount to zero.
        this.totalFeeSet = false; // Mark total fee as not set.
    }

    public String getStudentId() { // Getter for student ID.
        return studentId; // Return stored student ID.
    }

    public String getName() { // Getter for student name.
        return name; // Return stored student name.
    }

    public boolean isTotalFeeSet() { // Indicates whether total fee is set.
        return totalFeeSet; // Return fee set flag.
    }

    public double getTotalFee() { // Getter for total fee.
        return totalFee; // Return total fee value.
    }

    public double getPaidAmount() { // Getter for paid amount.
        return paidAmount; // Return paid amount value.
    }

    public double getBalance() { // Computes remaining balance.
        if (!totalFeeSet) { // If total fee not defined yet,
            return 0.0; // return zero balance.
        }
        return totalFee - paidAmount; // Otherwise return remaining balance.
    }

    public void setTotalFee(double totalFee) { // Sets total fee for the student.
        if (totalFee <= 0) { // Reject zero or negative fees.
            throw new IllegalArgumentException("Total fee must be greater than 0."); // Signal invalid input.
        }
        this.totalFee = totalFee; // Store total fee.
        this.totalFeeSet = true; // Mark that total fee is now set.
        if (paidAmount > totalFee) { // If already paid exceeds total fee,
            paidAmount = totalFee; // clamp paid amount to total fee.
        }
    }

    public String payFee(double amount) { // Applies a payment and returns a status message.
        if (!totalFeeSet) { // Block payment if total fee not set.
            return "Total fee is not set. Please set the total fee first."; // Warning message.
        }
        if (amount <= 0) { // Reject zero or negative payments.
            return "Payment amount must be greater than 0."; // Error message.
        }
        double balance = getBalance(); // Compute current remaining balance.
        if (amount > balance) { // Prevent overpayment.
            return "Payment exceeds remaining balance. Please enter a valid amount."; // Error message.
        }
        paidAmount += amount; // Add payment to paid amount.
        balance = getBalance(); // Recalculate balance after payment.
        if (balance == 0.0) { // If no balance remains,
            return "Fee paid completely."; // Completion message.
        }
        return "Payment successful. Remaining balance: " + String.format("%.2f", balance); // Success message.
    }
}
