package OOPWorkingWithAbstractionPointInRectangle;

public class Rectangle {
    private Point2D bottomLeft;
    private Point2D topRight;

    public Rectangle(Point2D bottomLeft, Point2D topRight) {
        this.bottomLeft = bottomLeft;
        this.topRight = topRight;
    }

    public boolean contains(Point2D point) {
        return this.bottomLeft.isGreaterOrEqual(point)
                && this.topRight.isLessOrEqual(point);
    }
}
