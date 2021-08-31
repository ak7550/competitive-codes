import AkPackage.*;
import java.util.*;


public class BottomViewOfTree {
    public static void main(String args[]) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new BottomViewOfTree());
        while (!lines.isEmpty()) {
            Tree root = InputOutput.createBinaryTree(InputOutput.ArrayListFromString(lines.remove(0)));
            System.out.println("The given tree: ");
            Tree.inorderTraversal(root);
            System.out.println("Bottom view is: " + bottomView(root));
        }
    }

    static class Pair {
        int node;
        int height;

        public Pair(int d, int h) {
            node = d;
            height = h;
        }
    }

    public static ArrayList<Integer> bottomView(Tree root) {
        HashMap<Integer, Pair> hm = new HashMap<>();

        recurr(hm, 0, root, 0);
        ArrayList<Integer> arr = new ArrayList<>();
        System.out.println();
        hm.keySet().forEach(x -> {
            arr.add(hm.get(x).node);
            System.out.println(x+" ==> "+ arr.get(arr.size()-1));
        });

        return arr;
    }

    public static void recurr(HashMap<Integer, Pair> hm, int value, Tree root, int height) {
        if (root == null)
            return;

        if (!hm.containsKey(value))
            hm.put(value, new Pair(root.data, height));
        else {
            if (hm.get(value).height <= height)
                hm.put(value, new Pair(root.data, height));
        }

        recurr(hm, value - 1, root.left, height + 1);
        recurr(hm, value + 1, root.right, height + 1);
    }
}