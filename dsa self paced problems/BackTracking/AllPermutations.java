import AkPackage.*;
import java.util.*;

public class AllPermutations {
    public static void main(String args[]) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new AllPermutations());
        while (!lines.isEmpty()) {
            String str = lines.remove(0);
            System.out.println("All permutations are: ");
            permutate(new StringBuilder(str), 0);
        }
    }

    public static void permutate(StringBuilder str, int start) {
        if (start == str.length())
            return;
        StringBuilder res = new StringBuilder(str);
        for (int i = start; i < str.length(); i++) {
            res=LargestNumberWithKSwaps.swap(str, start, i);
            permutate(res, start+1);
            System.out.println(str + " ");
        }
    }
}