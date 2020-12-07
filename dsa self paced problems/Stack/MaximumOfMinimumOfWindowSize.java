import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

import AkPackage.InputOutput;

public class MaximumOfMinimumOfWindowSize {
    public static void main(String[] args) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new MaximumOfMinimumOfWindowSize());
        while (!lines.isEmpty()) {
            int arr[] = InputOutput.arrayFromString(lines.remove(0));
            System.out.println("For input: " + Arrays.toString(arr));
            System.out.println("Output: " + Arrays.toString(getResult(arr)));
        }
    }

    public static int[] getResult(int arr[]) {
        int[] ans = new int[arr.length];
        int[] left = new int[arr.length];
        int[] right = new int[arr.length];
        Stack<Integer> lt = new Stack<Integer>();
        Stack<Integer> rt = new Stack<Integer>();
        for (int i = 0, j = arr.length - 1; i < arr.length; i++, j--) {
            while (!lt.empty() && arr[lt.peek()] >= arr[i])
                lt.pop();
            left[i] = lt.empty() ? -1 : lt.peek();
            lt.push(i);
            while (!rt.empty() && arr[rt.peek()] >= arr[j])
                rt.pop();
            right[j] = rt.empty() ? arr.length : rt.peek();
            rt.push(j);
        }
        for (int i = 0; i < arr.length; i++) {
            int index = right[i] - left[i] - 2;
            ans[index] = Math.max(ans[index], arr[i]);
        }
        for (int i = arr.length - 2; i >= 1; i--)
            ans[i] = Math.max(ans[i], ans[i + 1]);
        System.out.println(Arrays.toString(right));
        return ans;
    }
}
