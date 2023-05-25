package com.revature.Library;

import java.util.ArrayList;

public class Library {


    ArrayList<Book> books = new ArrayList<>();

    ArrayList<LibraryMember> members = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
    }
    public void addMember(LibraryMember member) {
        members.add(member);
    }
    public ArrayList<Book> printBooks() {
//        System.out.println("Books in the library:");
//        for (Book book : books) {
//            System.out.println(book.getTitle() + ", Author: " + book.getAuthor() + ", Publication Year: " + book.getPublicationYear());
//        }
        return books;
    }
    public String removeBook(String title, int pubYear) {
        for (Book book : books) {
            if ((title.equals(book.getTitle())) && (book.getPublicationYear() == pubYear)) {
                books.remove(book);
                return ("It got deleted");
            } else {
                return ("Either title or publication year is incorrect");
            }
        }
        return ("No books inside this library");
    }

    public ArrayList<LibraryMember> printMembers() {
        return members;
    }
//    public void printMembers() {
//        System.out.println("Members of the library:");
//        for (LibraryMember member : members) {
//            System.out.println(member.getName());
//        }
    }
