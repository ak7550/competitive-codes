import AkPackage.*;
import java.util.*;

public class PrintCommonNodeInTwoBST {
    public static void main(String args[]) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new PrintCommonNodeInTwoBST());
        while (!lines.isEmpty()) {
            Tree root1 = InputOutput.createBST(InputOutput.ArrayListFromString(lines.remove(0))),
                    root2 = InputOutput.createBST(InputOutput.ArrayListFromString(lines.remove(0)));
            System.out.println("For the given two BST's: ");
            Tree.inorderTraversal(root1);
            System.out.println();
            Tree.inorderTraversal(root2);
            System.out.println("Common Nodes are: " + printCommon(root1, root2));
        }
    }
    
    public static ArrayList<Integer> printCommon(Tree root1, Tree root2) {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        Stack<Integer> st = new Stack<Integer>();
        inorder1(root1, st);
        inorder2(root2, st, arr);
        return arr;
    }

    public static void inorder1(Tree root, Stack<Integer> st) {
        if (root == null)
            return;
        inorder1(root.left, st);
        st.push(root.data);
        inorder1(root.right, st);
    }

    public static void inorder2(Tree root, Stack<Integer> st, ArrayList<Integer> arr) {
        if (root == null)
            return;
        inorder2(root.right, st, arr);
        int popped = 0;
        while (!st.isEmpty() && root.data <= st.peek())
            popped = st.pop();
        if (popped == root.data)
            arr.add(0, popped);
        if (st.isEmpty())
            return;
        inorder2(root.left, st, arr);
    }
}