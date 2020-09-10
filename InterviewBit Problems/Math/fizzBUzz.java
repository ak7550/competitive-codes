import java.util.ArrayList;
import java.util.List;

import AkPackage.InputOutput;

public class fizzBUzz {
    public static void main(String[] args) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new fizzBUzz());
        while (!lines.isEmpty()) {
            int value = InputOutput.ArrayListFromString(lines.remove(0)).get(0);
            List<String> ans = getResult(value);
            System.out.println("For input: " + value);
            System.out.println("Output is: " + ans);
        }
    }

    public static List<String> getResult(int n) {
        List<String> ans = new ArrayList<String>();
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                ans.add("FizzBuzz");
            } else if (i % 3 == 0) {
                ans.add("Fizz");
            } else if (i % 5 == 0) {
                ans.add("Buzz");
            } else {
                ans.add(Integer.toString(i));
            }
        }
        return ans;
    }
}