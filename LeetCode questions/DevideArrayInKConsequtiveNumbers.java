import AkPackage.*;
import java.util.*;

public class DevideArrayInKConsequtiveNumbers {
    public static void main(String args[]) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new DevideArrayInKConsequtiveNumbers());

        while (!lines.isEmpty()) {
            int nums[] = InputOutput.arrayFromString(lines.remove(0)),
                    k = InputOutput.arrayFromString(lines.remove(0))[0];
            System.out.println("For input: " + Arrays.toString(nums));
            System.out.println("o/p: " + isPossibleToDevide(nums, k));
        }
    }

    public static boolean isPossibleToDevide(int nums[], int k) {
        if (nums.length % k != 0)
            return false;
        TreeMap<Integer, Integer> tm = new TreeMap<>();
        Arrays.stream(nums).forEach(x -> tm.put(x, tm.getOrDefault(x, 0) + 1));
        // _ within this loop, I am not allowed to delete anything from the treemap
        for (int key : tm.keySet()) {
            int fre = tm.get(key); // all the numbers in it's array should be with same fre
            if (fre <= 0)
                continue;
            for (int i = 0; i < k; i++) {
                if (!tm.containsKey(key + i) || tm.get(key + i) < fre)
                    return false;

                // -> update
                tm.put(key + i, tm.get(key + i) - fre);
            }
        }
        return true;
    }
}