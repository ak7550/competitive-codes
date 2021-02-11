import AkPackage.*;
import java.util.*;


public class KLargestElemets {

    public static void main(String args[]){
        ArrayList<String> lines= InputOutput.takeCompleteInput(new KLargestElemets());
        while (!lines.isEmpty()) {
            int arr[]=InputOutput.arrayFromString(lines.remove(0));
            int k=Integer.parseInt(lines.remove(0));
            System.out.println("For the input of: "+ Arrays.toString(arr));
            System.out.println(k + " largest elements are: ");
            System.out.println(kLargest(arr,k));
        }
    }
    
    public static ArrayList<Integer> kLargest(int arr[], int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(k);
        for (int i = 0; i < k; i++) pq.add(arr[i]);
        for (int i = k; i < arr.length; i++) {
            int val = pq.peek();
            if (val < arr[i]) {
                pq.poll();
                pq.add(arr[i]);
            }
        }
        ArrayList<Integer> ar = new ArrayList<Integer>();
        while (!pq.isEmpty()) {
            ar.add(0,pq.poll());
        }
        return ar;
    }
}