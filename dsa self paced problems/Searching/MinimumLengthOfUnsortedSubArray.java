import AkPackage.*;
import java.util.*;

public class MinimumLengthOfUnsortedSubArray {
    public static void main(String args[]) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new MinimumLengthOfUnsortedSubArray());
        while (!lines.isEmpty()) {
            int arr[] = InputOutput.arrayFromString(lines.remove(0));
            System.out.println("For the given array: " + Arrays.toString(arr));
            getResult(arr);
        }
    }

    public static void getResult(int arr[]) {
        boolean found = false;
        int sI = 0, eI = arr.length - 1;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                sI = i + 1;
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println(Arrays.toString(arr) + " is sorted");
            return;
        }
        found = false;
        for (int i = arr.length-1; i >= 1; i--) {
            if (arr[i - 1] > arr[i]) {
                eI = i - 1;
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println(Arrays.toString(arr) + " is sorted");
            return;
        }
        //for start, we will consider the right most part
        // for end, we will consider the left most part
        int newSI = binarySearchForStart(arr, 0, sI - 1, arr[sI]), newEI = binarySearchForEnd(arr, eI+1, arr.length - 1, arr[eI]);
        System.out.println("Unsorted array starts from "+ (newSI+1) + " and ends at "+ (newEI-1));
    }

    public static int binarySearchForStart(int arr[], int start, int end, int value) {
        // I have to search for the index, which will be the proper place for value in between start and end
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (mid == start && arr[mid] > value)
                return start;
            if (mid == end && arr[mid] < value)
                return mid;
            if (arr[mid] > value && arr[mid - 1] < value)
                return mid;
            if (arr[mid] < value)
                start = mid + 1;
            else
                end = mid - 1;
        }
        return -1;

    }
    public static int binarySearchForEnd(int arr[], int start, int end, int value) {
        // I have to search for the index, which will be the proper place for value in between start and end
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (mid == start && arr[mid] > value)
                return start;
            if (mid == end && arr[mid] < value)
                return mid;
            if (arr[mid] > value && arr[mid - 1] < value)
                return mid-1;
            if (arr[mid] < value)
                start = mid + 1;
            else
                end = mid - 1;
        }
        return -1;

    }

}