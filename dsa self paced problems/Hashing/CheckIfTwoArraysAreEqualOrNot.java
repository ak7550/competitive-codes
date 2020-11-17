import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import AkPackage.InputOutput;

/**
 * CheckIfTwoArraysAreEqualOrNot
 */
public class CheckIfTwoArraysAreEqualOrNot {

    public static void main(String[] args) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new CheckIfTwoArraysAreEqualOrNot());
        while (!lines.isEmpty()) {
            int arr[] = InputOutput.arrayFromString(lines.remove(0)),
                    brr[] = InputOutput.arrayFromString(lines.remove(0));
            System.out.println(Arrays.toString(arr) + "\nand\n" + Arrays.toString(brr) + "\n are: "
                    + (getResult(arr, brr) ? "" : "not") + " equal");
        }
    }

    public static boolean getResult(int arr[], int brr[]) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        HashMap<Integer, Integer> hm2 = new HashMap<>();
        for (Integer i : arr)
            hm.put(i, hm.containsKey(i) ? hm.get(i) + 1 : 1);
        for (Integer i : brr)
            hm2.put(i, hm2.containsKey(i) ? hm2.get(i) + 1 : 1);
        return hm.equals(hm2);
        
    }
}