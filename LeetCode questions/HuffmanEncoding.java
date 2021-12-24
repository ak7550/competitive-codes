import AkPackage.*;
import java.util.*;

public class HuffmanEncoding {
    public static void main(String args[]) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new HuffmanEncoding());
        while (!lines.isEmpty()) {
            String str = lines.remove(0);
            int fre[] = InputOutput.arrayFromString(lines.remove(0));

            System.out.println("For ip: " + str + "\nfre: " + Arrays.toString(fre));
            System.out.println("o/p: " + huffmanCodes(str, fre));
        }
    }

    static class Node {
        Character ch = null;
        Node left, right;
        int val;

        public Node(Character c, int v) { // leaf node
            ch = c;
            val = v;
        }

        // -> internal node
        public Node(Node a, Node b) {
            val = a.val + b.val;
            left = a;
            right = b;
        }
    }

    // => If two elements have same frequency, then the element which occur at first
    // => will be taken on the left of Binary Tree and other one to the right.
    public static ArrayList<String> huffmanCodes(String str, int fre[]) {
        if (str.length() == 1)
            return new ArrayList<>();
        // !problem occurs when both of the nodes are having the same frequencies
        PriorityQueue<Node> pq = new PriorityQueue<Node>((a, b) -> a.val == b.val ? 1 : a.val - b.val);
        for (int i = 0; i < fre.length; i++)
            pq.add(new Node(str.charAt(i), fre[i]));

        while (pq.size() > 1)
            pq.add(new Node(pq.poll(), pq.poll()));

        // now we have only 1 node into the pq
        ArrayList<String> ans = new ArrayList<>();
        preOrder(pq.poll(), new StringBuilder(), ans);

        return ans;
    }

    public static void preOrder(Node root, StringBuilder str, ArrayList<String> ans) {
        if (root.ch != null) {
            ans.add(str.toString());
            return;
        }
        preOrder(root.left, str.append(0), ans);
        str.deleteCharAt(str.length() - 1);
        preOrder(root.right, str.append(1), ans);
        str.deleteCharAt(str.length() - 1);
    }
}