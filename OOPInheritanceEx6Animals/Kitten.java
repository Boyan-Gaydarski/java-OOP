package OOPInheritanceEx6Animals;

public class Kitten extends Cat {

    public Kitten(String name, int age) {
        super(name, age, Gender.FEMALE);
    }

    @Override
    public String produceSound() {
        return "Meow";
    }
}
