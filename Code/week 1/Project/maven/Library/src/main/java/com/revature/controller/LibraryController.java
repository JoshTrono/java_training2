package com.revature.controller;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/library")
public class LibraryController {

    @PostMapping("/addBook")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public String addBook(@RequestParam String title, @RequestParam String authorName, @RequestParam int publicationYear) {
        System.out.println("Book Name: " + title);
        System.out.println("Author Name: " + authorName);
        System.out.println("Publication Year: " + publicationYear);
        return "Book got added";
    }
}
