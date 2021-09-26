import AkPackage.*;
import java.util.*;

public class CountTotalSetBits {
    public static void main(String args[]) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new CountTotalSetBits());
        while (!lines.isEmpty()) {
            int num = Integer.parseInt(lines.remove(0));
            System.out.println("For: " + num);
            System.out.println("Ans: " + countSetBit(num));
        }
    }

    public static int countSetBit(int n) {
        int digit = (int) (Math.log10(n) / Math.log10(2)) + 1;
        int maxNumber = (1 << digit) - 1;
        if (n == maxNumber)
            return digit * (1 << (digit - 1));
        else {
            int smallestNumber = (1 << (digit - 1));
            if (n == smallestNumber)
                return 1 + countSetBit(smallestNumber - 1);
            int remaining = n - smallestNumber+1;
            return remaining + countSetBit(remaining-1) + countSetBit(smallestNumber - 1);
        }
        // return 0;
    }
}