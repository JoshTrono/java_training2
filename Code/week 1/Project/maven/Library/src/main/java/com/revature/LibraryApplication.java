package com.revature;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.revature.Library.Library;
import com.revature.Library.Book;
@SpringBootApplication
public class LibraryApplication {
    public static Library library = new Library();
    public static Book book1 = new Book("Lord of the Rings", "J. R. R. Tolkien", 1954);
    public static Book book2 = new Book("Science Tectbook", "Scientist", 1998);



    public static void main(String[] args) {
        library.addBook(book1);
        library.addBook(book2);
        library.printBooks();
        SpringApplication.run(LibraryApplication.class, args);
    }
}
