package mandy.app;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

class SortsTest {

    @Test
    void sequentialSort() {
        List numberlist = List.of(5, 2, 3, 4, 1);
        List sortedlist = Sorts.sequentialSort(numberlist);
        List expectedList = List.of(1, 2, 3, 4, 5);
        assertEquals(expectedList, sortedlist);
    }

    @Test
    void insertionSort() {
        List numberlist = List.of(5, 2, 3, 4, 1);
        List sortedlist = Sorts.insertionSort(numberlist);
        List expectedList = List.of(1, 2, 3, 4, 5);
        assertEquals(expectedList, sortedlist);

        List numberlist2 = List.of(1, 2, 3, 4, 5);
        List sortedlist2 = Sorts.insertionSort(numberlist2);
        assertEquals(expectedList, sortedlist2);
    }

    @Test
    void mergeSort() {
        List numberlist = List.of(5, 2, 3, 4, 1);
        List sortedlist = Sorts.mergeSort(numberlist);
        List expectedList = List.of(1, 2, 3, 4, 5);
        assertEquals(expectedList, sortedlist);
    }

    @Test
    void quickSort() {
        List numberlist = List.of(5, 2, 3, 4, 1);
        List sortedlist = Sorts.quickSort(numberlist);
        List expectedList = List.of(1, 2, 3, 4, 5);
        assertEquals(expectedList, sortedlist);
    }
}