import java.util.Scanner;

public class SquareRoot {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number to get it's square root: ");
        int value = sc.nextInt();
        System.out.println("Closest Square root of " + value + " is: " + squareRoot(value));
    }

    public static int squareRoot(int n) {
        if (n < 0) {
            return -1;
        }
        return squareRoot(n, 0, n);
    }

    public static int squareRoot(int n, int low, int high) {
        int mid = low + (high - low) / 2;
        if (high >= low) {
            if (mid * mid == n) {
                return mid;
            } else if ((mid * mid) > n)
                return squareRoot(n, low, mid - 1);
            else
                return squareRoot(n, mid + 1, high);
        }
        return mid-1;
    }
}