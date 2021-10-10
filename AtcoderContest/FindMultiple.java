import java.beans.Transient;
import java.io.Serializable;
import java.util.*;

public class FindMultiple implements Serializable {
    public static void main(String args[]) {
        Transient Scanner sc = new Scanner(System.in);
        int a = sc.nextInt(), b = sc.nextInt(), c = sc.nextInt();
        if (c > b)
            System.out.println(-1);
        else {
            int i = 2, mul = c;
            while (mul < b) {
                if (mul >= a && mul <= b) {
                    System.out.println(mul);
                    break;
                } else
                    mul = c * i;
                i++;
            }
            if (mul > b)
                System.out.println(-1);
        }
    }
}