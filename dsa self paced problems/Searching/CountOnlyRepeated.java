import java.util.Arrays;
import java.util.Scanner;

import AkPackage.CompetetiveCoding;

class Pair2 {

    int value, count;
}

public class CountOnlyRepeated {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the length of the array: ");
        int arr[] = CompetetiveCoding.takeIntegerArrayInput(sc.nextInt());
        System.out.println("For Input: " + Arrays.toString(arr));
        Pair2 p = getResult(arr);
        System.out.println("Value is: " + p.value);
        System.out.println("Count is: " + p.count);
    }

    public static Pair2 getResult(int arr[]) {
        Pair2 p = new Pair2();
        p.value = arr[searchTheElement(arr, 0, arr.length - 1)];
        p.count = rightCount(arr, p.value) - leftcount(arr, p.value) + 1;
        return p;
    }

    public static int rightCount(int arr[], int value) {
        int start = 0, end = arr.length - 1;
        while (end >= start) {
            int mid = start + (end - start) / 2;
            if (mid == arr.length - 1 && arr[mid] == value) {
                return mid;
            }
            if (arr[mid] == value && arr[mid + 1] != value) {
                return mid;
            }
            if (arr[mid] > value)
                end = mid - 1;
            else
                start = mid + 1;
        }
        return -1;
    }

    public static int leftcount(int arr[], int value) {
        int start = 0, end = arr.length - 1;
        while (end >= start) {
            int mid = start + (end - start) / 2;
            if (mid == 0 && arr[mid] == value) {
                return mid;
            }
            if (arr[mid] == value && arr[mid - 1] != value) {
                return mid;
            }
            if (arr[mid] >= value) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }

    public static int searchTheElement(int arr[], int start, int end) {
        int mid = start + (end - start) / 2;
        if (end > start) {
            if (mid == 0 && arr[mid] == arr[mid + 1])
                return mid;
            else if (mid == arr.length - 1 && arr[mid] == arr[mid - 1])
                return mid;
            else if (mid != 0 && (arr[mid] == arr[mid + 1] || arr[mid] == arr[mid - 1] ))
                return mid;
            else if (mid == 0 && arr[mid] != arr[mid + 1])
                return -1;
            else if (mid == arr.length - 1 && arr[mid] != arr[mid - 1])
                return -1;
            return Math.max(searchTheElement(arr, mid + 1, end), searchTheElement(arr, start, mid - 1));
        }
        return -1;
    }
}