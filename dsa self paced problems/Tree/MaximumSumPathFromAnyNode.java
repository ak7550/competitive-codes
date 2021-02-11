import AkPackage.*;
import java.util.*;


public class MaximumSumPathFromAnyNode {
    static int max;
    public static void main(String args[]) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new MaximumSumPathFromAnyNode());
        while (!lines.isEmpty()) {
            Tree root = InputOutput.createBinaryTree(InputOutput.ArrayListFromString(lines.remove(0)));
            System.out.println("For the given tree: ");
            Tree.inorderTraversal(root);
            max = root.data;
            System.out.println("\nThe maximum sum path is: " + Math.max(findMaxSum2(root), max));
        }
    }

    public static int findMaxSum2(Tree root) { 
        if (root == null)
            return 0;
        int ls = findMaxSum2(root.left), rs = findMaxSum2(root.right);
        int includeAll = ls + rs + root.data, anyOne = Math.max(ls, rs) + root.data;
        max = Math.max(max, includeAll);
        max = Math.max(max, anyOne);
        max = Math.max(max, root.data);
        // if anyone is lesser than root.data then return root.data....
        return Math.max(anyOne, root.data);
    }
}

