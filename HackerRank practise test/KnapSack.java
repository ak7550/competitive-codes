import AkPackage.*;
import java.util.*;


public class KnapSack {
    public static void main(String args[]) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new KnapSack());
        while (!lines.isEmpty()) {
            List<Integer> arr = InputOutput.ArrayListFromString(lines.remove(0));
            int k = Integer.parseInt(lines.remove(0));
            // System.out.println("For I/P: " + arr);
            System.out.println("k =" + k);
            System.out.println("O/P is: " + knapsack(arr, k));
        }
    }

    static int max ;

    public static int knapsack(List<Integer> arr, int k) {
        max = 0;
        // arr.stream().distinct().sorted((a, b) -> b - a).map(arr::add);
        recurr(k, arr, 0, 0);
        return max;
    }

    public static void recurr(int k, List<Integer> arr, int index, int sum) {
        if (sum > k || index == arr.size())
            return;

        sum += arr.get(index);
        if (sum < k)
            max = Math.max(max, sum);
        if (sum == k) { // ultimate goal has reached
            max = sum;
            return;
        }
        if (max != k)
            recurr(k, arr, index, sum);
        if (max != k)
            recurr(k, arr, index + 1, sum);
    }
}