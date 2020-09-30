import java.util.ArrayList;
import java.util.Arrays;

import AkPackage.InputOutput;
import AkPackage.Mathematics;

public class HexadecimalNumbers {
    public static void main(String[] args) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new HexadecimalNumbers());
        while (!lines.isEmpty()) {
            int input[] = InputOutput.arrayFromString(lines.remove(0));
            int left = input[0], right = input[1];
            System.out.println("For input " + Arrays.toString(input) + "\nThe numbers are: " + getResult(left, right));
        }
    }

    public static boolean check(int num) {
        int sum=0,n=num;
        do {
            sum+=(num%16);
            num/=16;
        } while (num>0);
        return Mathematics.gcd(n, sum) > 1;
    }
    public static int getResult(int left, int right) {
        int sum = 0;
        for (int i = left; i <= right; i++) {
            if (check(i))
                sum++;
        }
        return sum;
    }
}