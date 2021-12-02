import AkPackage.*;
import java.util.*;

public class MinNumberBuckets {
    public static void main(String args[]) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new MinNumberBuckets());
        while (!lines.isEmpty()) {
            String street = lines.remove(0);
            System.out.println("For: " + street);
            System.out.println("Ans: " + minBuckets(street));
        }
    }

    public static int minBuckets(String street) {
        if (street.length() == 1)
            return street.charAt(0) == 'H' ? -1 : 0;
        char strt[] = street.toCharArray();
        for (int i = 0; i < strt.length; i++) {
            if (strt[i] == 'H') {
                if (i == 0 && strt[i + 1] == 'H')
                    return -1;
                if (i == 0 && strt[i + 1] == '.')
                    strt[i + 1] = 'B';
                if (i == strt.length - 1 && strt[i - 1] == 'H')
                    return -1;
                if (i == strt.length - 1 && strt[i - 1] == '.')
                    strt[i - 1] = 'B';
                // will try to put in right first, if not poss, then check if lesft is available
                else if (i > 0 && i < strt.length - 1 && strt[i - 1] != 'B'
                        && strt[i + 1] == '.')
                    strt[i + 1] = 'B';
                else if (i != 0 && i < strt.length - 1
                        && strt[i - 1] == 'H' && strt[i + 1] == 'H')
                    return -1;
                else if (i != 0 && i < strt.length - 1
                        && strt[i - 1] == '.' && strt[i + 1] == 'H')
                    strt[i - 1] = 'B';

            }
        }
        int count = 0;
        for (char ch : strt)
            if (ch == 'B')
                count++;

        return count;
    }
}