import AkPackage.*;
import java.util.*;

class Pair2 {
    int pos;
    Tree node;

    Pair2(int p, Tree r) {
        pos = p;
        node = r;
    }
}

public class VerticalOrderTraversalOFBT {
    public static void main(String args[]) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new VerticalOrderTraversalOFBT());
        while (!lines.isEmpty()) {
            Tree root = InputOutput.createBinaryTree(InputOutput.ArrayListFromString(lines.remove(0)));
            System.out.println("For the given tree: ");
            Tree.levelorderTraversal(root);
            System.out.println("\nVertical traversal result is: " + verticalOrder(root));
        }
    }

    public static ArrayList<Integer> verticalOrder(Tree root) {
        TreeMap<Integer, ArrayList<Integer>> tm = new TreeMap<Integer, ArrayList<Integer>>();
        ArrayDeque<Pair2> ar = new ArrayDeque<>();
        if (root == null)
            return null;
        ar.add(new Pair2(0, root));
        ArrayList<Integer> a = new ArrayList<Integer>();
        a.add(root.data);
        tm.put(0, a);
        while (!ar.isEmpty()) {
            Pair2 pair = ar.poll();
            int pos = pair.pos;
            Tree temp = pair.node;
            if (temp.left != null) {
                if (tm.containsKey(pos - 1))
                    a = tm.get(pos - 1);
                else
                    a = new ArrayList<>();
                a.add(temp.left.data);
                ar.add(new Pair2(pos - 1, temp.left));
                tm.put(pos - 1, a);
            }
            if (temp.right != null) {
                if (tm.containsKey(pos + 1))
                    a = tm.get(pos + 1);
                else
                    a = new ArrayList<>();
                a.add(temp.right.data);
                ar.add(new Pair2(pos + 1, temp.right));
                tm.put(pos + 1, a);
            }
        }
        ArrayList<Integer> arr = new ArrayList<Integer>();
        for (Map.Entry<Integer, ArrayList<Integer>> e : tm.entrySet()) {
            arr.addAll(e.getValue());
        }
        return arr;
    }

}