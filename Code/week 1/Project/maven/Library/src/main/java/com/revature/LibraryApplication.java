package com.revature;

import com.revature.controller.LibraryController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.revature.Library.Library;
import com.revature.Library.Book;
@SpringBootApplication
public class LibraryApplication {




    public static void main(String[] args) {
        LibraryController.library.addBook(LibraryController.book1);
        LibraryController.library.addBook(LibraryController.book2);
        SpringApplication.run(LibraryApplication.class, args);
    }
}
