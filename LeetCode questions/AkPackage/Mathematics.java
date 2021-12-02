package AkPackage;

import java.util.*;

// checking have not done yet. merging with master yet to be done
public class Mathematics {
    public static long mod = (long) Math.pow(10, 9) + 7;

    public static long[][] matrixPow(long mat[][], int n) {
        if (n == 1)
            return mat;
        long ans[][] = matrixPow(mat, n >> 1);

        return (n & 1) == 1 ? matrixMultiply(ans, mat) : matrixMultiply(ans, ans);
    }

    public static long[][] matrixMultiply(long A[][], long B[][]) {
        int row1 = A.length, col2 = B[0].length, row2 = A[0].length;
        long C[][] = new long[row1][col2];

        for (int i = 0; i < row1; i++) {
            for (int j = 0; j < col2; j++) {
                for (int k = 0; k < row2; k++)
                    C[i][j] = (C[i][j] + (A[i][k] * B[k][j]) % mod) % mod;
            }
        }

        return C;
    }

    public static int gcd(int no, int div) {
        if (div == 0)
            return no;
        return gcd(div, no % div);
    }

    public static int lcd(int a, int b) {
        return (a * b) / gcd(a, b);
    }

    public static long factorial(int n) {
        return n <= 1 ? 1 : (n * factorial(n - 1)) % mod;
    }

    public static int lcd(int arr[]) {
        if (arr.length <= 1) {
            System.out.println("LCD of a single number " + arr[0] + " is not possible.");
            return 0;
        }
        int product = 1;
        for (int i : arr) {
            product *= i;
        }
        return product / gcd(arr);
    }

    public static int gcd(int arr[]) {
        if (arr.length <= 1) {
            System.out.println("GCD of a single number " + arr[0] + " is not possible.");
            return 0;
        }
        int gcd = gcd(arr[0], arr[1]);
        for (int i = 2; i < arr.length; i++) {
            gcd = gcd(arr[i], gcd);
        }
        return gcd;
    }

    public static int[] gcdExtended(int no, int div) {
        int[] arr = new int[3];
        if (div == 0) {
            arr[0] = no;
            arr[1] = 0; // x
            arr[2] = 1; // y
            return arr;
        }
        arr = gcdExtended(div, no % div);
        int x1 = arr[1], y1 = arr[2];
        arr[1] = (int) (y1 - Math.floor(no / div) * x1);
        arr[2] = x1;
        // System.out.println("The array is: " + Arrays.toString(arr));
        return arr; // gcd=arr[0], x=arr[1], y=arr[2]
    }

    public static Integer[] getSieveTable(int n) {
        Integer[] spf = new Integer[n + 1];
        for (Integer i = 0; i <= n; i++) {
            spf[i] = i;
        }
        // separately marking spf for every even number as 2
        for (Integer i = 4; i <= n; i += 2) {
            spf[i] = 2;
        }
        for (Integer i = 3; i * i <= n; i++) {
            if (spf[i] == i) // that means i is a prime number as of now, replace all the multiples of i with
                             // i
            {
                for (Integer j = i * i; j <= n; j += i) {
                    // marking spf[j]=i
                    spf[j] = i;
                }
            }
        }
        return spf;
    }

    public static ArrayList<Integer> primeFactors(Integer x) {
        Integer[] spf = getSieveTable(x);
        ArrayList<Integer> arr = new ArrayList<Integer>();
        while (x != 1) {
            arr.add(spf[x]);
            x = x / spf[x];
        }
        return arr;
        // Time complexity O(log(n)) & Space complexity: O(n)
    }

    public static ArrayList<Integer> getFactors(int n) {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        for (int i = 1; i <= n / i; i++) {
            if (n % i == 0) {
                arr.add(i);
                if (n / i != i) // wont add theh same thing in case of square root
                    arr.add(n / i);
            }
        }
        return arr;
    }
}