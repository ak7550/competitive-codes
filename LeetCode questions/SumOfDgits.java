import AkPackage.*;
import java.util.*;


public class SumOfDgits {
    public static void main(String args[]) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new SumOfDgits());
        while (!lines.isEmpty()) {
            String str[] = lines.remove(0).split(" ");
            String s = str[0];
            int k = Integer.parseInt(str[1]);
            System.out.println("For given: " + s + " and " + k);
            System.out.println("Sum is: " + getLucky(s, k));
        }
    }

    public static int getLucky(String s, int k) {
        int sum = 0, index = 0;
        for (int i = 0; i < s.length(); i++) {
            int val = s.charAt(i) - 'a' + 1;
            while (val > 0) {
                sum += (val % 10);
                val = val >> 1;
            }
            k--;
        }
        int sum2 = sum;
        while (k > 0) {
            sum = 0;
            while (sum2 > 0) {
                sum += sum2 % 10;
                sum2 = sum2 >> 1;
            }
            k--;
            sum2 = sum;
        }

        return sum;
    }
}