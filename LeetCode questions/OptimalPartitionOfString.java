import AkPackage.*;
import java.util.*;


public class OptimalPartitionOfString {
    public static void main(String args[]) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new OptimalPartitionOfString());
        while (!lines.isEmpty()) {
            String str = lines.remove(0);
            System.out.println("For ip: " + str);
            System.out.println("OP is: " + solve(str));
        }
    }

    private static int solve(String str) {
        HashSet<Character> hs = new HashSet<>();

        int count = 1;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (hs.contains(ch)) {
                count++; // new substring
                hs.clear();
            }

            hs.add(ch);
        }
        return count;
    }

}