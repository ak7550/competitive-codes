import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import AkPackage.InputOutput;

/**
 * QueueReversal
 */
public class QueueReversal {

    public static void main(String[] args) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new QueueReversal());
        while (!lines.isEmpty()) {
            Queue<Integer> q = new LinkedList<>();
            InputOutput.ArrayListFromString(lines.remove(0)).forEach(x -> q.add(x));
            System.out.println("For Input: " + q);
            System.out.println("Output is: " + getResult(q));
        }
    }

    public static Queue<Integer> getResult(Queue<Integer> q) {
        Stack<Integer> st = new Stack<>();
        Iterator<Integer> it = q.iterator();
        while (it.hasNext()) {
            st.push(it.next());
            it.remove();
        }
        while (!st.empty())
            q.add(st.pop());
        return q;
    }
}