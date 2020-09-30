import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BreakupApp {
    public static void main(String[] args) throws Exception {
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(stdin.readLine());
        String totalConversation[] = new String[n];
        int dates[] = new int[31];
        Arrays.fill(dates, 0);
        int mul = 1;
        for (int i = 0; i < totalConversation.length; i++) {
            totalConversation[i] = stdin.readLine();
            System.out.println("Input: "+totalConversation[i]);
            if (totalConversation[i].charAt(0) == 'G') {
                mul = 2;
            } else if(totalConversation[i].charAt(0) == 'M') {
                mul = 1;
            }
            String str[] = totalConversation[i].split(" ");
            for (int j = 0; j < str.length; j++) {
                try {
                    int num = Integer.parseInt(str[j]);
                    dates[num] += mul;
                } catch (Exception e) {
                }
            }
        }
        int max = Integer.MIN_VALUE, maxIndex = -1;
        for (int i = 0; i < dates.length; i++) {
            if (dates[i] > max) {
                max = dates[i];
                maxIndex = i;
            }
        }
        System.out.println("Dates array is: "+ Arrays.toString(dates));
        if (maxIndex == 19 || maxIndex == 20 && dates[19] != dates[20]) {
            System.out.println("Date");
        } else {
            System.out.println("No Date");
        }
    }
}