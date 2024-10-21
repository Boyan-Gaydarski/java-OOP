package p01_Database;

import org.junit.Test;

import javax.naming.OperationNotSupportedException;

import static org.junit.Assert.*;

public class DatabaseTest {

    @Test
    public void testConstructorHasToCreateValidObject() throws OperationNotSupportedException {
        Integer[] numbers = {5, 9, 29, 45};
        Database database = new Database(numbers);

        Integer[] databaseNumbers = database.getElements();
        assertEquals("Count of elements is incorrect",numbers.length, databaseNumbers.length);

        for (int i = 0; i < databaseNumbers.length; i++) {
            assertEquals(databaseNumbers[i], numbers[i]);
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
        Integer[] numbers = {5, 9, 29, 45};
        Database database = new Database(numbers);
        database.add(null);
    }

    @Test
    public void testAddShouldAddElementAtNextIndex() throws OperationNotSupportedException {
        Integer[] numbers = {5, 9, 29, 45};
        Database database = new Database(numbers);
        database.add(17);
        assertEquals(5, database.getElements().length);
        assertEquals(Integer.valueOf(17), database.getElements()[4]);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testRemoveShouldThrowExWithEmptyData() throws OperationNotSupportedException {
        Integer[] numbers = {5, 9, 29, 45};
        Database database = new Database(numbers);
        for (int i = 0; i < numbers.length; i++) {
            database.remove();
        }
        database.remove();
    }

    @Test
    public void testRemoveLastElement() throws OperationNotSupportedException {
        Integer[] numbers = {5, 9, 29, 45};
        Database database = new Database(numbers);
        database.remove();
        Integer[] elementsInDatabase = database.getElements();
        assertEquals(numbers.length - 1, database.getElements().length);
        for (int i = 0; i < elementsInDatabase.length; i++) {
            assertEquals(elementsInDatabase[i], numbers[i]);
        }


    }
}
