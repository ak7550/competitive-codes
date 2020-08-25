import java.util.Arrays;
import java.util.Scanner;

public class nextSimiliarNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number: ");
        String str = sc.nextLine();
        String bigNumber = getResult(str);
        System.out.println("Biggest NUmber is: " + bigNumber);
    }

    public static String getResult(String A) {
        char ch[] = A.toCharArray();
        int inconsistence = ch.length;
        for (int i = ch.length - 1; i > 0; i--) {
            char right = ch[i], left = ch[i - 1];
            if (right > left) {
                inconsistence = i - 1;
                break;
            }
        }
        if (inconsistence < ch.length - 1) {
            // try to apply binary search

            if (inconsistence < ch.length - 1) {
                // better to use linear search from right mot end
                int index = binSearch(ch, inconsistence + 1, ch.length - 1, ch[inconsistence]);
                char temp = ch[inconsistence];
                ch[inconsistence] = ch[index];
                ch[index] = temp;
                reverse(ch, inconsistence + 1, ch.length - 1);
                String str = "";
                for (char c : ch) {
                    str += c;
                }
                return str;
            } else
                return "-1";
        }
        return null;
    }

    // giving some issue in case of bigger values
    public static int binSearch(char[] ch, int start, int end, char key) {
        while (start<=end) {
            int mid = start + (end - start) / 2;
            if (ch[mid] > key) {  
                if (mid == ch.length - 1) {
                    return mid;
                }  
                if (ch[mid + 1] <= key) {
                    return mid;
                }
            }
            if (ch[mid]<key) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }
	public static void reverse(char[] ch, int start, int end) {
        while (start<end) {
            char temp = ch[start];
            ch[start++] = ch[end];
            ch[end--] = temp;
        }
    }
}