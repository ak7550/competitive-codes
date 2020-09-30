import java.util.Arrays;
import java.util.Scanner;

public class MissingNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n - 1];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        int missingNumber = getResult(n, arr);
        System.out.println(missingNumber);
    }
    public static int getResult(int n, int arr[]) {
        boolean[] table = new boolean[n+1];
        Arrays.fill(table, false);
        for (int i = 0; i < arr.length; i++) {
            table[arr[i]] = true;
        }
        for (int i = 1; i < table.length; i++) {
            if (!table[i]) {
                return i;
            }
        }
        return -1;
    }
}