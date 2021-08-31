import AkPackage.*;
import java.util.*;

public class SherLockAndValidString {
    public static void main(String args[]) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new SherLockAndValidString());
        while (!lines.isEmpty()) {
            String str = lines.remove(0);
            System.out.println("For Input: " + str);
            System.out.println("O/p: " + isValid(str));
        }
    }

    public static boolean isValid(String s) {
        HashMap<Character, Integer> hm = new HashMap<>();

        for (char ch : s.toCharArray())
            hm.put(ch, hm.containsKey(ch) ? hm.get(ch) + 1 : 1);

        int distinct = (int) hm.values().stream().distinct().count();
        boolean valid =  distinct == 1;
        System.out.println(hm);

        if (!valid ) {

            int max = Collections.max(hm.values()), min = Collections.min(hm.values());
            valid = Math.abs(max - min) == 1
                    &&
                    (hm.values().stream().filter(x -> x == min).count() == 1
             ||
                    hm.values().stream().filter(x -> x == max).count() == 1);
        }

        return valid;

    }
}