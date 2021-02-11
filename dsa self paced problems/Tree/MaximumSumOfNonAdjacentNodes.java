import AkPackage.*;
import java.util.*;

public class MaximumSumOfNonAdjacentNodes {
    public static void main(String args[]) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new MaximumSumOfNonAdjacentNodes());
        while (!lines.isEmpty()) {
            Tree root = InputOutput.createBinaryTree(InputOutput.ArrayListFromString(lines.remove(0)));
            System.out.println("For the given tree: ");
            Tree.inorderTraversal(root);
            System.out.println(" ==> sum of non adjacent nodes are: " + getResult(root));
        }
    }

    public static int getResult(Tree root) {
        int arr[] = helper(root);
        return Math.max(arr[0], arr[1]);
    }

    public static int[] helper(Tree root) {
        if (root == null)
            return new int[] { 0, 0 };
        int ls[] = helper(root.left), rs[] = helper(root.right), withoutRoot = Integer.MIN_VALUE, withRoot = root.data;
        withoutRoot = Math.max(withoutRoot, Math.max(ls[1], rs[1]));
        withoutRoot = Math.max(withoutRoot, Math.max(ls[0], rs[0]));
        withoutRoot = Math.max(withoutRoot, Math.max(ls[0] + rs[0], ls[1] + rs[1]));
        withoutRoot = Math.max(withoutRoot, Math.max(ls[0] + rs[1], ls[1] + rs[0]));
        withRoot = Math.max(withRoot, withRoot + ls[0]);
        withRoot = Math.max(withRoot, withRoot + rs[0]);
        return new int[] { withoutRoot, withRoot };
    }
}