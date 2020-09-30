
import java.util.*;

class SquareTransaction {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        long arr[] = new long[(int) T];
        long sum = 0;
        ;
        for (int i = 0; i < T; i++) {
            arr[i] = sc.nextInt();
            sum += arr[i];
            arr[i] = sum;
        }
        int Q = sc.nextInt();
        for (int i = 0; i < Q; i++) {
            int t = sc.nextInt();
            boolean found = false;
            for (int j = 0; j < arr.length; j++) {
                if (arr[j] >= t) {
                    found = true;
                    System.out.print(j + 1);
                    break;
                }
            }
            System.out.println((found) ? "" : "-1");
        }

    }
}
