import AkPackage.Mathematics;

// Testcase 1:
// Input:  a = 3, m = 11
// Output: 4
// Since (4*3) mod 11 = 1, 4 is modulo inverse of 3
// One might think, 15 also as a valid output as "(15*3) mod 11" 
// is also 1, but 15 is not in ring {0, 1, 2, ... 10}, so not valid.

// ax+my=gcd(a,m)
// ==> modulo dividing both side by m

// ax%m + 0 = gcd(a,m)%m

// to get the value modulo multiplicative inverse gcd(a,m) = 1, they need to be 

// ==>ax%m = 1%m
// ==> ax%m = 1
// now find the value of x

public class MultiplicativeModulo {
    public static void main(String[] args) {
        int a = 3, m = 11;
        if (Mathematics.gcd(a, m) != 1) {
            System.out.println("Multiplicative inverse of " + a + " under " + m + " is not possible.");
        } else {
            int am = a % m;
            for (int i = 1; i < m; i++) {
                if ((am * i) % m == 1) {
                    System.out.println("Multiplicative modulo of " + a + " under " + m + " is: " + i);
                    break;
                }
            }
        }
    }
}