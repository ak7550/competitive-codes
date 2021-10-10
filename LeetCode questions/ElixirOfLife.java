import AkPackage.*;
import java.util.*;

public class ElixirOfLife {
    public static void main(String args[]) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new ElixirOfLife());
        while (!lines.isEmpty()) {
            String line = lines.remove(0);
            System.out.println("For: " + line);
            System.out.println("Max Frequency: " + countMaxFrequency(line));
        }
    }

    public static int countMaxFrequency(String pat) {
        int start = 1, end = pat.length() - 1, max = 1;
        while (start <= end) {
            if (pat.substring(0, start).equals(pat.substring(end)))
                max = Math.max(max, 2 + countFrequency(start, end, pat.substring(start, end), pat.substring(end)));
            start++;
            end--;
        }

        return max;
    }

    public static int countFrequency(int start, int end, String txt, String pat) {
        int count = 0;
        for (int i = 0; i + pat.length() <= txt.length(); i++) {
            if (txt.substring(i, i + pat.length()).equals(pat)) {
                count++;
                i += pat.length();
                i -= 1;
            }
        }
        return count;
    }
}