import java.util.*;

//Time complexity O(log(n)) & Space complexity: O(n)
public class PrimeFactorsv2 {

    public static void main(String[] args) {
        Integer n = 2245;
        Integer[] spf = new Integer[n + 1];
        sieve(n,spf);
        int arr[]=listToArray(primeFactors(n,spf));
        Arrays.sort(arr);
        System.out.println("Prime factors of " + n + " is: " + Arrays.toString(arr));
    }

    public static ArrayList<Integer> primeFactors(Integer x, Integer[] spf) {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        while (x != 1) {
            arr.add(spf[x]);
            x = x / spf[x];
        }
        return arr;
    }

    public static int[] listToArray(ArrayList<Integer> arr) {
        int a[] = new int[arr.size()];
        for (int i = 0; i < arr.size(); i++) {
            a[i] = arr.get(i);
        }
        return a;
    }

    // method to store the smallest prime factors of indexed number
    public static void sieve(Integer n, Integer[] spf) {
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
        // System.out.print(
        //         "Smallest prime factors of all the numbers from 0 to " + n + " is: " + Arrays.toString(spf));
    }
}