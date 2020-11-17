import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import AkPackage.InputOutput;

public class LongestSubArrayWithGivenSum {
    public static void main(String[] args) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new LongestSubArrayWithGivenSum());
        while (!lines.isEmpty()) {
            int arr[] = InputOutput.arrayFromString(lines.remove(0)), sum = Integer.parseInt(lines.remove(0));
            System.out.println("For input: " + Arrays.toString(arr) + "\nSum= " + sum);
            System.out.println("\nLongest subarray length is: " + getResult(arr, sum));
        }
    }

    public static int getResult(int arr[], int sum) {
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        int s = 0, maxLength = Integer.MIN_VALUE, count = 0;
        for (int i = 0; i < arr.length; i++) {
            s += arr[i];
            if (hm.containsKey(s - sum)) {
                count++;
                maxLength = Math.max(maxLength, i - hm.get(s - sum));
                System.out.print("SubArray from " + (hm.get(s - sum) + 1) + " to " + i+": ");
                System.out.println(Arrays.toString(Arrays.copyOfRange(arr, hm.get(s - sum) + 1, i+1)));
            }
            hm.put(s, hm.containsKey(s) ? hm.get(s) : i);
            if (s == sum) {
                count++;
                maxLength = Math.max(maxLength, i + 1);
                System.out.print("SubArray from 0 to " + i+": ");
                System.out.println(Arrays.toString(Arrays.copyOfRange(arr, 0, i+1)));
            }
        }
        System.out.println("Number of subarrays are: " + count);
        return maxLength;
    }

}
