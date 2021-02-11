import AkPackage.*;
import java.util.*;

public class SmallerOnRight {
    public static void main(String args[]) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new SmallerOnRight());
        while (!lines.isEmpty()) {
            ArrayList<Integer> arr = InputOutput.ArrayListFromString(lines.remove(0));
            System.out.println("For the given input of: " + arr);
            System.out.println("Maximum count of smaller on right is: " + getResult(arr));
        }
    }

    public static int getResult(ArrayList<Integer> arr) {
        TreeSet<Integer> ts = new TreeSet<Integer>();
        int max = 0;
        for (int i = arr.size() - 1; i >= 0; i--) {
            ts.add(arr.get(i));
            Integer floor = ts.floor(arr.get(i));
            if (floor != null) {
                SortedSet<Integer> set = ts.headSet(floor);
                i = Math.max(max, set.size());
            }
        }
        return max;
    }
}