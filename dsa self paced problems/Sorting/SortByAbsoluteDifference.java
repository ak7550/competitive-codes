import java.util.*;

import AkPackage.InputOutput;

public class SortByAbsoluteDifference {
    public static void main(String[] args) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new SortByAbsoluteDifference());
        while (!lines.isEmpty()) {
            int arr[] = InputOutput.arrayFromString(lines.remove(0));
            int k = InputOutput.arrayFromString(lines.remove(0))[0];
            System.out.println("For Input: " + Arrays.toString(arr));
            sort(arr, k);
            System.out.println("Sorted Array is: " + Arrays.toString(arr));
        }
    }

    public static void sort(int arr[], int k) {
        ArrayList<Integer> a = new ArrayList<Integer>();
        for (int x : arr)
            a.add(x);
        Collections.sort(a, (a1, a2) -> Math.abs(a1 - k) - Math.abs(a2 - k));
        for (int i = 0; i < arr.length; i++)
            arr[i] = a.get(i);
    }
}
