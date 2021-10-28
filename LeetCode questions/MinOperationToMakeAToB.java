import AkPackage.*;
import java.util.*;

public class MinOperationToMakeAToB {
    public static void main(String args[]) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new MinOperationToMakeAToB());
        while (!lines.isEmpty()) {
            int A[] = InputOutput.arrayFromString(lines.remove(0)), B[] = InputOutput.arrayFromString(lines.remove(0));

            System.out.println("For given: \n" + Arrays.toString(A) + "\n" + Arrays.toString(B));
            System.out.println("Minimum operations required are: " + minOperation(A, B, A.length, B.length));
        }
    }

    public static int minOperation(int A[], int B[], int N, int M) {
        HashSet<Integer> hs = new HashSet<>();
        Arrays.stream(B).forEach(hs::add);

        TreeSet<Integer> ts = new TreeSet<>(); // as we need to maintain the sorted order
        int max = 0;
        for (int i = 0; i < N; i++) {
            if (hs.contains(A[i])) {
                Integer ceil = ts.ceiling(A[i]);
                if (ceil != null)
                    ts.remove(ceil);
                ts.add(A[i]);
                max = Math.max(max, ts.size());
            }
        }
        return (M + N) - 2 * max;
    }

}
