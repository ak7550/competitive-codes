import java.util.ArrayList;
import java.util.Arrays;

import AkPackage.Array;
import AkPackage.InputOutput;
import AkPackage.Mathematics;

public class KadanesAlgo {
    public static void main(String[] args) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new KadanesAlgo());
        int T = Integer.parseInt(lines.get(0));
        lines.remove(0);
        while (T-- > 0) {
            int length = Integer.parseInt(lines.get(0));
            lines.remove(0);
            int arr[] = InputOutput.arrayFromString(lines.get(0));
            lines.remove(0);
            System.out.println("For Input " + Arrays.toString(arr) + ": ");
            getResult(arr);
            System.out.println();
            System.out.println();
            System.out.println();
        }
    }

    public static void getResult(int arr[]) {
        int max = 0, sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            sum = (sum < 0) ? 0 : sum;
            max = Math.max(max, sum);
        }
        max = allNegative(arr) ? findMax(arr) : max;
        System.out.println("Sum is: " + max);
    }

    public static boolean allNegative(int arr[]) {
        for (int i : arr) {
            if (i >= 0) {
                return false;
            }
        }
        return true;
    }

    public static int findMax(int arr[]) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
        }
        return max;
    }
}