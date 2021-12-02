import AkPackage.*;
import java.util.*;

public class RulingPower {
    public static void main(String args[]) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new RulingPower());
        while (!lines.isEmpty()) {
            int arr[] = InputOutput.arrayFromString(lines.remove(0));
            System.out.println("For the given: " + Arrays.toString(arr));
            System.out.println("Ruling Power is: " + rulingPower(arr));
        }
    }

    public static int rulingPower(int arr[]) {
        HashMap<Integer, ArrayDeque<Integer>> hm = new HashMap<Integer, ArrayDeque<Integer>>();
        int maxSum = -1;
        for (int x : arr) {
            int ds = countDigitSum(x);
            if (!hm.containsKey(ds))
                hm.put(ds, new ArrayDeque<>());

            ArrayDeque<Integer> pq = hm.get(ds);

            if (pq.size() < 2)
                pq.add(x); // -> small number will be at the top
            else {
                //_ trying to implemet 0-1 bfs ==> O(1) operation
                if (x > pq.peekFirst() && x>pq.peekLast()) {
                    pq.pollFirst();
                    pq.addLast(x);
                } else if (x > pq.peekFirst() && x < pq.peekLast()) {
                    pq.pollFirst();
                    pq.addFirst(x);
                } //-> intension is to make the arraydeque sorted, while it's size is 2
            }
            if (pq.size() > 1)
                maxSum = Math.max(maxSum, pq.stream().reduce((num, sum) -> num + sum).get());
        }

        return maxSum;
    }

    public static int countDigitSum(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}