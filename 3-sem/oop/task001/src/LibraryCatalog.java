import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.*;

public class LibraryCatalog {
    private static final List<BookLocation> catalog = new ArrayList<>();

    public static void main(String[] args) {

        try {
            System.setOut(new PrintStream(System.out, true, "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nМеню:");
            System.out.println("1. Добавить книгу");
            System.out.println("2. Просмотреть все книги");
            System.out.println("3. Найти книгу");
            System.out.println("4. Выйти");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    addBook(scanner);
                    break;
                case "2":
                    viewAllBooks();
                    break;
                case "3":
                    findBook(scanner);
                    break;
                case "4":
                    System.out.println("Выход из программы.");
                    System.exit(0);
                default:
                    System.out.println("Некорректный ввод, попробуйте снова.");
            }
        }
    }

    private static void addBook(Scanner scanner) {
        System.out.println("Введите название книги:");
        String title = scanner.nextLine();

        System.out.println("Введите имя автора:");
        String author = scanner.nextLine();

        System.out.println("Введите комнату:");
        String room = scanner.nextLine();

        System.out.println("Введите шкаф:");
        String cabinet = scanner.nextLine();

        System.out.println("Введите полку:");
        String shelf = scanner.nextLine();

        catalog.add(new BookLocation(title, author, room, cabinet, shelf));
        System.out.println("Книга успешно добавлена.");
    }

    private static void viewAllBooks() {
        if (catalog.isEmpty()) {
            System.out.println("Каталог пуст.");
        } else {
            System.out.println("Список всех книг:");
            for (int i = 0; i < catalog.size(); i++) {
                BookLocation book = catalog.get(i);
                System.out.printf("%d. %s, %s (Комната: %s, Шкаф: %s, Полка: %s)%n",
                        i + 1, book.getTitle(), book.getAuthor(),
                        book.getRoom(), book.getCabinet(), book.getShelf());
            }
        }
    }

    private static void findBook(Scanner scanner) {
        System.out.println("Введите название или автора книги для поиска:");
        String query = scanner.nextLine().toLowerCase();

        List<BookLocation> results = new ArrayList<>();
        for (BookLocation book : catalog) {
            if (book.getTitle().toLowerCase().contains(query) ||
                    book.getAuthor().toLowerCase().contains(query)) {
                results.add(book);
            }
        }

        if (results.isEmpty()) {
            System.out.println("Книги не найдены.");
        } else {
            System.out.println("Найденные книги:");
            for (BookLocation book : results) {
                System.out.printf("%s, %s (Комната: %s, Шкаф: %s, Полка: %s)%n",
                        book.getTitle(), book.getAuthor(),
                        book.getRoom(), book.getCabinet(), book.getShelf());
            }
        }
    }
}
