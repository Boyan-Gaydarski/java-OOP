package OOPWorkingWithAbstractionHotelReservations;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");

        double price = Double.parseDouble(input[0]);
        int days = Integer.parseInt(input[1]);
        String inputSeason = input[2];
        Season season = Season.valueOf(inputSeason.toUpperCase());
        String inputDiscount = input[3];
        Discount discount = Discount.valueOf(inputDiscount.toUpperCase());

        PriceCalculator priceCalculator = new PriceCalculator(season, discount, price, days);

        System.out.printf("%.2f%n", priceCalculator.calculatePrice());
    }
}
