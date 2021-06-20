import AkPackage.*;
import java.util.*;

public class KadaneI {
    public static void main(String args[]) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new KadaneI());
        while (!lines.isEmpty()) {
            int arr[] = InputOutput.arrayFromString(lines.remove(0));
            System.out.println("For the given: " + Arrays.toString(arr));
            long ans = maximumSum(arr);
            System.out.println("Maximum sum: " + ans);
        }
    }

    public static long maximumSum(int arr[]) {
        long sum[] = new long[arr.length];
        long max = Integer.MIN_VALUE;
        sum[0] = arr[0];
        max = Math.max(max, sum[0]);
        for (int i = 1; i < arr.length; i++) {
            sum[i] = Math.max(arr[i], max + arr[i]);
            max = sum[i];
        }
        Arrays.stream(sum).forEach(x -> System.out.print(x + " "));
        return Arrays.stream(sum).max().getAsLong();
    }
}