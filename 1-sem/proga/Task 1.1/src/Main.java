import java.util.Scanner;

//figure1 - уголок квадрата
//figure2 - часть дуги образованной разностью площадей окружностей
//figure3 - 4 сектора малой окружности
//totalFigure - закрашенная фигура

public class Main {
    public static double[] getDataFromConsole() {
        Scanner sn = new Scanner(System.in);

        System.out.println("Введите радиус меньшей окружности:");
        double r1 = sn.nextDouble();

        System.out.println("Введите радиус большей окружности:");
        double r2 = sn.nextDouble();

        return new double[]{r1, r2};
    }

    public static double calculateCircleArea(double radius) {
        return Math.PI * Math.pow(radius, 2);
    }

    public static double calculateSquareArea(double radius) {
        double squareSide = 2 * radius;
        return Math.pow(squareSide, 2);
    }

    public static double calculateSquare (double squareArea, double biggerCircleArea) {
        return (squareArea - biggerCircleArea) / 4;
    }

    public static double bigCircle (double smallerCircleArea, double biggerCircleArea) {
        return (biggerCircleArea - smallerCircleArea) / 8 * 3;
    }

    public static double smallCircle (double smallerCircleArea) {
        return smallerCircleArea / 2;
    }

    public static double sumFigure (double figure1Area, double figure2Area, double figure3Area) {
        return figure1Area + figure2Area + figure3Area;
    }

    public static void main(String[] args) {
        double[] data = getDataFromConsole();

        double smallerCircleArea = calculateCircleArea(data[0]);
        double biggerCircleArea = calculateCircleArea(data[1]);
        double squareArea = calculateSquareArea(data[1]);

        double figure1Area = calculateSquare(squareArea, biggerCircleArea);
        double figure2Area = BigCircle(smallerCircleArea, biggerCircleArea);
        double figure3Area = SmallCircle(smallerCircleArea);
        double finalFigureArea = SumFigure (figure1Area, figure2Area, figure3Area);

        System.out.println(finalFigureArea);
    }
}
