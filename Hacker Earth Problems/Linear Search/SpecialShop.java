import java.util.ArrayList;

import AkPackage.InputOutput;

public class SpecialShop {
    public static void main(String[] args) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new SpecialShop());
        while (!lines.isEmpty()) {
            int arr[] = InputOutput.arrayFromString(lines.remove(0));
            int n = arr[0], a = arr[1], b = arr[2];
            System.out.println("For input: " + n + " " + a + " " + b);
            System.out.println("Differentiation result is: ");
            differentiation(n, a, b);
            System.out.println("Multiplied result is: ");
            multiplication(n, a, b);
            System.out.println("Test Case result is: ");
            usingLoop(n, a, b);
        }
    }

    public static void differentiation(int n, int a, int b) {

    }

    public static void multiplication(int n, int a, int b) {
        long an=(a*n)/(a+b), bn=(b*n)/(a+b);

    }

    public static void usingLoop(int n, int a, int b) {
        long min = Long.MAX_VALUE;
        for (int i = 0; i <= n / 2 + 1; i++) {
            long value1 = (long) (a * Math.pow(i, 2) + b * Math.pow((n - i), 2));
            long value2 = (long) (b * Math.pow(i, 2) + a * Math.pow((n - i), 2));
            min = Math.min(min, Math.min(value1, value2));
        }
        System.out.println(min);
    }
    
    public static long getValue(long n, long a, long ) {
        
    }
}