import java.util.ArrayList;
import java.util.Arrays;

import AkPackage.InputOutput;

public class FrequienciesOfALimitedRangeArray {
    public static void main(String[] args) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new FrequienciesOfALimitedRangeArray());
        int T = Integer.parseInt(lines.get(0));
        lines.remove(0);
        while (T-- > 0) {
            int length = Integer.parseInt(lines.get(0));
            lines.remove(0);
            int arr[] = InputOutput.arrayFromString(lines.get(0));
            lines.remove(0);
            System.out.print("For Input " + Arrays.toString(arr) + ": ");
            getResult(arr);
            System.out.println();
        }
    }

    // auxiliary space complexity: O(1)==> biggest challenge
    private static void getResult(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            arr[i]--;
        }
        int cons=100;
        for (int i = 0; i < arr.length; i++) {
            arr[arr[i] % cons] += cons;
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] /= cons;
        }
        System.out.println(Arrays.toString(arr));
        
    }
}