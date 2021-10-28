import AkPackage.*;
import java.util.*;

public class NearestPerfectSquare {
    public static void main(String args[]) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new NearestPerfectSquare());
        while (!lines.isEmpty()) {
            String input = lines.remove(0);
            perfectSquare(input);
        }
    }

    public static void perfectSquare(String n) {
        Long val = Long.parseLong(n);
        long sqrt = (long) Math.sqrt(val);
        // if(sqrt*sqrt == val) System.out.println(n);

        // now i am pretty sure that val is not perfect square...
        long rootm2 = sqrt - 2, rootm1 = sqrt - 1, rootp1 = sqrt + 1, rootp2 = sqrt + 2;
        long sm2 = rootm2 * rootm2, sm1 = rootm1 * rootm1, sp1 = rootp1 * rootp1, sp2 = rootp2 * rootp2;
        long dif = Long.MAX_VALUE, ans = -1;
        if (dif > Math.abs(sm2 - val)) {
            dif = Math.abs(sm2 - val);
            ans = sm2;
        }
        if (dif > Math.abs(sm1 - val)) {
            dif = Math.abs(sm1 - val);
            ans = sm1;
        }
        if (dif > Math.abs(sp1 - val)) {
            dif = Math.abs(sp1 - val);
            ans = sp1;
        }
        if (dif > Math.abs(sp2 - val)) {
            dif = Math.abs(sp2 - val);
            ans = sp2;
        }
        long sq = sqrt * sqrt;
        if (Math.abs(sq - val) != 0)
            if (dif > Math.abs(sm2 - val)) {
                dif = Math.abs(sm2 - val);
                ans = sm2;
            }

        System.out.println(ans);
    }
}