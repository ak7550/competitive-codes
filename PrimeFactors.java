/**
 * PrimeFactors
 */

 // Time complexity: O(sqrt(n))
public class PrimeFactors {
    public static void main(String[] args) {
        int n=100;
        int no=n;
        System.out.print("Prime factors are: ");
        for (int i = 2; i < Math.sqrt(no); i++) {
            while(n%i==0)
            {
                System.out.print(i+" ");
                n/=i;
            }
        }
    }
}