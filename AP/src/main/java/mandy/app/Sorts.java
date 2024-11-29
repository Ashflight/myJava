package mandy.app;

import java.util.ArrayList;
import java.util.List;

public class Sorts {
    public static List<Integer> sequentialSort(List<Integer> data) {
        ArrayList<Integer> copy = new ArrayList<>(data);
        ArrayList<Integer> sorted = new ArrayList<>();
        int currentMin;
        int minIndex;
        while (!copy.isEmpty()) {
            currentMin = copy.get(0);
            minIndex = 0;
            for (int i = 1; i < copy.size(); i++) {
                if (copy.get(i) < currentMin) {
                    currentMin = copy.get(i);
                    minIndex = i;
                }
            }
            sorted.add(currentMin);
            copy.remove(minIndex);
        }
        return sorted;
    }
    public static List<Integer> insertionSort(List<Integer> data) {
        ArrayList<Integer> copy = new ArrayList<>(data);
        ArrayList<Integer> sorted = new ArrayList<>();
        int index;
        sorted.add(copy.get(0));
        copy.remove(0);
        while (!copy.isEmpty()) {
            boolean inserted = false;
            for (int i = 0; i < sorted.size(); i++) {
                if (sorted.get(i) >= copy.get(0)) {
                    sorted.add(i, copy.get(0));
                    copy.remove(0);
                    inserted = true;
                    break;
                }
            }
            if (!inserted) {
                sorted.add(copy.get(0));
                copy.remove(0);
            }
        }
        return sorted;
    }
    public static List<Integer> mergeSort(List<Integer> data) {
        if (data.size() == 1) {
            return data;
        }
        else {
            List<Integer> subArray1 = new ArrayList<>(data.subList(0, data.size()/2));
            List<Integer> subArray2 = new ArrayList<>(data.subList(data.size()/2, data.size()));
            subArray1 = mergeSort(subArray1);
            subArray2 = mergeSort(subArray2);
            ArrayList<Integer> sorted = new ArrayList<>();
            while (!subArray1.isEmpty() && !subArray2.isEmpty()) {
                if (subArray1.get(0) < subArray2.get(0)) {
                    sorted.add(subArray1.get(0));
                    subArray1.remove(0);
                }
                else {
                    sorted.add(subArray2.get(0));
                    subArray2.remove(0);
                }
            }
            sorted.addAll(subArray1);
            sorted.addAll(subArray2);
            return sorted;
        }
    }
    public static List<Integer> quickSort(List<Integer> data) {
        int pivot;
        if (data.size() <= 1) {
            return data;
        }
        else {
            pivot = data.get(data.size() - 1);
            List<Integer> subArray1 = new ArrayList<>();
            List<Integer> subArray2 = new ArrayList<>();
            for (int i = 0; i < data.size() - 1; i++) {
                if (data.get(i) < pivot) {
                    subArray1.add(data.get(i));
                }
                else {
                    subArray2.add(data.get(i));
                }
            }
            subArray1 = quickSort(subArray1);
            subArray2 = quickSort(subArray2);
            ArrayList<Integer> sorted = new ArrayList<>(subArray1);
            sorted.add(pivot);
            sorted.addAll(subArray2);
            return sorted;
        }
    }
}
