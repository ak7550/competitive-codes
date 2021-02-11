import AkPackage.*;
import java.util.*;

public class IterativeInOrderTraversal {
    public static void main(String args[]) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new IterativeInOrderTraversal());
        while (!lines.isEmpty()) {
            Tree root = InputOutput.createBinaryTree(InputOutput.ArrayListFromString(lines.remove(0)));
            System.out.println("For the given tree: ");
            Tree.levelorderTraversal(root);
            System.out.println();
            ArrayList<Integer> arr = inorder(root);
            System.out.println("iterative inorder is: " + arr);
            System.out.println("Recursive inorder traversal is: ");
            Tree.inorderTraversal(root);
            System.out.println("\n");
        }
    }

    public static ArrayList<Integer> inorder(Tree root) {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        Stack<Tree> st = new Stack<Tree>();
        if (root == null)
            return null;
        st.push(root);

        while (!st.isEmpty()) {
            // PUSH ALL THE LEFT NODES
            while (root.left != null) {
                st.push(root.left);
                root = root.left;
            }

            // pop out all the left nodes, which donot have any right child
            do {
                root = st.pop();
                arr.add(root.data);
            } while (!st.isEmpty() && root.right == null);

            // if root has a right child, then push it into the stack
            if (root.right != null) {
                st.push(root.right);
                root = root.right;
            }
            
        }
        return arr;
    }
}