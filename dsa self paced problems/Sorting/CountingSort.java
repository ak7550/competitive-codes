import java.util.ArrayList;
import java.util.Arrays;

import AkPackage.InputOutput;

public class CountingSort {
    public static void main(String[] args) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new CountingSort());
        while (!lines.isEmpty()) {
            char seq[] = lines.remove(0).toCharArray();
            System.out.println("Before Sorting: " + Arrays.toString(seq));
            sort(seq);
        }
    }
    public static void sort(char seq[]) {
        int count[] = new int[26];
        for (char ch : seq) 
            count[ch - 97]++;
        for (int i = 1; i < count.length; i++) 
            count[i] += count[i - 1];
        char out[] = new char[seq.length];
        for (int i = seq.length - 1; i >= 0; i--) {
            out[count[seq[i] - 97] - 1] = seq[i];
            count[seq[i] - 97]--;
        }
        System.out.println("Sorted Output is: "+Arrays.toString(out));
    }
}
