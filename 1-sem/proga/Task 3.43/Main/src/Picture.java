public class Picture {
    private Rectangle rectangle;
    private HorizontalParabola horizontalParabola;
    public Circle circle;

    public Picture(Rectangle rectangle, HorizontalParabola horizontalParabola, Circle circle)
    {
        this.rectangle = rectangle;
        this.horizontalParabola = horizontalParabola;
        this.circle = circle;
    }

    public SimpleColor getColor(double x, double y)
    {
        if (circle.isPointInside(x, y))
        {
            if (rectangle.isPointInside(x, y))
                return SimpleColor.WHITE;
            else
                return SimpleColor.GREEN;
        }
        if (rectangle.isPointInside(x, y))
        {
            if (horizontalParabola.isPointInside(x,y))
                return SimpleColor.GRAY;
            else
                return SimpleColor.GREEN;
        }
        if (horizontalParabola.isPointInside(x,y))
            return SimpleColor.BLUE;
        else
            return SimpleColor.YELLOW;
    }
}