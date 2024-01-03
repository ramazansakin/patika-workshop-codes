package week1;

import java.util.List;

public class LibraryItem {
    private String title;
    private String author;
    private int publicationYear;
    private String isbn;

    public LibraryItem(String title, String author, int publicationYear, String isbn) {
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.isbn = isbn;
    }

    // Getters, setters, and toString() methods...
}

class Book2 extends LibraryItem implements Reservable {
    private boolean isReserved;

    public Book2(String title, String author, int publicationYear, String isbn) {
        super(title, author, publicationYear, isbn);
    }

    // Implement Reservable interface methods
    @Override
    public boolean isAvailable() {
        return !isReserved;
    }

    @Override
    public void setReserved(boolean reserved) {
        isReserved = reserved;
    }
}


class LibraryTest {

    public void processReservables(List<Reservable> reservables) {
        for (Reservable item : reservables) {
            System.out.println(item.isAvailable());
            // Additional processing...
        }
    }
}


