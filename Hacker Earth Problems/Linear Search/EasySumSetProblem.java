import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 * EasySumSetProblem
 */
public class EasySumSetProblem {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the length of a: ");
        int an = sc.nextInt();
        System.out.println("Enter the value of a one by one: ");
        int a[] = new int[an];
        for (int i = 0; i < a.length; i++) {
            a[i] = sc.nextInt();
        }
        System.out.println("Enter the length of s: ");
        int sn = sc.nextInt();
        int s[] = new int[sn];
        System.out.println("Enter the value of s one by one: ");
        for (int i = 0; i < s.length; i++) {
            s[i] = sc.nextInt();
        }
        ArrayList<Integer> b = getResult(a, s);
        System.out.println("For input: \na= " + Arrays.toString(a) + "\ns= " + Arrays.toString(s) + "\nb= " + b);
    }

    public static ArrayList<Integer> getResult(int a[], int s[]) {
        ArrayList<Integer> b = new ArrayList<Integer>();
        Arrays.sort(a);
        Arrays.sort(s);
        // int min = s[0], max = s[s.length - 1];
        int hash[] = new int[s[s.length-1] + 1];
        Arrays.fill(hash, 0);
        for (int i = 0; i < s.length; i++) {
            hash[s[i]] = s[i];
        }
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < s.length; j++) {
                b.add(s[j] - a[i]);
            }
        }
        Collections.sort(b);
        // removing the negatives
        while (b.get(0) < 0) {
            b.remove(0);
        }
        // removing the same element
        for (int i = 0; i < b.size() - 1; i++) {
            if (b.get(i).equals(b.get(i + 1))) {
                b.remove(i + 1);
                i--;
            }
        }
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b.size(); j++) {
                if (a[i] + b.get(j) >= hash.length) {
                    b.remove(j);
                    j--;
                    continue;
                }
                if (hash[a[i] + b.get(j)] == 0) {
                    b.remove(j);
                    j--;
                }
            }
        }
        return b;
    }
}