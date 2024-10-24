package Prototype;

public class Chair implements Prototype, Cloneable {
    private int height;
    private int width;
    private String color;

    public Chair(int height, int width, String color) {
        this.height = height;
        this.width = width;
        this.color = color;
    }

    private Chair(Chair chair) {
        this.height = chair.height;
        this.width = chair.width;
        this.color = chair.color;
    }

    @Override
    public Chair clone() {
        try {
            return (Chair) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
