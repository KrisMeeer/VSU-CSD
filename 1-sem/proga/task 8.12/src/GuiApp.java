import javax.swing.*;
import java.awt.*;
import java.io.FileNotFoundException;

public class GuiApp {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Array Shift GUI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Чтение данных из файла в JTable
        try {
            int[][] array = DataProcessor.readDataFromFile("ConsoleApp.java");

            // Создание JTable и JScrollPane
            JTable table = new JTable(array.length, array[0].length);
            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array[0].length; j++) {
                    table.setValueAt(array[i][j], i, j);
                }
            }
            JScrollPane scrollPane = new JScrollPane(table);

            // Добавление компонентов на форму
            frame.getContentPane().setLayout(new BorderLayout());
            frame.getContentPane().add(scrollPane, BorderLayout.CENTER);

            // Вывод формы
            frame.setSize(400, 300);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);

            // Выполнение циклического сдвига (пример сдвига строк на 2 позиции)
            array = DataProcessor.cyclicShift(array, 2, false);

            // Запись данных из JTable в файл
            DataProcessor.writeDataToFile(array, "output02.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
