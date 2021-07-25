import AkPackage.*;
import jdk.jfr.Unsigned;

import java.util.*;

public class LeftMostSetBit {
    public static void main(String args[]) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new LeftMostSetBit());
        while (!lines.isEmpty()) {
            int n = InputOutput.ArrayListFromString(lines.remove(0)).get(0);
            System.out.println("For: " + n);
            System.out.println("Left Most set bit present at: " + findLeftMostSetBit(n));
        }
    }

    public static int findLeftMostSetBit(int n) {
        if (n == 0)
            return 0;
        int res = 1;
        System.out.println("nageative value: "+ ~n);
        while ((n & 1) == 0) {
            res++;
            n = n >> 1;
        }
        return res;
    }

}