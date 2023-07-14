import AkPackage.*;
import java.util.*;

class Job {
    int start, end, profit;

    public Job(int start, int end, int profit) {
        this.start = start;
        this.end = end;
        this.profit = profit;
    }

}

public class JobScheduling {
    public static void main(String args[]) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new JobScheduling());
        while (!lines.isEmpty()) {
            int start[] = InputOutput.arrayFromString(lines.remove(0));
            int end[] = InputOutput.arrayFromString(lines.remove(0));
            int profit[] = InputOutput.arrayFromString(lines.remove(0));
            System.out.println("start:" + Arrays.toString(start) + "end: " + Arrays.toString(end) + " profit: "
                    + Arrays.toString(profit));
            System.out.println("ans is: " + schedule(start, end, profit));
        }
    }

    private static int schedule(int[] start, int[] end, int[] profit) {
        Job jobs[] = new Job[start.length];
        int dp[] = new int[start.length];
        for (int i = 0; i < start.length; i++) {
            jobs[i] = new Job(start[i], end[i], profit[i]);
        }
        Arrays.sort(jobs, (a, b) -> a.end - b.end);
        dp[0] = jobs[0].profit;

        for (int i = 1; i < dp.length; i++) {
            int profitC = jobs[i].profit;
            int l = search(jobs, i);
            if (l != -1) {
                profitC += dp[l];
            }
            dp[i] = Math.max(dp[i - 1], profitC);
        }

        return dp[jobs.length - 1];
    }

    private static int search(Job[] jobs, int index) {
        int start = 0, end = index-1;
        while (start <= end) {
            int mid = start + ((end - start) >> 1);
            if (jobs[mid].end <= jobs[index].start) {
                if (jobs[mid + 1].end <= jobs[index].start) {
                    start = mid + 1;
                } else {
                    return mid;
                }
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }
}