import java.util.Scanner;

public class CoinFlip {
    public static void main(String[] args) throws java.lang.Exception {
        // your code goes here
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int g = sc.nextInt();
            while (g-- > 0) {
                int i = sc.nextInt(), n = sc.nextInt(), q = sc.nextInt();
                if (n % 2 == 0) {
                    System.out.println(n/2);
                }else{
                    System.out.println((i==1)?(q==1)?n/2:n/2+1:(q==1)?n/2+1:n/2);
                }
            }
        }
    }
}
