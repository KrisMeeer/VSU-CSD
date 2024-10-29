package ru.vsu.cs.course1;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Task {
    public static String[] task(String[] arr, int k, int m, int r) {
        List<Tablet> tablets = new ArrayList<>();
        for (String input : arr) {
            String[] parts = input.split(" ");
            String model = parts[0];
            int memory = Integer.parseInt(parts[1]);
            int rating = Integer.parseInt(parts[2]);
            double price = Double.parseDouble(parts[3]);
            tablets.add(new Tablet(model, memory, rating, price));
        }
        List<Tablet> filteredTablets = new ArrayList<>();
        for (Tablet tablet : tablets) {
            if (tablet.memory >= m && tablet.rating >= r) {
                filteredTablets.add(tablet);
            }
        }
        // Сорт цена
        filteredTablets.sort(Comparator.comparingDouble(t -> t.price));
        // дешевые
        List<Tablet> selectedTablets = filteredTablets.subList(0, Math.min(k, filteredTablets.size()));
        // Общий прайс
        double totalCost = selectedTablets.stream().mapToDouble(t -> t.price).sum();

        String[] resultArray = new String[selectedTablets.size()+1];
        int iter = 0;
        for (Tablet tablet : selectedTablets) {
            resultArray[iter] = (tablet.model + " - " + tablet.price);
            iter += 1;
        }
        resultArray[selectedTablets.size()] = "Итоговая цена = " + String.valueOf(totalCost);
        return resultArray;
    }
}

