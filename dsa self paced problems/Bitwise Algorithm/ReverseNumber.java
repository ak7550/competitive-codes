import AkPackage.*;
import java.util.*;


public class ReverseNumber {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println("For: " + n);
        System.out.println("Ans: "+ reverse(n));
    }

    public static int reverse(int n) {
        int num = 0, pow=1;
       for (int i = 0; i < 32; i++) {
           num <<= 1;
           num = (n & pow) == pow ? 1 : 0;
           pow = 10;
       }
        return num;
    }
}