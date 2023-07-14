import AkPackage.*;
import java.util.*;

public class PairOfSongs {
    public static void main(String args[]) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new PairOfSongs());
        while (!lines.isEmpty()) {
            int time[] = InputOutput.arrayFromString(lines.remove(0));
            System.out.println("For i/p: " + Arrays.toString(time));
            System.out.println("o/p: " + countPairs(time));
        }
    }

    public static int countPairs(int time[]) {
        Arrays.sort(time);
        int count = 0;
        for (int i = 0; i + 1 < time.length; i++)
            count += countPairs(time, i + 1, time.length - 1, time[i]);

        return count;
    }

    public static int countPairs(int time[], int low, int high, int val) {
        if (low > high)
            return 0;
        int count = 0, mid = low + ((high - low) >> 1);
        if ((val + time[mid]) % 60 == 0) {
            System.out.println(Arrays.toString(new int[]{val, time[mid]}));
            count++;
        }
        if (time[mid] - time[low] >= 60)
            count += countPairs(time, low, mid - 1, val);
        // if (time[high] - time[mid] >= 60)
            count += countPairs(time, mid + 1, high, val);
        return count;
    }
}