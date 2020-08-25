import java.util.Scanner;

public class ReverseInteger {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number: ");
        int n = sc.nextInt();
        System.out.print("Reverse value of " + n + " is: " + getReverse(n));
    }

    public static int getReverse(int n) {
        if (n < 0) {
            return getReverse(Math.abs(n)) * (-1);
        }
        long sum = 0;
        while (n > 0) {
            int lastDigit = n % 10;
            if (sum * 10 > Integer.MAX_VALUE)
                return 0;
            sum = (sum * 10);
            sum += lastDigit;
            n /= 10;
        }
        System.out.println(Integer.MIN_VALUE / 2);
        return (int)sum;
    }
}