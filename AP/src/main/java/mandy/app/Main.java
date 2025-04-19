package mandy.app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        // DIRECTORY:
        // Searches and Sorts were written to review searching and sorting algorithms.
        // FourDigitInteger, Cruise, Sentence, and Matrix + ArrayUtil are from Barron's Diagnostic Test.
        // Note + NoteKeeper are from Barron's Practice Test 2
        // mystery24 is the mystery method from MCQ #24 of Princeton's Practice Test 2

        //sortSearchSpam();
        runNote();
        mystery24();
    }

    public static void sortSearchSpam() {
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

    public static void runNote() {
        NoteKeeper n = new NoteKeeper();
        n.addNote("pick up dry cleaning");
        n.addNote("special dog chow");
        n.addNote("car registration");
        n.addNote("dentist monday");
        n.addNote("dog license");
        n.addNote("buy carrots");
        n.addNote("carpet cleaning");
        n.addNote("pick up car");
        n.printNotes();
        n.removeNotes("car");
        System.out.println("Notes with car removed");
        n.printNotes();
    }

    public static void mystery24() {
        int[] A = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
        System.out.println(Arrays.toString(A));

        // main loop from question
        for (int k = 0; k < A.length / 2; k++) {
            swap(A[k], A[A.length - k - 1]);
        }
        System.out.println(Arrays.toString(A));
        // does nothing. as expected.
    }

    public static void swap(int x, int y) {
        int temp;
        temp = x;
        x = y;
        y = temp;
    }
}