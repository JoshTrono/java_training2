package com.revature.Library;


    public class Book {
        private String title;
        private String author;
        private int publicationYear;

        public void setAuthor(String author) {
            this.author = author;
        }

        public void setPublicationYear(int publicationYear) {
            this.publicationYear = publicationYear;
        }

        public Book() {

        }

        public Book(String title, String author, int publicationYear) {
            this.title = title;
            this.author = author;
            this.publicationYear = publicationYear;
        }
        public void setTitle(String s) {
            this.title = s;
        }

        public String getAuthor() {
            return author;
        }

        public int getPublicationYear() {
            return publicationYear;
        }

        public String getTitle() {
            return this.title;
        }

        public void displayBook() {
            System.out.println("Book name: " + this.title);
            System.out.println("Author: " + this.author);
            System.out.println("PublicationYear: " + this.publicationYear);
        }
    }


