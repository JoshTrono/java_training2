public class Book {
    abstract class Book {
        String title;
        int Stock;
        abstract void setTitle(String s);
        String getTitle() {
            return title;
        }
    }

    class Fiction extends Book {
        void setTitle(String s) {
            title = s;
        }
        void setStock(int n) {
            Stock = n;
        }
    }

}