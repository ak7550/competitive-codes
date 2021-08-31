import AkPackage.*;
import java.util.*;

public class MakePallindrome {
    public static void main(String args[]) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new MakePallindrome());
        while (!lines.isEmpty()) {
            String line = lines.remove(0);
            List<Integer> start = InputOutput.ArrayListFromString(lines.remove(0)),
                    end = InputOutput.ArrayListFromString(lines.remove(0)),
                    sub = InputOutput.ArrayListFromString(lines.remove(0));
            System.out.println("For given: ");
            System.out.println(line);
            System.out.println(start);
            System.out.println(end);
            System.out.println(sub);
            makePallindrome(line, start, end, sub);

        }
    }

    public static void makePallindrome(String s, List<Integer> startIndex, List<Integer> endIndex, List<Integer> subs) {
        for (int i = 0; i < subs.size(); i++) {
            int val = func(s.substring(startIndex.get(i), endIndex.get(i)) + 1, subs.get(i));
            System.out.print(val);
        }
    }

    public static int func(String s, int val) {
        if (s.length() <= val || s.length() == 1)
            return 1;
        int start = 0, end = s.length() - 1, count = 0;
        while (start < end) {
            if (s.charAt(start) != s.charAt(end))
                count++;
            start++;
            end--;
        }
        return count <= val ? 1 : 0;
    }
}