import AkPackage.*;
import java.util.*;

public class FindSubStringWithGivenHashValue {
    public static void main(String args[]) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new FindSubStringWithGivenHashValue());
        while (!lines.isEmpty()) {
            String str = lines.remove(0);
            ArrayList<Integer> arr = InputOutput.ArrayListFromString(lines.remove(0));
            System.out.println("for ip: " + str + " " + arr);
            System.out.println("Ans: " + subStrHash(str, arr.get(0), arr.get(1), arr.get(2), arr.get(3)));
        }
    }

    public static String subStrHash(String str, int power, int modulo, int k, int hash) {
        long val = 0;
        for (int i = 0; i < k; i++) {
            val += (Math.pow(power, i) * val(str.charAt(i)));
            // val %= modulo;
        }
        if ((val % modulo) == hash)
            return str.substring(0, k);

        for (int i = 1; i + k < str.length(); i++) {
            // System.out.println(str.substring(i, i+k));
            val -= val(str.charAt(i - 1)); // delete the previous character
            val /= power;
            val += (Math.pow(power, k - 1) * val(str.charAt(k - 1)));
            // val %= modulo;
            if ((val % modulo) == hash)
                return str.substring(i, i + k);
        }

        return "";
    }

    public static int val(char ch) {
        return ch - 'a' + 1;
    }
}