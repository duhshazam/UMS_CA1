
public class Book {
    private String bookId;
    private String title;
    private String author;
    private String isbn;
    private boolean isAvailable;
    private int totalCopies;
    private int availableCopies;

    public Book(String bookId, String title, String author, String isbn, int totalCopies) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.totalCopies = totalCopies;
        this.availableCopies = totalCopies;
        this.isAvailable = true;
    }

    // ENCAPSULATION: Control book borrowing
    public boolean borrowBook() {
        if (availableCopies > 0) {
            availableCopies--;
            if (availableCopies == 0) {
                isAvailable = false;
            }
            System.out.println("[Library] Book borrowed: " + title + " | Copies left: " + availableCopies);
            return true;
        } else {
            System.out.println("[Library] NO COPIES AVAILABLE: " + title);
            return false;
        }
    }

    // ENCAPSULATION: Return book
    public void returnBook() {
        if (availableCopies < totalCopies) {
            availableCopies++;
            isAvailable = true;
            System.out.println("[Library] Book returned: " + title + " | Available: " + availableCopies);
        }
    }

    // Getters
    public String getBookId() { return bookId; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public boolean isAvailable() { return isAvailable; }
    public int getAvailableCopies() { return availableCopies; }

    public void displayBookInfo() {
        System.out.println("  Title: " + title + " | Author: " + author + " | Available: " + availableCopies + "/" + totalCopies);
    }
}
