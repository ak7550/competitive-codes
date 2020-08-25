import java.util.Arrays;

public class Q3 {
    public static void main(String[] args) {
        // String str = ""; // just to take inputs
        // int[] arr = Array.arrayFromString(str);
        int arr[] = { 6, 8, 5 };
        System.out
                .println("Sum of all the subsets of" + Arrays.toString(arr) + " array is: " + sumOfSubSets(arr, 0, 0));
    }

    public static int sumOfSubSets(int[] arr, int index, int sum) {
        if (index == arr.length) {
            return sum;
        }
        return sumOfSubSets(arr, index + 1, sum) + sumOfSubSets(arr, index + 1, sum + arr[index]);
    }
}

// Time complexity: O(2^length of the array)