import java.util.ArrayList;
import java.util.Arrays;

import AkPackage.InputOutput;

public class SubArrayWithGivenSum {
    public static void main(String[] args) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new SubArrayWithGivenSum());
        while (!lines.isEmpty()) {
            int[] input = InputOutput.arrayFromString(lines.remove(0));
            System.out.println("For input: " + Arrays.toString(input));
            int sum = InputOutput.arrayFromString(lines.remove(0))[0];
            ArrayList<Integer> ans = getResult(sum, input);
            System.out.println("Ans is: " + ans + " <====sums to==> " + sum);
        }
    }

    public static ArrayList<Integer> getResult(int s, int arr[]) {
        int sI = 0, eI = -1, sum = 0;
        ArrayList<Integer> ans = new ArrayList<Integer>();
        do {
            if (sum==0 && eI!=-1) {
                if (eI<arr.length-1) {
                    sum += arr[--sI];
                    sum += arr[++eI];
                } else {
                    break;
                }
            }
            if (sum == s) {
                ans.add(sI + 1);
                ans.add(eI + 1);
                return ans;
            }
            if (sum < s) {
                if (eI==arr.length-1) {
                    break;
                }
                sum += arr[++eI];
            }
            if (sum > s) {
                sum -= arr[sI++];
            }
        } while (eI < arr.length); // the loop should iterate till end
        if (sum == s) {
            ans.add(sI + 1);
            ans.add(eI + 1);
            return ans;
        }
        ans.add(-1);
        return ans;
    }
}