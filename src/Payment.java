import java.time.LocalDate;

// tuition, fees, fines
public class Payment {
    private String paymentId;
    private Student student;
    private double amount;
    private String paymentType; // "Tuition", "Fine", "Fee"
    private LocalDate paymentDate;
    private boolean isPaid;

    public Payment(String paymentId, Student student, double amount, String paymentType) {
        this.paymentId = paymentId;
        this.student = student;
        this.amount = amount;
        this.paymentType = paymentType;
        this.isPaid = false;
    }

    // ENCAPSULATION: Process payment
    public void processPayment() {
        this.paymentDate = LocalDate.now();
        this.isPaid = true;
        System.out.println("[Payment] " + paymentType + " of $" + amount + " processed for " + student.getName());
    }

    public boolean isPaid() { return isPaid; }
    public double getAmount() { return amount; }
    public String getPaymentType() { return paymentType; }
    public LocalDate getPaymentDate() { return paymentDate; }

    public void displayPaymentInfo() {
        System.out.println("  " + paymentType + ": $" + amount + " | Status: " + (isPaid ? "PAID" : "PENDING"));
    }
}
