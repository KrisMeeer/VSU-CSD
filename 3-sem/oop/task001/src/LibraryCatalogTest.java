import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

import static org.junit.jupiter.api.Assertions.*;

public class LibraryCatalogTest {
    private LibraryCatalog catalog;

    @BeforeEach
    public void setUp() {
        catalog = new LibraryCatalog(); // Инициализация нового каталога перед каждым тестом
    }

    @Test
    public void testAddBooks() {

        try {
            System.setOut(new PrintStream(System.out, true, "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        catalog.addBook("Преступление и наказание", "Федор Достоевский", "102", "B", "1");
        catalog.addBook("Война и мир", "Лев Толстой", "101", "A", "3");
        catalog.addBook("Анна Каренина", "Лев Толстой", "101", "A", "4");
        catalog.addBook("Кавказский пленник", "Лев Толстой", "101", "A", "5");
        catalog.addBook("Детство", "Лев Толстой", "101", "B", "7");
        catalog.addBook("Отрочество", "Лев Толстой", "101", "B", "7");
        catalog.addBook("Юность", "Лев Толстой", "101", "B", "7");
        catalog.addBook("Идиот", "Федор Достоевский", "200", "J", "33");
        catalog.addBook("Мастер и Маргарита", "Михаил Булгаков", "56", "X", "16");

        // Проверочка
        assertEquals(9, catalog.getCatalogSize(), "Каталог должен содержать 9 книг");
        assertEquals("Преступление и наказание", catalog.getBook(0).getTitle(), "Название первой книги должно быть 'Преступление и наказание'");
        assertEquals("Война и мир", catalog.getBook(1).getTitle(), "Название второй книги должно быть 'Война и мир'");
        assertEquals("Анна Каренина", catalog.getBook(2).getTitle(), "Название третьей книги должно быть 'Анна Каренина'");
        assertEquals("Кавказский пленник", catalog.getBook(3).getTitle(), "Название четвертой книги должно быть 'Кавказский пленник'");
        assertEquals("Детство", catalog.getBook(4).getTitle(), "Название пятой книги должно быть 'Детство'");
        assertEquals("Отрочество", catalog.getBook(5).getTitle(), "Название шестой книги должно быть 'Отрочество'");
        assertEquals("Юность", catalog.getBook(6).getTitle(), "Название первой седьмой должно быть 'Юность'");
        assertEquals("Идиот", catalog.getBook(7).getTitle(), "Название восьмой книги должно быть 'Идиот'");
        assertEquals("Мастер и Маргарита", catalog.getBook(8).getTitle(), "Название девятой книги должно быть 'Мастер и Маргарита'");


        catalog.findBook("Михаил Булгаков");
    }
}
