import AkPackage.*;
import java.util.*;

class Pair {
    int pos;
    Tree node;

    Pair(int p, Tree n) {
        pos = p;
        node = n;
    }
}

public class TopViewOfBT {
    public static void main(String args[]) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new TopViewOfBT());
        while (!lines.isEmpty()) {
            Tree root = InputOutput.createBinaryTree(InputOutput.ArrayListFromString(lines.remove(0)));
            System.out.println("For the given tree: ");
            Tree.levelorderTraversal(root);
            System.out.println("Top view of the tree is: " + topView(root));
        }
    }

    public static ArrayList<Integer> topView(Tree root) {
        TreeMap<Integer, Integer> tm = new TreeMap<Integer, Integer>();
        ArrayDeque<Pair> ad = new ArrayDeque<Pair>();
        if (root == null) 
            return null;
        ad.add(new Pair(0, root));
        tm.put(0, root.data);
        while (!ad.isEmpty()) {
            Pair temp = ad.poll();
            if (temp.node.left != null) {
                ad.add(new Pair(temp.pos - 1, temp.node.left));
                tm.putIfAbsent(temp.pos - 1, temp.node.left.data);
            }
            if (temp.node.right != null) {
                ad.add(new Pair(temp.pos + 1, temp.node.right));
                tm.putIfAbsent(temp.pos + 1, temp.node.right.data);
            }
        }
        ArrayList<Integer> arr = new ArrayList<Integer>();
        arr.addAll(tm.values());
        return arr;
    }

    public static void inorder(Tree root, TreeMap<Integer, Integer> tm, int pos) {
        if (root == null)
            return;
        inorder(root.left, tm, pos - 1);
        tm.putIfAbsent(pos, root.data);
        inorder(root.right, tm, pos + 1);
    }

    public static void preorder(Tree root, TreeMap<Integer, Integer> tm, int pos) {
        if (root == null)
            return;
        tm.putIfAbsent(pos, root.data);
        preorder(root.left, tm, pos - 1);
        preorder(root.right, tm, pos + 1);
    }
}