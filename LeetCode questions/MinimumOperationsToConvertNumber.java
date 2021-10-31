import AkPackage.*;
import java.util.*;

public class MinimumOperationsToConvertNumber {
    public static void main(String args[]) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new MinimumOperationsToConvertNumber());
        while (!lines.isEmpty()) {
            int nums[] = InputOutput.arrayFromString(lines.remove(0)),
                    arr[] = InputOutput.arrayFromString(lines.remove(0));
            int start = arr[0], goal = arr[1];
            System.out.println("Fro the gievn: " + Arrays.toString(nums));
            System.out.println("minimum operations required are: " + countminimum(nums, start, goal));
        }
    }

    public static int countminimum(int nums[], int start, int goal) {
        Queue<Integer> q = new LinkedList<>();
        HashSet<Integer> visited = new HashSet<>();
        int count = 0;
        q.add(start);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int poll = q.poll();
                if (poll == goal)
                    return count;
                if (poll < 0 || poll > 1000 || visited.contains(poll))
                    continue;
                visited.add(poll);
                for (Integer x : nums) {
                    int add = x + poll, subs = poll - x, xor = poll ^ x;
                    q.add(add);
                    q.add(subs);
                    q.add(xor);
                }
            }
            count++;
        }

        return -1;
    }

}