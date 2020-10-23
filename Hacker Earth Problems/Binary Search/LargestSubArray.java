import java.util.ArrayList;

import AkPackage.InputOutput;

public class LargestSubArray {
    public static void main(String[] args) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new LargestSubArray());
        if (!lines.isEmpty()) {
            int n = InputOutput.arrayFromString(lines.remove(0))[0];
            String str = lines.remove(0);
            System.out.println("For input: " + str);
            System.out.println("Length of largest sub String: " + getResult(str));
        }
    }

    public static int getResult(String str) {
        int staringIndex = 0, endingIndex = 0, zero = 0, one = 0, maxLength = 0, temp = 0;
        boolean isZero;
        for (int i = 0; i < str.length(); i++) {
            isZero = str.charAt(i) == '0';
            if (isZero) {
                zero++;
            } else {
                one++;
            }
            if (one > zero) {
                endingIndex = i - 1;
                staringIndex = temp;
                temp = i;
                maxLength = Math.max(maxLength, endingIndex - staringIndex + 1);
                if (isZero) {
                    zero = 1;
                    one = 0;
                } else {
                    zero = 0;
                    one = 1;
                }
            }

        }
        return Math.max(maxLength, str.length() - temp);
    }
}
