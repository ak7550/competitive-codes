import java.util.ArrayList;
import java.util.Scanner;

import AkPackage.InputOutput;

public class trailingZeroesInFactorial {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number: ");
        int n = sc.nextInt();
        System.out.println("Number of trailing zeroes present in " + n + " are: " + getresult(n));
    }

    public static int getresult(int A) {
        int sum = 0;
        for (int i = 5; i <= A; i *= 5)
            sum += Math.floor(A / i);
        return sum;
    }
}