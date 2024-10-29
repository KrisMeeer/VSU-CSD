import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        double y = calculateY();
        System.out.println("Значение y: " + y);
    }

    public static double calculateY() {
        double result = 0;

        for (int i = 99; i >= 3; i-=3) {
            result = Math.sqrt(i + result);
        }

        return result;
    }
}