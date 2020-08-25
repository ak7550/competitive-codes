import java.util.ArrayList;
import java.util.Arrays;

import AkPackage.InputOutput;

public class MaximumIndex {
    public static void main(String[] args) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new MaximumIndex());
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
        int smallArray[] = new int[arr.length], bigArray[] = new int[arr.length];
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            min = Math.min(min, arr[i]);
            smallArray[i] = min;
        }
        for (int i = arr.length - 1; i >= 0; i--) {
            max = Math.max(max, arr[i]);
            bigArray[i] = max;
        }
        System.out.println("SmallArray: " + Arrays.toString(smallArray));
        System.out.println("BigArray: " + Arrays.toString(bigArray));
        int i = 0, j = 0, m = -1;
        while (i < arr.length && j <  arr.length) {
            if (smallArray[i]<=bigArray[j]) {
                m = Math.max(m, j - i);
                j += 1;
            } else {
                i += 1;
            }
        }
        System.out.println("MaxDifference in My code: " + m);
    }

    
}