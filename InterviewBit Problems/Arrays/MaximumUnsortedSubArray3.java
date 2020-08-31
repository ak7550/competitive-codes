import java.util.ArrayList;
import java.util.Arrays;

import AkPackage.InputOutput;

public class MaximumUnsortedSubArray3 {
    public static void main(String[] args) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new MaximumUnsortedSubArrayInterviewBit());
        while (!lines.isEmpty()) {
            ArrayList<Integer> line = InputOutput.ArrayListFromString(lines.remove(0));
            ArrayList<Integer> ans = getResult(line);
            System.out.println("For Input: " + line);
            System.out.println("Output is: " + ans);
        }
    }

    private static ArrayList<Integer> getResult(ArrayList<Integer> A) {
        ArrayList<Integer> maxArr = new ArrayList<Integer>(), minArr = new ArrayList<Integer>(),
                ans = new ArrayList<Integer>();
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for (int i = A.size() - 1, j = 0; i >= 0; i--, j++) {
            min = Math.min(min, A.get(i));
            minArr.add(0, min);
            max = Math.max(max, A.get(j));
            maxArr.add(max);
        }
        // System.out.println(maxArr);
        // System.out.println(minArr);
        for (int i = 0; i < A.size(); i++) {
            if (A.get(i).equals(minArr.get(i))) {
                continue;
            } else {
                ans.add(i);
                break;
            }
        }
        for (int i = A.size() - 1; i >= 0; i--) {
            if (A.get(i).equals(maxArr.get(i))) {
                continue;
            } else {
                ans.add(i);
                break;
            }
        }
        if (ans.isEmpty()) {
            ans.add(-1);
            return ans;
        } else {
            return ans;
        }
    }
}