package OOPInheritanceEx5Restaurant;

import java.math.BigDecimal;

public class Salmon extends MainDish {
    private final static double SALMON_GRAMS = 22.0;

    public Salmon(String name, BigDecimal price) {
        super(name, price, SALMON_GRAMS);
    }
}
