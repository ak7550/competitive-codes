import AkPackage.*;
import java.util.*;

//=> AD-HOC problem, still solvable, with strong mathematics



public class MinOPerationsToMakeUniqueGrid {
    public static void main(String args[]) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new MinOPerationsToMakeUniqueGrid());
        while (!lines.isEmpty()) {
            int grid[][] = Graph.takeAdjacencyMatrixInput(lines);
            int x = InputOutput.arrayFromString(lines.remove(0))[0];
            Graph.printAdjacencyMatrix(grid);
            System.out.println("Ans is: " + getCount(grid, x));

        }
    }

    public static int getCount(int grid[][], int x) {
        // the idea is to reach to the median, as all the least calculations would lead to the median

        ArrayList<Integer> arr = new ArrayList<>();
        Arrays.stream(grid).forEach(x1 -> Arrays.stream(x1).forEach(arr::add));
        Collections.sort(arr);
        int med = arr.get((arr.size() - 1) >> 1), count = 0;

        //_ now, task is to make all the elements to med, in the shorrtest no of calculations.
        for (int val : arr) {
            if (med != val) {
                int diff = Math.abs(med - val);
                if (diff % x != 0) //-> if not dividable, that means, i cant make val to med using x
                    return -1;
                else
                    count += (diff / x);
            }
        }
        return count;
    }
}