import java.util.Arrays;
import java.util.Scanner;

import AkPackage.CompetetiveCoding;

public class RoofTop {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of the buildings: ");
        int arr[] = CompetetiveCoding.takeIntegerArrayInput(sc.nextInt());
        int maxConsequtiveSteps = getResult(arr);
        System.out.println("For Input: " + Arrays.toString(arr));
        System.out.println("Maximum consequtive steps are: " + maxConsequtiveSteps);
    }

    public static int getResult(int arr[]) {
        int max = Integer.MIN_VALUE, count = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i + 1] - arr[i] >= 1) {
                count++;
            } else {
                count = 0;
            }
            max = Math.max(max, count);
        }
        max = Math.max(max, count);
        return max;
    }
}