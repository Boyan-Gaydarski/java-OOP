package OOPPolymorphismAnimals;

public class Dog extends Animal {


    protected Dog(String name, String favouriteFood) {
        super(name, favouriteFood);
    }

    @Override
    public String explainSelf() {
        return String.format("I am %s and my favourite food is %s%nDJAAF",getName(), getFavouriteFood());
    }
}
