package p02_ExtendedDatabase;

import org.junit.Before;
import org.junit.Test;


import javax.naming.OperationNotSupportedException;

import static org.junit.Assert.assertEquals;

public class ExtendedDatabaseTest {

    private Database database;
    private static final Person[] PEOPLE = {new Person(1, "First"), new Person(2, "Second"), new Person(3, "Third")};

    @Before
    public void prepareDatabase() throws OperationNotSupportedException {
        database = new Database(PEOPLE);
    }

    @Test
    public void testConstructorHasToCreateValidObject() throws OperationNotSupportedException {

        Person[] databasePeople = database.getElements();
        assertEquals("Count of elements is incorrect", PEOPLE.length, databasePeople.length);

        for (int i = 0; i < databasePeople.length; i++) {
            assertEquals(databasePeople[i], PEOPLE[i]);
        }
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorThrowWhenMoreThanSixteenElements() throws OperationNotSupportedException {
        Person[] people = new Person[17];
        new Database(people);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorThrowWhenLessThanOneElement() throws OperationNotSupportedException {
        Person[] people = new Person[0];
        new Database(people);

    }

    @Test(expected = OperationNotSupportedException.class)
    public void testAddShouldThrowWhenParamNull() throws OperationNotSupportedException {

        database.add(null);
    }

    @Test
    public void testAddShouldAddElementAtNextIndex() throws OperationNotSupportedException {

        database.add(new Person(4, "Fourth"));
        assertEquals(4, database.getElements().length);
        assertEquals(4, database.getElements()[3].getId());
        assertEquals("Fourth", database.getElements()[3].getUsername());
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testRemoveShouldThrowExWithEmptyData() throws OperationNotSupportedException {

        for (int i = 0; i < PEOPLE.length; i++) {
            database.remove();
        }
        database.remove();
    }

    @Test
    public void testRemoveLastElement() throws OperationNotSupportedException {

        database.remove();
        Person[] peopleInDatabase = database.getElements();
        assertEquals(PEOPLE.length - 1, database.getElements().length);
        for (int i = 0; i < peopleInDatabase.length; i++) {
            assertEquals(peopleInDatabase[i], PEOPLE[i]);
        }
    }



    @Test(expected = OperationNotSupportedException.class)
    public void testFindByUsernameThrowExWithNullUsername() throws OperationNotSupportedException {
        database.findByUsername(null);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testFindByUsernameThrowWithEmptyData() throws OperationNotSupportedException {
        database = new Database(null, null);
        database.findByUsername("First");
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testFindByUsernameThrowExIfSizeDoesNotEqualOne() throws OperationNotSupportedException {
        database = new Database();
        database.findByUsername("First");
    }

    @Test
    public void testFindByUsernameReturnCorrectPerson() throws OperationNotSupportedException {
        Person resultPerson = database.findByUsername("First");
        assertEquals(1, resultPerson.getId());
        assertEquals("First", resultPerson.getUsername());
    }



    @Test(expected = OperationNotSupportedException.class)
    public void testFindByIdThrowWithEmptyData() throws OperationNotSupportedException {
        database = new Database(null, null);
        database.findById(1);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testFindByIdThrowExIfSizeDoesNotEqualOne() throws OperationNotSupportedException {
        database = new Database();
        database.findById(1);
    }

    @Test
    public void testFindByIdReturnCorrectPerson() throws OperationNotSupportedException {
        Person resultPerson = database.findById(1);
        assertEquals(1, resultPerson.getId());
        assertEquals("First", resultPerson.getUsername());
    }
}
