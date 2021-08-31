import AkPackage.*;
import java.util.*;

public class SumOfSquareNumbers {
    public static void main(String args[]) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new SumOfSquareNumbers());
        while (!lines.isEmpty()) {
            int num = InputOutput.ArrayListFromString(lines.remove(0)).get(0);
            System.out.println("For I/P: " + num);
            System.out.println("O/P: " + judgeSquareSum(num));
        }
    }

    public static boolean judgeSquareSum(int val) {
        if (checkSquare(val) || checkSquare(val - 1) || val % 10 == 0)
            return true;

        if (val <= 2 || val == 8)
            return true;

        for (int i = 2; i * i < val; i++) {
            if (checkSquare(val - (i * i))) {
                System.out.println(i + " "+ (val - (i*i)));
                return true;
            }
        }
        return false;
    }

    public static boolean checkSquare(int val) {
        if (val < 0)
            return false;
        int sqrt = (int) Math.sqrt(val);
        return sqrt * sqrt == val;
    }
}