import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

import AkPackage.Array;

public class SearchInSortedRotatedArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random ran = new Random();
        System.out.print("Enter the length of the array: ");
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = ran.nextInt(100);
        }
        int x = arr[arr.length - 1]; // element to be searched.==> biggest element
        Arrays.sort(arr);
        // System.out.print("Enter the number to search: ");
        // int x = sc.nextInt();
        Array.rightrotate(arr, ran.nextInt(n));
        System.out.println("For the array " + Arrays.toString(arr) + "\nThe index of " + x + " is: " + search(arr, x));
    }

    public static int search(int arr[], int s) {
        int indexOfBiggestElement = searchBiggest(arr, 0, arr.length - 1);
        System.out.println(arr[indexOfBiggestElement] + " is the biggest element, present at index " + indexOfBiggestElement);
        /*
         * 3 special cases are there pivot element is at end and we need to find the
         * pivot element pivot element is at begining and we need to find the pivot
         * element
         */
        return Math.max(searchElement(arr, 0, indexOfBiggestElement, s),
                searchElement(arr, (indexOfBiggestElement + 1) % arr.length, arr.length - 1, s));
    }

    public static int searchBiggest(int arr[], int l, int h) {
        int mid = l + (h - l) / 2;
        if (h >= l) {
            if (arr[mid] > arr[(mid + 1) % arr.length]) {
                return mid;
            }
            if (arr[mid] < arr[l]) {
                return searchBiggest(arr, l, mid - 1);
            } else {
                return searchBiggest(arr, mid + 1, h);
            }
        }
        return -1;
    }

    public static int searchElement(int arr[], int l, int h, int s) {
        int mid = l + (h - l) / 2;
        if (h >= l) {
            if (arr[mid] == s) {
                return mid;
            }
            if (arr[mid] > s) {
                return searchElement(arr, l, mid - 1, s);
            } else {
                return searchElement(arr, mid + 1, h, s);
            }
        }
        return -1;
    }
}