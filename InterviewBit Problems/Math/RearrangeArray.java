import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import AkPackage.Array;
import AkPackage.CompetetiveCoding;

/**
 * RearrangeArray
 */
public class RearrangeArray {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the length of the Array: ");
        Integer n = sc.nextInt();
        ArrayList<Integer> arr = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            arr.add(sc.nextInt());
        }
        System.out.println("For input: " + arr);
        arrange(arr);
        System.out.print("Output: "+arr);
    }

    public static void arrange(ArrayList<Integer> a) {
        for (int i = 0; i < a.size(); i++) {
            a.set(i, (a.get(i) + (a.get(a.get(i) % a.size())) * a.size()));
        }
        for (int i = 0; i < a.size(); i++) {
            int a1 = a.get(i);
            int value = a1 / a.size();
            a.set(i, value % a.size());
        }
    }
}