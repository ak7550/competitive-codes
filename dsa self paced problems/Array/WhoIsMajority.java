import java.util.ArrayList;

import AkPackage.InputOutput;

/**
 * WhoIsMajority
 */
public class WhoIsMajority {

    public static void main(String[] args) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new WhoIsMajority());
        int T = Integer.parseInt(lines.get(0));
        lines.remove(0);
        while (T-- > 0) {
            int length = Integer.parseInt(lines.get(0));
            lines.remove(0);
            int arr[] = InputOutput.arrayFromString(lines.get(0));
            lines.remove(0);
            int xy[] = InputOutput.arrayFromString(lines.get(0));
            lines.remove(0);
            getResult(arr, xy[0], xy[1]);
        }
    }

    public static void getResult(int arr[], int x, int y) {
        int countX = 0, countY = 0;
        for (int i : arr) {
            if (i == x) {
                countX++;
            }
            if (i == y) {
                countY++;
            }
        }
        System.out.println((countX >= countY) ? (countX == countY) ? Math.min(x, y) : x : y);
    }
}