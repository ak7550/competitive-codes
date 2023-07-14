import AkPackage.*;
import java.util.*;

public class LongestPallindromeByConcatingStrings {
    public static void main(String args[]) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new LongestPallindromeByConcatingStrings());
        while (!lines.isEmpty()) {
            String str[] = lines.remove(0).split(" ");
            System.out.println("For ip: " + Arrays.toString(str));
            System.out.println("op is: " + longestPalindrome(str));
        }
    }

    public static int longestPalindrome(String words[]) {
        HashMap<String, Integer> hm = new HashMap<>();
        for (String word : words)
            hm.put(word, hm.getOrDefault(word, 0) + 1);

        int left = 0, max = 0, mid = 0;
        for (String word : words) {
            String reverse = new StringBuilder(word).reverse().toString();

            // check if it is the same
            if (word.equals(reverse) && hm.containsKey(word)) {
                int count = hm.get(word);
                if ((count & 1) == 0) // for even
                    mid += (word.length() * count);
                else {
                    mid += (word.length() * (count - 1)); // only consider the even
                    max = Math.max(max, word.length()); // add the length of the remaining, for the max word length
                }

                hm.remove(word);
            }

            // check if the reverse are present individually
            else if (hm.containsKey(reverse)) {
                int count = Math.min(hm.get(word), hm.get(reverse));
                left += ((word.length() * count) << 1);
                hm.remove(word);
                hm.remove(reverse);
            }
        }

        return left + max + mid;
    }
}