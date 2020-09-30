import java.util.Scanner;

public class GoldenRectangle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        long count = 0;
        while (t-- > 0) {
            float a = sc.nextFloat(), b = sc.nextFloat();
            float w = Math.max(a, b), h = Math.min(a, b);
            double ratio=w/h;
            if (ratio>=1.6 && ratio<=1.7) {
                count++;
            }
        }
        System.out.println(count);
    }
}