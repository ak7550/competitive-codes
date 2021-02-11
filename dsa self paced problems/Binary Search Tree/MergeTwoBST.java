import AkPackage.*;
import java.util.*;

public class MergeTwoBST {
    public static void main(String args[]) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new MergeTwoBST());
        while (!lines.isEmpty()) {
            Tree r1 = InputOutput.createBinaryTree(InputOutput.ArrayListFromString(lines.remove(0))),
                    r2 = InputOutput.createBinaryTree(InputOutput.ArrayListFromString(lines.remove(0)));
            System.out.println("For two given bsts: ");
            Tree.inorderTraversal(r1);
            System.out.println();
            Tree.inorderTraversal(r2);
            System.out.println("\nThe mergeed arraylist is: " + merge(r1, r2));
        }
    }

    public static ArrayList<Integer> merge(Tree root1, Tree root2) {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        Stack<Tree> st1 = new Stack<>(), st2 = new Stack<>();
        st1.push(root1);
        st2.push(root2);
        pushLeftSubNode(st1, root1);
        pushLeftSubNode(st2, root2);
        while (!st1.isEmpty() && !st2.isEmpty()) {
            if (st1.peek().data < st2.peek().data) {
                arr.add(st1.peek().data);
                Tree temp = st1.pop();
                if (temp.right != null) {
                    st1.push(temp.right);
                    pushLeftSubNode(st1, temp.right);
                }
            } else {
                arr.add(st2.peek().data);
                Tree temp = st2.pop();
                if (temp.right != null) {
                    st2.push(temp.right);
                    pushLeftSubNode(st2, temp.right);
                }
            }
        }

        if (!st1.isEmpty()) {
            arr.add(st1.peek().data);
            Tree temp = st1.pop();
            if (temp.right != null) {
                st1.push(temp.right);
                pushLeftSubNode(st1, temp.right);
            }
        }
        if (!st2.isEmpty()) {
            arr.add(st2.peek().data);
            Tree temp = st2.pop();
            if (temp.right != null) {
                st2.push(temp.right);
                pushLeftSubNode(st2, temp.right);
            }
        }
        return arr;
    }

    public static void pushLeftSubNode(Stack<Tree> st, Tree root) {
        while (root.left != null) {
            st.push(root.left);
            root = root.left;
        }
    }
}