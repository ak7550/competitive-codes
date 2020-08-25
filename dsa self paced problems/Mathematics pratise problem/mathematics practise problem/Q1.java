/**
 * Q1
 */
public class Q1 {
    public static void main(String[] args) {
        int n = 20;
        System.out.print("Sum of Proper Divisors of " + n + " is: " + sumOfProperDivisors(n));
    }

    public static int sumOfProperDivisors(int n) {
        int sum = 0;
        System.out.println("Divisors are: ");
        for (int i = 2; i <= n / i; i++) {
            if (n % i == 0) {
                sum += i;
                System.out.print(i + " ");
                if (n / i != i) {// wont add theh same thing in case of square root
                    sum += (n / i);
                    System.out.print(n / i + " ");
                }
            }
        }
        return sum + 1;
    }
}

// time complexity= O(sqrt(n))