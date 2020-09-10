import java.util.ArrayList;
import java.util.Collections;

import AkPackage.InputOutput;

public class NobleInteger {
    public static void main(String[] args) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new NobleInteger());
        while (!lines.isEmpty()) {
            ArrayList<Integer> arr = InputOutput.ArrayListFromString(lines.remove(0));
            System.out.println("For input: " + arr);
            int nobleInteger = getResult(arr);
            System.out.println("The output is: " + nobleInteger);
        }
    }

    public static int getResult(ArrayList<Integer> arr) {
        Collections.sort(arr);
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i).equals(arr.get(i + 1)))
                continue;
            if (arr.get(i).equals(arr.size() - 1 - i)) {
                return arr.get(i);
            }
        }
        if (arr.get(arr.size() - 1) == 0) {
            return 1;
        }
        return -1;
    }
}