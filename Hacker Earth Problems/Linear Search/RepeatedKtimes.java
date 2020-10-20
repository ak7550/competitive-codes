import java.util.*;
public class RepeatedKtimes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), max = Integer.MIN_VALUE, k = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            max = Math.max(max, arr[i]);
        }
        int hash[] = new int[max + 1];
        Arrays.fill(hash, 0);
        for (int i = 0; i < n; i++) {
            hash[arr[i]]++;
        }
        for (int i = 1; i <= max; i++) {
            if (hash[i] == k) {
                System.out.println(i);
                break;
            }
        }
    }
}