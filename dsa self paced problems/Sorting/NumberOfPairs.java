import java.util.ArrayList;
import java.util.Arrays;

import AkPackage.InputOutput;

public class NumberOfPairs {

    public static void main(String[] args) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new NumberOfPairs());
        while (!lines.isEmpty()) {
            int X[] = InputOutput.arrayFromString(lines.remove(0));
            int Y[] = InputOutput.arrayFromString(lines.remove(0));
            System.out.println("For Input: \n" + Arrays.toString(X) + "\n" + Arrays.toString(Y));
            int ans = getResult(X, Y);
            System.out.println("Number of Pairs are: " + ans);
        }
    }

    public static int getResult(int x[], int y[]) {
        int count = 0;
        Arrays.sort(y);
        int minus[] = new int[5];
        for (int i = 0; i < y.length && y[i] <= 4; i++)
            minus[y[i]]++;
        for (int i = 0; i < x.length; i++) {
            if (x[i] == 0) //(0,y) invalid
                continue;
            if (x[i] == 1) {
                count += minus[0];
                continue; // only (1,0) valids
            }
            count += minus[0] + minus[1]; // (x,1),(x,0) always valids
            if (x[i] == 3)
                count += minus[2];
            int pos = binarySearch(y, x[i], 0, y.length - 1);
            if (pos == -1) // we won't get any value for x[i]
                continue;
            count += y.length - pos; // possible counts
            if (x[i] == 2)
                count -= (minus[3] + minus[4]); //(2,3), (2,4) invalid
        }
        return count;
    }

    // binarySearch should return the lowest possible index=i from which y[i]>value
    // (exactly greater than)
    public static int binarySearch(int y[], int value, int start, int end) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (y[mid] > value) {
                int pos = binarySearch(y, value, start, mid - 1);
                return pos == -1 ? mid : pos;
            } else
                return binarySearch(y, value, mid + 1, end);
        }
        return -1;
    }
}
