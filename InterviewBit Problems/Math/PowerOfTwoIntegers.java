import java.util.Scanner;

public class PowerOfTwoIntegers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number: ");
        int ans = isPower(sc.nextInt());
        System.out.println("Ans is: "+ans);
    }
    
    public static int isPower(int A) {
        if (A < 1) {
            return 0;
        }
        if (A == 1) {
            return 1;
        }
        for (int i = 2; i <= Math.sqrt(A); i++) {
            double p = Math.log(A) / Math.log(i);
            if ((p-(int)p)<0.00000001) {
                // if it's a natural number then ceiling and the floor value will be same
                return 1;
            }
                
        }
        return 0;
    }
    public static double log(int a) {
        return (double) (Math.log10(a) / Math.log10(2));
    }
}