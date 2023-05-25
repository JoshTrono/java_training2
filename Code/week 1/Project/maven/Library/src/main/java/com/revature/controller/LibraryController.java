package com.revature.controller;

import com.revature.Library.Book;
import com.revature.Library.Library;
import com.revature.Library.LibraryMember;
import com.revature.LibraryApplication;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import com.revature.Library.Library.*;


@Controller
@RequestMapping("/library")
public class LibraryController {

    public static Library library = new Library();
    public static Book book1 = new Book("Lord of the Rings", "J. R. R. Tolkien", 1954);
    public static Book book2 = new Book("Science Tectbook", "Scientist", 1998);


    @PostMapping("/addBook")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public String addBook(@RequestParam String title, @RequestParam String authorName, @RequestParam int publicationYear) {
        Book book = new Book(title, authorName, publicationYear);
        library.addBook(book);
        return "Book got added";
    }

    @GetMapping("/displayBooks")
    @ResponseBody
    public ArrayList<Book> displayBooks() {

        return library.printBooks();
    }

    @DeleteMapping("/removeBook")
    @ResponseBody
    public String removeBook(@RequestParam String title, @RequestParam int publicationYear) {
        return library.removeBook(title, publicationYear);
    }
    @PostMapping("/addMember")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public String addMember(@RequestParam String name, @RequestParam String address, @RequestParam int id) {
        LibraryMember member = new LibraryMember(name, address, id);
        library.addMember(member);
        return "Member got added";
    }
    @GetMapping("/displayMembers")
    @ResponseBody
    public ArrayList<LibraryMember> displayMembers() {

        return library.printMembers();
    }
}
