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

                newBook.displayBook();
                print("Is this correct? Y/N");
                if (scanner.nextLine().toLowerCase() == "y") {
                    library.addBook(newBook);
                    break;
                } else {
                    println("please re-enter the information");
                }

            }



            println("Continue? Y/N");
        } while ((scanner.nextLine().toLowerCase() == "yes") || (scanner.nextLine().toLowerCase() == "y"));

    }

    private static void println(String s) {
        System.out.println(s);
    }
    public static void print(String s) {
        System.out.print(s);
    }
}