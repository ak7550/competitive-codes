import java.math.BigInteger;
import java.util.ArrayList;

import AkPackage.InputOutput;

/**
 * FindNthFibonacci
 */
public class FindNthFibonacci {

    public static void main(String[] args) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new FindNthFibonacci());
        while (!lines.isEmpty()) {
            int input = InputOutput.ArrayListFromString(lines.remove(0)).get(0);
            int fibonaci = fibonaci(input);
            System.out.println("For Input: " + input);
            System.out.println("Output is: " + fibonaci);
        }
    }

    public static int fibonaci(int A) {
        int cons = 1000000007;
        int f[][] = new int[][] { { 1, 1 }, { 1, 0 } };
        int ans[][] = matrixPow(f, A);
        return ans[0][1];
    }

    public static int[][] matrixPow(int f[][], int n) {
        if (n == 1) {
            return f;
        } else if (n % 2 == 0) {
            return matrixMultiply(matrixPow(f, n / 2), matrixPow(f, n / 2));
        } else {
            return matrixMultiply(matrixPow(f, n - 1), f);
        }
    }

    public static int[][] matrixMultiply(int a[][], int b[][]) {
        BigInteger cons = new BigInteger(Integer.toString(1000000007));
        BigInteger a00 = new BigInteger(Integer.toString(a[0][0]));
        BigInteger a01 = new BigInteger(Integer.toString(a[0][1]));
        BigInteger a10 = new BigInteger(Integer.toString(a[1][0]));
        BigInteger a11 = new BigInteger(Integer.toString(a[1][1]));
        BigInteger b00 = new BigInteger(Integer.toString(b[0][0]));
        BigInteger b01 = new BigInteger(Integer.toString(b[0][1]));
        BigInteger b10 = new BigInteger(Integer.toString(b[1][0]));
        BigInteger b11 = new BigInteger(Integer.toString(b[1][1]));
        BigInteger ab00 = a00.multiply(b00).mod(cons).add(a01.multiply(b10).mod(cons)).mod(cons);
        BigInteger ab01 = a00.multiply(b01).mod(cons).add(a01.multiply(b11).mod(cons)).mod(cons);
        BigInteger ab10 = a10.multiply(b00).mod(cons).add(a11.multiply(b10).mod(cons)).mod(cons);
        BigInteger ab11 = a10.multiply(b01).mod(cons).add(a11.multiply(b11).mod(cons)).mod(cons);
       return new int[][] { { ab00.intValue() , ab01.intValue() }, { ab10.intValue(), ab11.intValue() } };
    }
}