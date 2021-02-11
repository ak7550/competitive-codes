import AkPackage.*;
import java.util.*;

public class PostorderToPreOrder {
    public static void main(String args[]) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new PostorderToPreOrder());
        while (!lines.isEmpty()) {
            int pre[] = InputOutput.arrayFromString(lines.remove(0));
            System.out.println("For the given preorder: " + Arrays.toString(pre));
            System.out.println("The post order result is: " + Arrays.toString(getPostOrder(pre)));
        }
    }

    static class NodeD {
        Tree node;
        int max, min;

        public NodeD(Tree n, int mi, int ma) {
            node = n;
            max = ma;
            min = mi;
        }
    }

    public static int[] getPostOrder(int pre[]) {
        int preIndex = 0, postIndex = 0;
        int post[] = new int[pre.length];
        Stack<NodeD> st = new Stack<NodeD>();
        if (preIndex == pre.length)
            return post;
        Tree root = new Tree(pre[preIndex++]);
        st.push(new NodeD(root, Integer.MIN_VALUE, Integer.MAX_VALUE));

        while (preIndex < pre.length) {
            while (!st.isEmpty() && !(st.peek().min < pre[preIndex] && st.peek().max > pre[preIndex]))
                post[postIndex++] = st.pop().node.data;
            NodeD temp = st.peek();
            // left subtree
            if (pre[preIndex] > temp.min && pre[preIndex] < temp.node.data) {
                temp.node.left = new Tree(pre[preIndex++]);
                st.push(new NodeD(temp.node.left, temp.min, temp.node.data));
            }
            if (preIndex == pre.length)
                break;
            // right subtree
            if (pre[preIndex] > temp.node.data && pre[preIndex] < temp.max) {
                temp.node.right = new Tree(pre[preIndex++]);
                st.push(new NodeD(temp.node.right, temp.node.data, temp.max));
            }
        }
        while (!st.isEmpty())
            post[postIndex++] = st.pop().node.data;

        return post;
        // return root;
    }
}