import java.util.ArrayList;
import AkPackage.InputOutput;

public class NextPermutation {
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
        char num[] = Integer.toString(A).toCharArray();
        int discrepency = num.length - 1;
        for (int i = num.length - 1; i > 0; i--) {
            char right = num[i], left = num[i - 1];
            if (left < right) {
                discrepency = i - 1;
                break;
            }
        }
        if (discrepency < num.length - 1) {
            for (int i = num.length-1; i > discrepency; i--) {
                if (num[discrepency] < num[i]) {
                    swap(num, discrepency, i);
                    break;
                }
            }
            reverse(num, discrepency + 1, num.length - 1);
        } else {
            reverse(num, 0, num.length - 1);
        }
        return Integer.parseInt(new String(num));
    }

    public static void swap(char num[], int start, int end) {
        char temp = num[start];
        num[start] = num[end];
        num[end] = temp;
    }

    public static void reverse(char num[], int start, int end) {
        while (start < end)
            swap(num, start++, end--);
    }
}