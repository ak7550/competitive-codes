import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

import AkPackage.InputOutput;

public class SubArrayWithGivenSum {
    public static void main(String[] args) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new SubArrayWithGivenSum());
        while (!lines.isEmpty()) {
            int arr[] = InputOutput.arrayFromString(lines.remove(0));
            int sum = Integer.parseInt(lines.remove(0));
            boolean check = getResult(arr, sum);
            System.out.println("For the given array: " + Arrays.toString(arr));
            System.out.println("The subarray that sums to " + sum + " is " + (check ? "present" : "not present"));
        }
    }

    public static boolean getResult(int arr[], int sum) {
        HashSet<Integer> hm = new HashSet<>();
        int s = 0;
        for (int integer : arr) {
            s += integer;
            if (hm.contains(s - sum))
                return true;
            hm.add(s);
            if (s == sum)
                return true;
        }
        // System.out.println("Hashset is: "+hm.toString());
        return false;
    }
}
