import AkPackage.*;
import java.util.*;


public class MinimumNumberInSortedRotatedArray {
    public static void main(String args[]) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new MinimumNumberInSortedRotatedArray());
        while (!lines.isEmpty()) {
            int arr[] = InputOutput.arrayFromString(lines.remove(0));
            System.out.println("for ip:" + Arrays.toString(arr));
            System.out.println("Smallest element is: " + getSmallest(arr, 0, arr.length - 1));
        }
    }

    private static int getSmallest(int arr[], int low, int high) {
        while (low < high) {
            int mid = low + (high - low) >> 1;
            int next = (mid + 1) % arr.length;
            if (arr[mid] > arr[next])
                return arr[next];
            else if (arr[high] < arr[mid])
                low = mid;
            else
                high = mid;
        }

        return -1;
    }

}