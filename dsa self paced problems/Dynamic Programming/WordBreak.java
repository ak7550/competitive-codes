import AkPackage.*;
import java.util.*;

public class WordBreak {
    public static void main(String args[]){
        ArrayList<String> lines= InputOutput.takeCompleteInput(new WordBreak());
        while (!lines.isEmpty()) {
            String str = lines.remove(0);
            List<String> wordDict = new ArrayList<>();
            Arrays.stream(lines.remove(0).split(" ")).forEach(wordDict::add);
            System.out.println("For: " + str + "\n" + wordDict);
            System.out.println("Ans: "+ wordBreak(str, wordDict));
        }
    }

    public static boolean wordBreak(String str, List<String> dic) {
        int size = str.length();

        if (size == 0)
            return true;

        boolean wb[] = new boolean[size + 1];

        for (int i = 1; i <= size; i++) {
            if (!wb[i] && dic.contains(str.substring(0, i)))
                wb[i] = true;

            if (wb[i]) {
                if (i == size)
                    return true;

                for (int j = i + 1; j <= size; j++) {
                    if (!wb[j] && dic.contains(str.substring(i, j)))
                        wb[j] = true;

                    if (j == size && wb[j])
                        return true;
                }
            }
        }

        return false;
    }
}