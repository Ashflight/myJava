package mandy.app;

public class Main {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
        System.out.println(Searches.linearSearch(numbers, 12));
        System.out.println(Searches.linearSearch(numbers, 21));
        System.out.println(Searches.iterativeBinarySearch(numbers, 12));
        System.out.println(Searches.iterativeBinarySearch(numbers, 21));
        System.out.println(Searches.recursiveBinarySearch(numbers, 12));
        System.out.println(Searches.recursiveBinarySearch(numbers, 21));
    }
}