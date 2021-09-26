import java.util.Arrays;
import java.util.Scanner;

public class NewCode {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        int sum = Arrays.stream(arr).sum();
        int getCubeRoot = getRoot(sum);
        if (Math.pow(getCubeRoot, 3) == sum)
            System.out.println("Yes");
        else
            System.out.println(Math.pow(getCubeRoot, 3) - sum);
    }
    public static int getRoot(int num) {
        int left = 1, right = num, ans = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (mid * mid * mid == num)
                return mid;
            if (mid * mid * mid < num) {
                left = mid + 1;
                ans = mid;
            } else
                right = mid - 1;
        }
        return ans;
    }
}
