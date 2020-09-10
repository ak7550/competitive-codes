import java.util.ArrayList;

import AkPackage.InputOutput;

public class ExcelColumnNumber {
    public static void main(String[] args) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new ExcelColumnNumber());
        while (!lines.isEmpty()) {
            String str = lines.remove(0);
            int ans = getResult(str);
            System.out.println("For Input: " + str);
            System.out.println("OutPut is: " + ans);
        }
    }

    public static int getResult(String str) {
        int mul = 1, sum=0;
        for (int i = str.length() - 1; i >= 0; i--) {
            int val = str.charAt(i) - 'A' + 1;
            sum += (val * mul);
            mul *= 26;
        }
        return sum;
    }
}