import java.util.Scanner;

public class Main {

    public static Circle circleLow = new Circle(1, -3, 3);
    public static Circle circleLarge = new Circle(0, -3, 5);
    public static VerticalParabola verticalParabolaUp = new VerticalParabola(-3, -3, 0.5);
    public static VerticalParabola verticalParabolaDown = new VerticalParabola(-6, 4, -0.25);

    public static SimpleColor getColor(double x, double y) {
        if ((circleLow.isPointDownOfCircle(x, y) && !verticalParabolaUp.isPointOfParabola(x, y) && !verticalParabolaDown.isPointOfParabola(x, y)) || ((circleLarge.isPointDownOfCircle(x, y)) && !circleLow.isPointDownOfCircle(x, y) && verticalParabolaDown.isPointOfParabola(x, y) && !verticalParabolaUp.isPointOfParabola(x, y))) {
            return SimpleColor.GREEN;
        } else if ((verticalParabolaDown.isPointOfParabola(x, y) && circleLow.isPointDownOfCircle(x, y) && !verticalParabolaUp.isPointOfParabola(x, y)) || (verticalParabolaUp.isPointOfParabola(x, y) && !verticalParabolaDown.isPointOfParabola(x, y)) && !circleLarge.isPointDownOfCircle(x, y) || (verticalParabolaDown.isPointOfParabola(x, y) && !verticalParabolaUp.isPointOfParabola(x, y) && !circleLarge.isPointDownOfCircle(x, y))) {
            return SimpleColor.ORANGE;
        } else if ((verticalParabolaUp.isPointOfParabola(x, y) && circleLarge.isPointDownOfCircle(x, y)) && !circleLow.isPointDownOfCircle(x, y) && !verticalParabolaDown.isPointOfParabola(x, y)) {
            return SimpleColor.GRAY;
        } else if ((verticalParabolaUp.isPointOfParabola(x, y) && verticalParabolaDown.isPointOfParabola(x, y) && !circleLow.isPointDownOfCircle(x, y)) || (verticalParabolaUp.isPointOfParabola(x, y) && !verticalParabolaDown.isPointOfParabola(x, y) && circleLow.isPointDownOfCircle(x, y) || (!verticalParabolaUp.isPointOfParabola(x, y)) && !verticalParabolaDown.isPointOfParabola(x, y) && x < 0 && !circleLarge.isPointDownOfCircle(x, y))) {
            return SimpleColor.WHITE;
        }
        return SimpleColor.BLUE;
    }


    static double readDoubleValueFromConsole(String varName) {
        while (true) {
            System.out.printf("Введиете %s: ", varName);
            String str = scanner.nextLine();
            if (Double.parseDouble(str) > 10 || Double.parseDouble(str) < -10) {
                System.out.printf(" -> неверное значение (%s)%n", str);
            } else {
                try {
                    return Double.valueOf(str);
                } catch (Exception e) {
                    System.out.printf(" -> неверное значение (%s)%n", str);
                }
            }
        }
    }

    public static Scanner scanner;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        double x = readDoubleValueFromConsole("X"), y = readDoubleValueFromConsole("Y");
        System.out.printf("(%.2f ,%.2f) -> %s", x, y, getColor(x, y));
    }
}