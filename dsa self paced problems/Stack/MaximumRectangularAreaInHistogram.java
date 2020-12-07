import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

import AkPackage.InputOutput;

public class MaximumRectangularAreaInHistogram {
    public static void main(String[] args) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new MaximumRectangularAreaInHistogram());
        while (!lines.isEmpty()) {
            int hist[] = InputOutput.arrayFromString(lines.remove(0));
            System.out.println("input: " + Arrays.toString(hist));
            System.out.println("output: " + getResult(hist));
        }
    }

    // very very tricky solution
    public static int getResult(int hist[]) {
        Stack<Integer> st = new Stack<Integer>();
        int res = 0;
        for (int i = 0; i < hist.length; i++) {
            // in search of previous smaller element
            while (!st.empty() && hist[st.peek()] >= hist[i]) {
                int top = st.pop();
                // after removing an item, we'll find the area of the bar, considering it as the
                // smallest element.
                res = Math.max(res, hist[top] * (st.empty() ? i : i - st.peek() - 1)); // crucial formula
                // i-st.peek()-1 will give you the range of all the bar havig equal or higher
                // height than hist[top]
            }
            st.push(i);
        }
        while (!st.empty()) {
            int top = st.pop();
            res = Math.max(res, hist[top] * (st.empty() ? hist.length : hist.length - st.peek() - 1));
        }
        return res;
    }

    public static int getResult2(int hist[]) {
        Stack<Integer> left = new Stack<Integer>();
        Stack<Integer> right = new Stack<Integer>();
        int curr = 0, res = 0;
        for (int i = 0, j = hist.length - 1; i < hist.length; i++, j--) {
            while (!left.empty() && hist[left.peek()] >= hist[i]) {
                int top = left.pop();
            }
            while (!right.empty() && hist[right.peek()] >= hist[j]) {
                right.pop();
            }
            res = Math.max(res, hist[i] + hist[i]);
        }
        return 0;
    }
}
