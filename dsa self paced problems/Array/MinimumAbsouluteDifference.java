import java.util.ArrayList;
import java.util.Arrays;

import AkPackage.InputOutput;

public class MinimumAbsouluteDifference {
    public static void main(String[] args) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new MinimumAbsouluteDifference());
        int T = Integer.parseInt(lines.get(0));
        lines.remove(0);
        while (T-- > 0) {
            int length = Integer.parseInt(lines.get(0));
            lines.remove(0);
            int arr[] = InputOutput.arrayFromString(lines.get(0));
            lines.remove(0);
            System.out.println("For Input " + Arrays.toString(arr) + " minimum absoulute difference is: " + getResult(arr));
        }
    }

    public static int getResult(int arr[]) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            int abdiff = Math.abs(arr[i] - arr[(i + 1) % arr.length]);
            // System.out.println("Absoulute difference between " + arr[i] + " and " + arr[(i + 1) % arr.length] + " is: " + abdiff);
            min = Math.min(min, abdiff);
        }
        return min;
    }
}