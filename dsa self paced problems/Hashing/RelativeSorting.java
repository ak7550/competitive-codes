import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Set;
import java.util.Map.Entry;

import AkPackage.InputOutput;

public class RelativeSorting {
    public static void main(String[] args) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new RelativeSorting());
        while (!lines.isEmpty()) {
            int a1[] = InputOutput.arrayFromString(lines.remove(0)),
                    a2[] = InputOutput.arrayFromString(lines.remove(0));
            System.out.println("For Input: \n" + Arrays.toString(a1) + "\n" + Arrays.toString(a2));
            System.out.println("Output is: " + getResult(a1, a2));
        }
    }

    public static ArrayList<Integer> getResult(int a1[], int a2[]) {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        HashMap<Integer, Integer> mp = new HashMap<Integer, Integer>();
        for (int i : a1)
            mp.put(i, mp.containsKey(i) ? mp.get(i) + 1 : 1);
        for (int i : a2) {
            if (mp.containsKey(i)) {
                for (int j = 0; j < mp.get(i); j++)
                    arr.add(i);
                mp.remove(i);
            }
        }
        ArrayList<Integer> ar = new ArrayList<Integer>();
        for (Entry<Integer, Integer> e : mp.entrySet())
            for (int i = 0; i < e.getValue(); i++)
                ar.add(e.getKey());
        Collections.sort(ar);
        arr.addAll(ar);
        // arr.forEach(e-> System.out.print(e+" "));
        return arr;
    }
}
