import AkPackage.*;
import java.util.*;

public class FoldableBT {
    public static void main(String args[]) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new FoldableBT());
        while (!lines.isEmpty()) {
            Tree root = InputOutput.createBinaryTree(InputOutput.ArrayListFromString(lines.remove(0)));
            System.out.println("The given tree: ");
            Tree.inorderTraversal(root);
            System.out.println(" ==> is" + (IsFoldable(root) ? "" : " not ") + " foldable");
        }
    }

    public static boolean IsFoldable(Tree root) {
        if (root == null)
            return true;
        root.left = mirrorTree(root.left);
        return checkEqual(root.left, root.right);
    }

    public static boolean checkEqual(Tree rl, Tree rr) {
        if (rl == null && rr == null)
            return true;
        if (rl == null && rr != null || rl != null && rr == null)
            return false;
        return checkEqual(rl.left, rr.left) && checkEqual(rl.right, rr.right);
    }
    public static Tree mirrorTree(Tree root) {
        if (root == null)
            return null;
        Tree right=root.right;
        root.right = root.left;
        root.left = right;
        mirrorTree(root.right);
        mirrorTree(root.left);
        return root;
    }
}