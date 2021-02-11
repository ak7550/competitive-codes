import AkPackage.*;
import java.util.*;

public class FloorInBST {
    public static void main(String args[]) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new FloorInBST());
        while (!lines.isEmpty()) {
            Tree root = InputOutput.createBinaryTree(InputOutput.ArrayListFromString(lines.remove(0)));
            int key = Integer.parseInt(lines.remove(0));
            System.out.println("For the given BST: ");
            Tree.levelorderTraversal(root);
            System.out.println("Floor of " + key + " is: " + floor(root, key));
        }
    }

    public static int floor(Tree root, int x) {
        if (root == null)
            return -1;
        // Code here
        int pf = -1;
        while (root != null) {
            if (root.data == x)
                return x;
            else if (root.data < x) {
                pf = root.data;
                root = root.right;
            } else
                root = root.left;
        }
        return pf;
    }
}