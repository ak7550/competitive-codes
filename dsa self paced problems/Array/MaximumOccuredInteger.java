import java.util.ArrayList;
import java.util.Arrays;
import AkPackage.InputOutput;

/**
 * MaximumOccuredInteger
 */
public class MaximumOccuredInteger {

    public static void main(String[] args) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new MaximumOccuredInteger());
        int T = Integer.parseInt(lines.get(0));
        lines.remove(0);
        while (T-- > 0) {
            int length = Integer.parseInt(lines.get(0));
            lines.remove(0);
            int L[] = InputOutput.arrayFromString(lines.get(0));
            lines.remove(0);
            int R[] = InputOutput.arrayFromString(lines.get(0));
            lines.remove(0);
            System.out
                    .println("For input " + Arrays.toString(L) + " and " + Arrays.toString(R) + ": " + getResult(L, R));
        }
    }

    public static int getResult(int L[], int R[]) {
        int count[] = new int[findMax(R) + 2];
        Arrays.fill(count, 0);
        for (int l : L) {
            count[l]++;
        }
        for (int r : R) {
            count[r + 1]--;
        }
        int prefixSum[] = new int[findMax(R) + 2];
        Arrays.fill(prefixSum, 0);
        for (int i = 1; i < prefixSum.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + count[i];
        }
        return findIndex(prefixSum, findMax(prefixSum));
    }

    public static int findIndex(int arr[], int max) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == max) {
                return i;
            }
        }
        return -1;
    }

    public static int findMax(int arr[]) {
        int max = Integer.MIN_VALUE;
        for (int i : arr) {
            max = Math.max(max, i);
        }
        return max;
    }

}