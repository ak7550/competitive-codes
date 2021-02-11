import AkPackage.*;
import java.util.*;

class NodeDeatails {
    Tree node;
    int max, min;
    NodeDeatails(Tree n, int min, int max){
        node = n;
        this.max = max;
        this.min = min;
    }
}

public class LevelOrderTraversalToBST {
    public static void main(String args[]) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new LevelOrderTraversalToBST());
        while (!lines.isEmpty()) {
            int arr[] = InputOutput.arrayFromString(lines.remove(0));
            Tree.preorderTraversal(getBST(arr));
        }
    }
    
    public static Tree getBST(int arr[]) {
        if (arr.length == 0)
            return null;
        ArrayDeque<NodeDeatails> ad = new ArrayDeque<NodeDeatails>();
        int index = 0;
        Tree root=new Tree(arr[index++]);
        ad.add(new NodeDeatails(root, Integer.MIN_VALUE, Integer.MAX_VALUE));
        while (index<arr.length) {
            NodeDeatails temp = ad.poll();
            if (arr[index] >= temp.min && arr[index] < temp.node.data) {
                Tree nodeLeft = new Tree(arr[index++]);
                temp.node.left = nodeLeft;
                ad.add(new NodeDeatails(nodeLeft, temp.min, temp.node.data));
            }
            if (index == arr.length)
                break;
            if (arr[index]>temp.node.data && arr[index]<=temp.max) {
                Tree nodeRight = new Tree(arr[index++]);
                temp.node.right = nodeRight;
                ad.add(new NodeDeatails(nodeRight, temp.node.data, temp.max));
            }
        }
        return root;
    }
}