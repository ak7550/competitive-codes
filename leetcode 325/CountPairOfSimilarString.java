import AkPackage.*;
import java.util.*;


public class CountPairOfSimilarString {
    public static void main(String args[]){
        ArrayList<String> lines= InputOutput.takeCompleteInput(new CountPairOfSimilarString());
        while (!lines.isEmpty()) {
            String words[] = lines.remove(0).split(" ");
            System.out.println("for ip: " + Arrays.toString(words));
            System.out.println("op: "+ similarPairs(words));
        }
    }

    private static int similarPairs(String[] words) {
        Arrays.stream(words).map(word -> word.t)
        for (String word : words) {
            char charArr[] = word.toCharArray();

        }


    }
}