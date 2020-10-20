import java.util.*;

import AkPackage.InputOutput;

public class MannasFirstName {
    public static void main(String[] args) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new MannasFirstName());
        while (!lines.isEmpty()) {
            String str = lines.remove(0);
            System.out.println("For input: " + str);
            getResult(str);
        }
    }

    public static void getResult(String str) {
        int suvo = 0, suvojit = 0;
        for (int i = 0; i + 4 <= str.length(); i++) {
            if (str.substring(i, i + 4).equals("SUVO")) {
                if (i + 7 <= str.length() && str.substring(i, i + 7).equals("SUVOJIT"))
                    suvojit++;
                else
                    suvo++;
            }
        }
        System.out.println("SUVO = " + suvo + ", SUVOJIT = " + suvojit);
    }
}