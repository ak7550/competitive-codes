import AkPackage.*;
import java.util.*;


public class CountNByKElements {
    public static void main(String args[]) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new CountNByKElements());
        while (!lines.isEmpty()) {
            int arr[] = InputOutput.arrayFromString(lines.remove(0));
            int k = InputOutput.ArrayListFromString(lines.remove(0)).get(0);
            System.out.println("For the input: " + Arrays.toString(arr));
            System.out.println("K= " + k);
            System.out.println("Number occurs more than n/k is: " + countOccurance(arr, k));
        }
    }

    public static int countOccurance(int arr[], int k) {
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        for (int x : arr)
            hm.put(x, hm.containsKey(x) ? hm.get(x) + 1 : 1);
        int count = 0;
        for (Map.Entry<Integer, Integer> map : hm.entrySet()) // don't wanna increment count value by 1, for the same number if it holds >n/k frequency, for that reason an extra loop introduced
            if (map.getValue() > arr.length / k)
                count++;
        return count;
    }
}