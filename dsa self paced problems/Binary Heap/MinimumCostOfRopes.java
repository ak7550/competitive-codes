import AkPackage.*;
import java.util.*;

public class MinimumCostOfRopes {
    public static void main(String args[]) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new MinimumCostOfRopes());
        while (!lines.isEmpty()) {
            int arr[] = InputOutput.arrayFromString(lines.remove(0));
            System.out.println("For the given input: " + Arrays.toString(arr) + "\nminimum cost is: " + minCost(arr));
        }
    }

    public static int minCost(int arr[]) {
        int sum = 0;
        if (arr.length == 1)
            return 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Arrays.stream(arr).forEach(pq::add);
        while (!pq.isEmpty()) {
            int val = pq.poll() + pq.poll();
            sum += val;
            if (pq.isEmpty())
                break;
            pq.add(val);
        }
        return sum;
    }
}