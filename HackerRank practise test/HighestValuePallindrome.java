import AkPackage.*;
import java.util.*;


public class HighestValuePallindrome {
    public static void main(String args[]) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new HighestValuePallindrome());
        while (!lines.isEmpty()) {
            String arr[] = lines.remove(0).split(" ");
            String s = arr[0];
            int k = Integer.parseInt(arr[1]);
            System.out.println("For Input: " + s + " " + k);
            System.out.println("O/P: " + highestPall(s, k));
        }
    }

    public static String highestPall(String s, int k) {
        int n = s.length();
        StringBuilder str = new StringBuilder(s);
        int left = 0, right = n - 1;

        while (left < right && k > 0) {
            if (str.charAt(left) != str.charAt(right)) {
                k -= 1;
                int max = Math.max(Integer.parseInt(str.charAt(left) + ""), Integer.parseInt(str.charAt(right) + ""));
                str.replace(left, left + 1, max + "");
                str.replace(right, right + 1, max + "");
            }
            left++;
            right--;
        }

        // 3possibilities ==> i) left==right && k>0
        // ii) k==0
        // iii) left == right && k<=0

        if (left >= right && k > 0) {
            // that means the string is pall already
            left = 0;
            right = n - 1;

            while (left <= right && k > 0) {
                if (left != right && k-2>=0) {
                    str.replace(left, left + 1, 9 + "");
                    str.replace(right, right + 1, 9 + "");
                    k -= 2;
                } else if(left == right) {
                    k--;
                    str.replace(left, left + 1, 9 + "");
                }
                left++;
                right--;
            }
            return str.toString();
        }

        else {
            // i cant change anything any more
            String res = str.reverse().toString();
            str.reverse();
            return res.compareTo(str.toString()) == 0 ? str.toString() : "-1";
        }

    }
}