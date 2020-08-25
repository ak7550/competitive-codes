import java.util.ArrayList;
import java.util.Arrays;

import AkPackage.InputOutput;

public class SotedAndRotatedArray {
    public static void main(String[] args) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new SotedAndRotatedArray());
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
        System.out.println((checkForAcending(arr) || checkForAcending(reverseArr(arr))));
    }

    public static boolean checkForAcending(int arr[]) {
        int sortedOrderBreak = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[(i + 1)]) {
                sortedOrderBreak += 1;
            }
        }
        if (sortedOrderBreak != 1) { // as the array is either sorted properly or has been break the order of sorting
                                     // many times
            return false;
        }
        if (arr[arr.length - 1] > arr[0] && sortedOrderBreak == 1) { // though it has broken the order of sorting only
                                                                     // once but the last number is greater than the
                                                                     // first number, that should not be the case for a
                                                                     // sorted and rotated array.
            return false;
        } else {
            return true;
        }
    }

    public static int[] reverseArr(int arr[]) {
        for (int i = 0; i < arr.length / 2; i++) {
            int tem = arr[i];
            arr[i] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = tem;
        }
        System.out.println("After Reversing the Array: " + Arrays.toString(arr));
        return arr;
    }
}