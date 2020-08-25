import java.util.ArrayList;
import java.util.Arrays;

import AkPackage.InputOutput;

public class StockBuyAndSell {
    public static void main(String[] args) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new StockBuyAndSell());
        int T = Integer.parseInt(lines.get(0));
        lines.remove(0);
        while (T-- > 0) {
            int length = Integer.parseInt(lines.get(0));
            lines.remove(0);
            int arr[] = InputOutput.arrayFromString(lines.get(0));
            lines.remove(0);
            System.out.println("For Input " + Arrays.toString(arr) + ": ");
            getResult(arr);
        }
    }

    public static void getResult(int arr[]) {
        boolean buy = false, sell = true;
        int trading = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i == arr.length - 1) {
                System.out.print(buy ? ("," + i + ")") : "");
                break;
            }
            if (!buy && arr[i] < arr[i + 1] && sell) {
                buy = true;
                trading++;
                sell = false;
                System.out.print("(" + i);
            }
            if (buy && arr[i] > arr[i + 1] && !sell) {
                sell = true;
                buy = false;
                System.out.print("," + i + ")");
            }
        }
        System.out.println((trading == 0) ? "No Profit" : "");
    }
}