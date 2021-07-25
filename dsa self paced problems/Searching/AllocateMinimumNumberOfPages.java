import java.util.ArrayList;
import java.util.Arrays;

import AkPackage.Array;
import AkPackage.InputOutput;

public class AllocateMinimumNumberOfPages {
    public static void main(String[] args) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new AllocateMinimumNumberOfPages());
        while (!lines.isEmpty()) {
            ArrayList<Integer> line = InputOutput.ArrayListFromString(lines.remove(0));
            int m = line.remove(0);
            int books[] = Array.intArrayFromArrayList(line);
            System.out.println("For Input: " + Arrays.toString(books));
            int res = getResult(books, m);
            System.out.println("The minimum allocated number of pages: " + res);
        }
    }

    public static int getResult(int arr[], int m) {
        int start = Arrays.stream(arr).max().getAsInt(), end = Arrays.stream(arr).sum(), res = 0;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (isValid(arr, mid, m)) {
                res = mid;
                end = mid - 1; // when we have got a valid number, then search in the left to get more minimum values.
            } else {
                start = mid + 1;
            }
        }
        return res;
    }


    public static boolean isValid(int arr[], int max, int givenNoOfStudents) {
        int studentCount = 1, sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (sum > max) {
                sum = arr[i];
                studentCount++;
                if (studentCount > givenNoOfStudents) {
                    return false;
                }
            }
        }
        return studentCount <= givenNoOfStudents; // we can return true directly, instead of checking anything else here.
    }
}