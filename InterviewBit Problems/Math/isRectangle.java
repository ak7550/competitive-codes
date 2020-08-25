import java.util.Scanner;

/**
 * isRectangle
 */
public class isRectangle {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the individual lengths: ");
        int A = sc.nextInt(), B = sc.nextInt(), C = sc.nextInt(), D = sc.nextInt();
        System.out.println((check(A, B, C, D))? "rectangle" : "not a rectangle");
    }
    public static boolean check(int A, int B, int C, int D) {
        if (A == B && C == D || A == C && B == D || A == D && B == C)
            return true;
        else
            return false;
    }
}