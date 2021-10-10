import AkPackage.*;
import java.util.*;


public class IsSubSequence {
    public static void main(String args[]) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new IsSubSequence());
        while (!lines.isEmpty()) {
            String[] str = lines.remove(0).split(" ");
            System.out.println("For Input: " + str[0] + " " + str[1]);
            System.out.println("Ans is: " + isSubSequence(str[0], str[1]));
        }
    }

    public static boolean isSubSequence(String sub, String txt) {
        if (sub.length() > txt.length())
            return false;

        int prev[] = null, curr[] = new int[sub.length() + 1];

        Arrays.fill(curr, 0);

        prev = curr;
        curr = new int[sub.length() + 1];

        for (int i = 1; i <= txt.length(); i++) {
            curr[0] = 0;
            for (int j = 1; j <= sub.length(); j++)
                curr[j] = sub.charAt(j - 1) == txt.charAt(i - 1) ?
                            prev[j - 1] + 1 : Math.max(prev[j], curr[j - 1]);

            prev = curr;
            curr = new int[sub.length() + 1];
        }
        System.out.println(Arrays.toString(prev));
        return prev[sub.length()] == sub.length();
    }
}