import AkPackage.*;
import java.util.*;


public class SumOfJIK {
    public static void main(String args[]) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new SumOfJIK());
        while (!lines.isEmpty()) {
            int arr[] = InputOutput.arrayFromString(lines.remove(0));
            int i = arr[0], j = arr[1], k = arr[2];
            System.out.println("for i=" + i + " j=" + j + " k=" + k);
            System.out.println("Ans: " + getSequenceSum(i, j, k));
        }
    }

    public static long getSequenceSum(int i, int j, int k) {
        long sumI = getSum(j) - getSum(i - 1);

        long sumK = getSum(j - 1 ) - getSum(k - 1);

        return sumI + sumK;
    }

    public static long getSum(long num) {
        return num * (num + 1) / 2;
    }
}