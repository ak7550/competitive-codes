import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

import AkPackage.Array;
// The code is to find the biggest element present a sorted and rotated array.
public class PeekElement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the length of the array: ");
        int n = sc.nextInt();
        int arr[] = new int[n];
        Random ran = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = ran.nextInt(3);
        }
        Arrays.sort(arr);
        Array.rightrotate(arr, ran.nextInt(10));
        int indexOfBiggestElement = searchBigElement(arr);
        System.out.println("For the array of " + Arrays.toString(arr) + "\nThe index of the biggest element is: "
                + indexOfBiggestElement + "\nThe element is: " + arr[indexOfBiggestElement]);
    }

    public static int searchBigElement(int arr[]) {
        return searchBigElement(arr, 0, arr.length - 1);
    }

    public static int searchBigElement(int arr[], int l, int h) {
        int mid = l + (h - l) / 2;
        
        if (h >= l) {
            if (arr[mid] > arr[(mid + 1) % arr.length]) {
                return mid;
            }
            if (arr[mid]<arr[l]) {
                return searchBigElement(arr, l, mid - 1);
            } else {
                return searchBigElement(arr, mid + 1, h);
            }
        }
        return -1;
    }
}