import AkPackage.*;
import java.util.*;

public class RearrangeCharacters {
    public static void main(String args[]) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new RearrangeCharacters());
        while (!lines.isEmpty()) {
            String line = lines.remove(0);
            System.out.println("\n\nFor the given input of " + line);
            System.out
                    .println(line + " can " + (rearrangeCharacters(line) ? "" : "not ") + "be rearranged such a way!!");
        }
    }

    public static boolean rearrangeCharacters(String str) {
        HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
        for (int i = 0; i < str.length(); i++)
            hm.put(str.charAt(i), hm.containsKey(str.charAt(i)) ? hm.get(str.charAt(i)) + 1 : 1);
        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>(
                (a, b) -> b.getValue() - a.getValue() == 0 ? b.getKey() - a.getKey() : b.getValue() - a.getValue());
        pq.addAll(hm.entrySet());
        System.out.println(pq);
        Map.Entry<Character, Integer> last = null, previousLast = null;
        StringBuilder res = new StringBuilder();
        // only one element present in pq
        if (pq.size() == 1)
            return false;

        while (!pq.isEmpty()) {
            last = pq.poll();
            // if this two are having same key values, then not possible.
            if (last != null && previousLast != null && last.getKey().equals(previousLast.getKey()))
                return false;
            else {
                res.append(last.getKey());
                last.setValue(last.getValue() - 1);
                if (previousLast != null && !previousLast.getValue().equals(0))
                    pq.add(previousLast);
                previousLast = last;
            }
        }
        System.out.println("\n##res is: " + res);
        // check if the last is having 0 frequency left though the pq is emptied out.
        return last.getValue().equals(0);

    }
}