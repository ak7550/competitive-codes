import java.util.ArrayList;

import AkPackage.InputOutput;

public class SortedPermutationRank {
    public static void main(String[] args) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new SortedPermutationRank());
        while (!lines.isEmpty()) {
            String input = lines.remove(0);
            System.out.println("For input: " + input);
            int rank = getResult(input);
            System.out.println("Rank is: " + rank);
        }
    }
    public static int getResult(String str) {
        // the idea is to generate the str once again and will calculate after how long it may come 
        StringBuilder newStr = new StringBuilder();
        
    }
}