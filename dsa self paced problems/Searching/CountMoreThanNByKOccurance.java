import java.util.ArrayList;
import java.util.Arrays;

import AkPackage.InputOutput;

public class CountMoreThanNByKOccurance {
    public static void main(String[] args) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new CountMoreThanNByKOccurance());
        while (!lines.isEmpty()) {
            int arr[] = InputOutput.arrayFromString(lines.remove(0));
            int k = Integer.parseInt(lines.remove(0));
            System.out.println("For Input: " + Arrays.toString(arr));
            int ans = getResult(arr, k);
            System.out.println("Output is: " + ans);
        }
    }

    // it's easy while solving by sorting the array, but it uses O(nlogn) time
    // comlexity, it's recommended to use O(n) time complexity without sorting the
    // array.
    public static int getResult(int arr[], int k) {
        int n = arr.length;
        Arrays.sort(arr);
        int count = 0, countNumber = 0;
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] == arr[i + 1]) {
                countNumber++;
            } else {
                countNumber++;
                if (countNumber > n / k) {
                    count++;
                }
                countNumber = 0;
            }
        }
        countNumber++;
        if (countNumber > n / k) {
            count++;
        }
        return count;
    }
    // O(n) solution, use hashmap to count the frequencies of all the elements.
} 