import AkPackage.*;
import java.util.*;


public class DevideIntoMinimalNumberOfGroups {
    public static void main(String args[]) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new DevideIntoMinimalNumberOfGroups());
        while (!lines.isEmpty()) {
            int arr[][] = Graph.takeAdjacencyMatrixInput(lines);
            System.out.println("for ip: " + Arrays.deepToString(arr));
            System.out.println("ans is: " + solve(arr));
        }
    }


    private static int solve(int arr[][]) {
        int max = -1;
        for (int[] ar : arr) {
            max = Math.max(max, ar[1]);
        }

        int postSum[] = new int[max + 1];

        for (int ar[] : arr) {
            int from = ar[0], to = ar[1];
            for(int i=from; i<=to; i++)
                postSum[i]++;
        }
        return Arrays.stream(postSum).max().getAsInt();
    }
}