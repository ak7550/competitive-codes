import AkPackage.*;
import java.util.*;

public class BlackAndWhite {
    public static void main(String args[]) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new BlackAndWhite());
        while (!lines.isEmpty()) {
            int arr[] = InputOutput.arrayFromString(lines.remove(0));
            int n = arr[0], m = arr[1];
            System.out.println("for n=" + n + " m=" + m);
            System.out.println("Solution is: " + solve(n, m));
        }
    }

    public static long solve(int n, int m) {
        long modulo = (long) Math.pow(10, 9) + 7, res = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                long acquiredPlaces = placeWhiteKnight(n,m, i, j, modulo) % modulo;
                res += ((n * m) % modulo - acquiredPlaces) % modulo;

            }
        }
        return res%modulo;
    }

    public static long placeWhiteKnight(int n, int m, int row, int col, long modulo) {
        long count = 1;

        if(mark(n,m,row-2, col-1)) count = (count + 1) % modulo;
        if(mark(n,m,row+2, col+1)) count = (count + 1) % modulo;
        if(mark(n,m,row+2, col-1)) count = (count + 1) % modulo;
        if(mark(n,m,row-2, col+1)) count = (count + 1) % modulo;
        if(mark(n,m,row-1, col-2)) count = (count + 1) % modulo;
        if(mark(n,m,row+1, col+2)) count = (count + 1) % modulo;
        if(mark(n,m,row+1, col-2)) count = (count + 1) % modulo;
        if(mark(n,m,row-1, col+2)) count = (count + 1) % modulo;

        return count;

        // now i have counted how many possible squares are under the terotory of white knight
    }

    public static boolean mark(int n, int m, int row, int col) {
        if (row >= 0 && row <n)
            if (col >= 0 && col < m)
                return true;
        return false;
    }
}