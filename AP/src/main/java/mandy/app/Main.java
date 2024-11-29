package mandy.app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // CURRENTLY BROKEN
        // FOR SOME REASON THE EASY SORTS AREN'T WORKING
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
        System.out.println("Data: " + Arrays.toString(numbers));
        System.out.println(Searches.linearSearch(numbers, 12));
        System.out.println(Searches.linearSearch(numbers, 21));
        System.out.println(Searches.iterativeBinarySearch(numbers, 12));
        System.out.println(Searches.iterativeBinarySearch(numbers, 21));
        System.out.println(Searches.recursiveBinarySearch(numbers, 12));
        System.out.println(Searches.recursiveBinarySearch(numbers, 21));
        ArrayList<Integer> randomNumbers = new ArrayList<>();
        for (int number : numbers) {
            randomNumbers.add(number);
        }
        Collections.shuffle(randomNumbers);
        System.out.println("Unordered List: " + randomNumbers);
        System.out.println(Sorts.sequentialSort(randomNumbers)); // has problems currently
        System.out.println(Sorts.insertionSort(randomNumbers));
        System.out.println(Sorts.mergeSort(randomNumbers));
        System.out.println(Sorts.quickSort(randomNumbers));
    }
}