import java.util.ArrayList;
import java.util.Arrays;

import AkPackage.InputOutput;
import AkPackage.Mathematics;

public class RotateArray {
    public static void main(String[] args) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new RotateArray());
        int T = Integer.parseInt(lines.get(0));
        lines.remove(0);
        while (T-- > 0) {
            int l[] = InputOutput.arrayFromString(lines.get(0));
            lines.remove(0);
            int length = l[0], k = l[1];
            int arr[] = InputOutput.arrayFromString(lines.get(0));
            lines.remove(0);
            System.out.println("For input: " + Arrays.toString(arr));
            getResult(arr, k);
            System.out.println(Arrays.toString(arr));
        }
    }
    public static void getResult(int arr[], int d) {
        for (int i = 0; i < Mathematics.gcd(arr.length, d); i++) {
            int l = i;
            int temp = arr[l];
            while (true) {
                int k = (l + d) % arr.length;
                if (k == i) {
                    arr[l] = temp;
                    break;
                }
                arr[l] = arr[k];
                l = k;
            }
        }
    }
}