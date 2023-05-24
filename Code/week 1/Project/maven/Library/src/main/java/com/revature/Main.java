package com.revature;

import com.revature.Library.Library;

import com.revature.Library.Book;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library();
        Book book1 = new Book("Lord of the Rings", "J. R. R. Tolkien", 1954);
        Book book2 = new Book("Science Tectbook", "Scientist", 1998);
        library.addBook(book1);
        library.addBook(book2);
        library.printBooks();
        String continue1 = "yes";
        do {
            println("1.) Do you want to add a book, 2.) remove a book, 3.) display all books, 4.) go to Library Member section");
            int selection = scanner.nextInt();
            scanner.nextLine();
            while (selection == 1) {
                Book newBook = new Book();
                println("");
                print("Book Title: ");
                newBook.setTitle(scanner.nextLine());

                print("Author Name: ");
                newBook.setAuthor(scanner.nextLine());

                print("Publication Year: ");
                newBook.setPublicationYear(scanner.nextInt());
                println("-----------");
                println("");
                newBook.displayBook();
                print("Is this correct? Y/N ");
                scanner.nextLine();
                String value = scanner.nextLine();
                if (value.equals("y")) {
                    library.addBook(newBook);
                    break;
                } else {
                    println("please re-enter the information");
                }

            }
            if (selection == 2) {
                print("What book you want to remove. Title: ");
                String Title = scanner.nextLine();
                print("Confirmation, what is the publication year: ");
                int pubYar = scanner.nextInt();
                scanner.nextLine();
                println(library.removeBook(Title,pubYar));

            }
            if (selection == 3) {
                library.printBooks();
            }



            println("Continue? Y/N");
            continue1 = scanner.nextLine();
            continue1 = continue1.toLowerCase();
        } while ((continue1.equals("yes")) || (continue1.equals("y")));

    }

    private static void println(String s) {
        System.out.println(s);
    }
    public static void print(String s) {
        System.out.print(s);
    }
}