import AkPackage.*;
import java.util.*;


public class PairWithSpecificDifference {
    public static void main(String args[]) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new PairWithSpecificDifference());
        while (!lines.isEmpty()) {
            int arr[] = InputOutput.arrayFromString(lines.remove(0)),
                    k = InputOutput.ArrayListFromString(lines.remove(0)).get(0);
            System.out.println("for the given: " + Arrays.toString(arr) + " k=" + k);
            System.out.println("Max sum is: " + maxSum(arr, k));
        }
    }

    public static int maxSum(int arr[], int k) {
        Arrays.sort(arr);
        int maxSum = 0, i = arr.length - 1;
        while(i>0){
            int j = i - 1;
            int diff = Math.abs(arr[i] - arr[j]);
            if (diff < k) {
                maxSum += arr[i]+arr[j];
                i = j - 1;
            } else
                i = j;
        }
        return maxSum;
    }
}