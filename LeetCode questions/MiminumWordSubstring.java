import AkPackage.*;
import java.util.*;


public class MiminumWordSubstring {
    public static void main(String args[]) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new MiminumWordSubstring());
        while (!lines.isEmpty()) {
            String s = lines.remove(0), t = lines.remove(0);
            System.out.println("for ip: " + s + "  " + t);
            System.out.println("ans: " + minimumWordSubstring(s, t));
        }
    }

    private static String minimumWordSubstring(String s, String t) {
        if (s.length() < t.length())
            return "";
        boolean found = false;
        Map<Character, Integer> hm = new HashMap<>();
        int count = 0;

        for (char ch : t.toCharArray()) {
            if (!hm.containsKey(ch)){
                count++;
            }
            hm.put(ch, hm.getOrDefault(ch, 0) + 1);
        }

        int min = Integer.MAX_VALUE, start = 0, end = 0, ms = 0, me = 0;

        for (end = 0; end < s.length(); end++) {
            // int index = s.charAt(end)-'A';
            if (!hm.containsKey(s.charAt(end))) {
                continue;
            }
            hm.put(s.charAt(end), hm.get(s.charAt(end)) - 1);
            // tt[index]--;
            if (hm.get(s.charAt(end)) == 0) {
                count--;
            }

            while (count == 0) { // covered all of situation
                found = true;
                if (end - start + 1 < min) {
                    ms = start;
                    me = end;
                    min = end - start + 1;
                }
                while (!hm.containsKey(s.charAt(start))) {
                    start++;
                }
                if (end - start + 1 < min) {
                    ms = start;
                    me = end;
                    min = end - start + 1;
                }
                hm.put(s.charAt(start), hm.get(s.charAt(start)) + 1);
                // tt[s.charAt(start) - 'A']++;
                // if(tt[s.charAt(start) - 'A'] == 1){
                if (hm.get(s.charAt(start)) == 1) {
                    count++;
                }
                start++;
            }
        }
        return found ? s.substring(ms, me + 1) : "";
    }
}