import java.util.Scanner;

public class IncreasingArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // System.out.println("Enter the length of the array: ");
        long n = sc.nextLong();
        // System.out.println("Enter the numbers one by one: ");
        long[] arr = new long[(int)n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(getResult(arr));
    }
    public static long getResult(long arr[]) {
        long sum = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i - 1]) {
                sum += (arr[i - 1] - arr[i]);
                arr[i] = arr[i - 1];
            }
        }
        return sum;
    }
}
