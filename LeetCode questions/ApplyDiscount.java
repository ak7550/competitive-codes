import AkPackage.*;
import java.util.*;

public class ApplyDiscount {
    public static void main(String args[]) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new ApplyDiscount());
        while (!lines.isEmpty()) {
            String sen = lines.remove(0);
            int discount = InputOutput.ArrayListFromString(lines.remove(0)).get(0);
            System.out.println("For ip: " + sen + " " + discount);
            System.out.println("op is: " + discountPrices(sen, discount));
        }
    }

    public static String discountPrices(String sen, int discount) {
        int i = 0;
        StringBuilder ans = new StringBuilder();
        while (i < sen.length()) {
            char ch = sen.charAt(i);
            ans.append(ch);
            if (ch == '$') {
                int j = check(i + 1, sen, ans, discount);
                i = j-1;
            }
            i++;
        }

        return ans.toString();
    }

    static int check(int i, String sen, StringBuilder ans, int discount) {
        StringBuilder aa = new StringBuilder();
        while (i < sen.length()) {
            char ch = sen.charAt(i);
            aa.append(ch);
            i++;
            if (ch == ' ')
                break;
        }

        try {
            double dd = Double.parseDouble(aa.toString());
            ans.append(applyDiscount(dd, discount)+" ");
            return i;
        } catch (Exception e) {
            ans.append(aa);
            return i;
        }
    }

    static double applyDiscount(double dd, int discount) {
        return dd * (1 - ((double) discount / 100));
    }
}