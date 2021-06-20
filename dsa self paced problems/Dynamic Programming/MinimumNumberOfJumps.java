import AkPackage.*;
import java.util.*;

//* TOUGH QUESTION

public class MinimumNumberOfJumps {
    public static void main(String args[]) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new MinimumNumberOfJumps());
        while (!lines.isEmpty()) {
            int arr[] = InputOutput.arrayFromString(lines.remove(0));
            System.out.println("\n\nFor the given array: " + Arrays.toString(arr));
            System.out.println("Minimum number of jumps required to reach " + arr.length + " is: "
                    + minimumJumps(arr, arr.length));
        }
    }

    // O(n^2) approach
    public static int minimumJumps2(int arr[], int sum) {
        int minJump[] = new int[sum], jumpFrom[] = new int[sum];

        // -> minJump tells you the minimum jump it takes to reach ith index
        // -> jumpFrom tells you the last index from where the person will jump to ith
        // index.

        Arrays.fill(minJump, Integer.MAX_VALUE);
        minJump[0] = 0; // it takes 0 jumps to reach 0th index, as we are stading on it initially.
        jumpFrom[0] = -1;
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (j + arr[j] >= i && minJump[i] + 1 < minJump[j]) {
                    minJump[i] = minJump[j] + 1;
                    // jumpFrom[i] = j;
                }
            }
        }
        // System.out.println("Jump Path: "+ Arrays.toString(jumpFrom));
        return minJump[sum - 1] == Integer.MAX_VALUE || minJump[sum - 1] == Integer.MIN_VALUE ? -1 : minJump[sum - 1];
    }

    // O(n^2) approach
    public static int minimumJumps3(int arr[], int n) {
        if (n <= 1) // this is the end
            return 0;
        int jumpFrom[] = new int[n], jumpCount[] = new int[n];
        Arrays.fill(jumpFrom, Integer.MAX_VALUE);
        Arrays.fill(jumpCount, Integer.MAX_VALUE);
        jumpFrom[0] = -1;
        jumpCount[0] = 0;
        for (int i = 0; i < arr.length; i++) {
            // if arr[i] = 0, then we can't reach to anywhere from this node
            if (arr[i] != 0) {
                for (int j = 1; j <= arr[i] && i + j < arr.length; j++) {
                    // if it takes less jumps to reach i+j node from ith node then update the
                    // jumpFrom, jump count value
                    if (jumpCount[i + j] > jumpCount[i] + 1) {
                        jumpCount[i + j] = jumpCount[i] + 1;
                        jumpFrom[i + j] = i;
                    }
                }
            }
        }
        return jumpCount[n - 1] == Integer.MAX_VALUE || jumpCount[n - 1] < 0 ? -1 : jumpCount[n - 1];
    }

    //O(n) approach
    public static int minimumJumps(int arr[], int n) {
        if (n <= 1) // this is the end
            return 0;
        if (arr[0] == 0)
            return -1;
        int jumps = 0, maxReach = arr[0], currReach = 0;
        boolean possibleReach = false;

        for (int i = currReach; i <= maxReach && i < arr.length - 1; i++) {
            maxReach = Math.max(maxReach, i + arr[i]);
            if (maxReach >= arr.length - 1)
                possibleReach = true;
            if (i == currReach)// when I have reached to the limit, that means update
            {
                currReach = maxReach;
                jumps++;
            }
        }
        return possibleReach ? jumps : -1;
    }
}

