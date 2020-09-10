import java.util.ArrayList;

import AkPackage.InputOutput;

public class ExcelColumnTitle {
    public static void main(String[] args) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new ExcelColumnTitle());
        while (!lines.isEmpty()) {
            int number = InputOutput.arrayFromString(lines.remove(0))[0];
            String ans = getResult(number);
            System.out.println("For input: " + number);
            System.out.println("Ans is: " + ans);
        }
    }

    public static String getResult(int n) {
        StringBuilder str = new StringBuilder();
        String s = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        do {
            int rem = (n-1) % 26;
            // n = (rem == 0) ? n + 1 : n;
            // rem = (rem == 0) ? 26 : rem;
            Character ch = s.charAt(rem);
            str.insert(0, ch);
            n = (ch.equals('Z')) ? n - 1 : n;
            n /= 26;
        } while (n > 0);
        // char ch = s.charAt(n - 1);
        // str.insert(0, ch);
        return str.toString();
    }
}