package AkPackage;

import java.util.*;

public class Array {
    public static Integer[] integerArrayFromString(String str) {
        String arr[] = str.split(" ");
        List<Integer> myarr = new ArrayList<Integer>();
        for (String string : arr) {
            try {
                Integer ii = Integer.parseInt(string);
                myarr.add(ii);
            } catch (Exception e) {
                // TODO: handle exception
                // System.out.println("Exception avoided. The String is: "+ string);
            }
        }
        Integer[] a = new Integer[myarr.size()];
        // looks damn painfull, impromisation needed.
        for (int i = 0; i < a.length; i++) {
            a[i] = myarr.get(i);
        }
        return a;
    }

    // a method that converts list to array regardless of it's wrapper class
    public static int[] arrayFromString(String str) {
        return integerToint(integerArrayFromString(str));
    }

    public static int[] integerToint(Integer[] arr) {
        int a[] = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            a[i] = arr[i];
        }
        return a;
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
}