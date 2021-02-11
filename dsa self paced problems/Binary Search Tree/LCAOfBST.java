import AkPackage.*;
import java.util.*;

public class LCAOfBST {
    public static void main(String args[]) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new LCAOfBST());
        while (!lines.isEmpty()) {
            Tree root = InputOutput.createBinaryTree(InputOutput.ArrayListFromString(lines.remove(0)));
            int n1 = Integer.parseInt(lines.remove(0)), n2 = Integer.parseInt(lines.remove(0));
            System.out.println("For the given tree: ");
            Tree.inorderTraversal(root);
            System.out.println("LCA of a " + n1 + " and " + n2 + " is: " + findlca(root, n1, n2).data);
        }
    }

    public static Tree findlca(Tree root, int n1, int n2) {
        if (root == null)
            return null;
        while (root != null) {
            if (root.data <= n1 && root.data >= n2 || root.data >= n1 && root.data <= n2)
                return root;
            else if (root.data < n1 && root.data < n2)
                root = root.right;
            else
                root = root.left;
        }
        return null;

    }
}