import AkPackage.*;
import java.util.*;

class BST {
    public boolean isBST;
    Integer size, min, max;

    public BST(boolean ch, Integer s, Integer mn, Integer mx) {
        isBST = ch;
        size = s;
        min = mn;
        max = mx;
    }
}

public class MaxBSTInBT {
    public static void main(String args[]) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new MaxBSTInBT());
        while (!lines.isEmpty()) {
            Tree root = Tree.createBinaryTree(InputOutput.ArrayListFromString(lines.remove(0)));
            System.out.println("For the given bt: ");
            Tree.levelOrderTraversal(root);
            System.out.println("Max bst is: " + findMaxBST(root).size);
        }
    }

    // -> tc = O(n)
    public static BST findMaxBST(Tree root) {
        if (root == null)
            return new BST(true, 0, null, null);

        BST left = findMaxBST(root.left), right = findMaxBST(root.right);
        if (left.max == null)
            left.max = root.data;
        if (left.min == null)
            left.min = root.data;
        if (right.max == null)
            right.max = root.data;
        if (right.min == null)
            right.min = root.data;

        // -> must satisfy all the conditions of bst
        // _ max of left subtree should be smaller than root.data
        // _ min of right subtree should be bigger than root.data
        if (left.isBST && right.isBST) {
            Integer lmax = left.max, rmin = right.min;
            if (lmax <= root.data && rmin >= root.data)
                return new BST(true, left.size + right.size + 1, left.min, right.max);
        }
        return new BST(false, Math.max(left.size, right.size), null, null); // size of max bst
    }
}