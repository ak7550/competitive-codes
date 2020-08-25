import java.util.Arrays;
import java.util.Scanner;

import AkPackage.CompetetiveCoding;

/**
 * MaximumAbsoulutedifference
 */
public class MaximumAbsoulutedifference {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the lenght of the array: ");
        int n = sc.nextInt();
        int arr[] = CompetetiveCoding.takeIntegerArrayInput(n);
        System.out.println("For the Array: " + Arrays.toString(arr));
        int maxValue = getReuslt(arr);
        System.out.println("Maximum absoulute difference is: " + maxValue);
    }
    public static int getReuslt(int arr[]) {
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE, max=Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            max1 = Math.max(max1, arr[i] + i);
            max2 = Math.max(max2, arr[i] - i);
            min1 = Math.min(min1, arr[i] + i);
            min2 = Math.min(min2, arr[i] - i);
            max = Math.max(max, Math.max(max1-min1, max2-min2));
        }
        return max;
    }
}