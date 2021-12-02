import java.util.Scanner;

class State {
    int value;
    String name;

    public State(int v, String n) {
        value = v;
        name = n;
    }
}

public class Vacation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n], b[] = new int[n], c[] = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            b[i] = sc.nextInt();
            c[i] = sc.nextInt();
        }

        System.out.println(maximumPossibletotalPoint(a, b, c));
    }

    public static long maximumPossibletotalPoint(int a[], int b[], int c[]) {
        long chooseA[] = new long[a.length], chooseB[] = new long[a.length], chooseC[] = new long[c.length];

        chooseA[0] = a[0];
        chooseB[0] = b[0];
        chooseC[0] = c[0];
        for (int i = 1; i < a.length; i++) {
            chooseA[i] = Math.max(chooseB[i - 1], chooseC[i - 1]) + a[i];
            chooseB[i] = Math.max(chooseA[i - 1], chooseC[i - 1]) + b[i];
            chooseC[i] = Math.max(chooseA[i - 1], chooseB[i - 1]) + c[i];
        }

        return Math.max(chooseA[a.length - 1], Math.max(chooseB[a.length - 1], chooseC[a.length - 1]));
    }

}
