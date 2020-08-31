import java.util.ArrayList;

import AkPackage.InputOutput;

public class MaximumUnsortedSubArrayInterviewBit {
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
        int left1 = A.get(start), left2 = A.get(start + 1), right1 = A.get(end - 1), right2 = A.get(end);
        while (left1 <= left2 && right2 >= right1 && start < end) {
            start++;
            end--;
            left1 = A.get(start);
            left2 = A.get(start + 1);
            right1 = A.get(end - 1);
            right2 = A.get(end);
        }
        // now any one of them has faced the unsorted nature
        if (start > end) {
            ans.add(-1);
            return ans;
        }
        else if (left1 > left2 && right2 < right1) {
            ans.add(start);
            ans.add(end);
            return ans;
        }
        else if (right2 < right1) {
            for (int i = 0; i < end; i++) {
                if (A.get(i) > right2) {
                    ans.add(i);
                    ans.add(end);
                    return ans;
                }
            }
        } else {
            for (int i = A.size() - 1; i > start; i--) {
                if (A.get(i) < left1) {
                    ans.add(start);
                    ans.add(i);
                    return ans;
                }
            }
        }
        ans.add(-1);
        return ans;
    }
}