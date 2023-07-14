import AkPackage.*;
import java.util.*;

public class FindAndReplaceAString {
    public static void main(String args[]) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new FindAndReplaceAString());
        while (!lines.isEmpty()) {
            String str = lines.remove(0);
            int q = InputOutput.ArrayListFromString(lines.remove(0)).get(0);
            int index[] = InputOutput.arrayFromString(lines.remove(0));
            String sources[] = lines.remove(0).split(" "), targets[] = lines.remove(0).split(" ");

            System.out.println("For ip: " + str + " \nq= " + q + " \n indexes: " + Arrays.toString(index)
                    + " \n sources: " + Arrays.toString(sources) + "\n targets: " + Arrays.toString(targets));

            System.out.println("op is: " + findAndReplaceString(str, q, index, sources, targets));
        }
    }

    private static String findAndReplaceString(String s, int q, int index[], String sources[], String targets[]) {
        StringBuilder str = new StringBuilder(s);
        int increment =0 ;
        for (int i = 0; i < q; i++) {
            int pos = index[i];
            String source = sources[i], target = targets[i];
            int start = increment + pos;
            int end = start + source.length();
            if (str.substring(start, end).equals(source)) {
                str.delete(start, end);
                str.insert(start, target);

                increment += (target.length() - source.length());
            }
        }

        return str.toString();
    }
}