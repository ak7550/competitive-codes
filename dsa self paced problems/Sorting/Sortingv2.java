import java.util.ArrayList;
import java.util.Arrays;

import AkPackage.*;

public class Sortingv2 {
    static int convert = 0;

    public static void main(String[] args) {
        // int arr[] = Array.giveAnArray(7, 100);
        // int arr[] = new int[] { 2, 4, 1, 3, 5 };
        // int arr[] = new int[] { 5, 4, 3, 2, 1 };
        ArrayList<String> lines = InputOutput.takeCompleteInput("SampleMergeSort.txt");
        int arr[] = InputOutput.arrayFromString(lines.remove(0));
        System.out.println("For Input: " + Arrays.toString(arr));
        int arr2[] = Arrays.copyOf(arr, arr.length);
        mergeSort(arr, 0, arr.length - 1);
        System.out.println("The Sorted array is: " + Arrays.toString(arr));
        System.out.println("convert: " + convert);
        bubbleSort(arr2);
    }

    public static void bubbleSort(int arr[]) {
        int convert2 = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            boolean isSwapped = false;
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    convert2++;
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    isSwapped = true;
                }
            }
            if (isSwapped)
                break;
        }
        System.out.println("In bubble sort, the conversion is: " + convert2);
    }

    public static void mergeSort(int arr[], int s, int e) {
        if (s < e) {
            int mid = s + (e - s) / 2;
            mergeSort(arr, s, mid);
            mergeSort(arr, mid + 1, e);
            merge(arr, s, mid, e);
        }
    }

    public static void merge(int arr[], int s, int m, int e) {
        int temp1[] = Arrays.copyOfRange(arr, s, m + 1), temp2[] = Arrays.copyOfRange(arr, m + 1, e + 1);
        int i = 0, j = 0, k = s;
        while (i < temp1.length && j < temp2.length) {
            if (temp1[i] < temp2[j]) {
                arr[k++] = temp1[i++];
            } else {
                convert += (temp1.length - i); // tells that how much inversations are necessary. Means temp2[j] needs
                                               // temp1-i number of inversations (as it's sorted array and all the
                                               // numbers present in temp1 are greater than temp2[j], so temp1.length-i
                                               // is the proper place for temp[j] to be in).
                arr[k++] = temp2[j++];
            }
        }
        while (i < temp1.length) {
            arr[k++] = temp1[i++];
        }
        while (j < temp2.length) {
            arr[k++] = temp2[j++];
        }
    }
}
