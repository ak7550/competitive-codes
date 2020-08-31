import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import AkPackage.Array;
import AkPackage.CompetetiveCoding;
import AkPackage.InputOutput;

public class MedianOfTwoSortedArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the first Array: ");
        int n1 = sc.nextInt();
        System.out.print("Enter the size of the second Array: ");
        int n2 = sc.nextInt();
        System.out.println("Enter the first array: ");
        int a1[] = CompetetiveCoding.takeIntegerArrayInput(n1);
        // int a1[] = Array.giveAnArray(n1, 100);
        System.out.println("Enter the second array: ");
        int a2[] = CompetetiveCoding.takeIntegerArrayInput(n2);
        // int a2[] = Array.giveAnArray(n2, 100);
        Arrays.sort(a1);
        Arrays.sort(a2);
        double median = findMedian(a1, a2);
        System.out.println(
                "For the array: \n" + Arrays.toString(a1) + "\n" + Arrays.toString(a2) + "\nMedian is: " + median);
        int temp[] = mergeThemAllTogether(a1, a2); // just for testing purpose.
        double median2 = Array.findMedian(temp);
        System.out.println("Median2 is: " + median2);
    }

    public static int[] mergeThemAllTogether(int a1[], int a2[]) {
        int temp[] = new int[a1.length + a2.length];
        int i = 0;
        while (i < a1.length) {
            temp[i] = a1[i];
            i++;
        }
        int j = 0;
        while (j < a2.length) {
            temp[j + i] = a2[j];
            j++;
        }
        Arrays.sort(temp);
        System.out.println("Merged sorted array is: " + Arrays.toString(temp));
        return temp;
    }

    public static double findMedian(final int a1[], final int a2[]) {
        int small[] = (a1.length >= a2.length) ? a2 : a1;
        int big[] = (a1.length < a2.length) ? a2 : a1;
        int begin = 0, end = small.length;
        while (begin <= end) {
            int mid1 = begin + (end - begin) / 2;
            int mid2 = (small.length + big.length + 1) / 2 - mid1;
            int left1 = (mid1 == 0) ? Integer.MIN_VALUE : small[mid1 - 1];
            int right1 = (mid1 == small.length) ? Integer.MAX_VALUE : small[mid1];
            int left2 = (mid2 == 0) ? Integer.MIN_VALUE : big[mid2 - 1];
            int right2 = (mid2 == big.length) ? Integer.MAX_VALUE : big[mid2];
            if (left1 <= right2 && left2 <= right1) {
                double ans = -1;
                if ((small.length + big.length) % 2 == 0) {
                    ans= ((double) Math.max(left1, left2) + (double) Math.min(right1, right2)) / 2;
                } else {
                    ans = Math.max(left1, left2);
                }
                return (ans == -0.5) ? -1 : ans; // just to avoid the error scenario when small length is 0; when it happens it genuinely return -0.5
            } else if (left1 > right2) {
                end = mid1 - 1;
            } else
                begin = mid1 + 1;
        }
        return -1;
    }
}