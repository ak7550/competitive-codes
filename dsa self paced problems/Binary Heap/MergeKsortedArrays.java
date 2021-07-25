import AkPackage.*;
import java.util.*;

public class MergeKsortedArrays {
    public static void main(String args[]) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new MergeKsortedArrays());
        while (!lines.isEmpty()) {
            int k = Integer.parseInt(lines.remove(0));
            int arrays[][] = new int[k][];
            for (int i = 0; i < arrays.length; i++)
                arrays[i] = InputOutput.arrayFromString(lines.remove(0));
            System.out.println("For the given sorted arrays: ");
            Arrays.stream(arrays).forEach(arr -> System.out.println(Arrays.toString(arr)));
            System.out.println("The merged array is: " + mergeKArrays(arrays, k));
        }
    }

    static class ArrInfo {
        int value, arrayPos, elePos;

        ArrInfo(int v, int a, int e) {
            value = v;
            arrayPos = a;
            elePos = e;
        }
    }

    public static ArrayList<Integer> mergeKArrays(int arrays[][], int k) {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        PriorityQueue<ArrInfo> pq = new PriorityQueue<ArrInfo>(k, (a, b) -> a.value-b.value );
        for (int i = 0; i < arrays.length; i++)
            pq.add(new ArrInfo(arrays[i][0], i, 0)); // -> inserting the 1st elements of every array, considering those are lowest among all the other array elements.
        while (!pq.isEmpty()) {
            ArrInfo a = pq.poll();
            arr.add(a.value);
            if (a.elePos + 1 < arrays[a.arrayPos].length)
                pq.add(new ArrInfo(arrays[a.arrayPos][a.elePos + 1], a.arrayPos, a.elePos + 1));
        }
        return arr;
    }
}