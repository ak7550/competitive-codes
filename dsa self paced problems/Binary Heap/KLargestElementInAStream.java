import AkPackage.*;
import java.util.*;

public class KLargestElementInAStream {
    public static void main(String args[]) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new KLargestElementInAStream());
        while (!lines.isEmpty()) {
            int arr[] = InputOutput.arrayFromString(lines.remove(0));
            int k = Integer.parseInt(lines.remove(0));
            System.out.println("For the input of: " + Arrays.toString(arr));
            System.out.println("kth largest elements into the streams are: ");
            kthLargest(arr, k);
        }
    }

    public static void kthLargest(int arr[], int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(k);
        for (int i = 0; i < k - 1; i++) {
            pq.add(arr[i]);
            System.out.print(-1 + " ");
        }
        pq.add(arr[k - 1]);
        System.out.print(pq.peek() + " ");
        for (int i = k; i < arr.length; i++) {
            int val = pq.peek();
            if (arr[i] < val) // it won't insert into the pq
                System.out.print(val + " ");
            else {
                pq.poll();
                pq.add(arr[i]);
                System.out.print(pq.peek() + " ");
            }
        }
    }
}