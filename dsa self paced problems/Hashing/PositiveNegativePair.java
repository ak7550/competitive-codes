import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

import AkPackage.InputOutput;

public class PositiveNegativePair {
    public static void main(String[] args) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new PositiveNegativePair());
        while (!lines.isEmpty()) {
            int arr[] = InputOutput.arrayFromString(lines.remove(0));
            System.out.println("For Input: " + Arrays.toString(arr));
            System.out.println("Output is: " + getResult(arr));
        }
    }
    public static ArrayList<Integer> getResult(int arr[]) {
        HashSet<Integer> hs = new HashSet<>();
        ArrayList<Integer> ar = new ArrayList<>();
        for (int i : arr) {
            if (hs.contains(-i)) {
                int k = -i;
                ar.add(Math.min(k, i));
                ar.add(Math.max(k, i));
            }
            hs.add(i);
        }
        if (ar.size() == 0)
            ar.add(0);
        return ar;
    }
}
