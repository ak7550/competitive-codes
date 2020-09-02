import java.util.ArrayList;

import AkPackage.InputOutput;

public class PermutationOfAString {
    public static void main(String[] args) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new PermutationOfAString());
        while (!lines.isEmpty()) {
            String line = lines.remove(0);
            getResult(line);
        }
    }
    public static void getResult(String s) {
        StringBuilder str = new StringBuilder(s);
    }
}