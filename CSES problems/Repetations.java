import java.util.Scanner;

public class Repetations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // System.out.println("Enter the string: ");
        String str = sc.nextLine();
        int repetation = getResult(str);
        System.out.println(repetation);
    }

    public static int getResult(String str) {
        int sum = 1, maxSum = 0;
        for (int i = 0; i < str.length() - 1; i++) {
            if (str.charAt(i) == str.charAt(i + 1)) {
                sum++;
            } else {
                if (maxSum < sum) {
                    maxSum = sum;
                }
                sum = 1;
            }
        }
        if (maxSum < sum) {
            maxSum = sum;
            sum = 1;
        }
        return maxSum;
    }
}