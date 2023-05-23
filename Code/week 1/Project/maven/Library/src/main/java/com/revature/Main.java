package com.revature;

import com.revature.Library.Library;

import com.revature.Library.Book;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        Book book1 = new Book();
        Book book2 = new Book();
        book1.setTitle("Lord of the Rings");
        book2.setTitle("Science TextBook");
        library.addBook(book1);
        library.addBook(book2);
        library.printBooks();
    }
}