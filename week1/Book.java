package week1;

import java.util.List;


// modifier
public class Book implements Reservable {

    private String isbn;

    private String title;

    private String author;

    private int publicationYear;

    private boolean isReserved;

    // Constructor
    public Book(String title, String author, int publicationYear, String isbn, boolean isReserved) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.isReserved = isReserved;
    }

    // One of the Naming Convention Standards
    // camelCase - snake_case - kebab-case

    // Getters, setters, and toString() methods ...
    public String getAuthor() {
        return this.author;
    }

    public void setAuthor(String authorName) {
        this.author = authorName;
    }

    @Override
    public boolean isAvailable() {
        return isReserved;
    }

    @Override
    public void setReserved(boolean reserved) {
        isReserved = reserved;
    }

}


class Test {

    Book[] booklist = new Book[10];

    Car[] carlist = new Car[10];

    public static Reservable[] test = new Reservable[10];

    public static Car car = new Car("tofaş", false);
    public static Book myBook = new Book("Benim Kitabım", "Ramazan", 2024, "1231231231", false);


    public static void main() {
        test[0] = car;
        test[1] = myBook;
    }
}


class Car implements Reservable {

    private String name;
    private boolean isAvailable;

    public Car(String name, boolean isAvailable) {
        this.name = name;
        this.isAvailable = isAvailable;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean isAvailable() {
        return isAvailable;
    }

    @Override
    public void setReserved(boolean reserved) {
        this.isAvailable = reserved;
    }

}


interface Reservable {
    boolean isAvailable();

    void setReserved(boolean reserved);
}


class ExtendedBook implements Reservable {
    // existing code...
    private boolean isReserved;

    // Implement interface methods
    @Override
    public boolean isAvailable() {
        return !isReserved;
    }

    @Override
    public void setReserved(boolean reserved) {
        isReserved = reserved;
    }
}


class Library {

    private List<Book> books;

    public void addBook(Book book) {
        books.add(book);
    }

    public Book searchByTitle(String title) {
        // ... search logic
        return null;
    }

    public void borrowBook(Book book, String borrower) {
        // ... store borrower information
        book.setReserved(false);
    }

    // ... other methods for library functionalities
    public static void main(String[] args) {
        Book book1 = new Book("Java for Beginners", "John Doe", 2023, "1234567890", false);
        Library library = new Library();
        library.addBook(book1);

        Book borrowedBook = library.searchByTitle("Java for Beginners");
        library.borrowBook(borrowedBook, "Alice");

        // ... further interactions with library and books
    }

}

interface Shape {

    double calculate_area();

}

interface SquareOperation{

    int calculate_x();

}


class Square implements Shape, SquareOperation {

    private int edge;

    public Square(int edge) {
        this.edge = edge;
    }



    @Override
    public double calculate_area() {
        return Math.sqrt(edge);
    }

    public int calculate_x() {
        return 2 * edge;
    }
}


class Circle implements Shape {

    private int radius;

    public Circle(int radius) {
        this.radius = radius;
    }

    @Override
    public double calculate_area() {
        return Math.PI * Math.sqrt(radius);
    }

}