import java.util.ArrayList;
import java.util.Arrays;

import AkPackage.InputOutput;

public class CountingFrogPath {
    public static void main(String[] args) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new CountingFrogPath());
        while (!lines.isEmpty()) {
            int arr[] = InputOutput.arrayFromString(lines.remove(0));
            int x = arr[0], y = arr[1], s = arr[2], t = arr[3];
            int path = getResult(x, y, s, t);
            System.out.println("For Input: " + Arrays.toString(arr));
            System.out.println("Output is: " + path);
        }
    }

    public static int getResult(int x, int y, int s, int t) {
        int remainingTime = t - x + y;
        if (remainingTime >= (s - 1) * 2) // in this time period the frog may complete the whole square
        {
            int sum = 0, n = s;
            for (int i = n; i >= 2; i -= 2) {
                sum += i + (i - 1) * 2 + (i - 2);
            }
            sum += (s % 2 == 0 ? 1 : 0);
            return sum;
        } else {
            int half = remainingTime / 2, path = 2 * remainingTime;
            return 1 + path + ((half * (half + 1)) / 2);
        }
    }
}