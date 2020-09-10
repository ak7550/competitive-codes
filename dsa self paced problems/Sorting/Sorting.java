import java.util.Arrays;
import java.util.Scanner;
import AkPackage.Array;

/**
 * SelectionSort
 */
public class Sorting {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the length of the arrays: ");
        int n = sc.nextInt();
        int arr[] = Array.giveAnArray(n, 200);
        System.out.println("The unsorted array is: " + Arrays.toString(arr));
        // arr = selectionSort(arr);
        // arr = insertionSort(arr);
        // arr = bubbleSort(arr);
        mergeSort(arr,0,arr.length-1);
        // quickSort(arr, 0, arr.length - 1);
        System.out.println("The sorted array is: " + Arrays.toString(arr));
    }

    public static void quickSort(int arr[], int low, int high) {
        if (high>low){
            int pi=partition(arr, low, high);
            quickSort(arr, low, pi-1);
            quickSort(arr, pi+1,high);
        }
    }
    public static int partition(int arr[], int low, int high) {
        int pivot = arr[high], i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high]=temp;
        return i + 1;
    }

    public static void mergeSort(int arr[], int low, int high) {
        if (high > low) {
            int mid = low + (high - low) / 2;
            mergeSort(arr, low, mid);
            mergeSort(arr, mid + 1, high);
            merge(arr, low, mid, high);
        }
    }

    public static void merge(int arr[], int low, int mid, int high) {
        int temp[] = new int[high - low + 1];
        int i = low, j = mid + 1, k = 0;
        while (i <= mid && j <= high) {
            if (arr[i] > arr[j]) {
                temp[k++] = arr[j++];
            } else {
                temp[k++] = arr[i++];
            }
        }
        // the loop will break when one of the array will reach in it's end
        // enter the rest of the array elements.
        while (i <= mid) {
            temp[k++] = arr[i++];
        }
        while (j <= high) {
            temp[k++] = arr[j++];
        }
        // put everything in arr
        for (int k2 = low; k2 <= high; k2++) {
            arr[k2] = temp[k2 - low];
        }
    }

    public static int[] bubbleSort(int arr[]) {
        int n = arr.length; // n is the size of the array.
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tem = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tem;
                }
            }
        }
        return arr;
    }

    public static int[] insertionSort(int arr[]) {
        for (int i = 1; i < arr.length; i++) {
            int k = arr[i], j = i - 1;
            while (j >= 0 && arr[j] >= k) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = k;
        }
        return arr;
    }

    public static int[] selectionSort(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            int minIndex = findmin(arr, i, arr.length - 1);
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
        return arr;
    }

    public static int findmin(int arr[], int low, int high) {
        int min = Integer.MAX_VALUE, minIndex = -1;
        for (int i = low; i <= high; i++) {
            if (arr[i] < min) {
                min = arr[i];
                minIndex = i;
            }
        }
        return minIndex;
    }
}