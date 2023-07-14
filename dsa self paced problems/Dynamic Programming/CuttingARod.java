import AkPackage.*;
import java.util.*;

//docs: https://www.geeksforgeeks.org/cutting-a-rod-dp-13/
public class CuttingARod {
    public static void main(String args[]) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new CuttingARod());
        while (!lines.isEmpty()) {
            int price[] = InputOutput.arrayFromString(lines.remove(0));
            System.out.println("for ip: " + Arrays.toString(price));
            System.out.println("op is: " + cutTheRod(price));
        }
    }

    private static int cutTheRod(int price[]) {
        Integer dp[] = new Integer[price.length];
        return cutTheRod(price, price.length, dp);
    }

    private static int cutTheRod(int price[], int length, Integer dp[]) {

        if (length == 0)// nothing is left
            return 0;
        // from i=1 i will try to cut the rod by all the possible cuts and calculate the max profit that I can earn from cutting that length
        if (dp[length - 1] != null)
            return dp[length - 1];

        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= length; i++) {
            max = Math.max(max, price[i - 1] + cutTheRod(price, length - i, dp));
        }

        return dp[length-1] = max;
    }
}