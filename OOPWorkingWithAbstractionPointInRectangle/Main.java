package OOPWorkingWithAbstractionPointInRectangle;

import java.time.DayOfWeek;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] coordinates = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        Rectangle rectangle = new Rectangle(new Point2D(coordinates[0], coordinates[1]),
                new Point2D(coordinates[2], coordinates[3])
        );

        int n = Integer.parseInt(scanner.nextLine());

        while (n-- > 0) {
            coordinates = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            Point2D point = new Point2D(coordinates[0], coordinates[1]);
            boolean contains = rectangle.contains(point);

            System.out.println(contains);
        }

    }
}
