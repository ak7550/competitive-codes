import AkPackage.*;
import java.util.*;


public class CountTheReversal {
    public static void main(String args[]) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new CountTheReversal());
        while (!lines.isEmpty()) {
            String str = lines.remove(0);
            System.out.println("For input: " + str + '\n' + "o/p: " + countReverse(str));
        }
    }

    public static int countReverse(String s) {
        if ((s.length() & 1) == 1)
            return -1;
        LinkedList<Character> st = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (st.isEmpty())
                st.add(ch);
            else if (ch == '{')
                st.add(ch);
            else { // '}'
                if (st.isEmpty() || st.peekLast() == '}')
                    st.add(ch);
                else if (st.peekLast() == '{')
                    st.pollLast();

            }

        }
        return st.size() >> 1;
    }
}