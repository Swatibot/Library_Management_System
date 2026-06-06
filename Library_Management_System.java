import java.util.ArrayList;
import java.util.Scanner;

class Book {
    int id;
    String title;
    String author;

    Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
    }

    public String toString() {
        return "ID: " + id + ", Title: " + title + ", Author: " + author;
    }
}

public class LibraryManagementSystem {

    static ArrayList<Book> books = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        // Preloaded Books
        books.add(new Book(101, "Java Programming", "James Gosling"));
        books.add(new Book(102, "Data Structures", "Mark Allen"));
        books.add(new Book(103, "Computer Networks", "Andrew Tanenbaum"));
        books.add(new Book(104, "Operating Systems", "Abraham Silberschatz"));
        books.add(new Book(105, "Database Management System", "Raghu Ramakrishnan"));

        int choice;

        do {
            System.out.println("\n===== LIBRARY MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Book");
            System.out.println("2. Remove Book");
            System.out.println("3. Search Book");
            System.out.println("4. Display All Books");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    addBook();
                    break;

                case 2:
                    removeBook();
                    break;

                case 3:
                    searchBook();
                    break;

                case 4:
                    displayBooks();
                    break;

                case 5:
                    System.out.println("Thank you for using Library Management System!");
                    break;

                default:
                    System.out.println("Invalid Choice! Please try again.");
            }

        } while (choice != 5);
    }

    // Add Book
    static void addBook() {
        System.out.print("Enter Book ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Book Title: ");
        String title = sc.nextLine();

        System.out.print("Enter Author Name: ");
        String author = sc.nextLine();

        books.add(new Book(id, title, author));

        System.out.println("Book Added Successfully!");
    }

    // Remove Book
    static void removeBook() {
        System.out.print("Enter Book ID to Remove: ");
        int id = sc.nextInt();

        boolean found = false;

        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).id == id) {
                books.remove(i);
                found = true;
                System.out.println("Book Removed Successfully!");
                break;
            }
        }

        if (!found) {
            System.out.println("Book Not Found!");
        }
    }

    // Search Book
    static void searchBook() {
        System.out.print("Enter Book ID to Search: ");
        int id = sc.nextInt();

        boolean found = false;

        for (Book book : books) {
            if (book.id == id) {
                System.out.println("\nBook Found:");
                System.out.println(book);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Book Not Found!");
        }
    }

    // Display All Books
    static void displayBooks() {

        if (books.isEmpty()) {
            System.out.println("No Books Available!");
        } else {
            System.out.println("\n===== BOOK LIST =====");

            for (Book book : books) {
                System.out.println(book);
            }
        }
    }
}