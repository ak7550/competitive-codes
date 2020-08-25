import java.util.ArrayList;
import java.util.Arrays;

import AkPackage.InputOutput;

public class MaximumAdjacentPair {
    public static void main(String[] args) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new MaximumAdjacentPair());
        int T = Integer.parseInt(lines.get(0));
        lines.remove(0);
        while (T-- > 0) {
            int length = Integer.parseInt(lines.get(0));
            lines.remove(0);
            int arr[] = InputOutput.arrayFromString(lines.get(0));
            lines.remove(0);
            System.out.println("For input: " + Arrays.toString(arr));
            getResult(arr);
            System.out.println();
        }
    }
    private static void getResult(int arr[]) {
        for (int i = 0; i < arr.length-1; i++) {
            System.out.print(Math.max(arr[i], arr[i+1])+" ");
        }
    }
}