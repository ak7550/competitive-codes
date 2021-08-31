import java.util.ArrayList;
import java.util.Arrays;

import AkPackage.InputOutput;

public class MaxAndSecondMax {
    public static void main(String[] args) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new MaxAndSecondMax());
        int T = Integer.parseInt(lines.get(0));
        lines.remove(0);
        while (T-- > 0) {
            int length = Integer.parseInt(lines.get(0));
            lines.remove(0);
            int arr[] = InputOutput.arrayFromString(lines.get(0));
            lines.remove(0);
            System.out.println("For input: "+ Arrays.toString(arr));
            getResult(arr);
        }
    }

    public static void getResult(int arr[]) {
        int max = Integer.MIN_VALUE, secondMax = -1;
        for (int i : arr) {
            max = Math.max(max, i);
        }
        for (int i : arr) {
            secondMax = (i > secondMax) ? (i < max) ? i : secondMax : secondMax;
        }
        System.out.println("Max is: " + max + " Second max is: " + secondMax);
    }

    public static void getResult2(int arr[]) {
        int max = arr[0], sMax = -1;
        for (int i = 1; i < arr.length; i++) {
            if (max < arr[i]) {
                sMax = max;
                max = arr[i];
            }
            if (sMax < arr[i] && arr[i] < max)
                sMax = arr[i];
        }
        System.out.println("Max is: " + max + " Second max is: " + sMax);
    }
}