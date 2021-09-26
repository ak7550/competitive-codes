import AkPackage.*;
import java.util.*;


public class SinigleArrayFromDoubelArray {
    public static void main(String args[]) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new SinigleArrayFromDoubelArray());
        while (!lines.isEmpty()) {
            int arr[] = InputOutput.arrayFromString(lines.remove(0));
            System.out.println("For: " + Arrays.toString(arr));
            System.out.println("Single Array is: " + Arrays.toString(findOriginalArray(arr)));
        }
    }

    public static int[] findOriginalArray(int changed[]) {
        if ((changed.length & 1) == 1)
            return new int[changed.length / 2];

        HashMap<Integer, Integer> hm = new HashMap<>();
        Arrays.sort(changed);

        for (int x : changed)
            hm.put(x, hm.containsKey(x) ? hm.get(x) + 1 : 1);

        int newArr[] = new int[changed.length], k = 0;

        HashSet<Integer> hs = new HashSet<>();
        for (int x : changed) {
            if (hm.containsKey(x << 1) && hm.get(x) <= hm.get(x << 1)) {
                newArr[k++] = x;
                hm.put(x << 1, hm.get(x << 1) - hm.get(x));
                if (hm.get(x << 1) <= 0)
                    hm.remove(x << 1);
            }

        }



        return k == (changed.length / 2) ? newArr : new int[changed.length / 2];

    }


}