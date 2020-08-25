import java.util.Scanner;

import AkPackage.CompetetiveCoding;

/**
 * Pair
 */
class Pair {

    int first, second;
}

public class twoRepeatedElements {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the length of the arrray: ");
        int arr[] = CompetetiveCoding.takeIntegerArrayInput(sc.nextInt());
        Pair p = getResult(arr);
        System.out.println(p.first + " " + p.second);
    }
    public static Pair getResult(int arr[]) {
        Pair p = new Pair();
        for (int i = 0; i < arr.length; i++) {
            arr[i]--;
        }
        int n = arr.length - 2;
        for (int i = 0; i < arr.length; i++) {
            arr[arr[i] % n] += n;
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] /= n;
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        int k = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 2) {
                if (k == 1) {
                    p.second = i+ 1;
                    break;
                }
                p.first = i + 1;
                k++;
            }
        }
        return p;
    }
}