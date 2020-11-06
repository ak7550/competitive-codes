import java.util.ArrayList;
import java.util.Arrays;

import AkPackage.InputOutput;

public class MoergeTwoSortedArraysWithConstantSpace {
    public static void main(String[] args) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new MoergeTwoSortedArraysWithConstantSpace());
        while (!lines.isEmpty()) {
            int arr1[] = InputOutput.arrayFromString(lines.remove(0)),
                    arr2[] = InputOutput.arrayFromString(lines.remove(0));
            System.out.println("For input: \n" + Arrays.toString(arr1) + "\n" + Arrays.toString(arr2));
            getResult(arr1, arr2);
            System.out.println("Output: \n" + Arrays.toString(arr1) + "\n" + Arrays.toString(arr2));
        }
    }

    public static void getResult(int arr1[], int arr2[]) {
        int i = 0, j = 0;
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] > arr2[j]) {
                int temp = arr1[i];
                arr1[i] = arr2[j];
                arr2[j] = temp;
                sort2nd(arr2, j);
            } else
                i++;
        }
    }

    //from (start+1) the array is sorted. use binary search to find the proper place  
    public static void sort2nd(int arr[], int start) {
        int value = arr[start], i;
        for (i = start; i < arr.length - 1; i++) {
            if (arr[i + 1] > value) {
                break;
            }
            arr[i] = arr[i + 1];
        }
        arr[i] = value;
    }
}

// expected time complexity is: O(m+nlog(m+n))  ===> expected algorithm is heap sort
