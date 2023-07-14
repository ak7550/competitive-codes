import AkPackage.*;
import java.util.*;

public class LongestIncreasingSubSequence2 {
    public static void main(String args[]) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new LongestIncreasingSubSequence2());
        while (!lines.isEmpty()) {
            int nums[] = InputOutput.arrayFromString(lines.remove(0));
            int k = InputOutput.ArrayListFromString(lines.remove(0)).get(0);
            System.out.println("for ip: " + Arrays.toString(nums) + " and k:" + k);
            System.out.println("op is: " + solve(nums, k));
        }
    }

    private static int solve(int nums[], int k) {
        TreeSet<Integer> ts = new TreeSet<>();
        int max = 1;
        for (int xml : nums) {
            Integer ceil = ts.higher(xml);
            if (ceil != null && ceil - xml <= k) {
                ts.remove(ceil);
                ts.add(xml);
            } else if(ceil == null) {
                Integer floor = ts.lower(xml);
                if(floor != null && xml - floor <= k || floor == null)
                    ts.add(xml);
            } else {
                // tree is emoty
                ts.add(xml);
            }

            max = Math.max(max, ts.size());

        }
        System.out.println("ts:" + ts);
        return max;
    }
}