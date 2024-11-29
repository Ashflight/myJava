package mandy.app;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SearchesTest {

    @Test
    void linearSearch() {
        int[] numbers = new int[] {1, 2, 3, 4, 5};
        int target = 3;
        int returnValue = Searches.linearSearch(numbers, target);
        int expectedValue = 2;
        assertEquals(expectedValue, returnValue);

        target = 6;
        expectedValue = -1;
        int returnValue2 = Searches.linearSearch(numbers, target);
        assertEquals(expectedValue, returnValue2);
    }

    @Test
    void iterativeBinarySearch() {
        int[] numbers = new int[] {1, 2, 3, 4, 5};
        int target = 3;
        int returnValue = Searches.iterativeBinarySearch(numbers, target);
        int expectedValue = 2;
        assertEquals(expectedValue, returnValue);

        target = 4;
        expectedValue = 3;
        int returnValue2 = Searches.iterativeBinarySearch(numbers, target);
        assertEquals(expectedValue, returnValue2);

        target = 2;
        expectedValue = 1;
        int returnValue3 = Searches.iterativeBinarySearch(numbers, target);
        assertEquals(expectedValue, returnValue3);

        target = 6;
        expectedValue = -1;
        int returnValue4 = Searches.iterativeBinarySearch(numbers, target);
        assertEquals(expectedValue, returnValue4);
    }

    @Test
    void recursiveBinarySearch() {
        int[] numbers = new int[] {1, 2, 3, 4, 5};
        for (int i = 0; i < numbers.length; i++) {
            int target = numbers[i];
            int returnValue = Searches.recursiveBinarySearch(numbers, target);
            int expectedValue = i;
            assertEquals(expectedValue, returnValue);
        }

        int target = 6;
        int expectedValue = -1;
        int returnValue2 = Searches.recursiveBinarySearch(numbers, target);
        assertEquals(expectedValue, returnValue2);


        target = 0;
        expectedValue = -1;
        int returnValue3 = Searches.recursiveBinarySearch(numbers, target);
        assertEquals(expectedValue, returnValue3);

        int[] numbers2 = new int[] {1, 5, 10, 15, 20, 25};
        target = 18;
        expectedValue = -1;
        int returnValue4 = Searches.recursiveBinarySearch(numbers2, target);
        assertEquals(expectedValue, returnValue4);
    }
}