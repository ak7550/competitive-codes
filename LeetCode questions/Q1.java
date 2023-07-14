import AkPackage.*;
import java.util.*;


public class Q1 {
    public static void main(String args[]) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new Q1());
        while (!lines.isEmpty()) {
            int nums[] = InputOutput.arrayFromString(lines.remove(0));
            System.out.println("For ip: " + Arrays.toString(nums));
            System.out.println("op: " + solve(nums));
        }
    }

    private static int solve(int nums[]) {
        int newArr[] = Arrays.stream(nums).filter(x -> (x & 1) == 0).sorted().toArray();

        if (newArr.length == 0)
            return -1;
        System.out.println("new Arr" + Arrays.toString(newArr));

        int least = -1, leastCount = 0;
        int count = 1, val = newArr[0];

        for (int i = 1; i < newArr.length; i++) {
            if (newArr[i] == val) {
                count++;
            } else {
                if (count > leastCount) {
                    least = val;
                    leastCount = count;
                }
                count = 1;
                val = newArr[i];
            }
        }
        if (count > leastCount) {
            least = val;
            leastCount = count;
        }

        return least;
    }
}