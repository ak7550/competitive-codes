import AkPackage.*;
import java.util.*;

public class JobSequencingProblem {

    static class Job {
        public int id, deadline, profit;

        public Job(int s, int e, int p) {
            id = s;
            deadline = e;
            profit = p;
        }
    }

    public static void main(String args[]) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new JobSequencingProblem());
        while (!lines.isEmpty()) {
            int id[] = InputOutput.arrayFromString(lines.remove(0)),
                    end[] = InputOutput.arrayFromString(lines.remove(0)),
                    profit[] = InputOutput.arrayFromString(lines.remove(0));
            Job arr[] = new Job[id.length];
            for (int i = 0; i < arr.length; i++)
                arr[i] = new Job(id[i], end[i], profit[i]);
            System.out.println("Maximum number of job is: " + jobScheduling(arr));
        }
    }

    public static int jobScheduling(Job arr[]) {
        Arrays.sort(arr, (a, b) -> b.profit - a.profit);
        System.out.println("For the given sorted array: ");
        Arrays.stream(arr).forEach(x -> System.out.println(x.id + " " + x.deadline + " " + x.profit));
        // this is the trick, that I was unable to figure out
        boolean scheduled[] = new boolean[arr.length + 1];
        int maxProfit =0, time = 0;
        for (int i = 0; i < arr.length; i++) {
            int endDate = arr[i].deadline > arr.length ? arr.length : arr[i].deadline;
            while (scheduled[endDate] && endDate>0)
                endDate--;
            if(endDate>0){
                scheduled[endDate] = true;
                maxProfit += arr[i].profit;
                time++;
            }
        }
        System.out.println("Number of jobs done: " + time);
        return maxProfit;
    }
}