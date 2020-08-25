import java.util.ArrayList;
import java.util.Arrays;
import AkPackage.InputOutput;
public class MaxEvenOdd {
    public static void main(String[] args) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new MaxEvenOdd());
        int T = Integer.parseInt(lines.get(0));
        lines.remove(0);
        while (T-- > 0) {
            int length = Integer.parseInt(lines.get(0));
            lines.remove(0);
            int arr[] = InputOutput.arrayFromString(lines.get(0));
            lines.remove(0);
            System.out.println("For Input " + Arrays.toString(arr) + ": ");
            getResult(arr);
            System.out.println();
            System.out.println();
            System.out.println();
        }
    }

    public static void getResult(int arr[]) {
        int count = 1, max = 0;
        boolean flag = isEven(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            boolean temp = isEven(arr[i]);
            if (temp != flag) {
                count += 1;
            } else {
                max = Math.max(max, count);
                count = 1;
            }
            flag = temp;
        }
        max = Math.max(max, count);
        System.out.println(max);
    }

    public static boolean isEven(int x) {
        return x % 2 == 0;
    }
}