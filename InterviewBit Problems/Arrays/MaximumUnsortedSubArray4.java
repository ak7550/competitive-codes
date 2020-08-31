import java.util.ArrayList;

import AkPackage.InputOutput;

public class MaximumUnsortedSubArray4 {
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
        int max = A.get(0), min = A.get(A.size() - 1), s = -1, e = -1;
        ArrayList<Integer> ans = new ArrayList<Integer>();
        for (int i = 1; i < A.size(); i++) {
            if (max > A.get(i)) {
                s = i - 1;
                break;
            }
            max = A.get(i);
        }
        for (int i = A.size() - 2; i >= 0; i--) {
            if (min < A.get(i)) {
                e = i + 1;
                break;
            }
            min = A.get(i);
        }
        // search if there's any small element and big element present inside of the
        // unsorted array
        for (int i = s; i < e; i++) {
            min = Math.min(min, A.get(i));
            max = Math.max(max, A.get(i));
        }
        // what is the exact place of min in the sorted array of 0 to s-1
        for (int i = 0; i < s; i++) {
            if (A.get(i) > min) {
                s = i;
                break;
            }
        }
        // what is the exact place of max in the sorted array of e+1 to n-1
        for (int i = A.size() - 1; i > e; i--) {
            if (A.get(i) < max) {
                e = i;
                break;
            }
        }
        if (s != -1 && e != -1) {
            ans.add(s);
            ans.add(e);
            return ans;
        } else {
            ans.add(-1);
            return ans;
        }
    }
}
// right logic