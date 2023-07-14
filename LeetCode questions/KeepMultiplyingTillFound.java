import AkPackage.*;
import java.util.*;


public class KeepMultiplyingTillFound {
    public static void main(String args[]) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new KeepMultiplyingTillFound());
        while (!lines.isEmpty()) {
            int nums[] = InputOutput.arrayFromString(lines.remove(0)),
                    original = InputOutput.ArrayListFromString(lines.remove(0)).get(0);

            System.out.println("For ip: " + Arrays.toString(nums) + "\t " + original);
            System.out.println("Ans: " + findVal(nums, original));
        }
    }

    public static int findVal(int nums[], int original) {
        Arrays.sort(nums);
        int index = -1, from = 0, end = nums.length;
        while (from < end) {
            index = Arrays.binarySearch(nums, from, end, original);
            if (index >= 0) {
                original <<= 1;
                from = index + 1;
            } else
                break;
        }

        return original;
    }
}