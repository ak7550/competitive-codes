import java.util.ArrayList;
import java.util.Arrays;

import AkPackage.InputOutput;

public class TappingRainProblem {
    public static void main(String[] args) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new TappingRainProblem());
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
        int bigPillarsOnLeft[] = new int[arr.length], bigPillarsOnRight[] = new int[arr.length];
        int sum = 0, max = Integer.MIN_VALUE;
        for (int i = 0; i < bigPillarsOnLeft.length; i++) {
            max = Math.max(max, arr[i]);
            bigPillarsOnLeft[i] = max;
        }
        max = Integer.MIN_VALUE;
        for (int i = arr.length-1; i >= 0; i--) {
            max = Math.max(max, arr[i]);
            bigPillarsOnRight[i] = max;
        }

        for (int i = 0; i < arr.length; i++) {
            sum += Math.min(bigPillarsOnLeft[i], bigPillarsOnRight[i]) - arr[i];
        }
        System.out.println("Maximum Capacity is: " + sum);
    }
}