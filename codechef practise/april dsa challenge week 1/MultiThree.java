import java.util.Scanner;

public class MultiThree {
    public static void main(String[] args) throws java.lang.Exception {
        // your code goes here
        try {
            Scanner sc = new Scanner(System.in);
            int T = sc.nextInt();
            while (T-- > 0) {
                long k = sc.nextLong();
                int d0 = sc.nextInt(), d1 = sc.nextInt();
                if (d0 + d1 == 10) {
                    System.out.println("NO");
                } else {
                    if (k == 2) {
                        System.out.println((d0 + d1) % 3 == 0 ? "YES" : "NO");
                    } else if (k == 3) {
                        System.out.println((d0 + d1 + (d0 + d1) % 10) % 3 == 0 ? "YES" : "NO");
                    } else {
                        long sum = d0 + d1 + (d0 + d1) % 10;
                        long pairs = (k - 3) / 4, remain = (k - 3) % 4;
                        sum += 20 * Math.floor(pairs);
                        System.out.println("max long: " + Long.MAX_VALUE);
                        System.out.println("After multiplying the sum is: " + sum);
                        if (remain == 0) {
                            System.out.println(sum % 3 == 0 ? "YES" : "NO");
                        } else {
                            int d2 = (d0 + d1) % 10;
                            int d3 = (d0 + d1 + d2) % 10;
                            int d4 = (d0 + d1 + d2 + d3) % 10;
                            int d5 = (d0 + d1 + d2 + d3 + d4) % 10;
                            if (remain == 1)
                                sum += d3;
                            else if (remain == 2)
                                sum += (d3 + d4);
                            else if (remain == 3)
                                sum += (d3 + d4 + d5);
                            System.out.println(sum % 3 == 0 ? "YES" : "NO");
                        }
                    }
                }
            }
        } catch (Exception e) {
            System.exit(0);
        }
    }
}