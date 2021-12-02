import AkPackage.*;
import java.util.*;
//* good question on dp and greedy ==> beautiful implementation of b-search
public class TwoBestNonOverLappingEvents {
    public static void main(String args[]) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new TwoBestNonOverLappingEvents());
        while (!lines.isEmpty()) {
            int events[][] = Graph.takeAdjacencyMatrixInput(lines);
            System.out.println("For given: " + Arrays.deepToString(events));
            System.out.println("Max Result is: " + maxTwoEvents(events, 2));
        }
    }

    public static int maxTwoEvents(int events[][], int k) {
        Arrays.sort(events, (e1, e2) -> e1[0] == e2[0] ? e1[1] - e2[1] : e1[0] - e2[0]);
        Integer dp[][] = new Integer[events.length][k];
        return calc2(events, 0, k, 0, dp);
    }

    // -> recusive solution
    public static int calc(int events[][], int index, int k, int count, int lastEvent[]) {
        if (index == events.length || count == k)
            return 0; // base case
        int max = Integer.MIN_VALUE;
        if (lastEvent == null || lastEvent[1] < events[index][0]) // events[index] is allowed to consider
            max = Math.max(max, calc(events, index + 1, k, count + 1, events[index]) + events[index][2]);

        max = Math.max(max, calc(events, index + 1, k, count, lastEvent)); // not considering this event

        return max;
    }

    //-> trying to reduce the number of states to apply dp
    public static int calc2(int events[][], int index, int k, int count, Integer dp[][]) {
        //_ as it is a sorted array, we can apply b-search to find our next index
        if (index == events.length || count == k)
            return 0;
        if(dp[index][count]!= null)
            return dp[index][count];
        int max = Integer.MIN_VALUE;
        int nextIndex = upperbound(events, index, events[index][1]); //_ b-search to reduce the forget the last considered event. ==> only consider  that one, that is possible
        //-> considering this value
        max = Math.max(max, calc2(events, nextIndex, k, count + 1, dp) + events[index][2]);

        //-> not considering
        max = Math.max(max, calc2(events, index + 1, k, count, dp));
        return max;
    }
    //_ now we have two states only, (1)index, (2) count ==> it's easy to implement memonization

    public static int upperbound(int events[][], int start, int base) {
        int end = events.length-1;
        int ans = end+1;
        while (start <= end) {
            int mid = start + ((end - start) >> 1);
            if (events[mid][0] > base) {
                ans = mid;
                end = mid - 1;
            } else
                start = mid + 1;
        }
        return ans;
    }
}