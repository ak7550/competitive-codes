import java.util.ArrayList;

import AkPackage.InputOutput;

/**
 * AddOneToNumber
 */
public class AddOneToNumber {

    public static void main(String[] args) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new AddOneToNumber());
        while (!lines.isEmpty()) {
            ArrayList<Integer> line = InputOutput.ArrayListFromString(lines.remove(0));
            System.out.println("For Input " + line);
            System.out.println("Ans is: " + addOne2(line));
        }
    }

    public static ArrayList<Integer> addOne2(ArrayList<Integer> A) {
        ArrayList<Integer> ans = new ArrayList<Integer>();
        while (A.get(0).equals(0)) {
            A.remove(0);
        } // removing all the not important zeroes. /
        int i = A.size() - 1, carry = 1;
        do {
            int digit = A.get(i) + carry;
            carry = digit / 10;
            digit %= 10;
            ans.add(0, digit);
            i--;
        } while (i >= 0); // check we are getting a carry and i has not reached to the start
        if (carry != 0 && i < 0) { // check if we are reached to the start and and carry is still 1.
            ans.add(0, carry);
        }
        return ans;
    }
}