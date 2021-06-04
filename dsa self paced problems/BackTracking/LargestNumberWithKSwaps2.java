import AkPackage.*;
import java.util.*;

public class LargestNumberWithKSwaps2 {
    public static void main(String args[]) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new LargestNumberWithKSwaps());
        while (!lines.isEmpty()) {
            int k = Integer.parseInt(lines.remove(0));
            String str = lines.remove(0);
            System.out.println("\nmaximum number is: " + findMaximum(str, k));
        }
    }

    public static String findMaximum(String string, int k) {
        HashMap<Character, ArrayList<Integer>> hm = new HashMap<Character, ArrayList<Integer>>();
        PriorityQueue<Character> pq = new PriorityQueue<Character>(Collections.reverseOrder());
        StringBuilder str = new StringBuilder(string);
        for (int i = 0; i < string.length(); i++) {
            if (!hm.containsKey(string.charAt(i)))
                hm.put(string.charAt(i), new ArrayList<Integer>());
            hm.get(string.charAt(i)).add(i);
            pq.add(string.charAt(i));
        }
        int pos = 0;
        // this is tricky
        char ch = ' ';
        while (k > 0 && !pq.isEmpty()) {
            while (!pq.isEmpty()) {
                if (ch != pq.peek())
                    break;
                pq.poll();
            }
            if (pq.isEmpty())
                break;
            ch = pq.poll();
            ArrayList<Integer> arr = hm.get(ch);
            // taling the numbers first that will get exchanged with the same numbers
            char chararr[] = new char[arr.size()];
            // now to sort so every time i get the least value to put it into the last.
            str.toString().getChars(pos, pos + arr.size(), chararr, 0);
            if (k > arr.size())
                Arrays.sort(chararr);
            // lets exchange
            for (char c : chararr) {
                if (k > 0) {
                    int i1 = hm.get(c).get(0), i2 = arr.get(arr.size() - 1);
                    // if these two indexes are not same, we swap
                    if (i1 == i2 || str.charAt(i1)==str.charAt(i2)) {
                        hm.get(c).remove(0);
                        pos++;
                        continue;
                    }
                    if (i2 > i1) {
                        hm.get(c).remove(0);
                        arr.remove(arr.size() - 1);
                        str = LargestNumberWithKSwaps.swap(str, i1, i2);
                        hm.get(c).add(0, i2);
                        Collections.sort(hm.get(c));
                        k--;
                    }
                    pos++;
                }
            }
        }
        return str.toString();
    }
}

// I resign