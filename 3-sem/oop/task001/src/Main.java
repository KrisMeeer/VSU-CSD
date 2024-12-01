import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

public class Main {
    public static void main(String[] args) {

        try {
            System.setOut(new PrintStream(System.out, true, "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        LibraryCatalog catalog = new LibraryCatalog();

        catalog.addBook("Преступление и наказание", "Федор Достоевский", "102", "B", "1");
        catalog.addBook("Война и мир", "Лев Толстой", "101", "A", "3");
        catalog.addBook("Анна Каренина", "Лев Толстой", "101", "A", "4");
        catalog.addBook("Кавказский пленник", "Лев Толстой", "101", "A", "5");
        catalog.addBook("Детство", "Лев Толстой", "101", "B", "7");
        catalog.addBook("Отрочество", "Лев Толстой", "101", "B", "7");
        catalog.addBook("Юность", "Лев Толстой", "101", "B", "7");
        catalog.addBook("Идиот", "Федор Достоевский", "200", "J", "33");
        catalog.addBook("Мастер и Маргарита", "Михаил Булгаков", "56", "X", "16");

        catalog.runConsole();
    }
}
