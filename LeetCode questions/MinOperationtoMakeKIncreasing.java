import AkPackage.*;
import java.util.*;

public class MinOperationtoMakeKIncreasing {
    public static void main(String args[]) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new MinOperationtoMakeKIncreasing());
        while (!lines.isEmpty()) {
            int arr[] = InputOutput.arrayFromString(lines.remove(0)),
                    k = InputOutput.ArrayListFromString(lines.remove(0)).get(0);

            System.out.println("For ip: " + Arrays.toString(arr) + " " + k);
            System.out.println("op is: " + minOperations(arr, k));
        }
    }

    public static int minOperations(int arr[], int k) {
        int count = 0;
        for (int i = 0; i+k < arr.length; i++) {
            int prev = arr[i], curr = arr[i + k];
            if(prev>curr){
                curr = prev;
                count += (curr - arr[i+k]);
                arr[i] = curr;
            }
        }
        return count;
    }
}