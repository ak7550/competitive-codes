import java.util.Arrays;
import java.util.Scanner;

public class Grid1 {
    final static long mod = (long) 1e9 + 7;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int h = sc.nextInt(), w = sc.nextInt();

        char grid[][] = new char[h][w];
        for (int i = 0; i < grid.length; i++) {
            String str = sc.next();
            if (str.equals(""))
                str = sc.next();
            for (int j = 0; j < grid[0].length; j++) {
                grid[i][j] = str.charAt(j);
            }
        }

        System.out.println(findPaths2(grid, h, w));
    }

    public static long findPaths2(char grid[][], int height, int width) {
        long count[][] = new long[grid.length][grid[0].length];

        for (int i = 0; i < grid.length; i++)
            count[i][0] = grid[i][0] == '#' || (i>0 && count[i-1][0]==0) ? 0 : 1;
        for (int i = 0; i < grid[0].length; i++)
            count[0][i] = grid[0][i] == '#' || (i>0 && count[0][i-1] == 0) ? 0 : 1;

        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[0].length; j++) {
                if (grid[i][j] == '#')
                    count[i][j] = 0;
                else
                    count[i][j] = (count[i - 1][j] % mod + count[i][j - 1] % mod) % mod;
            }
        }
        return count[grid.length - 1][grid[0].length - 1] % mod;
    }

    public static long findPaths(char grid[][], int height, int width) {
        long facto[] = new long[height + width + 2];
        facto[1] = 1;
        facto[0] = 1;
        for (int i = 2; i < facto.length; i++)
            facto[i] = (facto[i - 1] * i) % mod;

        System.out.println("Factorial array: " + Arrays.toString(facto));
        long total = ncr(height + width - 2, width - 1, facto);
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (grid[i][j] == '#') { // wall
                    total -= ncr(height + width - 2 - (i + j), width - j - 1, facto);
                    total -= ncr(i + j, j, facto);
                }
            }
        }

        return total;
    }

    public static long ncr(long n, long r, long facto[]) {
        System.out.println("ncr for: " + n + " " + r);
        long div = ((facto[(int) r] % mod) * (facto[(int) (n - r)] % mod)) % mod;

        long ans = (facto[(int) n] % mod) * (fermat(div, mod - 2) % mod) % mod;
        System.out.println("Ans is: " + ans);
        return ans;
    }

    public static long fermat(long a, long b) {
        if (b == 1)
            return a;
        long val = fermat(a, b >> 1) % mod;
        val = (val * val) % mod;
        if ((b & 1) == 1) // odd
            val = (val * a) % mod;
        return val;
    }

}
