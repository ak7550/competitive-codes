import AkPackage.*;
import java.util.*;

public class LongestIncreasingSubSequence {
    public static void main(String args[]) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new LongestIncreasingSubSequence());
        while (!lines.isEmpty()) {
            int arr[] = InputOutput.arrayFromString(lines.remove(0));
            System.out.println("\n\n\n\nFor the given: " + Arrays.toString(arr));
            System.out.println("Longest Increasing subsequence is:");
            longestSubSequence3(arr);
        }
    }

    // O(n^2) solution, O(n^2) space
    public static void longestSubSequence(int arr[]) {
        @SuppressWarnings("unchecked") // docs:
                                       // https://stackoverflow.com/questions/14847480/type-safety-the-expression-of-type-arraylist-needs-unchecked-conversion
        ArrayList<Integer>[] dp = new ArrayList[arr.length]; // docs:
                                                             // https://www.geeksforgeeks.org/array-of-arraylist-in-java/

        dp[0] = new ArrayList<>();
        dp[0].add(arr[0]);
        for (int i = 1; i < dp.length; i++) {
            ArrayList<Integer> maxArr = new ArrayList<Integer>();
            for (int j = i; j >= 0; j--) {
                if (arr[j] < arr[i] && dp[j].size() > maxArr.size())
                    maxArr = dp[j];
            }
            // _ maxArr.size() == 0 ==> nothing has gone into maxArr, arr[i] is the maximum
            // number soo far
            dp[i] = maxArr.size() == 0 ? new ArrayList<>() : new ArrayList<>(maxArr);
            dp[i].add(arr[i]);
        }

        Arrays.stream(dp).forEach(System.out::println); // print them all

        // finding the max length
        ArrayList<Integer> longest = Arrays.stream(dp).max((a, b) -> a.size() - b.size()).get();

        System.out.println("Longest one: " + longest);
    }

    // O(n^2) solution, O(n) space
    public static void longestSubSequence2(int arr[]) {
        int[] dp = new int[arr.length];
        dp[0] = 1;
        for (int i = 1; i < dp.length; i++) {
            for (int j = i; j >= 0; j--) {
                if (arr[j] < arr[i] && dp[j] > dp[i])
                    dp[i] = dp[j];
            }
            // _ dp[i] == 0 ==> nothing has gone into dp[i], arr[i] is the maximum number
            // soo far
            dp[i] += 1; // add arr[i] into it
        }

        System.out.println("Dp is: " + Arrays.toString(dp));

        // finding the max length
        Integer longest = Arrays.stream(dp).max().getAsInt();

        System.out.println("Longest one: " + longest);
    }

    // O(nlogn) solution, O(n) space ==> BINARY SEARCH
    public static void longestSubSequence3(int arr[]) {
        ArrayList<Integer> tail = new ArrayList<Integer>();
        tail.add(arr[0]);
        // tail[i] ==> minimum possible tail value for LIS of length i+1
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > tail.get(tail.size() - 1))
                tail.add(arr[i]);
            else
                tail.set(getCeilIndex(arr[i], tail), arr[i]);
        }
        System.out.println("Tail array is: " + tail);
    }

    public static int getCeilIndex(int value, ArrayList<Integer> arr) {
        if (arr.size() == 1)
            return 0;
        int start = 0, end = arr.size() - 1;
        int mid = -1;
        while (start < end) {
            mid = start + (end - start) / 2;
            if (mid == 0)
                return arr.get(mid) < value ? mid + 1 : mid;
            // sweet spot
            else if (arr.get(mid - 1) < value && arr.get(mid + 1) > value)
                return mid + 1;
            else if (arr.get(mid) > value)
                end = mid;
            else
                start = mid;
        }
        return mid;
    }

}