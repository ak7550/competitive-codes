import java.util.ArrayList;
import AkPackage.InputOutput;

/**
 * LuckyNumber
 */
public class LuckyNumber {

    public static void main(String[] args) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new LuckyNumber());
        lines.remove(0);//removing the testcase number
        for (String string : lines) {
            System.out.println("Input " + string + ": " + getResult(Integer.parseInt(string)));
        }
    }

    public static boolean getResult(int n) {
        return jos(n, 2);
    }

    public static boolean jos(int n, int k) {
        if (n % k == 0) {
            return false;
        }
        if (n < k)
            return true;
        n -= n / k;
        // n += (k == 2) ? 0 : 1;
        return jos(n, k + 1);
    }
}