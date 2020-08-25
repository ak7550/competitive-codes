import java.util.ArrayList;
import java.util.Arrays;

import AkPackage.InputOutput;

public class ReverseArray {
    public static void main(String[] args) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new ReverseArray());
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

    public static void getResult(int arr[], int k) {
        for (int i = 0; i < arr.length; i += k) {
            getResult(arr, i, (i + k - 1 > arr.length - 1) ? arr.length - 1 : i + k - 1);
        }
    }

    public static void getResult(int arr[], int low, int high) {
        while (low < high) {
            int temp = arr[low];
            arr[low++] = arr[high];
            arr[high--] = temp;
        }
    }
}