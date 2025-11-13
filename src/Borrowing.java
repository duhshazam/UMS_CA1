import java.time.LocalDate;

// borrowing transaction
public class Borrowing {
    private String borrowingId;
    private Student student;
    private Book book;
    private LocalDate borrowDate;
    private LocalDate dueDate;
    private LocalDate returnDate;
    private double fine;
    private final int BORROWING_DAYS = 14; // 2 weeks
    private final double FINE_PER_DAY = 0.50; // $0.50 per day

    public Borrowing(String borrowingId, Student student, Book book) {
        this.borrowingId = borrowingId;
        this.student = student;
        this.book = book;
        this.borrowDate = LocalDate.now();
        this.dueDate = borrowDate.plusDays(BORROWING_DAYS);
        this.fine = 0;
    }

    // ENCAPSULATION: Return book and calculate fine if late
    public void returnBook() {
        this.returnDate = LocalDate.now();
        calculateFine();
        book.returnBook();
        System.out.println("[Borrowing] Book returned by " + student.getName() + " | Fine: $" + fine);
    }

    // Calculate fine for late return
    private void calculateFine() {
        if (returnDate != null && returnDate.isAfter(dueDate)) {
            long daysLate = java.time.temporal.ChronoUnit.DAYS.between(dueDate, returnDate);
            fine = daysLate * FINE_PER_DAY;
        }
    }

    public double getFine() { return fine; }
    public LocalDate getDueDate() { return dueDate; }
    public Book getBook() { return book; }
    public Student getStudent() { return student; }

    public void displayBorrowingInfo() {
        System.out.println("  Borrowed: " + book.getTitle() + " | Due: " + dueDate);
    }
}
