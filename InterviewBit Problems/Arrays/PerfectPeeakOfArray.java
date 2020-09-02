import java.util.ArrayList;

import AkPackage.InputOutput;

public class PerfectPeeakOfArray {
    public static void main(String[] args) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new PerfectPeeakOfArray());
        while (!lines.isEmpty()) {
            ArrayList<Integer> line = InputOutput.ArrayListFromString(lines.remove(0));
            System.out.println("For Input " + line);
            System.out.println(perfectPeak(line));
        }
    }

    public static int perfectPeak(ArrayList<Integer> A) {
        ArrayList<Integer> minArr = new ArrayList<Integer>(), maxArr = new ArrayList<Integer>();
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int i = A.size() - 1; i >= 0; i--) {
            min = Math.min(min, A.get(i));
            minArr.add(0, min);
        }
        for (Integer integer : A) {
            max = Math.max(max, integer);
            maxArr.add(max);
        }
        // System.out.println("minArr is:" + minArr);
        // System.out.println("maxArr is: " + maxArr);
        return check(minArr, maxArr, A, 0, A.size());
    }

    public static int check(ArrayList<Integer> minArr, ArrayList<Integer> maxArr, ArrayList<Integer> A, int start,
            int end) {
        for (int i = 1; i < A.size()-1; i++) {
            if (A.get(i).equals(minArr.get(i)) && A.get(i).equals(maxArr.get(i))) {
                return 1;
            }
        }
        return 0;
    }
}