import AkPackage.*;
import java.util.*;


public class DevideString {
    public static void main(String args[]) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new DevideString());
        while (!lines.isEmpty()) {
            String str = lines.remove(0);
            int k = InputOutput.ArrayListFromString(lines.remove(0)).get(0);
            char ch = lines.remove(0).charAt(0);
            System.out.println("For ip: " + str + " " + k + " " + ch);
            System.out.println("op is: " + Arrays.toString(devideString(str, k, ch)));
        }
    }

    public static String[] devideString(String s, int k, char fill) {
        int rem = s.length() % k, div = s.length() / k;

        String ans[] = new String[rem == 0 ? div : div + 1];

        for (int i = 0, j = 0; i < s.length(); i += k, j++) {
            if (i + k < s.length())
                ans[j] = s.substring(i, i + k);
            else {
                ans[j] = s.substring(i);
                int len = ans[j].length();
                // System.out.print("asa");
                for (int ki = len; ki < k; ki++)
                    ans[j] += fill;
            }
        }
        return ans;
    }
}