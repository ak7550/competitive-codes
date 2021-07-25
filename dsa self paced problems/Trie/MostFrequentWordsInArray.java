import AkPackage.*;
import java.util.*;

public class MostFrequentWordsInArray {
    public static void main(String args[]) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new MostFrequentWordsInArray());
        while (!lines.isEmpty()) {
            String arr[] = lines.remove(0).split(" ");
            System.out.println("For: " + Arrays.toString(arr));
            System.out.println("Most frequent words are: " + mostFrequentWord(arr));
        }
    }

    public static String mostFrequentWord(String arr[]) {
        // Hastmap<String, Integer> tm = new Hastmap<String, Integer>();
        TreeMap<String, Integer> tm = new TreeMap<String, Integer>(Collections.reverseOrder());
        for (String string : arr)
            tm.put(string, tm.containsKey(string) ? tm.get(string) + 1 : 1);
        // tm.putAll(tm);
        System.out.println(tm);
        return tm.firstKey();
    }
}