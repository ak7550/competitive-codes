import AkPackage.*;

import java.security.Key;
import java.util.*;

class KeyValue {
    int position, count;

    public KeyValue(int p, int c) {
        position = p;
        count = c;
    }
}

public class MinimumCostToMoveChips {
    public static void main(String args[]) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new MinimumCostToMoveChips());
        while (!lines.isEmpty()) {
            int position[] = InputOutput.arrayFromString(lines.remove(0));
            System.out.println("For ip: " + Arrays.toString(position));
            System.out.println("Ans: " + minimumCostToMoveChips(position));
        }
    }

    private static int minimumCostToMoveChips(int position[]) {
        int count = 0;
        int pcount[] = new int[(int)1e9 - 1];

        for (int i = 0; i < pcount.length; i++)
            pcount[position[i]-1]++;

        PriorityQueue<KeyValue> pq = new PriorityQueue<>((a, b) -> b.count - a.count);
        for (int i = 0; i < pcount.length; i++)
            if(pcount[i] != 0)
                pq.add(new KeyValue(i, pcount[i]));

        int high = pq.poll().position;
        while (!pq.isEmpty()) {
            KeyValue kv = pq.poll();
            int diff = Math.abs(high - kv.position);
            if ((diff & 1) == 1)
                count += kv.count;
        }

        return count;
    }
}