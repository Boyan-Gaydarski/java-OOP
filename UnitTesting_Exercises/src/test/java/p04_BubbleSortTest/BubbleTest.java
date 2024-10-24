package p04_BubbleSortTest;

import org.junit.Test;

import static org.junit.Assert.*;

public class BubbleTest {
    
    @Test
    public void testSort() {
        int[] arr = {100, 13, 7, 0, -5, 2};
        Bubble.sort(arr);
        int[] expectedSortedArray = {-5, 0, 2, 7, 13, 100};
        for (int i = 0; i < expectedSortedArray.length; i++) {

            assertEquals(expectedSortedArray[i], arr[i]);
        }
    }
}
