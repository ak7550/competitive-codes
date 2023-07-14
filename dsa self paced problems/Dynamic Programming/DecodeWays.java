import AkPackage.*;
import java.util.*;


public class DecodeWays {
    public static void main(String args[]){
        ArrayList<String> lines= InputOutput.takeCompleteInput(new DecodeWays());
        while (!lines.isEmpty()) {
            String number = lines.remove(0);
            System.out.println("For ip: " + number);
            System.out.println("Ans is: "+ decodeWays(number));
        }
    }

    private static int decodeWays(String number) {
        int dp1 = 1, dp2 = 0, n = number.length();
        for (int i = n-1; i >=0; i--) {
            int dp = number.charAt(i) == '0' ? 0 : dp1;
            if(i<n-1 && (number.charAt(i)=='1' || number.charAt(i)=='2' && number.charAt(i+1)-'0'<7))
                dp += dp2;

            dp2 = dp1;
            dp1 = dp;
        }
        return dp1;
    }
}