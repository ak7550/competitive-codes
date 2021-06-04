import AkPackage.*;
import java.util.*;


public class ActivitySelection {
    public static void main(String args[]) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new ActivitySelection());
        while (!lines.isEmpty()) {
            int start[] = InputOutput.arrayFromString(lines.remove(0)),
                    end[] = InputOutput.arrayFromString(lines.remove(0));
            System.out.println("Start: " + Arrays.toString(start) + "\nEnd: " + Arrays.toString(end));
            System.out.println("Maximum tasks to be performed are: "+ activitySelection(start, end));
        }
    }

    static class Pair {
        public int start, finish;

        public Pair(int s, int e) {
            start = s;
            finish = e;
        }
    }

    public static int activitySelection(int start[], int end[]) {
       Pair arr[]= new Pair[start.length];
        for (int i = 0; i < end.length; i++) 
            arr[i] = new Pair(start[i], end[i]);

        Arrays.sort(arr, (a,b) -> a.finish-b.finish);
        Pair curr = arr[0];
        int count = 1;
        for (int i = 1; i < arr.length; i++) {
            if (curr.finish < arr[i].start) {
                count++;
                curr = arr[i];
            }
        }
        return count;
    }
}