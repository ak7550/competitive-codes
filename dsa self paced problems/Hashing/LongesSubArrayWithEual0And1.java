import java.util.ArrayList;
import java.util.Arrays;

import AkPackage.InputOutput;

/**
 * LongesSubArrayWithEual0And1
 */
public class LongesSubArrayWithEual0And1 {

    public static void main(String[] args) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new LongesSubArrayWithEual0And1());
        while (!lines.isEmpty()) {
            int arr[] = InputOutput.arrayFromString(lines.remove(0));
            System.out.println("For input: " + Arrays.toString(arr));
            int longestSubArrayLength = getResult(arr);
            System.out.println("Longes subaray length is: " + longestSubArrayLength);
        }
    }
    public static int getResult(int arr[]) {
                
    }
}