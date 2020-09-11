package AkPackage;

import java.util.*;

public class Array {

    // a method that converts list to array regardless of it's wrapper class
    public static int[] arrayFromString(String str) {
        return InputOutput.ArrayListFromString(str).stream().mapToInt(Integer::valueOf).toArray();
    }

    public static int[] intArrayFromArrayList(ArrayList<Integer> arrayList) {
        return arrayList.stream().mapToInt(Integer::valueOf).toArray();
    }

    public static Integer[] swapIntegers(Integer arr[], int firstIndex, int secondIndex) {
        Integer temp = arr[firstIndex];
        arr[firstIndex] = arr[secondIndex];
        arr[secondIndex] = temp;
        return arr;
    }

    public static void leftRotateArr(int arr[], int d) {
        // add your code here
        int g = Mathematics.gcd(arr.length, d);
        for (int i = 0; i < g; i++) {
            int temp = arr[i];
            int j = i;
            while (true) {
                int k = (j + d) % arr.length;
                if (k == i)
                    break;
                arr[j] = arr[k];
                j = k;
                // System.out.println("write the String");
            }
            arr[j] = temp;
        }
    }

    public static void rightrotate(int arr[], int d) {
        int g = Mathematics.gcd(arr.length, d);
        for (int i = 0; i < g; i++) {
            int temp = arr[arr.length - g + i];
            int j = arr.length - g + i;
            while (true) {
                int k = j - d;
                if (k == i - g)
                    break;
                if (k < 0)
                    k += arr.length;

                arr[j] = arr[k];
                j = k;
            }
            arr[j] = temp;
        }
    }

    public static int kadane(int[] arr) {
        int curentMax = arr[0], maxFar = arr[0];
        for (int j = 1; j < arr.length; j++) {
            int i = arr[j];
            curentMax = Math.max(i, i + curentMax);
            maxFar = Math.max(curentMax, maxFar);
        }
        return maxFar;
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

    public static int[] giveAnArray(int size, int bound) {
        return new Ran().giveAnArray(size, bound);
    }

    public static int[] giveAnArray(int size) {
        return giveAnArray(size, 100);
    }

    public static double findMedian(int arr[]) {
        int a[] = arr;
        if (a.length == 0)
            return -1;
        Arrays.sort(a);
        if (a.length % 2 == 0) {
            return ((double) a[a.length / 2] + (double) a[(a.length / 2) - 1]) / 2;
        }
        return a[a.length / 2];
    }
}

// convert arraylist to array of same wrapper class
// String[] array = list.toArray(new String[list.size()]);