package OOPInheritanceEx5Restaurant;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        Food food = new Food("Husky", BigDecimal.valueOf(2.50), 50.0);
        Salmon salmon = new Salmon("Hunky", BigDecimal.valueOf(2.50));


        System.out.println(food.getGrams());
        System.out.println(salmon.getGrams());
    }

}
