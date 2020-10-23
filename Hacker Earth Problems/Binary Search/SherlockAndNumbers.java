import java.util.ArrayList;
import java.util.Arrays;

import AkPackage.InputOutput;

public class SherlockAndNumbers {
    public static void main(String[] args) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new SherlockAndNumbers());
        while (!lines.isEmpty()) {
            int t = Integer.parseInt(lines.remove(0));
            while (t-- > 0) {
                String str[] = lines.remove(0).split(" ");
                int n = Integer.parseInt(str[0]), k = Integer.parseInt(str[1]), p = Integer.parseInt(str[2]);
                int arr[] = InputOutput.arrayFromString(lines.remove(0));
                System.out.println("For Input: "+ n + k + p + Arrays.toString(arr));
                getResult(n, k, p, arr);
            }
        }
    }
    public static void getResult(int n, int k, int p, int arr[]) {
        
    }
}
