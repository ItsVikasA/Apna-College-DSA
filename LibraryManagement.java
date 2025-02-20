import java.util.ArrayList;
import java.util.Scanner;

class Book {
    int id;
    String title;
    String author;

    Book(int id, String title, String author){
        this.id = id;
        this.title = title;
        this.author = author;
    }

    public String toString() {
        return "ID: " + id + ", Title: " + title + ", Author: " + author;
    }
}

public class LibraryManagement {
    static ArrayList<Book> books = new ArrayList<>();
    static int bookId = 1;
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n1. Add Book\n2. View Books\n3. Search Book\n4. Delete Book\n5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1 -> addBook();
                case 2 -> viewBooks();
                case 3 -> searchBook();
                case 4 -> deleteBook();
                case 5 -> {
                    System.out.println("Exiting...");
                    return;
                }
                default -> System.out.println("Invalid choice. Try again!");
            }
        }
    }

    static void addBook() {
        System.out.print("Enter book title: ");
        String title = scanner.nextLine();
        System.out.print("Enter author: ");
        String author = scanner.nextLine();

        books.add(new Book(bookId++, title, author));
        System.out.println("Book added successfully!");
    }

    static void viewBooks() {
        if (books.isEmpty()) {
            System.out.println("No books found!");
            return;
        }
        for (Book b : books) {
            System.out.println(b);
        }
    }

    static void searchBook() {
        System.out.print("Enter book title to search: ");
        String title = scanner.nextLine();
        for (Book b : books) {
            if (b.title.equalsIgnoreCase(title)) {
                System.out.println("Book Found: " + b);
                return;
            }
        }
        System.out.println("Book not found!");
    }

    static void deleteBook() {
        System.out.print("Enter book ID to delete: ");
        int id = scanner.nextInt();
        books.removeIf(b -> b.id == id);
        System.out.println("Book deleted (if found)!");
    }
}