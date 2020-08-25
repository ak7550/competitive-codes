import java.util.ArrayList;

import AkPackage.InputOutput;

public class PowerSet {
    public static void main(String[] args) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new PowerSet());
        lines.remove(0);// removing the testcase number
        for (String string : lines) {
            System.out.print("Input " + string + ": ");
            getResult(string);
            System.out.println();
        }
    }

    public static void getResult(String string) {
        String str = new String();
        powerSet(string, 0, str);
    }

    public static void powerSet(String string, int index, String str) {
        if (index == string.length()) {
            System.out.print(str + " ");
            return;
        }
        powerSet(string, index + 1, str);
        powerSet(string, index + 1, str + string.charAt(index));
    }
}