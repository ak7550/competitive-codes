import java.util.Scanner;

/**
 * BishuAndSoldiers
 */
public class BishuAndSoldiers {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int soldiers = sc.nextInt();
        int powers[] = new int[soldiers];
        for (int i = 0; i < powers.length; i++) {
            powers[i] = sc.nextInt();
        }
        // i represents rounds
        int rounds=sc.nextInt();
        for (int i = 0; i < rounds; i++) {
            int powerOfBishu = sc.nextInt(), kill = 0, sum = 0;
            for (int powerOfSoldier : powers) {
                if (powerOfSoldier <= powerOfBishu) {
                    kill++;
                    sum += powerOfSoldier;
                }
            }
            System.out.println(kill + " " + sum);
            kill = 0;
            sum = 0;
        }
        sc.close();
    }
}