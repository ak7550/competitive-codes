import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
import java.util.stream.Stream;

import AkPackage.InputOutput;

public class CelebrityProblem {
    public static void main(String[] args) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new CelebrityProblem());
        while (!lines.isEmpty()) {
            int n = Integer.parseInt(lines.remove(0)), i = 0, j = -1;
            int M[][] = new int[n][];
            for (Integer integer : InputOutput.ArrayListFromString(lines.remove(0))) {
                if (i == 0)
                    M[++j] = new int[n];
                M[j][i++] = integer;
                i %= n;
            }
            System.out.println("For input: ");
            Arrays.stream(M).forEach(x -> System.out.println(Arrays.toString(x)));
            System.out.println("Celebrity is present at: " + getResult(M, n) + " position.");
        }
    }

    public static int getResult(int arr[][], int n) {
        Stack<Integer> st = new Stack<Integer>();
        Stream.iterate(0, x -> x + 1).limit(n).forEach(x -> st.push(x));
        int j = -1, i = -1;
        while (!st.empty()) {
            j = st.pop();
            if (st.empty())
                return j == 0 ? arr[1][0] == 1 ? j : -1 : j;
            i = st.pop();
            if (arr[i][j] == 1 && arr[j][i] == 0)
                st.push(j);
            else if (arr[i][j] == 0 && arr[j][i] == 1)
                st.push(i);
            else
                continue;
        }

        return -1;
    }
}
