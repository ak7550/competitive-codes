import AkPackage.*;
import java.util.*;


public class KadaneII {
    public static void main(String args[]) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new KadaneII());
        while (!lines.isEmpty()) {
            int arr[] = InputOutput.arrayFromString(lines.remove(0));
            System.out.println("\n\nFor the given array: " + Arrays.toString(arr));
            long res = maximumSum(arr);
            System.out.println("Ans is: " + res);
        }
    }

    public static long maximumSum(int arr[]) {
        long sum[] = new long[arr.length];
        long max = Integer.MIN_VALUE;
        sum[0] = Math.max(arr[0], 0);

        if (arr.length == 1)
            return sum[0];

        sum[1] = Math.max(arr[1], 0);

        if (arr.length == 2)
            return Math.max(arr[0], arr[1]);

        sum[2] = Math.max(arr[2], 0);
        sum[2] = Math.max(sum[2], sum[2] + sum[0]);

        if (arr.length == 3)
            return Math.max(sum[1], sum[2]);

        max = Math.max(max, arr[0]);
        max = Math.max(max, arr[1]);
        max = Math.max(max, arr[2]);

        for (int i = 3; i < arr.length; i++) {
            sum[i] = sum[i - 2] + arr[i];
            sum[i] = Math.max(sum[i], sum[i - 3] + arr[i]);
            sum[i] = Math.max(sum[i], arr[i]);
            sum[i] = Math.max(sum[i], sum[i - 2]);
            sum[i] = Math.max(sum[i], sum[i - 3]);
            max = Math.max(max, arr[i]);
        }

        System.out.println("sum is: " + Arrays.toString(sum));
        return Math.max(sum[arr.length - 1], sum[arr.length - 2]) == 0 ? max
                : Math.max(sum[arr.length - 1], sum[arr.length - 2]);
    }
}