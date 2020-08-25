public class countDivisors {
    public static void main(String[] args) {
        int n = 30, count = 0;
        for (int i = 1; i <= n / i; i++) {
            if (n % i == 0) {
                count += 2;
                if (n / i == i)
                    count--;
            }
        }
        System.out.println("Number of divisors are: " + count);
    }
}