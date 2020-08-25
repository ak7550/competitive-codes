public class Q4 {
    public static void main(String[] args) {
        int a = 325, b = 265, n = 1231232;
        System.out.println("XORinacci of f(" + n + ") is: " + XORinacci(a, b, n));
    }

    public static int XORinacci(int a, int b, int n) {
        int sum = a ^ b;
        if (n == 0) {
            return a;
        }
        if (n == 1) {
            return b;
        }
        for (int i = 3; i <= n; i++) {
            a = b;
            b = sum;
            sum = a ^ b;
        }
        return sum;
    }
}

// Time Complexity: O(n)