import java.util.ArrayList;

import AkPackage.InputOutput;

public class TimeConvertion {
    public static void main(String[] args) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new TimeConvertion());
        while (!lines.isEmpty()) {
            String line = lines.remove(0);
            System.out.println("Input: " + line);
            System.out.println("Output: " + timeConversion(line));
        }
    }

    static String timeConversion(String s) {
        String st[] = s.split(":");
        StringBuilder str = new StringBuilder();
        int hour = Integer.parseInt(st[0]);
        char decider = s.charAt(s.length() - 2);
        if (decider == 'P' || decider=='p') {
            if (hour != 12) {
                hour += 12;
            }
        } else {
            if (hour == 12) {
                hour -= 12;
            }
        }
        String h = (hour < 10) ? "0" + Integer.toString(hour) : Integer.toString(hour);
        str.append(h);
        str.append(":");
        str.append(st[1]);
        str.append(":");
        str.append(st[2]);
        str.deleteCharAt(str.length() - 1);
        str.deleteCharAt(str.length() - 1);
        return str.toString();
    }
}