import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import AkPackage.InputOutput;

public class CountNonRepeatedElements {
    public static void main(String[] args) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new CountNonRepeatedElements());
        while (!lines.isEmpty()) {
            int arr[] = InputOutput.arrayFromString(lines.remove(0));
            long count = getReault(arr);
            System.out.println("For input: " + Arrays.toString(arr) + "\nThere is " + count + "non repeated elements.");
        }
    }
    public static long getReault(int arr[]) {
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        for (int i : arr) 
            hm.put(i, hm.containsKey(i) ? hm.get(i) + 1 : 1);
        long count = 0;
        for (Map.Entry<Integer, Integer> e : hm.entrySet()) {
            if (e.getValue().equals(1))
                count++;
        }
        
        // hm.
        return count;
    }
}
