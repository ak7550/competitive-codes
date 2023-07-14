import AkPackage.*;
import java.util.*;

public class LeastCapacityToShipPackages {
    public static void main(String args[]) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new LeastCapacityToShipPackages());
        while (!lines.isEmpty()) {
            int arr[] = InputOutput.arrayFromString(lines.remove(0)),
                    d = InputOutput.ArrayListFromString(lines.remove(0)).get(0);

            System.out.println("For ip: " + Arrays.toString(arr) + " d= " + d);
            System.out.println("op: " + leastWeightCapacity(arr, d));
        }
    }

    public static int leastWeightCapacity(int arr[], int d) {
        // -> the idea is to implement binary search
        // -> overall time complexity ==> O(nlog(sum-max(arr)))
        int sum = 0, max = 0;
        for (int x : arr) {
            sum += x;
            max = Math.max(max, x);
        }

        // -> b search from max to sum range
        int start = max, end = sum, ans = -1;
        while (start <= end) {
            int mid = start + ((end - start) >> 1);
            if (isPossible(mid, arr, d)) {
                ans = mid;
                end = mid - 1;
            } else
                start = mid + 1;
        }

        return ans;
    }

    public static boolean isPossible(int mid, int arr[], int d) {
        int count = 1, sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (sum > mid) {
                count++;
                sum = arr[i];
                if (count > d)
                    return false;
            }
        }

        return count <= d;
    }
}