package mandy.app;

public class ArrayUtil {
    public static void reverseArray(int[] array) {
        // This method in the support class was filled in by me because the textbook only gives its precondition and postcondition
        int start = 0;
        int end = array.length -1;
        int temp;
        while (start < end) {
            temp = array[start];
            array[start] = array[end];
            array[end] = temp;
            start++;
            end--;
        }
    }
}
