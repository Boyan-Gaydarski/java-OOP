package Prototype;

public class Main {
    public static void main(String[] args) {
        Chair chair = new Chair(13, 73, "Red");

        Chair clone = chair.clone();

        System.out.println(chair);
        System.out.println(clone);
    }
}
