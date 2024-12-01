import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LibraryCatalog {
    private final List<BookLocation> catalog = new ArrayList<>();

    //добавляем книги в каталог
    public void addBook(String title, String author, String room, String cabinet, String shelf) {
        catalog.add(new BookLocation(title, author, room, cabinet, shelf));
    }

    public int getCatalogSize() {
        return catalog.size();
    }

    public BookLocation getBook(int index) {
        return catalog.get(index);
    }

    // Метод для поиска книги по названию или автору
    public void findBook(String query) {
        boolean found = false;
        for (BookLocation book : catalog) {
            if (book.getTitle().toLowerCase().contains(query.toLowerCase()) ||
                    book.getAuthor().toLowerCase().contains(query.toLowerCase())) {
                System.out.println("Найденная книга: ");
                System.out.printf("%s, %s (Комната: %s, Шкаф: %s, Полка: %s)%n",
                        book.getTitle(), book.getAuthor(),
                        book.getRoom(), book.getCabinet(), book.getShelf());
                found = true;
            }
        }
        if (!found) {
            System.out.println("Книги не найдены.");
        }
    }

    // Метод для работы с консолью: добавление книг и поиск
    public void runConsole() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nМеню:");
            System.out.println("1. Добавить книгу");
            System.out.println("2. Найти книгу");
            System.out.println("3. Выйти");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    addBookConsole(scanner);
                    break;
                case "2":
                    System.out.println("Введите название или автора книги для поиска:");
                    String query = scanner.nextLine();
                    findBook(query);
                    break;
                case "3":
                    System.out.println("Выход из программы.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Некорректный ввод, попробуйте снова.");
            }
        }
    }

    // Метод для добавления книги через консоль
    private void addBookConsole(Scanner scanner) {
        String title = getValidInput(scanner, "Введите название книги:");
        String author = getValidInput(scanner, "Введите имя автора:");
        String room = getValidInput(scanner, "Введите комнату:");
        String cabinet = getValidInput(scanner, "Введите шкаф:");
        String shelf = getValidInput(scanner, "Введите полку:");

        addBook(title, author, room, cabinet, shelf);
        System.out.println("Книга успешно добавлена.");
    }

    private String getValidInput(Scanner scanner, String prompt) {
        String input;
        while (true) {
            System.out.println(prompt);
            input = scanner.nextLine().trim();
            if (input.isEmpty()) {
                System.out.println("Ошибка: введено пустое значение. Пожалуйста, попробуйте снова.");
            } else {
                break;
            }
        }
        return input;
    }
}
