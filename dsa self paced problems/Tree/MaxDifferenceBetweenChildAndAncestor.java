import AkPackage.*;
import java.util.*;

public class MaxDifferenceBetweenChildAndAncestor {
    public static void main(String args[]) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new MaxDifferenceBetweenChildAndAncestor());
        while (!lines.isEmpty()) {
            Tree root = InputOutput.createBinaryTree(InputOutput.ArrayListFromString(lines.remove(0)));
            System.out.println("For the given tree: ");
            Tree.inorderTraversal(root);
            System.out.println(" ==> Max Difference is: " + maxDiff(root));
        }
    }

    static int max;

    public static int maxDiff(Tree root) {
        if (root == null || (root.left == null && root.right == null))
            return Integer.MIN_VALUE;
        max = Integer.MIN_VALUE;
        getResult(root);
        return max;
    }

    public static int getResult(Tree root) {
        if (root == null)
            return Integer.MAX_VALUE; // I don't know what to return
        int ls = getResult(root.left);
        int rs = getResult(root.right);
        int val = Math.min(ls, rs);
        // updating the max value
        max = Math.max(max, root.data - val);
        return Math.min(root.data, val);
    }

}