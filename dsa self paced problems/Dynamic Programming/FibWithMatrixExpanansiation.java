import AkPackage.*;
import java.util.*;

public class FibWithMatrixExpanansiation {
    public static void main(String args[]) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new FibWithMatrixExpanansiation());
        while (!lines.isEmpty()) {
            long n = Long.parseLong(lines.remove(0));
            // System.out.println(n + "th fibonacci number is:" + (n <= 2 ? n : findNthFibonacci(n)));
            System.out.println(n+": "+ findNthFibonacci(n));
        }
    }

    public static long findNthFibonacci(long n) {
        long matrix[][] = Mathematics.matrixPow(new long[][] { { 1, 1 }, { 1, 0 } }, (int) n);

        System.out.println(Arrays.deepToString(matrix));

        // return ((matrix[0][0] * 1) % Mathematics.mod + (matrix[0][1] * 1) % Mathematics.mod) % Mathematics.mod;

        return matrix[0][0];
    }
}