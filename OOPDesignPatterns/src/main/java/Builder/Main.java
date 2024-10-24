package Builder;

public class Main {
    public static void main(String[] args) {
        Address address = new Address();

        address.setName("name")
                .setCity("city")
                .setAddressLine1("addressLine1")
                .setPostcode("postcode");
    }
}
