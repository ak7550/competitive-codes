import java.util.Scanner;

public class FrogProblem {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int stones[] = new int[n];
        for (int i = 0; i < n; i++) {
            stones[i] = sc.nextInt();
        }
        int score = 0, maxScore = 0;
        int i = findIndex(stones, k);
        score = stones[i];
        while (maxScore <= score && i + k < n) {
            i += k;
            maxScore = score;
            score += stones[i];
        }
        System.out.print(maxScore);
    }

    public static int findIndex(int arr[], int k) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < k-1; i++) {
            max = Math.max(max, arr[i]);
        }

        for (int i = k - 2; i >= 0; i--) {
            if (arr[i] == max) {
                return i;
            }
        }
        return -1;
    }
}