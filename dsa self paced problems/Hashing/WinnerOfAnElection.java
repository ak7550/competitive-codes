import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import AkPackage.InputOutput;

public class WinnerOfAnElection {
    public static void main(String[] args) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new WinnerOfAnElection());
        while (!lines.isEmpty()) {
            String[] arr = lines.remove(0).split(" ");
            System.out.println("For input: " + Arrays.toString(arr));
            System.out.println("Winner is: " + Arrays.toString(getResult(arr)));
        }
    }
    public static String[] getResult(String arr[]) {
        HashMap<String, Integer> hm = new HashMap<String, Integer>();
        String min = "";
        int maxVote = Integer.MIN_VALUE;
        for (String i : arr) {
            hm.put(i, hm.containsKey(i) ? hm.get(i) + 1 : 1);
            maxVote = Math.max(maxVote, hm.get(i));
        }
        for (Map.Entry<String, Integer> e : hm.entrySet()) {
            if (e.getValue().equals(maxVote)) {
                if (min.equals(""))
                    min = e.getKey();
                min = min.compareTo(e.getKey()) <= 0 ? min : e.getKey();
            }
        }
        return new String[] { min, Integer.toString(maxVote) };
    }
}
