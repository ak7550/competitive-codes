import AkPackage.*;
import java.util.*;


public class Recurr {
    public static void main(String args[]) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new Recurr());
        while (!lines.isEmpty()) {
            String str = lines.remove(0);
            System.out.println("for ip: " + str);
            System.out.println("op: " + permutation("", str));
        }
    }

    public static ArrayList<String> permutation(String up, String p) {
        ArrayList<String> ans = new ArrayList<>();
        if (up.isEmpty()) {
            ans.add(p);
            return ans;
        }

        char ch = up.charAt(0);
        for (int i = 0; i <= p.length(); i++) {
            String f = p.substring(0, i),
                    s = p.substring(i, p.length());
            ans.addAll(permutation(f + ch + s, up.substring(1)));
        }

        
        return ans;
    }
}
