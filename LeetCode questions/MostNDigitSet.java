import AkPackage.*;
import java.util.*;
//!Wrong code
public class MostNDigitSet {
    public static void main(String args[]) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new MostNDigitSet());
        while (!lines.isEmpty()) {
            String digits[] = lines.remove(0).split(" ");
            int n = InputOutput.ArrayListFromString(lines.remove(0)).get(0);

            System.out.println("For ip:" + Arrays.toString(digits) + " " + n);
            System.out.println("op: " + atMostGivenDigitSet(digits, n));
        }
    }

    public static int atMostGivenDigitSet(String digits[], int n) {
        String limit = Integer.toString(n);
        int totalDigit = limit.length();
        // any number that has less number of digits than digit are valid.
        int count = 0;
        count += digits.length * ((Math.pow(digits.length, totalDigit - 1) - 1) / (digits.length - 1));
        if (digits.length == 1)
            count = 1;
        for (int i = 0; i < totalDigit; i++) {
            String number = limit.charAt(i) + "";
            int index = findIndex(digits, number);
            if (index == digits.length) {
                int ele = index, pos = totalDigit - i;
                count += Math.pow(ele, pos);
                break;
            } else if (index != digits.length && !digits[index].equals(number)) {
                int remainingPos = totalDigit - i,
                        remainingEle = index;
                count += (int) Math.pow(remainingEle, remainingPos);
                // break;
            } else { // same
                int remainingPos = totalDigit - 1 - i,
                        remainingEle = index;
                count += remainingEle * (int) Math.pow(digits.length, remainingPos);

                count += (i + 1) == totalDigit ? 1 : 0;
            }
        }
        return count;
    }

    public static int findIndex(String digits[], String number) {
        int start = 0, end = digits.length - 1;
        int ans = end + 1;
        while (start <= end) {
            int mid = start + ((end - start) >> 1);
            if (digits[mid].equals(number))
                return mid;
            else if (digits[mid].compareTo(number) < 0)
                start = mid + 1;
            else {
                ans = mid;
                end = mid - 1;
            }
        }
        return ans;
    }
}