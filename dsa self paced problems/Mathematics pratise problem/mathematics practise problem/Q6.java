
public class Q6 {
    public static void main(String[] args) {
        int n = 10000,m=2;
        System.out.print("Prime number from "+m+"  to " + n + " are: ");
        Integer[] spf = new Integer[n + 1];
        for (Integer i = 0; i <= n; i++) {
            spf[i] = i;
        }
        // separately marking spf for every even number as 2
        for (Integer i = 4; i <= n; i += 2) {
            spf[i] = 2;
        }
        for (Integer i = 3; i * i <= n; i++) {
            if (spf[i] == i) // that means i is a prime number as of now, replace all the multiples of i with i
            {
                for (Integer j = i * i; j <= n; j += i) {
                    // marking spf[j]=i
                    spf[j] = i;
                }
            }
        }
        for (int i = m; i < spf.length; i++) {
            if (spf[i] == i) {
                System.out.print(i + " ");
            }
        }
    }
}
//time complexity = O(n), to generate sieve table=O(nloglogn)