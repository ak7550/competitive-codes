package AkPackage;

import java.util.Arrays;
import java.util.Scanner;

public class CompetetiveCoding {
    public static int takeIntegerInput() {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        sc.close();
        return x;
    }

    public static String takeStringInput() {
        Scanner sc = new Scanner(System.in);
        String x = sc.nextLine();
        sc.close();
        return x;
    }

    public static float takeFloatInput() {
        Scanner sc = new Scanner(System.in);
        float x = sc.nextFloat();
        sc.close();
        return x;
    }

    public static double takeInput() {
        Scanner sc = new Scanner(System.in);
        double x = sc.nextDouble();
        sc.close();
        return x;
    }

    public static int[] takeIntegerArrayInput(int length) {
        int arr[] = new int[length];
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < length; i++) {
            arr[i] = scanner.nextInt();
        }
        scanner.close();
        System.out.println("the array is: " + Arrays.toString(arr));
        return arr;
    }

    public static int sumOfArrayElements(int[] arr) {
        int sum = 0;
        for (int i : arr) {
            sum += i;
        }
        return sum;
    }
}