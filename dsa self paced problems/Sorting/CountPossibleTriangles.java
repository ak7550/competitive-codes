import java.util.ArrayList;
import java.util.Arrays;

import AkPackage.InputOutput;

public class CountPossibleTriangles {
    public static void main(String[] args) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new CountPossibleTriangles());
        while (!lines.isEmpty()) {
            int arr[] = InputOutput.arrayFromString(lines.remove(0));
            System.out.println("For input: " + Arrays.toString(arr));
            System.out.println("\nPossible triangles are: " + getResult(arr));
        }
    }

    public static int getResult(int arr[]) {
        Arrays.sort(arr);
        int count = 0;
        for (int i = arr.length - 1; i >= 2; i--) {
            int max = arr[i];
            int start = 0, end = i - 1;
            while (start < end) {
                if (arr[start] + arr[end] > max) {
                    count += end - start;
                    printPossibilities(arr, start, end, max);
                    end--;
                    // break;
                } else
                    start++;
            }
        }
        return count;
    }

    public static void printPossibilities(int arr[], int start, int end, int max) {
        for (int i = start; i < end; i++) {
            System.out.print("(" + arr[i] + "," + arr[end] + "," + max + "), ");
        }
    }
}
