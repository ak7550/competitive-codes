import java.util.ArrayList;

import AkPackage.InputOutput;

public class KthRowInPascalTriangle {
    public static void main(String[] args) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new KthRowInPascalTriangle());
        while (!lines.isEmpty()) {
            int k = InputOutput.ArrayListFromString(lines.remove(0)).get(0);
            ArrayList<Integer> res = getResult(k);
            System.out.println("For input: " + k);
            System.out.println(k + "th row of pascal's triangle is: " + res);
        }
    }
    public static ArrayList<Integer> getResult(int n) {
        ArrayList<Integer> row = new ArrayList<Integer>();
        for (int r = 0; r <= n; r++) {
            if (r == 0) {
                row.add(1);
            } else {
                row.add((n - r + 1) * row.get(row.size() - 1)/r);
            }
        }
        return row;
    }
}