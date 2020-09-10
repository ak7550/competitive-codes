import java.util.ArrayList;
import java.util.Arrays;

import AkPackage.InputOutput;

/**
 * FindAllDuplicatesInAnArray
 */
public class FindAllDuplicatesInAnArray {

    public static void main(String[] args) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new FindAllDuplicatesInAnArray());
        while (!lines.isEmpty()) {
            int line[] = InputOutput.arrayFromString(lines.remove(0));
            System.out.println("For Input: " + Arrays.toString(line));
            ArrayList<Integer> ans = getResult(line);
            System.out.println("Ans is: " + ans);
        }
    }

    public static ArrayList<Integer> getResult(int arr[]) {
        ArrayList<Integer> ans = new ArrayList<Integer>();
        for (int i = 0; i < arr.length; i++) {
            arr[i]--;
        }
        for (int i = 0; i < arr.length; i++) {
            int val = arr[i];
            if (arr[val % arr.length] >= arr.length) {
                ans.add((val % arr.length) + 1);
            }
            arr[val % arr.length] += arr.length;
        }
        return ans;
    }
}