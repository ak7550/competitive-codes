import AkPackage.*;

import java.util.*;
import java.util.regex.Pattern;

import java.util.regex.Matcher;

public class HowMany {
    public static void main(String args[]) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new HowMany());
        while (!lines.isEmpty()) {
            String sentence = lines.remove(0);
            System.out.println("Word count: " + howMany(sentence));
        }
    }

    public static int howMany(String sentence) {
        String arr[] = sentence.split(" ");
        int count = 0;
        return (int) Arrays.stream(sentence.split(" "))
                .filter(x -> Pattern.matches("([A-Za-z])\\w+", x))
                .count();

        // for (String x : arr) {
        //     x.trim();
        //     try{
        //         int num = Integer.parseInt(x);
        //         // System.out.println(num);
        //     } catch (NumberFormatException nmb) {
        //         if( x.charAt(x.length()-1) != ' ' )
        //             count++;
        //         // System.out.println("For "+ x);

        //     }










        // }
        // return count;

    }
}