package p01_Database;

import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

import static org.junit.Assert.*;

public class DatabaseTest {
    private Database database;
    private static final Integer[] NUMBERS = {5, 9, 29, 45};

    @Before
    public void prepareDatabase() throws OperationNotSupportedException {
        database = new Database(NUMBERS);
    }

    @Test
    public void testConstructorHasToCreateValidObject() throws OperationNotSupportedException {

        Integer[] databaseNumbers = database.getElements();
        assertEquals("Count of elements is incorrect",NUMBERS.length, databaseNumbers.length);

        for (int i = 0; i < databaseNumbers.length; i++) {
            assertEquals(databaseNumbers[i], NUMBERS[i]);
        }
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorThrowWhenMoreThanSixteenElements() throws OperationNotSupportedException {
        Integer[] numbers = new Integer[17];
        new Database(numbers);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorThrowWhenLessThanOneElement() throws OperationNotSupportedException {
        Integer[] numbers = new Integer[0];
        new Database(numbers);

    }

    @Test(expected = OperationNotSupportedException.class)
    public void testAddShouldThrowWhenParamNull() throws OperationNotSupportedException {

        database.add(null);
    }

    @Test
    public void testAddShouldAddElementAtNextIndex() throws OperationNotSupportedException {

        database.add(17);
        assertEquals(5, database.getElements().length);
        assertEquals(Integer.valueOf(17), database.getElements()[4]);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testRemoveShouldThrowExWithEmptyData() throws OperationNotSupportedException {

        for (int i = 0; i < NUMBERS.length; i++) {
            database.remove();
        }
        database.remove();
    }

    @Test
    public void testRemoveLastElement() throws OperationNotSupportedException {

        database.remove();
        Integer[] elementsInDatabase = database.getElements();
        assertEquals(NUMBERS.length - 1, database.getElements().length);
        for (int i = 0; i < elementsInDatabase.length; i++) {
            assertEquals(elementsInDatabase[i], NUMBERS[i]);
        }


    }
}
