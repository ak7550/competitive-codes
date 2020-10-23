import java.util.ArrayList;
import java.util.Arrays;

import AkPackage.InputOutput;

public class CountTheSubArray {
    public static void main(String[] args) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new SherlockAndNumbers());
        while (!lines.isEmpty()) {
            int t = Integer.parseInt(lines.remove(0));
            while (t-- > 0) {
                String str[] = lines.remove(0).split(" ");
                long n = Long.parseLong(str[0]);
                long k = Long.parseLong(str[1]);
                int a2[] = InputOutput.arrayFromString(lines.remove(0));
                System.out.println("For Input: " + n + k + Arrays.toString(a2));
                getResult(n, k, a2);
            }
        }
    }
    public static void getResult(long n, long k, int arr[]) {
        
    }
}
