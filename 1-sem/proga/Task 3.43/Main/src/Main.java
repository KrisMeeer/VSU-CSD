import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Picture picture = new Picture(
                new Rectangle(1,3,8,7), // обозначение расположения прямоугольника
                new HorizontalParabola(+3,-6,0.125), // обозночение расположения горизонтальной параболы
                new Circle(1,0,4) // обозначение расположения круга
        );

        double x = enterPointCoordinate('x');
        double y = enterPointCoordinate('y');
        outputColorForPoint(x, y, picture);

    }

    public static void outputColorForPoint(double x, double y, Picture picture)
    {
        System.out.printf("(%.1f, %.1f) -> %S%n", x, y, picture.getColor(x, y)); //форматирование плавающей точки
    }

    public static double enterPointCoordinate(char coordinateName)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Input %S: ", coordinateName); // ввод строки

        return scanner.nextDouble();
    }
}
