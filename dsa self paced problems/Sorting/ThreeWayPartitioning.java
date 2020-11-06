import java.util.ArrayList;
import java.util.Collections;

import AkPackage.InputOutput;

public class ThreeWayPartitioning {
    public static void main(String[] args) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new ThreeWayPartitioning());
        while (!lines.isEmpty()) {
            ArrayList<Integer> arr = InputOutput.ArrayListFromString(lines.remove(0));
            int a1[] = InputOutput.arrayFromString(lines.remove(0));
            int a = a1[0], b = a1[1];
            System.out.println("For Input: " + arr);
            threeWayPartition(arr, a, b);
            System.out.println("Sorted Arrays is: " + arr);
        }
    }

    public static void threeWayPartition(ArrayList<Integer> arr, int a, int b) {
        int low = 0, high = arr.size() - 1, mid = 0;
        while (mid <= high) {
            if (arr.get(mid) < a)
                Collections.swap(arr, low++, mid++);
            else if (arr.get(mid) > b)
                Collections.swap(arr, high--, mid);
            else
                mid++;
        }
    }
}
