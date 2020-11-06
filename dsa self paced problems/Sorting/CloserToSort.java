import java.util.ArrayList;
import java.util.Arrays;

import AkPackage.InputOutput;

public class CloserToSort {
    public static void main(String[] args) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new CloserToSort());
        while (!lines.isEmpty()) {
            int arr[] = InputOutput.arrayFromString(lines.remove(0));
            long x = Long.parseLong(lines.remove(0));
            int index = getResult(arr, x);
            System.out.println("In " + Arrays.toString(arr) + x + " is present at: " + index);
        }
    }

    public static int getResult(int arr[], long x) {
        int start = 0, end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == x)
                return mid;
            if (mid + 1 != arr.length && arr[mid + 1] == x)
                return mid + 1;
            if (mid != 0 && arr[mid - 1] == x)
                return mid - 1;
            if (arr[mid] < x)
                start = mid + 1;
            else
                end = mid - 1;
        }
        return -1;
    }
}