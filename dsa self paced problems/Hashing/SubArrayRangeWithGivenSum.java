import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import AkPackage.InputOutput;

public class SubArrayRangeWithGivenSum {
    public static void main(String[] args) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new SubArrayRangeWithGivenSum());
        while (!lines.isEmpty()) {
            int arr[] = InputOutput.arrayFromString(lines.remove(0));
            int sum = Integer.parseInt(lines.remove(0));
            System.out.println("For input: " + Arrays.toString(arr));
            int count = getResult(arr, sum);
            System.out.println("Output is: " + count);
        }
    }
    public static int getResult(int arr[], int sum) {
        HashMap<Integer, Integer> mp = new HashMap<Integer, Integer>();
        int s = 0, count = 0;
        for (int i = 0; i < arr.length; i++) {
            s += arr[i];
            if (s == sum)
                count++;
            if (mp.containsKey(s - sum))
                count += mp.get(s - sum);
            mp.put(s, mp.containsKey(s) ? mp.get(s) + 1 : 1);
        }
        return count;
    }
}
