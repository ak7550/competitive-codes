import AkPackage.*;
import java.util.*;


public class ZAlgorithm {
    public static void main(String args[]) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new ZAlgorithm());
        while (!lines.isEmpty()) {
            String ip[] = lines.remove(0).split(" ");
            System.out.println("For ip: " + ip[0] + " " + ip[1]);
            System.out.println("op: " + zalgorithm(ip[0], ip[1]));
        }
    }

    public static ArrayList<Integer> zalgorithm(String str, String pat) {
        ArrayList<Integer> arr = new ArrayList<>();
        int i = 0;
        while (i < str.length()) {
            while (i<str.length() && str.charAt(i) != pat.charAt(0))
                i++;
            // now the first character matches
            int j = 0, k=i;
            while (k < str.length() && j < pat.length() && pat.charAt(j) == str.charAt(k)) {
                j++;
                k++;
            }
            if (j == pat.length())
                arr.add(i + 1);
            i = k;
        }

        if(arr.isEmpty()) arr.add(-1);
        return arr;
    }
}