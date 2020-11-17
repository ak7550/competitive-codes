import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

import AkPackage.InputOutput;

public class LongestConsequtiveSubsequence {
    public static void main(String[] args) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new LongestConsequtiveSubsequence());
        while (!lines.isEmpty()) {
            int arr[] = InputOutput.arrayFromString(lines.remove(0));
            System.out.println("For input: " + Arrays.toString(arr));
            System.out.println("Length of longest consequtive subsequence is: " + getResult2(arr));
        }
    }

    public static int getResult2(int arr[]) {
        HashSet<Integer> hs = new HashSet<Integer>();
        for (Integer integer : arr)
            hs.add(integer);
        int curr = 0, length = 1;
        for (Integer integer : arr) {
            // find the smallest value of the consequtive subsequence.
            if (!hs.contains(integer - 1)) {
                curr = 1;
                while (hs.contains(integer + curr))
                    curr++;
                length = Math.max(length, curr);
            }
        }
        return length;
    }
    // try to use hashing O(n) time and space complexity
    public static int getResult(int arr[]) {
        Arrays.sort(arr);
        int count = 1, length = 1;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == arr[i + 1])
                continue;
            else if (arr[i] + 1 == arr[i + 1])
                count++;
            else
                count = 1;
            length = Math.max(length, count);
        }
        return length;
    }
}
