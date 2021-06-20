import AkPackage.*;
import java.util.*;


public class MaxSubArraySumRemovingAtMostOneElement {
    public static void main(String args[]) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new MaxSubArraySumRemovingAtMostOneElement());
        while (!lines.isEmpty()) {
            int arr[] = InputOutput.arrayFromString(lines.remove(0));
            System.out.println("\n\nFor the given: " + Arrays.toString(arr));
            int res = maxSumSubarray(arr);
            System.out.println("Ans: " + res);
        }
    }

    public static int[] kadane(int arr[]) {
        int add[] = new int[arr.length];
        int sum = arr[0];
        add[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            sum += arr[i];
            add[i] = Math.max(sum, arr[i]);
            sum = add[i];
        }
        return add; // -> add[i] ===> contains either arr[i] or the sum of the subarray including arr[i]
    }

    public static int maxSumSubarray(int arr[]) {
        int fw[] = kadane(arr), bw[] = kadane(Array.reverseArr(arr));
        bw = Array.reverseArr(bw);
        int max = bw[0]; // none of the item is ignored

        if (arr.length == 1)
            return max;

        max = Math.max(max, bw[1]); // 1st item ignored

        if (arr.length == 2)
            return max;

        System.out.println("fw: " + Arrays.toString(fw));
        System.out.println("bw: " + Arrays.toString(bw));
        max = Math.max(max, fw[arr.length - 2]); // last item ignored
        for (int i = 1; i < arr.length - 1; i++) {
            max = Math.max(max, fw[i - 1] + bw[i + 1]); // ith item ignored
            max = Math.max(max, fw[i]);
            max = Math.max(max, bw[i]);
        }
        return max;
    }
}