import java.util.ArrayList;
import java.util.Arrays;
import AkPackage.InputOutput;

public class TheFuriousFive {
    static int[] fValue;
    public static void main(String[] args) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new TheFuriousFive());
        int t = Integer.parseInt(lines.remove(0));
        while (!lines.isEmpty()) {
            int n = Integer.parseInt(lines.remove(0));
            fValue = new int[(100+n)];
            Arrays.fill(fValue, 0);
            getRsult(n);
        }
        System.out.println(Arrays.toString(fValue));
    }

    public static void getRsult(int n) {
        int sum = 0,i;
        for (i = 1; sum < n; i++) {
            sum += getFValue(i);
        }
        System.out.println(i);
    }
    public static int getFValue(int x) {
        int count = 0;
        if (fValue[x] != 0)
            return fValue[x];
        while (x >= 5) {
            x /= 5;
            count++;
        }
        fValue[x] = count;
        return count;
    }
}
