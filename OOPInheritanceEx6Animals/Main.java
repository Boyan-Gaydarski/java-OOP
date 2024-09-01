package OOPInheritanceEx6Animals;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String animalType = scanner.nextLine();

        while (!"Beast!".equals(animalType)) {
            String[] animalData = scanner.nextLine().split("\\s+");
            String name = animalData[0];
            try {
                if (Integer.parseInt(animalData[1]) <= 0) {
                    throw new IllegalArgumentException("Invalid input!");
                }
                if (!animalData[2].equals("Male") && !animalData[2].equals("Female")) {
                    throw new IllegalArgumentException("Invalid input!");
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid input!");
                animalType = scanner.nextLine();
                continue;
            }
            int age = Integer.parseInt(animalData[1]);

            Gender gender = Gender.MALE;
            if (animalData[2].equals("Female")) {
                gender = Gender.FEMALE;
            }


            switch (animalType) {
                case "Frog":
                    Frog frog = new Frog(name, age, gender);
                    System.out.println(frog);
                    break;
                case "Dog":
                    Dog dog = new Dog(name, age, gender);
                    System.out.println(dog);
                    break;
                case "Cat":
                    Cat cat = new Cat(name, age, gender);
                    System.out.println(cat);
                    break;
                case "Kitten":
                    Kitten kitten = new Kitten(name, age);
                    System.out.println(kitten);
                    break;
                case "Tomcat":
                    Tomcat tomcat = new Tomcat(name, age);
                    System.out.println(tomcat);
                    break;
            }

            animalType = scanner.nextLine();
        }
    }
}
