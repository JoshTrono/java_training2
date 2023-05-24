package com.revature.controller;

import com.revature.Library.Book;
import com.revature.LibraryApplication;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import com.revature.Library.Library.*;


@Controller
@RequestMapping("/library")
public class LibraryController {

    @PostMapping("/addBook")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public String addBook(@RequestParam String title, @RequestParam String authorName, @RequestParam int publicationYear) {
        Book book = new Book(title, authorName, publicationYear);
        LibraryApplication.library.addBook(book);
        return "Book got added";
    }

    @GetMapping("/displayBooks")
    @ResponseBody
    public ArrayList<Book> displayBooks() {

        return LibraryApplication.library.printBooks();
    }

    @DeleteMapping("/removeBook")
    @ResponseBody
    public String removeBook(@RequestParam String title, @RequestParam int publicationYear) {
        return LibraryApplication.library.removeBook(title, publicationYear);
    }
}
