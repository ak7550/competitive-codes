import java.util.ArrayList;

import AkPackage.InputOutput;

public class PerfectPeeakOfArray2 {
    public static void main(String[] args) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new PerfectPeeakOfArray());
        while (!lines.isEmpty()) {
            ArrayList<Integer> line = InputOutput.ArrayListFromString(lines.remove(0));
            System.out.println("For Input "+ line);
            System.out.println(getResult(line));
        }
    }
    public static int getResult(ArrayList<Integer> A) {
        ArrayList<Integer> maxArr = new ArrayList<Integer>(), minArr = new ArrayList<Integer>();
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE,ans=0;
        for (int i = 1; i < A.size(); i++) {
            max = Math.max(max, A.get(i-1));
            maxArr.add(max);
        }
        for (int i = A.size() - 2; i >= 0; i--) {
            min = Math.min(min, A.get(i + 1));
            minArr.add(0, min);
        }
        for (int i = 2; i < A.size()-2; i++) {
            if (A.get(i)>maxArr.get(i-1) && A.get(i)<minArr.get(i+1)) {
                ans = 1;
                break;
            }
        }
        return ans;      
    }
}