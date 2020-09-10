import java.util.ArrayList;

import AkPackage.InputOutput;

public class Flip {
    public static void main(String[] args) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new Flip());
        while (!lines.isEmpty()) {
            String line = lines.remove(0);
            ArrayList<Integer> res = getResult(line);
            System.out.println("For input: " + line);
            System.out.println("output is: " + res);
        }
    }

    public static ArrayList<Integer> getResult(String str) {
        ArrayList<Integer> ans = new ArrayList<Integer>();
        int left = -1, right = -1, tempL = 0, zeroCount = 0, onecount = 0, maxDifference = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '0') {
                zeroCount++;
            } else {
                onecount++;
            }
            if (zeroCount - onecount < 0) {
                zeroCount = 0;
                onecount = 0;
                tempL = i + 1;
            } else if (zeroCount - onecount > maxDifference) {
                maxDifference = zeroCount - onecount;
                left = tempL;
                right = i;
            }
        }
        if (maxDifference > 0) { // to avoid the string consisting all 1's.
            ans.add(left+1);
            ans.add(right+1);
        }
        return ans;
    }
}

// using kadane's algorithm to find maximum contigious substring where countOfZeroes-countOfOnes is maximum