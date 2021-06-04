import AkPackage.*;
import java.util.*;

public class LargestNumberWithGivenSum {
    public static void main(String args[]) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new LargestNumberWithGivenSum());
        while (!lines.isEmpty()) {
            int input[] = InputOutput.arrayFromString(lines.remove(0)), digit = input[0], sum = input[1];
            System.out.println("Password is: " + largestNumber(digit, sum));
        }
    }

    public static String largestNumber(int n, int sum) {
        StringBuilder str = new StringBuilder();
        while (sum > 9 && --n > 0) {
            sum -= 9;
            str.append("9");
        }
        if (n == 0 && sum != 0)
            return "-1";

        str.append(sum);
        while (--n > 0)
            str.append(0);
        return str.toString();
    }
}