import AkPackage.*;
import java.util.*;

//!DP QUESTION, we must optimise it through memonisation
public class HouseRober3 {
    public static void main(String args[]) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new HouseRober3());
        while (!lines.isEmpty()) {
            Tree root = Tree.createBinaryTree(InputOutput.ArrayListFromString(lines.remove(0)));
            System.out.println("For i/p: ");
            Tree.levelorderTraversal(root);
            System.out.println("max value is: " + houseRobber(root));
        }
    }

    public static int houseRobber(Tree root) {
        HashMap<Tree, Integer[]> hm = new HashMap<>(); // int[0] == include, int[1] = exclude
        int in = include(root, hm), ex = exclude(root, hm);
        hm.put(root, new Integer[] { in, ex });
        return Math.max(in, ex);
    }

    public static int exclude(Tree root, HashMap<Tree, Integer[]> hm) {
        if (root == null)
            return 0;
        if (hm.get(root) != null && hm.get(root)[1] != null)
            return hm.get(root)[1];

        int left = Math.max(include(root.left, hm), exclude(root.left, hm)),
                right = Math.max(include(root.right, hm), exclude(root.right, hm));

        Integer arr[] = hm.getOrDefault(root, new Integer[2]);

        arr[1] = Math.max(left + right, Math.max(left, right));
        hm.put(root, arr);
        return arr[1];
    }

    public static int include(Tree root, HashMap<Tree, Integer[]> hm) {
        if (root == null)
            return 0;

        if (hm.get(root) != null && hm.get(root)[0] != null)
            return hm.get(root)[0];

        int ll = 0, lr = 0, rr = 0, rl = 0;
        if (root.left != null) {
            ll = Math.max(
                    include(root.left.left, hm), exclude(root.left.left, hm));
            lr = Math.max(
                    include(root.left.right, hm), exclude(root.left.right, hm));
        }
        if (root.right != null) {
            rl = Math.max(
                    include(root.right.left, hm), exclude(root.right.left, hm));
            rr = Math.max(
                    include(root.right.right, hm), exclude(root.right.right, hm));
        }
        Integer arr[] = hm.getOrDefault(root, new Integer[2]);
        arr[0] = root.data + ll + lr + rl + rr;
        hm.put(root, arr);
        return arr[0];
    }
}