import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import AkPackage.InputOutput;

public class SortingElementsOfAnArrayByFrequency {
    public static void main(String[] args) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new SortingElementsOfAnArrayByFrequency());
        while (!lines.isEmpty()) {
            int arr[] = InputOutput.arrayFromString(lines.remove(0));
            System.out.println("For Input: " + Arrays.toString(arr));
            System.out.println("Sorted array is: " + getResult2(arr));
        }
    }

    public static ArrayList<Integer> getResult2(int arr[]) {
        HashMap<Integer, Integer> mp = new HashMap<Integer, Integer>();
        ArrayList<Integer> ar = new ArrayList<Integer>();
        for (int i : arr) {
            mp.put(i, mp.containsKey(i) ? mp.get(i) + 1 : 1);
            ar.add(i);
        }
        Collections.sort(ar, (b, a) -> {
            if (!mp.get(a).equals(mp.get(b)))
                return mp.get(a).compareTo(mp.get(b));
            else
                return a.compareTo(b);
        });
        // Collections.reverse(ar);
        return ar;
    }

    public static ArrayList<Integer> getResult(int arr[]) {
        HashMap<Integer, Integer> mp = new HashMap<Integer, Integer>();
        ArrayList<Integer> ar = new ArrayList<Integer>();
        for (int i : arr)
            mp.put(i, mp.containsKey(i) ? mp.get(i) + 1 : 1);
            
        HashMap<Integer, ArrayList<Integer>> hm = new HashMap<Integer, ArrayList<Integer>>();
        for (Map.Entry<Integer, Integer> en : mp.entrySet()) {
            int value = en.getValue();
            ArrayList<Integer> rand = hm.get(value);
            if (rand == null)
                rand = new ArrayList<Integer>();
            rand.add(en.getKey());
            hm.put(value, rand);
        }
        int index = 0;
        for (Map.Entry<Integer, ArrayList<Integer>> en : hm.entrySet()) {
            for (Integer integer : en.getValue()) {
                for (int i = 0; i < en.getKey(); i++) {
                    ar.add(index, integer);
                    // index++;
                }
                index += en.getKey();
            }
            index = 0;
        }
        System.out.println("All the values are: " + mp);
        System.out.println("new hashmap: " + hm);
        return ar;
    }
}
