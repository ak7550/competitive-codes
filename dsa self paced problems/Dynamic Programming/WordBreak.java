import AkPackage.*;
import java.util.*;

public class WordBreak {
    public static void main(String args[]) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new WordBreak());
        while (!lines.isEmpty()) {
            String str = lines.remove(0);
            List<String> wordDict = new ArrayList<>();
            Arrays.stream(lines.remove(0).split(" ")).forEach(wordDict::add);
            System.out.println("For: " + str + "\n" + wordDict);
            System.out.println("Ans: " + wordBreak3(str, wordDict));
        }
    }

    public static boolean wordBreak(String str, List<String> dic) {
        int size = str.length();

        if (size == 0)
            return true;

        boolean wb[] = new boolean[size + 1];

        for (int i = 1; i <= size; i++) {
            if (!wb[i] && dic.contains(str.substring(0, i)))
                wb[i] = true;

            if (wb[i]) {
                if (i == size)
                    return true;

                for (int j = i + 1; j <= size; j++) {
                    if (!wb[j] && dic.contains(str.substring(i, j)))
                        wb[j] = true;

                    if (j == size && wb[j])
                        return true;
                }
            }
        }

        return false;
    }

    public static boolean wordBreak2(String str, List<String> dic) {
        Boolean dp[][] = new Boolean[str.length() + 1][str.length() + 1];
        return wordBreak2(str, dic, 0, str.length(), dp);
    }

    private static boolean wordBreak2(String str, List<String> dic, int start, int end, Boolean dp[][]) {
        if (dp[start][end] != null)
            return dp[start][end];

        if (dic.contains(str.substring(start, end)))
            return dp[start][end] = true;

        for (int i = start + 1; i < end; i++) {
            boolean check1 = wordBreak2(str, dic, start, i, dp),
                    check2 = false;
            if (check1) // if check1 is true, then we will go for the later part
                check2 = wordBreak2(str, dic, i, end, dp);

            if (check1 && check2)
                return dp[start][end] = true;
        }
        return dp[start][end] = false;
    }

    private static boolean wordBreak3(String str, List<String> dic) {
        if (dic.contains(str) || str.isEmpty())
            return true;

        for (int i = 0; i < str.length(); i++) {
            // -> as i am passing a chunk of String in recurrsive call, there is no way to
            // optimise it further using dp solution,
            // -> though I can optimise the search operation by implementing TRIE ds in the
            // given list of words
            if (dic.contains(str.substring(0, i)) && wordBreak3(str.substring(i), dic)) // as we are only moving further
                return true;
            // into the given string, we do
            // not need to memonise anything
        }
        return false;
    }

}