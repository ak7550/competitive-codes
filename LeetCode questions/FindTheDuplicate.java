import java.util.ArrayList;
import java.util.Arrays;

import AkPackage.InputOutput;

public class FindTheDuplicate {
    public static void main(String[] args) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new FindTheDuplicate());
        while (!lines.isEmpty()) {
            int line[] = InputOutput.arrayFromString(lines.remove(0));
            System.out.println("For Input: " + Arrays.toString(line));
            int dup = getResult(line);
            System.out.println("Output is: " + dup);
        }
    }

    public static int getResult(int arr[]) {
        int slow = arr[0], fast = arr[0];
        do {
            slow = arr[slow];
            fast = arr[arr[fast]];
        } while (slow != fast);
        slow = arr[0];
        while (slow != fast) {
            slow = arr[slow];
            fast = arr[fast];
        }
        return slow;
    }
}