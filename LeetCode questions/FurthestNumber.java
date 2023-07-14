import AkPackage.*;
import java.util.*;

public class FurthestNumber {
    public static void main(String args[]) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new FurthestNumber());
        while (!lines.isEmpty()) {
            int arr[] = InputOutput.arrayFromString(lines.remove(0));
            System.out.println("for ip: " + Arrays.toString(arr));
            System.out.println("op: " + Arrays.toString(findFurthest(arr.length, arr)));
        }
    }

    private static int[] findFurthest(int n, int arr[]) {
        int ans[] = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = findFurthest(arr, i + 1, n - 1, arr[i]);
        }
        return ans;
    }

    static int findFurthest(int arr[], int start, int end, int val) {
        int ans = -1;
        while (start < end) {
            int mid = start + ((end - start) >> 1);
            if (arr[mid] < val) {
                // check if I can go any further
                ans = mid;
                start = mid + 1;
            } else {
                int aa = findFurthest(arr, mid + 1, end, val);
                if (aa != -1) {
                    return ans = aa;
                } else
                    end = mid - 1; // now i am pretty much sure that, there is no smaller element in the right
            }
        }

        return ans;
    }
}