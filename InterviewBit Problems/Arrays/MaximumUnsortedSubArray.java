import java.util.ArrayList;
import java.util.Arrays;

import AkPackage.InputOutput;

public class MaximumUnsortedSubArray {
    public static void main(String[] args) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new MaximumUnsortedSubArray());
        while (!lines.isEmpty()) {
            int line[] = InputOutput.arrayFromString(lines.remove(0));
            int ans[] = getResult(line);
            System.out.println("For Input: " + Arrays.toString(line));
            System.out.println("Output is: " + Arrays.toString(ans));
        }
    }

    public static int[] getResult(int arr[]) {
        int sum = 0, temp = 0, sI = 0, eI = 0, maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (sum > maxSum) {
                maxSum = sum;
                eI = i;
                sI = temp;
            }
            if (sum < 0) {
                sum = 0;
                temp = i + 1;
            }
        }
        int ans[] = new int[eI - sI + 1];
        for (int i = sI, j = 0; i <= eI; i++, j++) {
            ans[j] = arr[i];
        }
        return ans;
    }
}