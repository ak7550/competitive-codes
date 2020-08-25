import java.util.Arrays;
import java.util.Scanner;

import AkPackage.CompetetiveCoding;

public class MissingInteger {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the lenght of the array: ");
        int n = sc.nextInt();
        int arr[] = CompetetiveCoding.takeIntegerArrayInput(n);
        System.out.println("For the Array: " + Arrays.toString(arr));
        System.out.println("Missing Number is: "+ firstMissingPositive(arr));
    }

    public static int firstMissingPositive(int[] A) {
        Arrays.sort(A);
        int min = 1;
        for (int i = 0; i < A.length; i++) {
            if (A[i] > 0 && A[i] == min) {
                min++;
            }
            if (A[i] > 0 && A[i] != min) {
                return min;
            }
        }
        return min;
    }
}