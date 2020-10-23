import java.util.ArrayList;

import AkPackage.InputOutput;

public class MonksEncounterWithPolynomial {
    public static void main(String[] args) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new MonksEncounterWithPolynomial());
        while (!lines.isEmpty()) {
            int t = Integer.parseInt(lines.remove(0));
            while (t-- > 0) {
                String str[] = lines.remove(0).split(" ");
                long a = Long.parseLong(str[0]), b = Long.parseLong(str[1]), c = Long.parseLong(str[2]),
                        k = Long.parseLong(str[3]);
                getResult(a, b, c, k);
            }
        }
    }
    public static void getResult(long a, long b, long c, long k) {
        c -= k;
        double rootSquare = b * b - 4 * a * c;
        if (rootSquare < 0) {
            System.out.println("0");
        } else {
            double root = Math.sqrt(rootSquare);
            double x1 = Math.ceil(((-b) + root) / (2 * a));
            System.out.println((long)x1);
        }
    }
}
