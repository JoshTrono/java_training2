class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello World!");

        Printer messagePrinter = new Printer();
        messagePrinter.print("Hello");
    }
}

class Printer {
    int number;
    String name;

    public void print(String message) {
        System.out.println(message);
    }
}