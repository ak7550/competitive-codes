import java.util.Arrays;
import java.util.Scanner;

/**
 * LocalKing
 */
public class LocalKing {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int kingsPower[] = new int[n];
            for (int i = 0; i < kingsPower.length; i++) {
                kingsPower[i] = sc.nextInt();
            }
            Arrays.sort(kingsPower);
            print(getResult(kingsPower, n, k));
        }
    }

    public static int[] getResult(int arr[], int n, int k) {
        int thrones[] = new int[k];
        for (int i = 0; i < k; i++) {
            thrones[i] = max(arr[i], arr[i + 1], arr[i + 2]);
        }
        return thrones;
    }

    public static int max(int a, int b, int c) {
        int max = Integer.MIN_VALUE;
        max = Math.max(max, a);
        max = Math.max(max, b);
        max = Math.max(max, c);
        new StringBuilder().append(str);
        Integer.
        return max;
    }

    public static void print(int arr[]) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}