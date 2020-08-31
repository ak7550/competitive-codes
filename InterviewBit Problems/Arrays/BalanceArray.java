import java.util.ArrayList;

import AkPackage.InputOutput;

public class BalanceArray {
    public static void main(String[] args) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new BalanceArray());
        while (!lines.isEmpty()) {
            ArrayList<Integer> line = InputOutput.ArrayListFromString(lines.remove(0));
            System.out.println("For Input: " + line);
            System.out.println("Ans is: " + getResult(line));

        }
    }

    public static int getResult(ArrayList<Integer> A) {
        ArrayList<Integer> prefixSum1 = new ArrayList<Integer>();
        ArrayList<Integer> sufixSum1 = new ArrayList<Integer>();
        ArrayList<Integer> sufixSum2 = new ArrayList<Integer>();
        ArrayList<Integer> prefixSum2 = new ArrayList<Integer>();
        prefixSum1.add(A.get(0));
        prefixSum1.add(A.get(1));
        sufixSum1.add(0, A.get(A.size() - 1));
        sufixSum1.add(0, A.get(A.size() - 2));
        for (int i = 2, j = A.size() - 3; i < A.size(); i++, j--) {
            prefixSum1.add(prefixSum1.get(i - 2) + A.get(i));
            sufixSum1.add(0, sufixSum1.get(1) + A.get(j));
        }
        System.out.println(prefixSum1);
        System.out.println(sufixSum1);
        return 0;
    }
}