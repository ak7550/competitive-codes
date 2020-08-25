import java.util.ArrayList;
import java.util.Arrays;

import AkPackage.InputOutput;

public class RearrangeTheArray {
    public static void main(String[] args) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new RearrangeTheArray());
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
    public static void getResult(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i] + arr[arr[i]] * arr.length;
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] /= arr.length;
            arr[i] %= arr.length;
        }
    }
}