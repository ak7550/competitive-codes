import java.util.ArrayList;

import AkPackage.InputOutput;
import AkPackage.Mathematics;

public class LargestCoprimeDivisor {
    public static void main(String[] args) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new LargestCoprimeDivisor());
        while (!lines.isEmpty()) {
            int[] line = InputOutput.arrayFromString(lines.remove(0));
            int res = getResult(line[0], line[1]);
            System.out.println("For Input: " + line[0] + " " + line[1]);
            System.out.println("Answer is: " + res);
        }
    }

    public static int getResult(int a, int b) {
        // int max = Math.max(a, b), min = Math.min(a, b);
        // a = max;
        // b = min;
        while (true) {
            int x = a / Mathematics.gcd(a, b);
            if (Mathematics.gcd(x, b) != 1) {
                a = x;
            }
            if (Mathematics.gcd(x, b)==1) {
                return x;
            }
        }

    }
}