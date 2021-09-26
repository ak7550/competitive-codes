// import AkPackage.*;
import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class patter {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), count = 0;
        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            if (check(num) != -1)
                count++;
        }
        System.out.println(count);
    }

    public static int check(int num) {
        int left = 1, right = num, ans = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (mid * mid * mid == num)
                return mid;
            if (mid * mid * mid < num) {
                left = mid + 1;
                ans = mid;
            }
            else
                right = mid - 1;
        }
        return -1;
    }
}