
import java.util.ArrayList;
import AkPackage.InputOutput;

public class Nextpermutationv2 {
    public static void main(String[] args) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new NextPermutation());
        while (!lines.isEmpty()) {
            int input = InputOutput.ArrayListFromString(lines.remove(0)).get(0);
            int nextNumber = getResult(input);
            System.out.println("For Input: " + input);
            System.out.println("The next number is: " + nextNumber);
        }
    }

    public static int getResult(int A) {
        Integer num = A, discrepency = (int) Math.log10(A);
        int i = discrepency;
        while (num > 10) {
            int right = num % 10, left = (num % 100) / 10;
            num /= 10;
            if (left < right) {
                discrepency = i - 1;
                break;
            }
            i--;
        }
        if (discrepency < (int) Math.log10(A)) {
            for (int j = (int) Math.log10(A); j > discrepency; j--) {
                if (getValue(A, j) > getValue(A, discrepency)) {
                    A = swap(A, j, discrepency);
                    break;
                }
            }
            A = reverse(A, discrepency + 1, (int) Math.log10(A));
        } else {
            A = reverse(A, 0, (int) Math.log10(A));
        }
        return A;
    }

    public static int getValue(int A, int index) {
        int length = (int) Math.log10(A) + 1;
        int val = A / (int) Math.pow(10, length - index - 1);
        return val % 10;
    }

    public static int reverse(int A, int start, int end) {
        while (start < end) {
            A = swap(A, start++, end--);
        }
        return A;
    }

    public static int swap(int num, int start, int end) {
        int valStart = getValue(num, start);
        int valEnd = getValue(num, end);
        num = setValue(num, end, valStart);
        num = setValue(num, start, valEnd);
        return num;
    }

    public static int setValue(int number, int index, int value) {
        int length = (int) Math.log10(number) + 1;
        int val = number / (int) Math.pow(10, length - index - 1);
        int r = number % (int) Math.pow(10, length - index - 1);
        int remainder = val % 10;
        val = (val - remainder + value);
        val *= (int) Math.pow(10, length - index - 1);
        return val + r;
    }

}