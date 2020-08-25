import java.util.ArrayList;
import java.util.Arrays;

import AkPackage.Array;
import AkPackage.InputOutput;

public class MaxCircularSubArraySum {
    public static void main(String[] args) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new MaxCircularSubArraySum());
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
        int sum = 0;
        for (int i : arr) {
            sum += i;
        }
        makenegativeArray(arr);
        System.out.println((sum + Array.kadane(arr)));
    }
    public static void makenegativeArray(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] *= -1;
        }
    }
}