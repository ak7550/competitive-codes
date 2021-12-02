import AkPackage.*;
import java.util.*;

public class CommonWordsWithOneOccurences {
    public static void main(String args[]) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new CommonWordsWithOneOccurences());
        while (!lines.isEmpty()) {
            String str1[] = lines.remove(0).split(""), str2[] = lines.remove(0).split(" ");

            System.out.println("For i/p:" + Arrays.toString(str1) + " " + Arrays.toString(str2));
            System.out.println("o/p is: " + wordsWithOneOccurences(str1, str2));
        }
    }

    public static int wordsWithOneOccurences(String str1[], String str2[]) {
        HashMap<String, Integer> hm = new HashMap<String, Integer>(); // string, frequency
        HashSet<String> h1 = new HashSet<String>();
        HashSet<String> h2 = new HashSet<String>();
        for (String string : str1) {
            hm.putIfAbsent(string, 0);
            hm.put(string, hm.get(string) + 1);
            if (hm.get(string) > 1)
                h1.remove(string);
            if (hm.get(string).equals(1))
                h1.add(string);
        }
        hm.clear();
        for (String string : str2) {
            hm.putIfAbsent(string, 0);
            hm.put(string, hm.get(string) + 1);
            if (hm.get(string) > 1)
                h2.remove(string);
            if (hm.get(string).equals(1))
                h2.add(string);
        }
        int count = 0;
        for (String string : h2) {
            if(h1.contains(string))
                count++;
        }
        return count;
    }

}