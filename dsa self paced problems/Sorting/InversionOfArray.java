import java.util.ArrayList;
import java.util.Arrays;

import AkPackage.InputOutput;

public class InversionOfArray {
    public static void main(String[] args) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new InversionOfArray());
        while (!lines.isEmpty()) {
            long n = Long.parseLong(lines.remove(0));
            String str = lines.remove(0);
            long arr[] = takeLongArrayInput(str, n);
            System.out.println("For input: " + Arrays.toString(arr));
            System.out.println("Number of Inversions are: " + getInversion(arr));
            System.out.println("Sorted array is: "+ Arrays.toString(arr));
        }
    }

    public static long[] takeLongArrayInput(String str, long n) {
        String s[] = str.split(" ");
        long arr[] = new long[(int) n];
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(s[i]);
        }
        return arr;
    }

    public static long getInversion(long arr[]) {
        return mergeSort(arr, 0, arr.length - 1);
    }

    public static long mergeSort(long arr[], long start, long end) {
        long inversation = 0;
        if (start < end) {
            long mid = start + (end - start) / 2;
            inversation += mergeSort(arr, start, mid);
            inversation += mergeSort(arr, mid + 1, end);
            inversation += merge(arr, start, mid, end);
        }
        return inversation;
    }

    public static long merge(long arr[], long start, long mid, long end) {
        long temp1[] = Arrays.copyOfRange(arr, (int) start, (int) mid),
                temp2[] = Arrays.copyOfRange(arr, (int) mid + 1, (int) end);
        long startingIndex = start, i = 0, j = 0, res=0;
        while (i < temp1.length && j < temp2.length) {
            if (temp2[(int) j] > temp1[(int) i]) {
                arr[(int) startingIndex++] = temp2[(int) j++];
                res += (temp2.length - j);
            } else {
                arr[(int) startingIndex++] = temp1[(int) i++];
            }
        }
        while (i < temp1.length) {
            arr[(int) startingIndex++] = temp1[(int) i++];
        }
        while (j < temp2.length) {
            arr[(int) startingIndex++] = temp2[(int) j++];
        }
        return res;
    }
}
