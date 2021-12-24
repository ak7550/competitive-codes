import AkPackage.*;
import java.util.*;

public class Jump3 {
    public static void main(String args[]) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new Jump3());
        while (!lines.isEmpty()) {
            int arr[] = InputOutput.arrayFromString(lines.remove(0)),
                    strt = InputOutput.ArrayListFromString(lines.remove(0)).get(0);
            System.out.println("For i/p: " + Arrays.toString(arr) + "\n start: " + strt);
            System.out.println("Ans is: " + canReach(arr, strt));
        }
    }

    // aproach bfs
    public static boolean canReach(int arr[], int start) {
        Queue<Integer> q = new LinkedList<>(); // will store the indices of the array
        // to avoid infinity loop, we must use visited array
        boolean visited[] = new boolean[arr.length];
        if (arr[start] == 0)
            return true;
        q.add(start);
        while (!q.isEmpty()) {
            int index = q.poll();
            // I have reached to this node before, once again coming to the same means an
            // infinity loop, so I must avoid it
            if (visited[index])
                continue;
            visited[index] = true;
            int front = index + arr[index], back = index - arr[index];
            if (front < arr.length && arr[front] == 0)
                return true;
            if (back >= 0 && arr[back] == 0)
                return true;
            if (front < arr.length)
                q.add(front);
            if (back >= 0)
                q.add(back);
        }

        return false;
    }
}