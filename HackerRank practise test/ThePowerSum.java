import AkPackage.*;
import java.util.*;

public class ThePowerSum {
    public static void main(String args[]) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new ThePowerSum());
        while (!lines.isEmpty()) {
            int line[] = InputOutput.arrayFromString(lines.remove(0));
            int x = line[0], n = line[1];
            System.out.println("For the value of x: " + x + " n: " + n);
            System.out.println("Number of way is: " + thePowerSum(x, n));
        }
    }

    // revurssive approach
    public static int thePowerSum(int num, int a) {
        return thePowerSum(num, 1, num, a);
    }

    public static int thePowerSum(int sum, int index, int n, int a) {
        if (sum == 0)
            return 1;
        if (sum < 0)
            return 0;
        if (index == n + 1)
            return 0;
        // once you take it, and once you wont
        return thePowerSum(sum - (int) Math.pow(index, a), index + 1, n, a) + thePowerSum(sum, index + 1, n, a);
    }

    
}