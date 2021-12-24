import java.util.Arrays;
import java.util.Scanner;

public class Coins {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double prob[] = new double[n];
        for (int i = 0; i < prob.length; i++)
            prob[i] = sc.nextDouble();

        System.out.println(findAns(prob, n));
    }

    public static double findAns(double prob[], int n) {
        // -> dp[x][y] ==> stores the probability of coming y heads when x coins will be
        // tossed
        double dp[][] = new double[n + 1][n + 1], head = 1, tail = 1;
        // for (int i = 0; i < prob.length; i++) {
        // head *= prob[i];
        // dp[i + 1][i + 1] = head;
        // tail *= (1 - prob[i]);
        // dp[i + 1][0] = tail; // _ in all the i+1 coins the pro of getting all tails.
        // }
        dp[1][0] = (1 - prob[0]);
        dp[1][1] = prob[0];

        for (int x = 2; x <= n; x++) {
            for (int y = 0; y <= x; y++) {
                // _ take 1 head, when there is 1less heads
                if (y == 0)
                    dp[x][y] = dp[x - 1][0] * (1 - prob[x - 1]);
                else
                    dp[x][y] = (dp[x - 1][y - 1] * prob[x - 1]) + (dp[x - 1][y] * (1 - prob[x - 1]));
                // -> take 1 tails, when there is all heads are present
            }
        }
        Arrays.stream(dp).forEach(x -> System.out.println(Arrays.toString(x)));

        // *HOW TO FIND THE PROBABILITY OF GETTING MORE NUMBER OF HEADS
        double sum = 0;
        for (int i = (n + 1) / 2; i <= n; i++)
            sum += dp[n][i];

        return sum;
    }
}
