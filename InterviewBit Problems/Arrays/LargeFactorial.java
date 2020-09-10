import java.util.ArrayList;

import AkPackage.InputOutput;

public class LargeFactorial {
    public static void main(String[] args) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new LargeFactorial());
        while (!lines.isEmpty()) {
            Integer A = Integer.parseInt(lines.remove(0));
            System.out.println("For input " + A);
            System.out.println("Output is: " + getResult(A));
        }
    }

    public static String getResult(Integer A) {
        StringBuilder str = new StringBuilder();
        str.append(1);
        for (int i = 1; i <= A; i++) {
            int carry = 0;
            for (int j = str.length() - 1; j >= 0; j--) {
                int val = Integer.parseInt(str.substring(j, j + 1));
                int ans = val * i + carry;
                carry = ans / 10;
                str.replace(j, j + 1, Integer.toString(ans % 10));
            }
            if (carry != 0) {
                str.insert(0, carry);
            }
        }
        return str.toString();
    }
}
// time complexity: O(n^2)