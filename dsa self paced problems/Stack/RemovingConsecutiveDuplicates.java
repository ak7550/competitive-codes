import java.util.ArrayList;
import java.util.Stack;

import AkPackage.InputOutput;

/**
 * RemovingConsecutiveDuplicates
 */
public class RemovingConsecutiveDuplicates {

    public static void main(String[] args) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new RemovingConsecutiveDuplicates());
        while (!lines.isEmpty()) {
            String str = lines.remove(0);
            System.out.println("For input: " + str);
            System.out.println("Output is: " + getResult(str));
        }
    }

    public static String getResult(String str) {
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            if (st.empty())
                st.push(str.charAt(i));
            else if (st.peek().equals(str.charAt(i)))
                st.pop();
            else
                st.push(str.charAt(i));
        }
        StringBuilder sb = new StringBuilder();
        st.forEach(x -> sb.append(x));
        return sb.toString();
    }
}