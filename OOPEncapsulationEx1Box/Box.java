package OOPEncapsulationEx1Box;

public class Box {
    private double length;
    private double width;
    private double height;

    public Box(double length, double width, double height) {
        SetLength(length);
        SetWidth(width);
        SetHeight(height);
    }

    private void SetLength(double length) {
        if (isGreaterThanZero(length)) {
            this.length = length;
        } else {
            throw new IllegalArgumentException("Length cannot be zero or negative.");
        }

    }

    private void SetWidth(double width) {
        if (isGreaterThanZero(width)) {
            this.width = width;
        } else {
            throw new IllegalArgumentException("Width cannot be zero or negative.");
        }

    }

    private void SetHeight(double height) {
        if (isGreaterThanZero(height)) {
            this.height = height;
        } else {
            throw new IllegalArgumentException("Height cannot be zero or negative.");
        }
    }

    private boolean isGreaterThanZero(double value) {
        return value > 0;
    }

    public double calculateSurfaceArea() {
        return (2 * length * width) + (2 * width * height) + (2 * length * height);
    }

    public double calculateLateralSurfaceArea() {
        return (2 * length * height) + (2 * width * height);
    }

    public double calculateVolume() {
        return length * width * height;
    }
}
