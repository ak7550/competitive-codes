import AkPackage.*;
import java.util.*;


public class BTtoDLL {
    public static void main(String args[]) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new BTtoDLL());
        while (!lines.isEmpty()) {
            Tree root = InputOutput.createBinaryTree(InputOutput.ArrayListFromString(lines.remove(0)));
            System.out.println("Inorderly the tree is: ");
            Tree.inorderTraversal(root);
            root = bToDLL(root);
            // print root in our own way.
        }
    }
    
    static Tree tail, head;

    static Tree bToDLL(Tree root) {
        // Your code here
        tail = null;
        return btTodll(root);
    }

    static Tree btTodll(Tree root) {
        if (root == null)
            return null;
        btTodll(root.left);
        if (tail == null) {
            tail = root;
            head = tail;
        } else {
            tail.right = root;
            root.left = tail;
            tail = tail.right;
        }
        btTodll(root.right);
        return head;
    }
}