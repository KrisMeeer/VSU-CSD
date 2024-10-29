/**
 * Вертикальная Парабола вида у = a(x − x0)^2 + y0
 */

// -0,25
    // 0.5
public class VerticalParabola {
    public double x0;
    public double y0;
    public double a;

    public VerticalParabola(double x0, double y0, double a) {
        this.x0 = x0;
        this.y0 = y0;
        this.a = a;
    }

    public boolean isPointOfParabola(double x, double y) {
        if (a < 0) {
            return y < a * Math.pow((x - x0), 2) + y0;
        } else {
            return y > a * Math.pow((x - x0), 2) + y0;
        }
    }
}
