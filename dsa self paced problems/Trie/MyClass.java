import java.util.*;

public class MyClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine().toLowerCase();
        // System.out.println(str);

        HashSet<Character> hs = new HashSet<>();

        for (int i = 0; i < 26; i++)
        hs.add((char) ('a' + i));

        for (int i = 0; i < str.length(); i++)
        hs.remove(str.charAt(i));

        if (hs.size() == 0)
            System.out.println(0);
            else {
                for (Character ch : hs)
                System.out.print(ch);
            }

        }
}

// public static void main(String[] args) {
// Scanner sc = new Scanner(System.in);
// int n1 = sc.nextInt(), n2 = sc.nextInt(), x = sc.nextInt();

// if (n1 >= n2)
// System.out.println(-1);
// else {
// int relative = n2 - n1;
// int time = x / relative;
// System.out.println((time * relative <= x) ? time + 1 : time);
// }
// }