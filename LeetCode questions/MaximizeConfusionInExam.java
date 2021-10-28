import AkPackage.*;
import java.util.*;


public class MaximizeConfusionInExam {
    public static void main(String args[]) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new MaximizeConfusionInExam());
        while (!lines.isEmpty()) {
            String ans = lines.remove(0);
            int k = Integer.parseInt(lines.remove(0));
            System.out.println("For: " + ans + " " + k);
            System.out.println("Maximum length is: " + maxConsecutiveAnswers(ans, k));
        }
    }

    public static int maxConsecutiveAnswers(String ans, int k) {
        int t = 0, f = 0;
        for (char ch : ans.toCharArray()) {
            if (ch == 'T')
                t++;
            else
                f++;
        }
        if (Math.min(t, f) <= k)
            return ans.length();
        return Math.max(maxConsecutiveAnswers(ans, k, 'T', 'F'), maxConsecutiveAnswers(ans, k, 'F', 'T'));
    }

    public static int maxConsecutiveAnswers(String ans, int k, char samCh, char oppCh) {
        Queue<Integer> opIndex = new LinkedList<>();
        int start = -1, end = 0, max=0;
        while (end < ans.length()) {
            if (ans.charAt(end) == oppCh) {
                if (opIndex.size() == k) {
                    max = Math.max(max, end - start-1);
                    start = opIndex.poll();
                }
                opIndex.add(end);
            }

            end++;
        }
        max = Math.max(max, end - start - 1);

        return max;
    }
}
