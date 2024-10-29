/**
 * (x - x0)^2 + (y - y0)^2 = R^2
 * r^2 = x^2 + 2x*x0  + x0^2 + y^2 - 2 * y * y0 + y0^2
 * y = sqrt(R^2 - (x - x0)^2) + y0
 **/
public class Circle {
    public double x0;
    public double y0;
    public double R;

    public Circle(double x0, double y0, double R) {
        this.x0 = x0;
        this.y0 = y0;
        this.R = R;
    }

    public boolean isPointDownOfCircle(double x, double y) {
        return y < Math.sqrt(Math.pow(R, 2) - Math.pow((x - x0), 2)) + y0;
    }

}
