import AkPackage.*;
import java.util.*;

public class SumOfTwoIntegers {
    public static void main(String args[]) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new SumOfTwoIntegers());
        while (!lines.isEmpty()) {
            int[] input = InputOutput.arrayFromString(lines.remove(0));
            System.out.println("for ip: " + Arrays.toString(input));
            System.out.println("op: " + findSum(input[0], input[1]));
        }
    }

    private static int findSum(int a, int b) {
        int sum = a, carry = b;
        while (carry != 0) {
            int temp = sum ^ carry;
            carry = (sum & carry) << 1;
            sum = temp;
        }
        return sum;
    }
}