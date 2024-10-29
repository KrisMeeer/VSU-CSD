import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ввод размера массива
        System.out.print("Введите размер массива: ");
        int size = scanner.nextInt();

        // Ввод элементов массива
        System.out.println("Введите элементы массива:");
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = scanner.nextInt();
        }

        // Находим среднее арифметическое
        double average = 0;
        for (int num : array) {
            average += num;
        }
        average /= size;

        // Находим минимальный элемент
        int min = array[0];
        for (int num : array) {
            if (num < min) {
                min = num;
            }
        }

        // Подсчитываем количество элементов больших или равных среднему и не равных минимальному
        int count = 0;
        for (int num : array) {
            if (num >= average && num != min) {
                count++;
            }
        }

        System.out.println("Количество элементов, больших или равных среднему и не равных минимальному: " + count);
    }
}