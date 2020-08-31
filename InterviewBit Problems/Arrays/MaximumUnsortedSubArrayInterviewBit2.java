import java.util.ArrayList;

import AkPackage.InputOutput;

public class MaximumUnsortedSubArrayInterviewBit2 {
    public static void main(String[] args) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new MaximumUnsortedSubArrayInterviewBit());
        while (!lines.isEmpty()) {
            ArrayList<Integer> input = InputOutput.ArrayListFromString(lines.remove(0));
            ArrayList<Integer> ans = getResult(input);
            System.out.println("for input: " + input);
            System.out.println("output is: " + ans);
        }
    }

    public static ArrayList<Integer> getResult(ArrayList<Integer> A) {
        // thinking of two pointer approach, both the pointers will be updated
        // consequitively
        int start = 0, end = A.size() - 1;
        ArrayList<Integer> ans = new ArrayList<Integer>();
        if (A.size() == 2 && A.get(0) <= A.get(1) || A.size() == 0 || A.size() == 1) {
            ans.add(-1);
            return ans;
        }
        if (A.size() == 2 && A.get(0) > A.get(1)) {
            ans.add(0);
            ans.add(1);
            return ans;
        }
        
        return ans;
    }
}