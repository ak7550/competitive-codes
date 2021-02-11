import AkPackage.*;
import java.util.*;

public class CheckSubTree {
    public static void main(String args[]) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new CheckSubTree());
        while (!lines.isEmpty()) {
            Tree t =  InputOutput.createBinaryTree(InputOutput.ArrayListFromString(lines.remove(0))),
                    s =  InputOutput.createBinaryTree(InputOutput.ArrayListFromString(lines.remove(0)));
            Tree.inorderTraversal(t);
            System.out.print(" ==> " + (isSubtree(t, s) ? "" : "not ") + "a subtree of ==> ");
            Tree.inorderTraversal(s);
            System.out.println();
        }
    }

    public static boolean isSubtree(Tree t, Tree s) {
        if (t == null && s == null)
            return true;
        if ((t == null && s != null) || (t != null && s == null))
            return false;
        // considering same numbers are present at different different Trees.
        if (t.data == s.data) {
            boolean ans = isSubtree(t.left, s.left) && isSubtree(s.right, t.right);
            return ans ? ans : isSubtree(t.left, s) || isSubtree(t.right, s);
        } else
            return isSubtree(t.left, s) || isSubtree(t.right, s);
    }
}
