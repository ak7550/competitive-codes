import AkPackage.*;
import java.util.*;

public class JobSequencingProblemv2 {

    static class Job {
        public int id, deadline, profit;

        public Job(int s, int e, int p) {
            id = s;
            deadline = e;
            profit = p;
        }
    }

    public static void main(String args[]) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new JobSequencingProblemv2());
        while (!lines.isEmpty()) {
            ArrayList<Integer> a = InputOutput.ArrayListFromString(lines.remove(0));
            Job arr[] = new Job[a.size() / 3];
            int i=0;
            while (!a.isEmpty())
                arr[i++] = new Job(a.remove(0), a.remove(0), a.remove(0));
            System.out.println("Maximum number of job is: " + jobScheduling(arr));
        }
    }

    public static int jobScheduling(Job arr[]) {
        Arrays.sort(arr,
                (a, b) -> b.profit-a.profit);
        System.out.println("For the given sorted array: ");
        Arrays.stream(arr).forEach(x -> System.out.println(x.id + " " + x.deadline + " " + x.profit));
        // this is the trick, that I was unable to figure out
        boolean scheduled[] = new boolean[arr.length + 1];
        int maxProfit = 0, time = 0;
        for (int i = 0; i < arr.length; i++) {
            int endDate = arr[i].deadline > arr.length ? arr.length : arr[i].deadline;
            while (scheduled[endDate] && endDate > 0)
                endDate--;
            if (endDate > 0) {
                scheduled[endDate] = true;
                maxProfit += arr[i].profit;
                time++;
            }
        }
        System.out.println("Number of jobs done: " + time);
        return maxProfit;
    }
}