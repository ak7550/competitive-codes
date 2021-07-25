import AkPackage.*;

import java.util.*;

public class RepeatedtString {
    public static void main(String args[]) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new RepeatedtString());
        while (!lines.isEmpty()) {
            String s = lines.remove(0);
            int n = InputOutput.ArrayListFromString(lines.remove(0)).remove(0);
            System.out.println("For given: " + s + " and n: " + n);
            System.out.println("Occurance of a is: " + repeatedString(s, n));
        }
    }

    public static int repeatedString(String s, int n) {
        int aIns = 0, res = 0;
        for (int i = 0; i < s.length(); i++)
            aIns += s.charAt(i) == 'a' ? 1 : 0;
        res += aIns * (n / s.length());
        int remain = n % s.length();
        for (int i = 0; i< remain; i++) 
            res += s.charAt(i) == 'a' ? 1 : 0;

        return res;
    }
}