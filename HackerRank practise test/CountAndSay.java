import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class CountAndSay {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String str = sc.next();
            System.out.println("For Input: " + str);
            getCount(str);
            System.out.println();
        }
    }

    public static void getCount(String str) {
        HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
        for (char ch : str.toCharArray())
            hm.put(ch, hm.containsKey(ch) ? hm.get(ch) + 1 : 1);
        
        for (char x : str.toCharArray())
            if (hm.containsKey(x))
                System.out.print(x + "" + hm.remove(x));
    }
}
