import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class DataProcessor {
    public static int[][] readDataFromFile(String fileName) throws FileNotFoundException {
        // Чтение данных из файла и создание двумерного массива
        Scanner scanner = new Scanner(new File(fileName));
        int rows = scanner.nextInt();
        int columns = scanner.nextInt();
        int[][] array = new int[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                array[i][j] = scanner.nextInt();
            }
        }
        return array;
    }

    public static void writeDataToFile(int[][] array, String fileName) throws FileNotFoundException {
        // Запись данных в файл
        PrintWriter writer = new PrintWriter(new File(fileName));
        writer.println(array.length + " " + array[0].length);

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                writer.print(array[i][j] + " ");
            }
            writer.println();
        }
        writer.close();
    }

    public static int[][] cyclicShift(int[][] array, int shiftValue, boolean shiftColumns) {
        // Реализация циклического сдвига
        int rows = array.length;
        int columns = array[0].length;

        if (shiftColumns) {
            for (int i = 0; i < shiftValue; i++) {
                int temp = array[0][columns - 1];
                for (int j = columns - 1; j > 0; j--) {
                    for (int k = 0; k < rows; k++) {
                        array[k][j] = array[k][j - 1];
                    }
                }
                array[0][0] = temp;
            }
        } else {
            for (int i = 0; i < shiftValue; i++) {
                int temp = array[rows - 1][0];
                for (int j = rows - 1; j > 0; j--) {
                    for (int k = 0; k < columns; k++) {
                        array[j][k] = array[j - 1][k];
                    }
                }
                array[0][0] = temp;
            }
        }

        return array;
    }
}