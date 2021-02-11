import AkPackage.*;
import java.util.*;

public class DeleteANodeFromBST {
    public static void main(String args[]) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new DeleteANodeFromBST());
        while (!lines.isEmpty()) {
            Tree root = InputOutput.createBinaryTree(InputOutput.ArrayListFromString(lines.remove(0)));
            int dataToDelete = Integer.parseInt(lines.remove(0));
            System.out.println("For the tree: ");
            Tree.inorderTraversal(root);
            System.out.println("\nAfter deleting the node: ");
            Tree.inorderTraversal(deleteBSTreeNode(root, dataToDelete));
        }
    }

    public static Tree deleteBSTreeNode(Tree root, int x) {
        if (root.data == x && root.left == null && root.right == null)
        return null;
        Tree nodeTodelete = Tree.searchInToBST(root, x);
        // node not found
        if (nodeTodelete.data != x)
            return root;
        // nodeTodelete is a leaf node itself.
        if (nodeTodelete.left==null && nodeTodelete.right==null) {
            nodeTodelete = null;
            return root;
        }
        Tree parent = null, curr = nodeTodelete;
        // shifting towards left side.
        while (curr.left != null && curr.right != null) {
            parent = curr;
            curr = curr.left; // moving towards the left child.
            int temp = curr.data;
            curr.data = parent.data;
            parent.data = temp;
        }
        // reach to the leaf==> curr
        if (curr.left == null && curr.right == null)
            parent = null;
        else
            parent.left = (curr.left != null) ? curr.left : curr.right;
        return root;
    }
}