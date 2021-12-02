public class ArrangingCoins {
    public static void main(String[] args) {
        int n = 5;
        int start = 1, end = n, ans = 1;
        while (start <= end) {
            int mid = start + ((end - start) >> 1);
            System.out.print(mid + " ");
            int sum = (mid * (mid + 1)) >> 1;
            if (sum <= n) {
                ans = mid;
                start = mid + 1;
            } else
                end = mid - 1;
        }
        System.out.println("\nans is: " + ans);
        
    }
}
