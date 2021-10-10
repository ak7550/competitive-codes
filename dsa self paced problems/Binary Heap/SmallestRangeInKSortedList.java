import AkPackage.*;
import java.util.*;
//=> HARD PROBLEM
public class SmallestRangeInKSortedList {
    public static void main(String args[]) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new SmallestRangeInKSortedList());
        while (!lines.isEmpty()) {
            int array[][] = Graph.takeAdjacencyMatrixInput(lines);
            System.out.println("For Input: " + Arrays.deepToString(array));
            System.out.println("Ans: " + Arrays.toString(findSmallestRange(array)));
        }
    }

    static class Position {
        int val, arrIndex, vIndex;

        public Position(int v, int ain, int vi) {
            val = v;
            arrIndex = ain;
            vIndex = vi;
        }
    }

    public static int[] findSmallestRange(int array[][]) {
        PriorityQueue<Position> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        int min = Integer.MAX_VALUE;
        int maxR = Integer.MIN_VALUE, start = -1, end = -1;
        for (int i = 0; i < array.length; i++) {
            pq.add(new Position(array[i][0], i, 0));
            maxR = Math.max(maxR, array[i][0]);
        }

        while (pq.size() == array.length) {
            Position pos = pq.poll();
            int val = pos.val;
            if (Math.abs(maxR - val) < min) {
                min = Math.abs(maxR - val);
                start = val;
                end = maxR;
            }
            int arrIndex = pos.arrIndex, vIndex = pos.vIndex;

            if (vIndex != array[arrIndex].length - 1) {
                pq.add(new Position(array[arrIndex][vIndex + 1], arrIndex, vIndex + 1));
                maxR = Math.max(maxR, array[arrIndex][vIndex + 1]); // update the maxR
            }
        }

        return new int[] { start, end };
    }


}