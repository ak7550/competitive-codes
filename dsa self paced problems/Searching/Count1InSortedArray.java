import java.util.ArrayList;
import java.util.Arrays;

import AkPackage.InputOutput;

/**
 * Count1InSortedArray
 */
public class Count1InSortedArray {

    public static void main(String[] args) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new Count1InSortedArray());
        int T = Integer.parseInt(lines.get(0));
        lines.remove(0);
        while (T-- > 0) {
            int length = Integer.parseInt(lines.get(0));
            lines.remove(0);
            int arr[] = InputOutput.arrayFromString(lines.get(0));
            lines.remove(0);
            System.out.println("For Input " + Arrays.toString(arr));
            count(arr);
        }
    }

    public static void count(int arr[]) {
        System.out.println("Number of 1's are: " + (searchRightMostIndex(arr, 0, arr.length-1) + 1));
    }

    public static int searchRightMostIndex(int arr[], int low, int high) {
        int mid = low + (high - low) / 2;
        if (low <= high) {
            if (arr[high] == 1) {
                return high;
            } else {
                if (arr[mid] != 1)
                    return searchRightMostIndex(arr, low, mid - 1);
                else if (arr[mid] == 1 && arr[mid + 1] == 1)
                    return searchRightMostIndex(arr, mid + 1, high);
                else
                    return mid;
            }
        } else
            return -1;
    }

}
