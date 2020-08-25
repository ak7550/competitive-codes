import java.util.ArrayList;
import java.util.Arrays;
import AkPackage.Array;
import AkPackage.InputOutput;

/*
    to use this algorithm, the given array must follow some specific rules.
    --> array size n>= 2
    --> only a single element will be repeated, and it can repeat more than 2 times
    --> 0 must present into the array
    --> all elements from 0 to max(arr)[ maximum element present inside the array ] must be present inside of the array.
    constraints:--
    --> the given array is read-only
    --> time comlexity <= O(n)
    --> aux space not more than O(1)
*/
class RepeatingElement {
    public static void main(String[] args) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new RepeatingElement());
        while (!lines.isEmpty()) {
            int length = Integer.parseInt(lines.remove(0));
            int[] input = Array.arrayFromString(lines.remove(0));
            int repeatingElement = getResult(input);
            System.out.println("For Input: " + Arrays.toString(input));
            System.out.println("Repeating Element: " + repeatingElement);
        }
    }

    // this algorithm is not working
    public static int getResult(int arr[]) {
        int slow = arr[0] + 1, fast = arr[0] + 1;
        do {
            slow = arr[slow] + 1;
            fast = arr[arr[fast] + 1] + 1;
        } while (slow != fast);
        slow = arr[0] + 1;
        while (slow != fast) {
            fast = arr[fast] + 1;
            slow = arr[slow] + 1;
        }
        return slow - 1;
    }
}