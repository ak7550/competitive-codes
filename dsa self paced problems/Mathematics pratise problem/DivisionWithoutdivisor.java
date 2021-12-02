import AkPackage.*;
import java.util.*;


public class DivisionWithoutdivisor {
    public static void main(String args[]) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new DivisionWithoutdivisor());
        while (!lines.isEmpty()) {
            int arr[] = InputOutput.arrayFromString(lines.remove(0));
            long a = arr[0], b = arr[1];
            System.out.println("For a: " + a + " b: " + b);
            System.out.println("Ans is: " + divide(a, b));
        }
    }

    public static long divide(long a, long b) {
        int sign = a<0 ^ b<0 ? -1 : 1;

        long ans = getResult(Math.abs(a),Math.abs(b));

        return sign == -1 ? -ans : ans;
    }

    public static long getResult(long a, long b){
        long i=0, pos=-1;
        for(i=30; i>=0; i--){
            pos = 1<<i;
            if((a - pos*b)>=0)
                break;
        }

        long rem = a-(pos*b);
        return rem<b ? pos : pos+getResult(rem, b);

    }
}