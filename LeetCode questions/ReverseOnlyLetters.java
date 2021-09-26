import AkPackage.*;
import java.util.*;

public class ReverseOnlyLetters {
    public static void main(String args[]) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new ReverseOnlyLetters());
        while (!lines.isEmpty()) {
            String str = lines.remove(0);
            System.out.println("For: " + str);
            System.out.println("Ans: " + reverseOnlyLetters(str));
        }
    }

    public static String reverseOnlyLetters(String s) {
        char str[] = s.toCharArray();
        int start = 0, end = str.length - 1;
        while (start < end) {
            if (!((str[start] >= 'a' && str[start] <= 'z') || (str[start] >= 'A' && str[start] <= 'Z')))
                start++;
            else if (!((str[end] >= 'a' && str[end] <= 'z') || (str[end] >= 'A' && str[end] <= 'Z')))
                end--;
            else {
                char tem = str[start];
                str[start++] = str[end];
                str[end--] = tem;
            }

        }

        return new String(str);
    }
}