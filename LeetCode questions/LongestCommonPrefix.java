import AkPackage.*;
import java.util.*;

class Trie {
    int wordCount = 0;
    boolean isWord = false;
    Trie children[] = new Trie[26];
    char ch;

    public int insert(String str) {
        Trie curr = this;
        int max = 0;
        for (char ch : str.toCharArray()) {
            if (curr.children[ch - 'a'] == null)
                curr.children[ch - 'a'] = new Trie();

            curr = curr.children[ch - 'a'];
            curr.ch = ch;
            curr.wordCount++; // increasing the word count
            max = Math.max(max, curr.wordCount);
        }

        // at the end of the string, make isWord true
        curr.isWord = true;

        return max;
    }

    public String getString(int max) {
        StringBuilder str = new StringBuilder();
        boolean found = false;
        for (Trie tr : this.children)
            if (tr != null)
                if (tr.makeString(str, max, 0)) {
                    found = true;
                    break;
                }

        return found ? str.toString() : "-1";
    }

    private boolean makeString(StringBuilder str, int max, int prev) {
        if (this.wordCount < prev)
            return false; // we have entered into the wrong route

        if (this.wordCount == max) // reached to the destination
        {
            str.append(this.ch);
            for(Trie tr: this.children)
                if(tr!=null && tr.wordCount == max)
                    tr.makeString(str, max, max);

            return true;
        }

        // everything looks fine now
        for (Trie tt : this.children)
            if (tt != null)
                if (tt.makeString(str, max, this.wordCount))
                    return true;

        return false;
    }

}

public class LongestCommonPrefix {
    public static void main(String args[]) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new LongestCommonPrefix());
        while (!lines.isEmpty()) {
            String str[] = lines.remove(0).split(" ");
            System.out.println("For ip: " + Arrays.toString(str));
            System.out.println("op: " + longestCommonPrefix(str));
        }
    }

    public static String longestCommonPrefix(String str[]) {
        Trie root = new Trie();
        int max = 0;
        for (String s : str)
            max = Math.max(max, root.insert(s));

        // so I knw the length of longest common prefix
        return max == str.length ? root.getString(max) : "-1";
    }
}
