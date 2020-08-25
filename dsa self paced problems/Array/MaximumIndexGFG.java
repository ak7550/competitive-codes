import java.util.ArrayList;
import java.util.Arrays;

import AkPackage.InputOutput;

public class MaximumIndexGFG {

    /*
     * For a given array arr[], returns the maximum j-i such that arr[j] > arr[i]
     */
    static int maxIndexDiff(int arr[], int n) {
        int maxDiff;
        int i, j;

        int RMax[] = new int[n];
        int LMin[] = new int[n];

        /*
         * Construct LMin[] such that LMin[i] stores the minimum value from (arr[0],
         * arr[1], ... arr[i])
         */
        LMin[0] = arr[0];
        for (i = 1; i < n; ++i)
            LMin[i] = Math.min(arr[i], LMin[i - 1]);

        System.out.println("LMin: " + Arrays.toString(LMin));

        /*
         * Construct RMax[] such that RMax[j] stores the maximum value from (arr[j],
         * arr[j+1], ..arr[n-1])
         */
        RMax[n - 1] = arr[n - 1];
        for (j = n - 2; j >= 0; --j)
            RMax[j] = Math.max(arr[j], RMax[j + 1]);

        System.out.println("RMax: " + Arrays.toString(RMax));
        /*
         * Traverse both arrays from left to right to find optimum j - i This process is
         * similar to merge() of MergeSort
         */
        i = 0;
        j = 0;
        maxDiff = -1;
        while (j < n && i < n) {
            if (LMin[i] < RMax[j]) {
                maxDiff = Math.max(maxDiff, j - i);
                j = j + 1;
            } else
                i = i + 1;
        }

        return maxDiff;
    }

    /* Driver program to test the above functions */
    public static void main(String[] args) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new MaximumIndex());
        int T = Integer.parseInt(lines.get(0));
        lines.remove(0);
        while (T-- > 0) {
            int length = Integer.parseInt(lines.get(0));
            lines.remove(0);
            int arr[] = InputOutput.arrayFromString(lines.get(0));
            lines.remove(0);
            System.out.println("For Input " + Arrays.toString(arr) + ": ");
            int maxDiff = maxIndexDiff(arr, length);
            System.out.println("MaxDifference in gfg: " + maxDiff);
            System.out.println();
            System.out.println();
            System.out.println();
        }
    }
}
