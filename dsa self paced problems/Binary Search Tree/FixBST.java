import AkPackage.*;
import java.util.*;

public class FixBST {
    public static void main(String args[]) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new FixBST());
        while (!lines.isEmpty()) {
            Tree root = InputOutput.createBinaryTree(InputOutput.ArrayListFromString(lines.remove(0)));
            System.out.println("\n\nFor the given Tree: ");
            Tree.inorderTraversal(root);
            System.out.println("\nThe corrected BST is: ");
            root = getResult(root);
            Tree.inorderTraversal(root);
        }
    }

    static Tree prev, curr;
    static int count;

    public static Tree getResult(Tree root) {
        ArrayList<Tree> arr = new ArrayList<Tree>();
        prev = null;
        curr = null;
        count = 0;
        inorder(root, arr);
        // swapping the two elements.
        int temp = prev.data;
        prev.data = curr.data;
        curr.data = temp;
        return root;
    }

    public static void inorder(Tree root, ArrayList<Tree> arr) {
        if (root == null)
            return;
        inorder(root.left, arr);
        if (!arr.isEmpty()) {
            if (arr.get(arr.size() - 1).data > root.data && count == 0) {
                count++;
                prev = arr.get(arr.size() - 1);
                curr = root;
            } else if (arr.get(arr.size() - 1).data > root.data && count == 1) {
                curr = root;
            }
        }
        arr.add(root);
        inorder(root.right, arr);
    }
}