import java.util.Scanner;

import AkPackage.CompetetiveCoding;

/**
 * Pair
 */
class Pair {

    int first, second;
}

public class twoRepeatedElementsv2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the length of the arrray: ");
        int arr[] = CompetetiveCoding.takeIntegerArrayInput(sc.nextInt());
        Pair p = getResult(arr);
        System.out.println(p.first + " " + p.second);
    }

    public static Pair getResult(int arr[]) {
        Pair p = new Pair();
        int x[] = new int[2];
        int k = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[Math.abs(arr[i])] < 0) {
                x[k++] = Math.abs(arr[i]);
                if (k == 2) {
                    break;
                }
            } else {
                arr[Math.abs(arr[i])] *= -1;
            }
        }
        p.first = x[0];
        p.second = x[1];
        return p;
    }
}