import java.io.FileNotFoundException;

public class ConsoleApp {
    public static void main(String[] args) {
        try {
            // Чтение данных из файла
            int[][] array = DataProcessor.readDataFromFile("input01.txt");

            // Вывод массива до сдвига
            System.out.println("Массив до сдвига:");
            printArray(array);

            // Выполнение циклического сдвига (пример сдвига столбцов на 1 позицию)
            array = DataProcessor.cyclicShift(array, 1, true);

            // Вывод массива после сдвига
            System.out.println("\n Массив после сдвига:");
            printArray(array);

            // Запись данных в файл
            DataProcessor.writeDataToFile(array, "output01.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void printArray(int[][] array) {
        for (int[] row : array) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
}
