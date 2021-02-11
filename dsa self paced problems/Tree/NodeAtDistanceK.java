import AkPackage.*;
import java.util.*;


public class NodeAtDistanceK {
    public static void main(String args[]) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new NodeAtDistanceK());
        while (!lines.isEmpty()) {
            Tree root = InputOutput.createBinaryTree(InputOutput.ArrayListFromString(lines.remove(0)));
            int k = Integer.parseInt(lines.remove(0));
            System.out.println("For the given tree: ");
            Tree.inorderTraversal(root);
            System.out.println("node at distacne k are: " + printKDistantfromLeaf(root, k));
        }
    }

    static int count;
    static ArrayList<Boolean> st;
    public static int printKDistantfromLeaf(Tree root, int k) {
        count = 0;
        st = new ArrayList<Boolean>();
        st.add(0, false);
        getResult(root, k);
        return count;
    }

    public static void getResult(Tree root, int k) {
        if (root == null)
            return;
        // indication of a leaf node
        if (root.left == null && root.right == null) {
            if (st.size() > k && !st.get(k)) {
                count++;
                st.set(k, true);
            }
            return;
        }
        st.add(0, false);
        getResult(root.left, k);
        st.remove(0);
        st.add(0, false);
        getResult(root.right, k);
        st.remove(0);
    }
}