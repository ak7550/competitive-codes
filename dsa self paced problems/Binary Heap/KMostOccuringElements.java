import AkPackage.*;
import java.util.*;

public class KMostOccuringElements {
    public static void main(String args[]) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new KMostOccuringElements());
        while (!lines.isEmpty()) {
            int arr[] = InputOutput.arrayFromString(lines.remove(0));
            int k = Integer.parseInt(lines.remove(0));
            System.out.println("For the given input: " + Arrays.toString(arr));
            System.out.println("Sum of frequencies of k most occuring elements are: " + kMostFrequent(arr, k));
        }
    }

    public static int kMostFrequent(int arr[], int k) {
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        Arrays.stream(arr).forEach(x -> hm.put(x, hm.containsKey(x) ? hm.get(x) + 1 : 1));
        int sum = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(k, Collections.reverseOrder());
        Arrays.stream(arr).forEach(x -> {
            if (hm.containsKey(x)) {
                pq.add(hm.get(x));
                hm.remove(x);
            }
        });
        for (int i = 0; i < k; i++) 
            sum += pq.poll();
        return sum;
    }

}