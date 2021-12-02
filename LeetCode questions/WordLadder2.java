import AkPackage.*;
import java.util.*;

//=> WORD LADDER IS A VERY IMPORTANT QUESTION FROM THE CONCEPT OF BFS..
public class WordLadder2 {
    public static void main(String args[]) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new WordLadder2());
        while (!lines.isEmpty()) {
            String fLine[] = lines.remove(0).split(" ");
            String wordList[] = lines.remove(0).split(" ");

            System.out.println("For i/p: " + fLine[0] + " " + fLine[1]);
            System.out.println("Wordlist: " + Arrays.toString(wordList));
            System.out.println("Possibilities are: " + findSequences2(fLine[0], fLine[1], wordList));
        }
    }

    // ! the problem with this code is, it gives tle ==> we have to optimise
    // it......
    // _ trying to impolement linkhashmap <String, ArrayList<String>> ==> string
    // gives the possible way to reach string from start
    static class StringInfo {
        int index; // changed index basically
        LinkedList<String> st;
        LinkedHashSet<String> hs; // only the remaining wordList

        public StringInfo(String s, int i, LinkedHashSet<String> hs) {
            index = i;
            st = new LinkedList<>();
            st.add(s);
            this.hs = hs;
        }

        public StringInfo(int i, LinkedList<String> ll, LinkedHashSet<String> hs) {
            index = i;
            st = ll;
            this.hs = hs;
        }

    }

    public static ArrayList<ArrayList<String>> findSequences2(String start, String target, String wordList[]) {
        Queue<StringInfo> q = new LinkedList<>();
        LinkedHashSet<String> hs = new LinkedHashSet<>();
        Arrays.stream(wordList).forEach(hs::add);
        hs.remove(start); // if it's there, then remove
        q.add(new StringInfo(start, -1, new LinkedHashSet<>(hs)));
        ArrayList<ArrayList<String>> ans = new ArrayList<>();
        LinkedHashMap<String, List<List<String>>> hm = new LinkedHashMap<>();
        if (!hs.contains(target)) // if target is not present, does not make any sense though
            return ans;
        while (!q.isEmpty()) {
            StringInfo sI = q.poll();
            StringBuilder str = new StringBuilder(sI.st.getLast());
            for (int i = 0; i < str.length(); i++) {
                char changedChar = str.charAt(i);
                if (i == sI.index) // -> dont do operations into the same index
                    continue;
                if (str.charAt(i) != target.charAt(i)) {
                    for (int j = 0; j < 26; j++) {
                        char ch = (char) ('a' + j);
                        str.replace(i, i + 1, ch + "");
                        if (sI.hs.contains(str.toString())) {
                            sI.st.add(str.toString()); // pushing at last
                            if (str.toString().equals(target)) {
                                // -> I need a linkedlist into the StringInfo class, so I can store the data
                                ans.add(new ArrayList<>(sI.st));
                            } else {
                                sI.hs.remove(str.toString());
                                q.add(new StringInfo(i, new LinkedList<>(sI.st), new LinkedHashSet<>(sI.hs)));
                            }
                            sI.st.removeLast(); // removing from the last of the stack
                        }
                    }
                    str.replace(i, i + 1, changedChar + "");
                }
            }
        }
        return ans;

    }
}
