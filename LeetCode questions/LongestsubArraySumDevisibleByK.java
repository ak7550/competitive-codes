import AkPackage.*;
import java.util.*;


public class LongestsubArraySumDevisibleByK {
    public static void main(String args[]) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new LongestsubArraySumDevisibleByK());
        while (!lines.isEmpty()) {
            int arr[] = InputOutput.arrayFromString(lines.remove(0));
            int k = InputOutput.ArrayListFromString(lines.remove(0)).get(0);
            System.out.println("fot ip: " + Arrays.toString(arr) + "\t k= " + k);
            System.out.println("op is: " + longestSubArraySum(arr, k));
        }
    }

    //* easy code, the implementation of hashmap but was not able to think and implement at one go....
    private static int longestSubArraySum(int a[], int k) {
        HashMap<Long, Integer> hm = new HashMap<>();
        long sum = 0;
        int max = 0;

        for (int i = 0; i < a.length; i++) {
            sum += a[i];
            // hm.put(sum, i);
            long rem = ((sum % k) + k) % k;
            if (rem == 0)
                max = Math.max(max, i + 1);
            else if (hm.containsKey(rem))
                max = Math.max(max, i - hm.get(rem));
            else
                hm.put(rem, i);
        }

        return max;
    }
}