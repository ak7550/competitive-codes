import java.util.ArrayList;
import java.util.Arrays;

import AkPackage.InputOutput;

public class RearrangeTheArrayAlternatively {
    public static void main(String[] args) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new RearrangeTheArrayAlternatively());
        int T = Integer.parseInt(lines.get(0));
        lines.remove(0);
        while (T-- > 0) {
            int length = Integer.parseInt(lines.get(0));
            lines.remove(0);
            int arr[] = InputOutput.arrayFromString(lines.get(0));
            lines.remove(0);
            System.out.println("For Input " + Arrays.toString(arr) + ": ");
            getResult(arr);
            System.out.println("Output is: " + Arrays.toString(arr));
            System.out.println();
            System.out.println();
            System.out.println();
        }
    }
    // tough question, watch some youtube videos to understand the logic, we are trying tp store two element at a given index.
    public static void getResult(int arr[]) {
        int n = arr.length;
        int me = arr[n - 1] + 1, maxi = n - 1, mini = 0;
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0)
                arr[i] = arr[i] + (arr[maxi--] % me) * me;
            else
                arr[i] = arr[i] + (arr[mini++] % me) * me;
        }
        for (int i = 0; i < n; i++) {
            arr[i] /= me;
        }
    }
}