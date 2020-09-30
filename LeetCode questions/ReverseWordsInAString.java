import java.util.ArrayList;

import AkPackage.InputOutput;

public class ReverseWordsInAString {
    public static void main(String[] args) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new ReverseWordsInAString());
        while (!lines.isEmpty()) {
            String line = lines.remove(0);
            System.out.println("For Input: " + line);
            System.out.println("Output is: " + getResult(line));
        }
    }
    public static String getResult(String input) {
        StringBuilder ouput = new StringBuilder();
        String strArray[] = input.trim().split(" ");
        for (int i = strArray.length - 1; i >= 0; i--) {
            if (strArray[i].trim().equals(" ")||strArray[i].trim().equals("")) {
                continue;
            }
            ouput.append(strArray[i].trim());
            ouput.append(" ");
        }
        return ouput.toString().trim();
    }
}