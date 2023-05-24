public class LibraryMember {
    String name;
    int id;
    int numBooks;
    Book[] books;
    public LibraryMember(String name, int id) {
        this.name = name;
        this.id = id;
        this.numBooks = 0;
        this.books = new Book[3];
    }
//    public void addBook(Book book) {
//        if (numBooks < 3) {
//            books[numBooks] = book;
//            numBooks++;
//        }
//    }
//    public void printBooks() {
//        System.out.println("Books borrowed by " + name + ":");
//        for (int i = 0; i < numBooks; i++) {
//            System.out.println(books[i].getTitle());
//        }
//    }
    public static void main(String[] args) {
        LibraryMember member = new LibraryMember("John", 123);
        Book book1 = new Fiction();
        book1.setTitle("The Lord of the Rings");
        member.addBook(book1);
        Book book2 = new Fiction();
        book2.setTitle("The Hobbit");
        member.addBook(book2);
        Book book3 = new Fiction();
        book3.setTitle("The Silmarillion");
        member.addBook(book3);
        member.printBooks();
    }
}