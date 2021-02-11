import AkPackage.*;
import java.util.*;

public class PairSumInBST {
    public static void main(String args[]) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new PairSumInBST());
        while (!lines.isEmpty()) {
            Tree root = InputOutput.createBinaryTree(InputOutput.ArrayListFromString(lines.remove(0)));
            int sum = Integer.parseInt(lines.remove(0));
            System.out.println("For the given tree: ");
            Tree.levelorderTraversal(root);
            System.out.println(sum + " can" + (isSum(root, sum) ? "" : " not") + " be made out of this above tree.");
        }
    }

    public static boolean isSum(Tree root, int sum) {
        HashSet<Integer> hs = new HashSet<>();
        return preorder(root, sum, hs);
    }

    static boolean preorder(Tree root, int sum, HashSet<Integer> hs) {
        if (root == null)
            return false;
        if (hs.contains(sum - root.data))
            return true;
        else
            hs.add(root.data);
        return preorder(root.left, sum, hs) || preorder(root.right, sum, hs);
    }

}