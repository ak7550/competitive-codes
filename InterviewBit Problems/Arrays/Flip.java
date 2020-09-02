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
        int left = -1, right = -1, l = 0, zeroes = 0, ones = 0, maxZeroes = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '0') {
                zeroes++;
            } else {
                ones++;
            }
            if (zeroes - ones < 0) {
                zeroes = 0;
                ones = 0;
                l = i + 1;
            } else if (zeroes - ones > maxZeroes) {
                maxZeroes = zeroes - ones;
                left = l;
                right = i;
            }
        }
        if (maxZeroes > 0) {
            left = left + 1;
            right = right + 1;
            ans.add(left);
            ans.add(right);
        }
        return ans;
    }
}