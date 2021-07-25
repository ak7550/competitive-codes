import AkPackage.*;
import java.util.*;

public class CountingValleys {
    public static void main(String args[]) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new CountingValleys());
        while (!lines.isEmpty()) {
            String path = lines.remove(0);
            System.out.println("For: " + path);
            System.out.println("Number of valleys are: " + countingValleys(path));
        }
    }

    public static int countingValleys(String path) {
        int seaLevel = 0, valley = 0;
        for (int i = 0; i < path.length(); i++) {
            valley+= seaLevel == 0 && path.charAt(i) == 'D' ? 1:0;
            seaLevel += path.charAt(i) == 'U' ? 1 : -1;
        }
        return valley;
    }
}