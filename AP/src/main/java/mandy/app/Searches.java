package mandy.app;

public class Searches {
    // has the two main searching methods
    // also has both versions of binary search
    // returns -1 if the data does not contain the target value
    // for int
    public static int linearSearch(int[] data, int target) {
        int index = 0;
        while (index < data.length) {
            if (data[index] == target) {
                return index;
            }
            index++;
        }
        return -1;
    }
    public static int iterativeBinarySearch(int[] data, int target) {
        int low = 0;
        int high = data.length - 1;
        int mid;
        while (high > low) {
            mid = (low + high + 1) / 2;
            if (data[mid] == target) {
                return mid;
            }
            else if (data[mid] > target) {
                high = mid;
            }
            else {
                low = mid;
            }
        }
        return -1;
    }
    public static int recursiveBinarySearch(int[] data, int target, int low, int high) {
        int index;
        int mid = (low + high + 1) / 2;
        if (low > high || mid >= data.length) {
            return -1;
        }
        if (data[mid] == target) {
            return mid;
        }
        else if (data[mid] > target) {
            index = recursiveBinarySearch(data, target, low, mid);
        }
        else {
            index = recursiveBinarySearch(data, target, mid, high);
        }
        return index;
    }
    public static int recursiveBinarySearch(int[] data, int target) {
        return recursiveBinarySearch(data, target, 0, data.length);
    }
}
