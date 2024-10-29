package ru.vsu.cs.course1;

import ru.vsu.cs.util.SwingUtils;

import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;


public class Program {

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose: console - true, window - false");

        boolean сommand = scanner.nextBoolean();
        if (сommand) {
            console();
        }
        else {
            window();
        }
    }
    public static void window() throws Exception {
        Locale.setDefault(Locale.ROOT);
        //SwingUtils.setLookAndFeelByName("Windows");
        //UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        SwingUtils.setDefaultFont("Microsoft Sans Serif", 18);

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrameMain().setVisible(true);
            }
        });
    }
    public static void console() throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите количество доступных планшетов ");
        int n = scanner.nextInt();
        String[] tabletArray = new String[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Введите название планшета №" + (i + 1) + ": ");
            String name = scanner.next();
            System.out.print("Введите стоимость планшета №" + (i + 1) + ": ");
            String price = scanner.next();
            System.out.print("Введите количество памяти планшета №" + (i + 1) + ": ");
            String memory = scanner.next();
            System.out.print("Введите рейтинг планшета №" + (i + 1) + ": ");
            String rating = scanner.next();
            tabletArray[i] = name + " " + memory + " " + rating + " " + price;
        }
        System.out.print("Введите желаемое количество: ");
        int kol = scanner.nextInt();
        System.out.print("Введите желаемую память устройства: ");
        int memory = scanner.nextInt();
        System.out.print("Введите желаемый рейтинг: ");
        int rating = scanner.nextInt();
        System.out.println(Arrays.toString(Task.task(tabletArray, kol, memory, rating)));
    }
}
