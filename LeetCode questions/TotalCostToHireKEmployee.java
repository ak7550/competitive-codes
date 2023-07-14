import AkPackage.*;
import java.util.*;


public class TotalCostToHireKEmployee {
    public static void main(String args[]){
        ArrayList<String> lines= InputOutput.takeCompleteInput(new TotalCostToHireKEmployee());
        while (!lines.isEmpty()) {
            int costs[] = InputOutput.arrayFromString(lines.remove(0));
            int rest[] = InputOutput.arrayFromString(lines.remove(0));
            System.out.println("Total cost to hire "+ rest[0] + " candidates: "+ totalCost(costs, rest[0], rest[1]));
        }
    }

    private static long totalCost(int[] costs, int k, int candidates) {
        PriorityQueue<Integer> left = new PriorityQueue<>((a, b) -> costs[a] == costs[b] ? a - b : costs[a] - costs[b]),
        right = new PriorityQueue<>((a,b) -> costs[a] == costs[b] ? a - b : costs[a] - costs[b]);
        // hashmap to keep a note about what are the indices inside of the pq
        if (k >= costs.length) {
            // we need to hire all the employees
            return Arrays.stream(costs).sum();
        }
        long totalCost = 0;
        int l=-1, r = costs.length;
        for (int i = 0, c = 0; c < candidates; i++, c++) {
            left.add(i);
            l++;
        }
        for (int i = costs.length - 1, c = 0; c < candidates; i--, c++) {
            r--;
            right.add(i);
        }

        int hired = 0;
        while (hired++ < k) {
            int leftMinIndex = left.peek(), rightMinIndex = right.peek();
            int val =  Math.min(costs[leftMinIndex], costs[rightMinIndex]);
            totalCost += val;
            boolean evictL = false;
            // eviction
            if (costs[leftMinIndex] == val) {
                left.poll();
                evictL = true;
            } else {
                right.poll();
            }

            if(l+1<r)// i need to put something in any of the pq
            {
                if (evictL) {
                    l++;
                    left.add(l);
                    evictL = false;
                } else {
                    r--;
                    right.add(r);
                }
            }
        }
        return totalCost;
    }
}