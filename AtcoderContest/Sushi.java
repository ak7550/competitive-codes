import java.util.Scanner;

public class Sushi {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sushi[] = new int[sc.nextInt()];
        for (int i = 0; i < sushi.length; i++)
            sushi[i] = sc.nextInt();

        System.out.println(getAns(sushi));
    }

    public static double getAns(int sushi[]) {
        
    }
}
