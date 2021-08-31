import AkPackage.*;
import java.util.*;

public class FillMissingBrackets {
    public static void main(String args[]) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new FillMissingBrackets());
        while (!lines.isEmpty()) {
            String s = lines.remove(0);
            System.out.println(count(s));
        }
    }

    public static int count(String s) {
        if ((s.length() & 1) == 1)
            return 1;
        int count = 0;
        for (int i = 2; i < s.length(); i += 2) {
            count += checkBalanced(s.substring(0, i))+ checkBalanced(s.substring(i));
        }
        return count;
    }

    public static int checkBalanced(String str) {
        HashMap<Character, Integer> hm = new HashMap<Character, Integer>();

        for (char ch : str.toCharArray()) {

            if (ch == '(' || ch == '[' || ch == '?')
                hm.put(ch, hm.containsKey(ch) ? hm.get(ch) + 1 : 1);

            if (ch == ')' || ch == ']') {
                ch = (ch == ')') ? '(' : '[';
                hm.put(ch, hm.containsKey(ch) ? hm.get(ch) - 1 : -1);
                if (hm.get(ch).equals(0))
                    hm.remove(ch);
            }
        }
    }
}