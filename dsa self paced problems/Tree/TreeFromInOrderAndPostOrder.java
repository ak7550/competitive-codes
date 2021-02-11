import AkPackage.*;
import java.util.*;

public class TreeFromInOrderAndPostOrder {
    static HashMap<Integer, Integer> hm;

    public static void main(String args[]) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new TreeFromInOrderAndPostOrder());
        while (!lines.isEmpty()) {
            int in[] = InputOutput.arrayFromString(lines.remove(0)),
                    post[] = InputOutput.arrayFromString(lines.remove(0));
            hm = new HashMap<Integer, Integer>();
            for (int i = 0; i < in.length; i++)
                hm.put(in[i], i);
            Tree root = buildTree(in, post, post.length);
            System.out.println("For the given,\nIn: " + Arrays.toString(in) + "\nPost: " + Arrays.toString(post)
                    + "\nThe tree in inorder form: ");
            Tree.inorderTraversal(root);
        }
    }

    static int curr;

    public static Tree buildTree(int in[], int post[], int n) {
        curr = n - 1;
        return buildTree2(in, post, 0, n - 1);
    }

    public static Tree buildTree2(int in[], int post[], int start, int end) {
        if (start > end)
            return null;
        Tree root = new Tree(post[curr]);
        int index = hm.get(post[curr]);
        curr--;
        root.right = buildTree2(in, post, index + 1, end);
        root.left = buildTree2(in, post, start, index - 1);
        return root;
    }
}