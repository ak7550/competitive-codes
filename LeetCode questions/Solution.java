import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), threeSold = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        Arrays.sort(arr);
        int count = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            if (threeSold > 0) {
                threeSold -= arr[i];
                count++;
            } else
                break;
        }

        System.out.println(count);
    }
}
