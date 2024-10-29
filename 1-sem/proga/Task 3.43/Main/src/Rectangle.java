public class Rectangle {
    public double x0l;
    public double y0l;
    public double x0r;
    public double y0r;

    public Rectangle(double x0l, double y0l, double x0r, double y0r)
    {
        this.x0l = x0l;
        this.y0l = y0l;
        this.x0r = x0r;
        this.y0r = y0r;
    }

    public boolean isPointInside(double x, double y)
    {
        //return (Math.abs(x-x0)+Math.abs(y)*Math.sin(0)<=length) && (Math.abs(x)*Math.sin(0)+Math.abs(y-y0)<=height);
        return ((x0l<=x && x<=x0r) && (y0l <= y && y <= y0r));
    }
}
