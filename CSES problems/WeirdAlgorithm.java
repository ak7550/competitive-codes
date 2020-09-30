import java.util.Scanner;

/**
 * WeirdAlgorithm
 */
public class WeirdAlgorithm {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        getResult(n);
    }
    public static void getResult(long n) {
        while (n != 1) {
            System.out.print(n+" ");
            if (n % 2 == 0) {
                n /= 2;
            } else {
                n = n * 3 + 1;
            }
        }
        System.out.print(n);
    }
}