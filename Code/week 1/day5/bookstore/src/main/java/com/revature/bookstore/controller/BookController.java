package com.revature.bookstore.controller;

import com.revature.bookstore.entity.Book;
import com.revature.bookstore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;


    @PostMapping("/books")
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public Book createBook(@RequestParam String title, @RequestParam String author, @RequestParam String description) {
        return bookService.createBook(new Book(title, author, description));
    }

    @GetMapping("/books")
    @ResponseBody
    public List<Book> displayBooks() {
        return bookService.DisplayBooks();
    }

    @DeleteMapping("/books/{id}")
    @ResponseBody
    public String deleteBook(@PathVariable Long id) {
        return bookService.deleteBook(id);
    }

    @PutMapping("/books/{id}")
    @ResponseBody
    public String updateBook(@PathVariable Long id, @RequestParam String title, @RequestParam String author, @RequestParam String description) {
        return bookService.updateBook(id, title, author, description);

    }

}
