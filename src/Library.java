import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

// AGGREGATION: Library HAS-A list of Books (books exist independently)
// If library closes, books still exist
public class Library {
    private String libraryId;
    private String libraryName;
    private List<Book> bookCatalog;
    private Map<String, Integer> borrowingLimits; // Different limits by role

    public Library(String libraryId, String libraryName) {
        this.libraryId = libraryId;
        this.libraryName = libraryName;
        this.bookCatalog = new ArrayList<>();
        this.borrowingLimits = new HashMap<>();
        setupBorrowingLimits();
    }

    // Setup borrowing limits for different roles
    private void setupBorrowingLimits() {
        borrowingLimits.put("Student", 5);
        borrowingLimits.put("Faculty", 20);
        borrowingLimits.put("PhD", 30);
    }

    // ENCAPSULATION: Add book to catalog
    public void addBook(Book book) {
        bookCatalog.add(book);
        System.out.println("[Library] Book added: " + book.getTitle());
    }

    // ENCAPSULATION: Get borrowing limit by role
    public int getBorrowingLimit(String role) {
        return borrowingLimits.getOrDefault(role, 3);
    }

    // Find book in catalog
    public Book findBook(String title) {
        for (Book book : bookCatalog) {
            if (book.getTitle().equals(title)) {
                return book;
            }
        }
        return null;
    }

    public void displayLibraryCatalog() {
        System.out.println("\n========== LIBRARY CATALOG ==========");
        System.out.println("Library: " + libraryName);
        for (Book book : bookCatalog) {
            book.displayBookInfo();
        }
    }

    public String getLibraryName() { return libraryName; }
}
