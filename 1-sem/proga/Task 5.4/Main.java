import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.ROOT);
        System.out.print("¬ведите значение h: ");
        console();
    }

    public static void console()
    {
        int h = getInputFromConsole();
        for (int i = 1; i <= h; i++) {
            printLine(i);
            System.out.print('\n');
        }
    }

    public static void printLine(int length)
    {
        for (int i = 0; i < length; i++)
        {
            if (i % 2 != 0)
                System.out.print('b');
            else
                System.out.print('a');
        }
    }

    public static int getInputFromConsole()
    {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}