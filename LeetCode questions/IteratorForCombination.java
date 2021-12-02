import AkPackage.*;
import java.util.*;


public class IteratorForCombination {
    public static void main(String args[]) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new IteratorForCombination());
        while (!lines.isEmpty()) {
            String input[] = lines.remove(0).split(" ");
            ArrayList<String> ans = new ArrayList<>();
            combinations(input[0], Integer.parseInt(input[1]), 0, new StringBuilder(), ans);
            System.out.println(ans);
        }
    }

    public static void combinations(String string, int k, int start, StringBuilder str, ArrayList<String> ans) {
        if (k == 0) {
            ans.add(str.toString());
            return;
        }

        for (int i = start; i+k <= string.length(); i++) {
            str.append(string.charAt(i));
            combinations(string, k - 1, i + 1, str, ans);
            str.deleteCharAt(str.length() - 1);
        }
    }
}