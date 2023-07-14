import AkPackage.*;
import java.util.*;

public class MinimumLengthSubstring {
    public static void main(String args[]) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new MinimumLengthSubstring());
        while (!lines.isEmpty()) {
            String s = lines.remove(0), t = lines.remove(0);
            System.out.println("for ip: " + s + ", " + t);
            System.out.println("op:" + minimumLengthSubString(s, t));
        }
    }

    private static String minimumLengthSubString(String s, String t) {
        HashMap<Character, Integer> hm = new HashMap<>();
        for (char ch : t.toCharArray()) {
            hm.put(ch, hm.getOrDefault(ch, 0) + 1);
        }
        int count = hm.size();
        int start = 0, end = 0, minLength = Integer.MAX_VALUE;
        String ans = "";
        for ( end = 0; end < s.length(); end++) {
            char ch = s.charAt(end);
            if (hm.containsKey(ch)) {
                hm.put(ch, hm.get(ch) - 1);
                if (hm.get(ch) == 0) {
                    count--;
                }
            }

            // valid substring found
            if (count == 0) {
                if (end - start + 1 < minLength) {
                    minLength = end - start + 1;
                    ans = s.substring(start, end + 1);
                }

                while (count >= 0) {
                    ch = s.charAt(start++);
                    if (hm.containsKey(ch)) {
                        hm.put(ch, hm.get(ch) + 1);
                        if (hm.get(ch) == 1) {
                            count++;
                            if (count == 1)
                                break;
                        }
                    }
                    if (end - start + 1 < minLength) {
                        minLength = end - start + 1;
                        ans = s.substring(start, end + 1);
                    }
                }
            }
        }
        return ans;
    }
}