package OOPInterfacesSayHello;

public class Chinese extends BasePerson {

    public Chinese(String name) {
        super(name);
    }

    @Override
    public String sayHello() {
        return "Ni hao";
    }
}
