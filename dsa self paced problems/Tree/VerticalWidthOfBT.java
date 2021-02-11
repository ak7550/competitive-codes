import AkPackage.*;
import java.util.*;

public class VerticalWidthOfBT {
    public static void main(String args[]) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new VerticalWidthOfBT());
        while (!lines.isEmpty()) {
            Tree root = (Tree) InputOutput.createBinaryTree(InputOutput.ArrayListFromString(lines.remove(0)));
            System.out.println("For the given tree: ");
            Tree.inorderTraversal(root);
            System.out.println("Vertical Width of BT is: " + verticalWidth(root));
        }
    }

    static int max = 0, min = 0;
    public static int verticalWidth(Tree root) {
        getResult(root, 0);
        if (root == null)
            return 0;
        max = 0;
        min = 0;
        return max - min + 1;
    }

    public static void getResult(Tree root, int curr) {
        if (root == null)
            return;
        max = Math.max(max, curr);
        min = Math.min(min, curr);
        getResult(root.left, curr - 1);
        getResult(root.right, curr+1);
    }
}