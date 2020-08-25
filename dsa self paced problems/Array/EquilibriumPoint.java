import java.util.ArrayList;
import java.util.Arrays;

import AkPackage.InputOutput;

public class EquilibriumPoint {
    public static void main(String[] args) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new EquilibriumPoint());
        int T = Integer.parseInt(lines.get(0));
        lines.remove(0);
        while (T-- > 0) {
            int length = Integer.parseInt(lines.get(0));
            lines.remove(0);
            int arr[] = InputOutput.arrayFromString(lines.get(0));
            lines.remove(0);
            System.out.println("For Input " + Arrays.toString(arr) + ": " + getResult(arr));
        }
    }

    public static int getResult(int arr[]) {
        int sum = 0, leftSum = 0, rightSum = 0;
        for (int i : arr) {
            sum += i;
        }
        if (arr.length == 1) {
            return 1;
        }
        leftSum = arr[0];
        for (int i = 1; i < arr.length; i++) {
            rightSum = sum - leftSum - arr[i];
            if (leftSum == rightSum) {
                return i + 1;
            }
            leftSum += arr[i];
        }
        return -1;
    }
}