import java.util.ArrayList;

import AkPackage.InputOutput;
import AkPackage.Tree;

/**
 * LowestCommonAncestor
 */
public class LowestCommonAncestor {

    public static void main(String[] args) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new LowestCommonAncestor());
        while (!lines.isEmpty()) {
            ArrayList<Integer> arr = InputOutput.ArrayListFromString(lines.remove(0));
            Tree root = (Tree)InputOutput.createBinaryTree(arr);
            String str[] = lines.remove(0).split(" ");
            int a = Integer.parseInt(str[0]), b = Integer.parseInt(str[1]);
            System.out.println("For given input: " + arr + "\na=" + a + " b=" + b + "\nLowest Common Ancestor is: "
                    + findLCA(root, a, b).data );
        }
    }

    public static Tree findLCA(Tree root, int a, int b) {
        if (root == null)
            return null;
        if (root.data == a || root.data == b)
            return root;
        Tree lt = findLCA(root.left, a, b), rt = findLCA(root.right, a, b);
        if (lt != null && rt!=null)
            return root;
        else if (lt != null)
            return lt;
        else
            return rt;
    }
}