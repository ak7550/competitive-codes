import AkPackage.*;
import java.util.*;

public class NumberOfValidWordOfEachPuzzle {
    public static void main(String args[]) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new NumberOfValidWordOfEachPuzzle());
        while (!lines.isEmpty()) {
            String words[] = lines.remove(0).split(" "), puzzles[] = lines.remove(0).split(" ");
            System.out.println("For given: ");
            System.out.println("Words: " + Arrays.toString(words));
            System.out.println("Puzzles: " + Arrays.toString(puzzles));
            System.out.println("Number of valid words in each puzzle: " + findNumOfValidWords(words, puzzles));
        }
    }

    public static List<Integer> findNumOfValidWords(String words[], String puzzles[]) {
        List<Integer> ans = new ArrayList<>();
        HashMap<String, Integer> wordMask = new HashMap<>();
        HashMap<Integer, Integer> wordMaskcount = new HashMap<>();
        for (String word : words) {
            int mask = getMask(word);
            wordMask.put(word, mask);
            wordMaskcount.put(mask, wordMaskcount.getOrDefault(mask, 0)+1);
        }

        for (int i = 0; i < puzzles.length; i++) {
            String puzzle = puzzles[i];
            int pMask = getMask(puzzle), firstLetterMask = 1 << (puzzle.charAt(0) - 'a');
            // ans.add(0);
            int count = 0;
            int subMask = pMask;
            while (subMask != 0) { // this will be done in a constant 6 rotations or less ==> O(1) operation
                if ((subMask & firstLetterMask) != 0 && wordMaskcount.containsKey(subMask))
                    count += wordMaskcount.get(subMask);

                subMask = (subMask - 1) & pMask; //-> to get the next possible substring ==> tricky part
            }

            ans.add(count);

        }
        return ans;
    }

    public static int getMask(String str){
        int mask = 0;
        for (char ch : str.toCharArray())
            mask |= 1 << (ch - 'a');

        return mask;
    }
}