import java.util.ArrayList;
import java.util.Stack;

import AkPackage.InputOutput;

public class DeleteMidElement {
    public static void main(String[] args) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new DeleteMidElement());
        while (!lines.isEmpty()) {
            Stack<Integer> s = new Stack<Integer>();
            s.addAll(InputOutput.ArrayListFromString(lines.remove(0)));
            int length = (int) s.stream().count();
            System.out.println("For input: " + s);
            System.out.println("New output: " + getResult(s, length));
        }
    }

    public static Stack<Integer> getResult(Stack<Integer> s, int sizeOfStack) {
        Stack<Integer> st = new Stack<>();
        int count = 0;
        while (count != Math.ceil(sizeOfStack / 2)) {
            st.push(s.pop());
            count++;
        }
        s.pop();
        while (!s.empty())
            st.push(s.pop());
        while (!st.empty()) 
            s.push(st.pop());
        
        // s.addAll(st);
        return s;
    }
}
